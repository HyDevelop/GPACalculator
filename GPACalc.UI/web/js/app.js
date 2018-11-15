var banner =
    " __ _  _     __                           \n" +
    "/__|_)|_|   /   _  |  _     |  _ _|_ _  __\n" +
    "\\_||  | |   \\__(_| | (_ |_| | (_| |_(_) | \n" +
    "               v1.0.0.0 By Hykilpikonna";

/**
 * Send and debug the response to console.
 *
 * @param apiNode Node
 * @param content Content
 */
function sendDebug(apiNode, content)
{
    api.send(apiNode, content, response => console.log(response), error =>
    {
        console.log("Error: " + error);
        return false;
    })
}

/**
 * Called when login is verified.
 */
function onLoginVerified()
{
    // Reload if signed in for the first time.
    if (UIkit.modal("#modal-login").isToggled()) reload();

    /*
    // Useful data for your client-side scripts:
    var profile = google.user.getBasicProfile();
    console.log("ID: " + profile.getId());
    console.log('Full Name: ' + profile.getName());
    console.log('Given Name: ' + profile.getGivenName());
    console.log('Family Name: ' + profile.getFamilyName());
    console.log("Image URL: " + profile.getImageUrl());
    console.log("Email: " + profile.getEmail());

    // The ID token you need to pass to your backend:
    var id_token = google.user.getAuthResponse().id_token;
    console.log("ID Token: " + id_token);
    */

    // Show sign off button
    $(".auth-signOut").show();

    // Print banner.
    console.log(banner);
    console.log("Welcome, " + google.profile.getName());

    // Send login to backend.
    api.send("auth.login", "", function (text)
    {
        if (text === "Registered") reload();
    });

    // Load Cache
    cache.loadFromServer(function ()
    {
        // Render editors
        renderProfilesInCache();
    });
}

/**
 * Called when login failed.
 */
function onLoginFailed()
{
    // Show login modal
    showLoginModal();
    console.log("[OnLoad] Login not found, displaying modal.");
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