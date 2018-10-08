// This JS is for displaying data, not direct rendering.
const editorBaseUrl = "http://" + document.domain + "/includes/editor/";
var studentProfileEditorTemplate;

/**
 * Get student profile editor template.
 *
 * @param callback Call this when complete.
 */
function getStudentProfileEditorTemplate(callback)
{
    if (studentProfileEditorTemplate == null)
    {
        $.ajax({
            url: editorBaseUrl + "student-profile-editor-template.jsp",
            success: function (result)
            {
                studentProfileEditorTemplate = result;
                getStudentProfileEditorTemplate(callback);
            }
        });
    }
    else
    {
        callback(studentProfileEditorTemplate);
    }
}