/**
 * Get Grades JSON
 *
 * @returns {string} Grades JSON String
 */
function getGradesAsJson()
{
    var json = {};
    json.subjectGradeMap = {};

    gradeEditorDiv.children().find("[name='gradeInput']").each((i, e) =>
    {
        // TODO: Check validity.
        json.subjectGradeMap[$(e).attr("coursename")] = $(e).val();
    });

    return JSON.stringify(json);
}

/**
 * Get student profile as JSON
 *
 * @returns {*} Student profile JSON Object
 */
function getStudentProfileAsJson()
{
    var json = {};
    var courseLevelList = json.subjectList = {};
    var levels = courseLevelList.subjects = [];

    var children = studentProfileEditorDiv.children();

    children.find("[name='sp-name']").each((i, e) =>
    {
        levels[i] = {};
        levels[i].keyName = "course-" + i;
        levels[i].name = $(e).val();
    });
    children.find("[name=sp-level]").each((i, e) => levels[i].level = $(e).val());
    children.find("[name=sp-credits]").each((i, e) => levels[i].credits = $(e).val());

    return json;
}

/**
 * Count entries in student profile editor.
 *
 * @returns {*} Amount of Entries.
 */
function countStudentProfileEditorEntries()
{
    return studentProfileEditorDiv.children().length;
}

/**
 * Count entries in grade ranges editor.
 *
 * @returns {*} Amount of Entries.
 */
function countGradeRangeEntries()
{
    return gradeRangesDiv.children().length;
}