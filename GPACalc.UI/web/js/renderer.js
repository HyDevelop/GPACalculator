// This JS is for displaying data, not direct rendering.
const gradeEditorDiv = $("#grade-editor-div");
const studentProfileEditorDiv = $("#student-profile-editor-div");

/**
 * Render the grades page.
 *
 * @param studentProfile Student profile json
 * @param gradingProfile Grading profile json
 */
function renderGradesPage(studentProfile, gradingProfile)
{
    // Get div and delete all child.
    gradeEditorDiv.empty();

    // Get subjects.
    var subjects = studentProfile.subjectList.subjects;
    for (var i in subjects)
    {
        var subject = subjects[i];
        var name = subject.name;

        gradeEditorDiv.append(gradeEditorTemplate.replace(/%id%/g, i).replace(/%course-name%/g, name));
    }
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

/**
 * Add an entry to student profile editor.
 *
 * @param id Integer ID of the entry.
 * @param name Course name.
 * @param level Course level.
 * @param credits Course credit.
 */
function studentProfileAddEntry(id, name, level, credits)
{
    studentProfileEditorDiv.append(studentProfileEditorTemplate.replace(/%id%/g, id));
    $("#name-" + id).val(name);
    $("#level-" + id).val(level);
    $("#credits-" + id).val(credits);
}