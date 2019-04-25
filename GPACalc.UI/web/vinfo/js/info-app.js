var banner =
    " __ _  _     __                               |        ___     _   \n" +
    "/__|_)|_|   /   _  |  _     |  _ _|_ _  __   -+-   \\ /  | __ _|_ _ \n" +
    "\\_||  | |   \\__(_| | (_ |_| | (_| |_(_) |     |     v  _|_| | | (_)\n" +
    "                                    v1.1.0.0 By Hykilpikonna";

/**
 * Called when login is verified.
 */
function googleLoginSuccessCallback()
{
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
}

/**
 * Called when login failed.
 * Redirects to the login page.
 */
function googleLoginFailedCallback()
{
    google.signIn();
}