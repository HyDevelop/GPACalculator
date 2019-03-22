/**
 * Google account related things.
 */
var google = {};

/**
 * Google User, null if not signed in.
 */
google.user = null;
google.profile = null;

/**
 * Sign out.
 */
google.signOut = function ()
{
    var auth2 = gapi.auth2.getAuthInstance();
    auth2.signOut().then(function ()
    {
        console.log('User signed out.');
        reload();
    });
};

/**
 * Check login.
 */
google.checkLoginOnLoad = function ()
{
    gapi.load('auth2', function ()
    {
        gapi.auth2.init({
                client_id: constants.client_id,
                scope: "profile email"
            })
            .then(function (auth2)
            {
                // Detects if user is logged in
                if (auth2.isSignedIn.get())
                {
                    console.log("[OnLoad] Login verified.");
                    google.auth2 = auth2;
                    google.user = auth2.currentUser.get();
                    google.profile = google.user.getBasicProfile();

                    onLoginVerified(auth2);
                }
                else onLoginFailed();
            });
    });
};

/**
 * Run on load
 */
$(document).ready(google.checkLoginOnLoad());

/**
 * Show user the login modal.
 */
google.showLoginModal = function ()
{
    var loginModal = UIkit.modal("#modal-login");
    if (!loginModal.isToggled()) loginModal.toggle();
};