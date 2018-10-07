
function checkNumeric(id)
{
    var element = $("#" + id);
    var value = element.val();
    if (isNaN(value))
    {
        element.parent().addClass("error");
    }
    else
    {
        element.parent().removeClass("error");
    }
}
