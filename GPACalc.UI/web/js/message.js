class Msg {}
var msg = new Msg();

msg.success = function (title, ... lines)
{
    msg.addMsg(messageSuccess, title, lines);
};

msg.addMsg = function (format, title, ... lines)
{
    var linesText = "";
    var div = $("#messages-div");

    lines.forEach(text => linesText += "<li>" + text + "</li>");
    div.append(format.replace(/%title%/g, title).replace(/%lines%/g, linesText));

    msg.updateRegistration();
};

msg.updateRegistration = function ()
{
    $('.message .close').on('click', function()
    {
        $(this).closest('.message').transition('fade');
    });
};
