// This JS is for displaying data, not direct rendering.
const gradeEditorDiv = $("#grade-editor-div");
const studentProfileEditorDiv = $("#student-profile-editor-div");
const gradeRangesDiv = $("#grade-ranges-div");

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
    studentProfileEditorDiv.empty();

    // Get subjects.
    var subjects = json.subjectList.subjects;
    for (var i in subjects)
    {
        var subject = subjects[i];
        var name = subject.name;
        var level = subject.level;
        var credits = subject.credits;

        studentProfileAddEntry(i, name, level, credits);
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

/**
 * Render the grade ranges page.
 *
 * @param json Grading profile json
 */
function renderGradeRangesPage(json)
{
    gradeRangesDiv.empty();

    var ranges = json.gradeRangeList.gradeRanges;

    for (var i in ranges)
    {
        var current = ranges[i];
        var name = current.name;
        var range = current.range;

        gradeRangesAddEntry(i, name, range);
    }
}

/**
 * Add an entry to grade ranges.
 *
 * @param id ID
 * @param name Letter grade
 * @param range Range Percentage
 */
function gradeRangesAddEntry(id, name, range)
{
    gradeRangesDiv.append(gradeRangesTemplate.replace(/%id%/g, id));
    $("#gr-letter-grade-" + id).val(name);
    $("#gr-percentage-" + id).val(range);
}

/**
 * Remove an entry.
 *
 * @param element The element of the close icon button.
 */
function studentProfileRemoveEntry(element)
{
    $(element).parent().parent().remove();
}