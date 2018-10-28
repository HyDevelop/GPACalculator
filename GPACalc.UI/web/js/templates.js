const includesBaseUrl = "http://" + document.domain + "/includes/";
var studentProfileEditorTemplate;
var gradeEditorTemplate;
var messageSuccess;
var messageError;

$(document).ready(function ()
{
    loadTemplate("studentProfileEditorTemplate", "editor/student-profile-editor-template");
    loadTemplate("gradeEditorTemplate", "editor/grade-editor-template");
    loadTemplate("messageSuccess", "message/message-success");
    loadTemplate("messageError", "message/message-error");
});

/**
 * Load template to a variable.
 *
 * @param variable Template variable name.
 * @param fileName Template file name.
 */
function loadTemplate(variable, fileName)
{
    $.ajax({
        url: includesBaseUrl + fileName + ".jsp",
        success: function (result)
        {
            window[variable] = result;
        }
    });
}