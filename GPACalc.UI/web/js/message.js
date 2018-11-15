/**
 * Message related.
 */
var msg = {};

/**
 * Send a success message.
 *
 * @param title Title
 * @param lines Lines under title.
 */
msg.success = function (title, ... lines)
{
    msg.addMsg(messageSuccess, title, lines);
};

/**
 * Send an error message.
 *
 * @param title Title
 * @param lines Lines under title.
 */
msg.error = function (title, ... lines)
{
    msg.addMsg(messageError, title, lines);
};

/**
 * Add a message.
 *
 * @param format Template of the message.
 * @param title Title
 * @param lines Lines under title.
 */
msg.addMsg = function (format, title, lines)
{
    var linesText = "";
    for (let i in lines) linesText += "<li>" + lines[i] + "</li>";

    $("#messages-div").append(format.replace(/%title%/g, title).replace(/%lines%/g, linesText));
    msg.updateRegistration();
};

/**
 * Update close icon registration.
 */
msg.updateRegistration = function ()
{
    $('.message .close').on('click', function()
    {
        // Fixed problem: If this is called twice, a message can not be closed.
        if (this.closed != null) return;
        this.closed = true;

        // Known bug: Transition doesn't remove object.
        //    Remove wouldn't look as good.
        //    Besides from using a delay there's no way to solve this.
        var message = $(this).closest('.hy-message-container');
        message.transition('vertical flip');
        // message.remove();
    });
};
