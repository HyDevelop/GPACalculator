/**
 * Class related to the Google API and authentication.
 */
function Google()
{
    // gAPI and Auth2 Instance (Initialized on init())
    var g = gapi;
    var a;

    /**
     * Sign in
     */
    this.signIn = function ()
    {
        a.signIn({
            prompt: "select_account",
            ux_mode: "redirect"
        });
    };

    /**
     * Sign out.
     */
    this.signOut = function ()
    {
        a.signOut().then(function ()
        {
            console.log('[GoogleApi] Signed out.');
        });
    };

    /**
     * Detects login information.
     */
    this.init = function ()
    {
        g.load('auth2', function ()
        {
            g.auth2.init({ client_id: constants.client_id }).then(function (auth2)
            {
                a = auth2;

                // Detects if user is logged in
                if (a.isSignedIn.get())
                {
                    console.log("[GoogleApi] Login verified.");
                    googleLoginSuccessCallback();
                }
                else
                {
                    console.log("[GoogleApi] No login info detected.");
                    googleLoginFailedCallback();
                }
            })

        });
    };

    /**
     * Get user
     */
    this.getUser = function ()
    {
        return a.currentUser.get()
    };

    /**
     * Get user profile
     */
    this.getProfile = function ()
    {
        return this.getUser().getBasicProfile();
    };
}

const google = new Google();

/**
 * Run on load.
 */
$(document).ready(google.init());