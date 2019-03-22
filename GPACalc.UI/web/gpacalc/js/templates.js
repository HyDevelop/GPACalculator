const includesBaseUrl = "http://" + document.domain + "/includes/";
var studentProfileEditorTemplate;
var gradeEditorTemplate;
var gradeRangesTemplate;
var weightHead;
var weightTemplate;

var messageSuccess;
var messageError;

$(document).ready(function ()
{
    loadTemplate("studentProfileEditorTemplate", "editor/student-profile-editor-template");
    loadTemplate("gradeEditorTemplate", "editor/grade-editor-template");
    loadTemplate("gradeRangesTemplate", "editor/grade-ranges-template");
    loadTemplate("weightHead", "editor/weight-editor-head");
    loadTemplate("weightTemplate", "editor/weight-editor-template");
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