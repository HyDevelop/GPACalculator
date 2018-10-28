<%@ page contentType="text/html;charset=UTF-8" %>
<html>
    <head>
        <%@include file="/includes/head/head.jsp"%>
    </head>
    <body class="wallpaper">
        <%@include file="/includes/navbar/navbar.jsp"%>
        <%@include file="/includes/auth/login-modal.jsp"%>
        <%@include file="/includes/misc/js-detector-modal.jsp"%>
        <div class="uk-container hy-container hy-message-container">
            <div class="ui error message hy-message">
                <i class="close icon"></i>
                <div class="header">
                    There were some errors with your submission
                </div>
                <ul class="list">
                    <li>You must include both a upper and lower case letters in your password.</li>
                    <li>You need to select your home country.</li>
                </ul>
            </div>
        </div>
        <div class="uk-container hy-container">
            <div class="uk-position-relative">
                <div class="uk-position-relative uk-margin-medium">
                    <ul class="uk-tab hy-tab" uk-tab>
                        <li aria-expanded="true" class="uk-active"><a href="#">Grades</a></li>
                        <li aria-expanded="false" class=""><a href="#">Course Settings</a></li>
                        <li aria-expanded="false" class=""><a href="#">School Settings</a></li>
                    </ul>

                    <ul class="uk-switcher uk-margin">
                        <li class="uk-active">
                            <div id="grade-editor-div"></div>
                            <%@include file="/includes/editor/grade-editor-end.jsp"%>
                        </li>
                        <li>
                            <%@include file="/includes/editor/student-profile-editor-head.jsp"%>
                            <div id="student-profile-editor-div"></div>
                            <%@include file="/includes/editor/student-profile-editor-end.jsp"%>
                        </li>
                        <li>
                            Text3
                        </li>
                    </ul>
                </div>
            </div>
        </div>
    </body>
</html>
<%@include file="/includes/end/end.jsp"%>
