<%--
 * 此文件由 Hykilpikonna 在 2018/10/19 创建!
 * Created by Hykilpikonna on 2018/10/19!
 * Github: https://github.com/hykilpikonna
 * Meow!
 *
 * @author Hykilpikonna 
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<div id="js-detector-modal" class="uk-flex-top uk-modal uk-flex uk-open" uk-modal="">
    <div class="uk-modal-dialog uk-modal-body uk-margin-auto-vertical">
        <button class="uk-modal-close-default" type="button" uk-close></button>
        <h2 class="uk-modal-title">JS Disabled</h2>
        <p>Why do u disable JS? This site won't work without JS...</p>
        <p class="uk-text-right">
        </p>
    </div>
</div>

<script>
    $(document).ready(function ()
    {
        console.log("hi");
        UIkit.modal("#js-detector-modal").toggle();
    })
</script>
