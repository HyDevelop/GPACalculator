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
        json.subjectGradeMap[$(this).attr("coursename")] = $(e).val();
    });

    return JSON.stringify(json);
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