const apiUrl = "http://" + document.domain + "/api";
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
 *          function(return result)
 * @param errorCallback Callback when there is an error.
 *          function(error message) that returns a boolean that decides whether to send error or not.
 */
function send(apiNode, content, callback, errorCallback)
{
    if (googleUser == null)
    {
        msg.error("Error: You must be logged in to do that.", "No google login is detected.");
        return;
    }

    var request = new XMLHttpRequest();
    request.open("POST", apiUrl, true);
    request.setRequestHeader("node", apiNode);
    request.setRequestHeader("token", googleUser.getAuthResponse().id_token);
    request.onreadystatechange = function ()
    {
        if (request.readyState === 4 && request.status === 200)
        {
            var text = request.responseText;

            // Error
            if (text.toLowerCase().startsWith("error"))
            {
                // Error callback, returns boolean that decides whether to send error message or not.
                var sendErrorMessage = true;
                if (errorCallback != null) sendErrorMessage = errorCallback(text);
                if (sendErrorMessage) msg.error("Error: Data Request Failed.",
                    "Requested API Node: " + apiNode,
                    "Error Response: " + text);
                return;
            }

            // Async callback
            callback(text);
        }
    };
    request.send(content);
}

/**
 * Send and debug the response to console.
 *
 * @param apiNode Node
 * @param content Content
 */
function sendDebug(apiNode, content)
{
    send(apiNode, content, response => console.log(response), error =>
    {
        console.log("Error: " + error);
        return false;
    })
}

/**
 * Called when signing in.
 *
 * @param user Google user.
 */
function onSignIn(user)
{
    googleUser = user;

    // Reload if signed in for the first time.
    if (UIkit.modal("#modal-login").isToggled()) reload();

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

    // Send login to backend.
    send("auth.login", "", function (text)
    {
        if (text === "Registered") reload();
    })
}

/**
 * Run on load
 */
$(document).ready(function onLoad()
{
    gapi.load('auth2', function ()
    {
        gapi.auth2.init(
        {
            client_id: constants.client_id,
            scope: "profile email"
        })
        .then(function (auth2)
        {
            // Detects if user is logged in
            if (auth2.isSignedIn.get()) console.log("[OnLoad] Login verified.");
            else
            {
                // Show login modal
                showLoginModal();
                console.log("[OnLoad] Login not found, displaying modal.");
            }

            // Load Cache
            cache.loadFromServer(function ()
            {
                // Render editors
                renderProfilesInCache();

            });
        });
    });
});

/**
 * Show user the login modal.
 */
function showLoginModal()
{
    var loginModal = UIkit.modal("#modal-login");
    if (!loginModal.isToggled()) loginModal.toggle();
}

/**
 * Reload user settings from server.
 */
function reloadSettings()
{
    cache.loadFromServer(() => renderProfilesInCache());
}

/**
 * Render profiles in cache.
 */
function renderProfilesInCache()
{
    renderGradesPage(cache.studentProfile, cache.gradingProfile);
    renderCourseSettingsPage(cache.studentProfile);
    renderGradeRangesPage(cache.gradingProfile);
}

/**
 * Upload student profile to server.
 */
function uploadStudentProfile()
{
    var json = getStudentProfileAsJson();
    send("data.set.student-profile", JSON.stringify(json), success =>
    {
        msg.success("Your Settings Are Uploaded!", success);
        cache.studentProfile = json;
        renderGradesPage(cache.studentProfile, cache.gradingProfile);
    });
}