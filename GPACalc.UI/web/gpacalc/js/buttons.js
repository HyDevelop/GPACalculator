var btn = {};

/**
 * Grades calculation page buttons
 */
btn.ge = {};

/**
 * Student profile settings page buttons
 */
btn.sp = {};

/**
 * Grades ranges settings page buttons
 */
btn.gr = {};

/**
 * Calculate GPA
 *
 * @param button Button
 */
btn.ge.submit = function (button)
{
    $(button).addClass("loading").addClass("disabled");
    api.send("data.calculate", getGradesAsJson(),

        function (grade)
        {
            msg.success("Grades Calculated: ", Math.round(grade * 1000.0) / 1000.0);
            $(button).removeClass("loading").removeClass("disabled");
        },

        function (error)
        {
            // Reset on fail
            $(button).removeClass("loading").removeClass("disabled");
            return true;
        },

        "record-in-graph", $("#ge-record-in-graph.checkbox").checkbox("is checked")
    )
};

/**
 * Add entry to student profile editor.
 */
btn.sp.add = function ()
{
    studentProfileAddEntry(countStudentProfileEditorEntries(), '', '', '');
};

/**
 * Upload student profile to server.
 */
btn.sp.upload = function ()
{
    var json = getStudentProfileAsJson();
    api.send("data.set.student-profile", JSON.stringify(json), success =>
    {
        msg.success("Your Settings Are Uploaded!", success);
        cache.studentProfile = json;
        renderGradesPage(cache.studentProfile, cache.gradingProfile);
    });
};

/**
 * Reload
 */
btn.sp.reload = btn.gr.reload = function ()
{
    cache.loadFromServer(() => renderProfilesInCache());
};

/**
 * Remove an entry.
 *
 * @param element The element of the close icon button.
 */
btn.sp.remove = btn.gr.remove = function (element)
{
    $(element).parent().parent().remove();
};

/**
 * Add entry to grade ranges editor.
 */
btn.gr.add = function ()
{
    gradeRangesAddEntry(countGradeRangeEntries(), '', '')
};

/**
 * TODO: Upload grade ranges (grading profile) to server.
 */
btn.gr.upload = function ()
{
    msg.notImplemented();
};