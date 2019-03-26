/**
 * Class related to the Google API and authentication.
 */
function Google()
{
    // gAPI and Auth2 Instance (Initialized on init())
    var g = gapi;
    var a;
}

const google = new Google();

/**
 * Run on load.
 */
$(document).ready(google.init());