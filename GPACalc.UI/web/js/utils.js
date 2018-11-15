/**
 * Reload page.
 */
function reload()
{
    window.location.reload(true);
}

/**
 * Get JS Version
 *
 * @return {string} JS Version
 */
function getJsVersion()
{
    this.jsv = {};
    jsv.versions = ["1.1", "1.2", "1.3", "1.4", "1.5", "1.6", "1.7", "1.8", "1.9", "2.0"];
    jsv.version = "";

    for (i = 0; i < jsv.versions.length; i++)
    {
        var g = document.createElement('script'),
            s = document.getElementsByTagName('script')[0];

        g.setAttribute("language", "JavaScript" + jsv.versions[i]);
        g.text = "this.jsv.version='" + jsv.versions[i] + "';";
        s.parentNode.insertBefore(g, s);
    }

    return jsv.version;
}