class Msg {}
var msg = new Msg();

msg.addMsg = function (format, title, ... lines)
{
    var linesText = "";
    var div = $("#messages-div");

    lines.forEach(text => linesText += "<li>" + text + "</li>");
    div.append(format.replace(/%title%/g, title).replace(/%lines%/g, linesText));
};

