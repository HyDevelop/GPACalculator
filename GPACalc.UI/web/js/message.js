class Msg {}
var msg = new Msg();

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
        $(this).closest('.message').transition('fade');
    });
};
