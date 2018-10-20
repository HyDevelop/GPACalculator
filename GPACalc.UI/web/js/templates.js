const editorBaseUrl = "http://" + document.domain + "/includes/editor/";
var studentProfileEditorTemplate;
var gradeEditorTemplate;

$(document).ready(function ()
{
    loadTemplate("studentProfileEditorTemplate", "student-profile-editor-template");
    loadTemplate("gradeEditorTemplate", "grade-editor-template");
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
        url: editorBaseUrl + fileName + ".jsp",
        success: function (result)
        {
            window[variable] = result;
        }
    });
}