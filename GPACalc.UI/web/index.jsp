<%@ page contentType="text/html;charset=UTF-8" %>
<html>
    <head>
        <%@include file="/includes/head/head.jsp"%>
    </head>
    <body>
        <%@include file="/includes/navbar/navbar.jsp"%>

        <div id="modal-login" class="uk-flex-top" uk-modal>
            <div class="uk-modal-dialog uk-modal-body uk-margin-auto-vertical">
                <button class="uk-modal-close-default" type="button" uk-close></button>
                <h2 class="uk-modal-title">Login</h2>
                <p>You have to login first... or else how can I possibly store any data about you?</p>
                <div class="g-signin2" data-onsuccess="onSignIn" data-theme="dark"></div>

                <p class="uk-text-right">
                </p>
            </div>
        </div>
    </body>
</html>
<%@include file="/includes/end/end.jsp"%>
