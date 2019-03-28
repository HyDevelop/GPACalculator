/**
 * Communicator to the api.
 */
function GPACalcApi()
{
    /**
     * Url Constant
     */
    var url = this.url = constants.api_url;

    /**
     * Send a request to api.
     *
     * @param apiNode Node of the api.
     * @param content Content in String.
     * @param callback Function to callback after.
     *          function(return result)
     * @param errorCallback Callback when there is an error.
     *          function(error message) that returns a boolean that decides whether to send error or not.
     * @param params Header parameter key value pairs
     */
    this.send = async function (apiNode, content, callback, errorCallback, ... params)
    {
        if (google.getUser() == null)
        {
            throw "Error 001: You must be logged in to do that.\nNo google login is detected.";
        }

        var request = new XMLHttpRequest();
        request.open("POST", this.url, true);
        request.setRequestHeader("node", apiNode);
        request.setRequestHeader("token", google.getUser().getAuthResponse().id_token);
        request.onreadystatechange = function ()
        {
            if (request.readyState === 4 && request.status === 200)
            {
                var text = request.responseText;

                // Error
                if (text.toLowerCase().startsWith("error"))
                {
                    // Error callback, returns boolean that decides whether to send error message or not.
                    var sendErrorMessage = true;
                    if (errorCallback != null) sendErrorMessage = errorCallback(text);
                    if (sendErrorMessage) msg.error("Error: Data Request Failed.",
                        "Requested API Node: " + apiNode,
                        "Error Response: " + text);
                    return;
                }

                // Async callback
                callback(text);
            }
        };

        // Set param headers.
        if (params == null) params = [];
        for (var i = 0; i < params.length; i += 2)
            request.setRequestHeader(params[i], params[i + 1]);

        request.send(content);
    };

    /**
     * Send and debug the response to console.
     *
     * @param apiNode Node
     * @param content Content
     */
    this.sendDebug = function (apiNode, content)
    {
        api.send(apiNode, content, response => console.log(response), error =>
        {
            console.log("Error: " + error);
            return false;
        })
    };
}

const api = new GPACalcApi();
