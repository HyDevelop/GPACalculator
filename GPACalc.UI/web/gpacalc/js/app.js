var banner =
    " __ _  _     __                           \n" +
    "/__|_)|_|   /   _  |  _     |  _ _|_ _  __\n" +
    "\\_||  | |   \\__(_| | (_ |_| | (_| |_(_) | \n" +
    "               v1.0.0.0 By Hykilpikonna";

/**
 * Called when login is verified.
 */
function googleLoginSuccessCallback()
{
    // Reload if signed in for the first time.
    if (UIkit.modal("#modal-login").isToggled()) reload();

    // Show sign off button
    $(".auth-signOut").show();

    // Print banner.
    console.log(banner);
    console.log("Welcome, " + google.getProfile().getName());

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
 * Redirects to the login page.
 */
function googleLoginFailedCallback()
{
    google.signIn();
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

// TODO: Check validity of grades.