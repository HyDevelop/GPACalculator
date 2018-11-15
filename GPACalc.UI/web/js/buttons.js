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
btn.grades.submit = function (button)
{
    $(button).addClass("loading").addClass("disabled");
    send("data.calculate", getGradesAsJson(),
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
        })
};