// This JS is for displaying data, not direct rendering.

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