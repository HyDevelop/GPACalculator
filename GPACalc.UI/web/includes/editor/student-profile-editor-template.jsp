<%--
 * 此文件由 Hykilpikonna 在 2018/10/07 创建!
 * Created by Hykilpikonna on 2018/10/07!
 * Github: https://github.com/hykilpikonna
 * Meow!
 *
 * @author Hykilpikonna 
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<div class="row hy-row">
    <div class="col-sm">
        <div class="ui fluid input hy-input">
            <input id="name-%id%" type="text" placeholder="Course Name">
        </div>
    </div>
    <div class="col-sm-2">
        <div class="ui fluid input hy-input">
            <input id="level-%id%" type="text" placeholder="Level">
        </div>
    </div>
    <div class="col-sm-1">
        <div class="ui fluid input hy-input">
            <input id="credits-%id%" type="text" placeholder="Credits" oninput="checkNumeric(this.id)">
        </div>
    </div>
    <div class="hy-close-icon">
        <i class="close icon" onclick="studentProfileRemoveEntry(this)"></i>
    </div>
</div>