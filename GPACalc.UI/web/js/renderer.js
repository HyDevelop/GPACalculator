// This JS is for displaying data, not direct rendering.
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

/**
 * Render the course settings page.
 *
 * @param json Student profile json
 */
function renderCourseSettingsPage(json)
{
    // Get div and delete all child.
    var div = $("#student-profile-editor-div");
    div.empty();

    // Get subjects.
    var subjects = json.subjectList.subjects;
    for (var i in subjects)
    {
        var subject = subjects[i];
        var keyName = subject.keyName;
        var name = subject.name;
        var level = subject.level;
        var credits = subject.credits;

        div.append(studentProfileEditorTemplate.replace(/%id%/g, i));

        // $("#key-" + i).val(keyName);
        $("#name-" + i).val(name);
        $("#level-" + i).val(level);
        $("#credits-" + i).val(credits);
    }
}