<%--
 * 此文件由 Hykilpikonna 在 2018/10/07 创建!
 * Created by Hykilpikonna on 2018/10/07!
 * Github: https://github.com/hykilpikonna
 * Meow!
 *
 * @author Hykilpikonna 
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
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
<script>
    // Reload page when hide
    $('#modal-login').on({
        'hide.uk.modal': function ()
        {
            reload();
        }
    });
</script>