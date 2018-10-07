const apiUrl = document.domain + "/api";
var googleUser = null;
var banner =
    " __ _  _     __                           \n" +
    "/__|_)|_|   /   _  |  _     |  _ _|_ _  __\n" +
    "\\_||  | |   \\__(_| | (_ |_| | (_| |_(_) | \n" +
    "               v1.0.0.0 By Hykilpikonna";

/**
 * Send a request to api.
 *
 * @param apiNode Node of the api.
 * @param content Content in String.
 * @param callback Function to callback after.
 */
function send(apiNode, content, callback)
{
    if (googleUser == null) return "Error: Not logged in.";

    var request = new XMLHttpRequest();
    request.open("POST", apiUrl, true);
    request.setRequestHeader("node", apiNode);
    request.setRequestHeader("token", googleUser.getAuthResponse().id_token);
    request.writeln(content);
    request.onreadystatechange = function ()
    {
        if (request.readyState === 4 && request.status === 200)
        {
            // Async callback
            callback(request.responseText);
        }
    }
}

/**
 * Called when signing in.
 *
 * @param user Google user.
 */
function onSignIn(user)
{
    googleUser = user;

    // Useful data for your client-side scripts:
    var profile = googleUser.getBasicProfile();
    console.log("ID: " + profile.getId());
    console.log('Full Name: ' + profile.getName());
    console.log('Given Name: ' + profile.getGivenName());
    console.log('Family Name: ' + profile.getFamilyName());
    console.log("Image URL: " + profile.getImageUrl());
    console.log("Email: " + profile.getEmail());

    // The ID token you need to pass to your backend:
    var id_token = googleUser.getAuthResponse().id_token;
    console.log("ID Token: " + id_token);

    // Show sign off
    $(".auth-signOut").show();

    // Print banner.
    console.log(banner);
    console.log("Welcome, " + profile.getName());
}

/**
 * Sign out.
 */
function signOut()
{
    var auth2 = gapi.auth2.getAuthInstance();
    auth2.signOut().then(function ()
    {
        console.log('User signed out.');
        reload();
    });
}

/**
 * Run on load
 */
function onLoad()
{
    // Detects if user is logged in
    if (googleUser == null)
    {
        // Show login modal
        showLoginModal();
    }
}

window.onload = onLoad();

/**
 * Show user the login modal.
 */
function showLoginModal()
{
    var loginModal = UIkit.modal("#modal-login");
    if (!loginModal.isToggled()) loginModal.toggle();
}



/**
 * Reload page.
 */
function reload()
{
    window.location.reload(true);
}