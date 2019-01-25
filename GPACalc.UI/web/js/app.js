var banner =
    " __ _  _     __                           \n" +
    "/__|_)|_|   /   _  |  _     |  _ _|_ _  __\n" +
    "\\_||  | |   \\__(_| | (_ |_| | (_| |_(_) | \n" +
    "               v1.0.0.0 By Hykilpikonna";

/**
 * Called when login is verified.
 */
function onLoginVerified()
{
    // Reload if signed in for the first time.
    if (UIkit.modal("#modal-login").isToggled()) reload();

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
    google.showLoginModal();
    console.log("[OnLoad] Login not found, displaying modal.");
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