var cache = {};

/**
 * Load profiles from server and cache them.
 *
 * @param callback Callback function after loaded
 */
cache.loadFromServer = function(callback)
{
    api.send("data.get.student-profile", "", function (studentProfile)
    {
        cache.studentProfile = JSON.parse(studentProfile);
        if (cache.gradingProfile != null) callback();
    });

    api.send("data.get.grading-profile", "", function (gradingProfile)
    {
        cache.gradingProfile = JSON.parse(gradingProfile);
        if (cache.studentProfile != null) callback();
    });
};

/**
 * Update profiles from local html input elements.
 */
cache.update = function()
{
    // TODO: Update from local settings
    cache.studentProfile = getStudentProfileAsJson();
};
