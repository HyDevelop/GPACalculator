<%@ page contentType="text/html;charset=UTF-8" %>
<html>
    <head>
        <%@include file="libs/imports-head.jsp"%>
    </head>
    <body class="wallpaper">
        <%@include file="includes/navbar/navbar.jsp"%>
        <%@include file="includes/misc/js-detector-modal.jsp"%>
        <div id="messages-div"></div>
        <div class="uk-container hy-container">
            <div class="uk-position-relative">
                <div class="uk-position-relative uk-margin">
                    <ul class="uk-tab hy-tab" uk-tab>
                        <li aria-expanded="true" class="uk-active"><a href="#">Grades</a></li>
                        <li aria-expanded="false" class=""><a href="#">Course Settings</a></li>
                        <li aria-expanded="false" class=""><a href="#">Grade Ranges</a></li>
                        <li aria-expanded="false" class=""><a href="#">School Settings</a></li>
                        <li aria-expanded="false" class=""><a href="#">Customization</a></li>
                    </ul>

                    <ul class="uk-switcher uk-margin">
                        <li class="uk-active">
                            <div id="grade-editor-div"></div>
                            <%@include file="includes/editor/grade-editor-end.jsp"%>
                        </li>
                        <li>
                            <%@include file="includes/editor/student-profile-editor-head.jsp"%>
                            <div id="student-profile-editor-div"></div>
                            <%@include file="includes/editor/student-profile-editor-end.jsp"%>
                        </li>
                        <li>
                            <%@include file="includes/editor/grade-ranges-head.jsp"%>
                            <div id="grade-ranges-div"></div>
                            <%@include file="includes/editor/grade-ranges-end.jsp"%>
                        </li>
                        <li>
                            <div id="weight-head-div"></div>
                            <div id="weight-template-div"></div>
                            <%@include file="includes/editor/weight-editor-end.jsp"%>
                        </li>
                        <li>
                            <%@include file="includes/editor/customization.jsp"%>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
    </body>
</html>
<%@include file="libs/imports-end.jsp"%>
