<%--
 * 此文件由 Hykilpikonna 在 2018/11/11 创建!
 * Created by Hykilpikonna on 2018/11/11!
 * Github: https://github.com/hykilpikonna
 * Meow!
 *
 * @author Hykilpikonna 
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<div class="row hy-row">
    <div class="col-sm">
        <div class="ui fluid input hy-input">
            <input id="gr-letter-%id%" name="gr-letter" type="text" placeholder="Letter Grade">
        </div>
    </div>
    <div class="col-sm">
        <div class="ui fluid input hy-input">
            <input id="gr-range-%id%" name="gr-range" type="text" placeholder="Percentage" oninput="checkNumeric(this)">
        </div>
    </div>
    <div class="hy-close-icon">
        <i class="close icon" onclick="studentProfileRemoveEntry(this)"></i>
    </div>
</div>
