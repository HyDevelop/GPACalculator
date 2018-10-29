function getGradesAsJson()
{
    var json = {};
    json["subjectGradeMap"] = {};

    $("#grade-editor-div").children().find("[name=gradeInput]").each(function (i)
    {
        // TODO: Check validity.
        json["subjectGradeMap"][$(this).attr("coursename")] = $(this).val();
    });

    return JSON.stringify(json);
}