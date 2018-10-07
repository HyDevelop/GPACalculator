<%@ page contentType="text/html;charset=UTF-8" %>
<html>
    <head>
        <%@include file="/includes/head/head.jsp"%>
    </head>
    <body>
        <%@include file="/includes/navbar/navbar.jsp"%>

        <!--div class="login-panel-overlay">
            <div>

            </div>
        </div-->
        <!-- This is a button toggling the modal -->
        <button class="uk-button uk-button-default uk-margin-small-right" type="button" uk-toggle="target: #modal-center">Open</button>

        <div id="modal-center" class="uk-flex-top" uk-modal>
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
<script>
    function onSignIn(googleUser)
    {
        // Useful data for your client-side scripts:
        var profile = googleUser.getBasicProfile();
        console.log("ID: " + profile.getId()); // Don't send this directly to your server!
        console.log('Full Name: ' + profile.getName());
        console.log('Given Name: ' + profile.getGivenName());
        console.log('Family Name: ' + profile.getFamilyName());
        console.log("Image URL: " + profile.getImageUrl());
        console.log("Email: " + profile.getEmail());

        // The ID token you need to pass to your backend:
        var id_token = googleUser.getAuthResponse().id_token;
        console.log("ID Token: " + id_token);
    }
</script>
