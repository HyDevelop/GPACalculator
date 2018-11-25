/**
 * Reload page.
 */
function reload()
{
    window.location.reload(true);
}

/**
 * Verify if a list contains a value
 *
 * @param list The list
 * @param value The value
 * @return {boolean} true if contains, else false.
 */
function contains(list, value)
{
    return list.indexOf(value) >= 0;
}

/**
 * Verify if a list contains a value, case insensitive.
 *
 * @param list The list
 * @param value The string value
 * @return {boolean} true if contains, else false.
 */
function containsIgnoreCase(list, value)
{
    return arrayToLowerCase(list).indexOf(value.toLowerCase()) >= 0;
}

/**
 * Make an array of String in lower case.
 *
 * @param list Array of String
 * @return {Array} Lowercase array.
 */
function arrayToLowerCase(list)
{
    var newList = [];
    for (var i in list) newList[i] = list[i].toLowerCase();
    return newList;
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