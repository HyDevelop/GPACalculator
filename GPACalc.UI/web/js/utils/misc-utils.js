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
 * Replace variables
 *
 * @param original Original string.
 * @param keyValuePairs Key, value, key, value, key, value.....
 */
function replace(original, ... keyValuePairs)
{
    for (var i = 0; i < keyValuePairs.length; i += 2)
    {
        original = original.replace(new RegExp("%" + keyValuePairs[i] + "%", "g"), keyValuePairs[i + 1]);
    }

    return original;
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

function closest(num, arr)
{
    var curr = arr[0];
    var diff = Math.abs(num - curr);
    for (var val = 0; val < arr.length; val++)
    {
        var newDiff = Math.abs(num - arr[val]);
        if (newDiff < diff)
        {
            diff = newDiff;
            curr = arr[val];
        }
    }
    return curr;
};