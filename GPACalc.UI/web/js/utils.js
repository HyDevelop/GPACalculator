/**
 * Reload page.
 */
function reload()
{
    window.location.reload(true);
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