const editorBaseUrl = "http://" + document.domain + "/includes/editor/";
var studentProfileEditorTemplate;

/**
 * Load student profile editor template.
 *
 * @param callback Callback when done
 */
function loadStudentProfileEditorTemplate(callback)
{
    $.ajax({
        url: editorBaseUrl + "student-profile-editor-template.jsp",
        success: function (result)
        {
            studentProfileEditorTemplate = result;
            callback();
        }
    });
}