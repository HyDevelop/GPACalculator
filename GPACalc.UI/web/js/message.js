var msg = {};

msg.success = function (title, ... lines)
{
    msg.addMsg(messageSuccess, title, lines);
};

msg.error = function (title, ... lines)
{
    msg.addMsg(messageError, title, lines);
};

msg.addMsg = function (format, title, lines)
{
    var linesText = "";
    for (let i in lines) linesText += "<li>" + lines[i] + "</li>";

    $("#messages-div").append(format.replace(/%title%/g, title).replace(/%lines%/g, linesText));
    msg.updateRegistration();
};

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
