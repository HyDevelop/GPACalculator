<%--
 * 此文件由 Hykilpikonna 在 2018/11/11 创建!
 * Created by Hykilpikonna on 2018/11/11!
 * Github: https://github.com/hykilpikonna
 * QQ: admin@moecraft.cc -OR- 871674895
 *
 * @author Hykilpikonna 
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<div class="row hy-row">
    <div class="col-sm">
        <div class="ui fluid input hy-input">
            <input id="gr-letter-grade-%id%" type="text" placeholder="Letter Grade">
        </div>
    </div>
    <div class="col-sm">
        <div class="ui fluid input hy-input">
            <input id="gr-percentage-%id%" type="text" placeholder="Minimum Percentage">
        </div>
    </div>
    <div class="hy-close-icon">
        <i class="close icon" onclick="studentProfileRemoveEntry(this)"></i>
    </div>
</div>
