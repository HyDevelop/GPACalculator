/**
 * Google account related things.
 */
var google = {};

/**
 * Google User, null if not signed in.
 */
google.user = null;

/**
 * Sign out.
 */
google.signOut = function()
{
    var auth2 = gapi.auth2.getAuthInstance();
    auth2.signOut().then(function ()
    {
        console.log('User signed out.');
        reload();
    });
};