<%@ page contentType="text/html;charset=UTF-8" %>
<html>
    <head>
        <%@include file="/includes/head/head.jsp"%>
    </head>
    <body class="wallpaper">
        <%@include file="/includes/navbar/navbar.jsp"%>
        <%@include file="/includes/auth/login-modal.jsp"%>
        <%@include file="/includes/misc/js-detector-modal.jsp"%>
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
                            <%@include file="/includes/editor/grade-editor.jsp"%>
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
