<%--
 * 此文件由 Hykilpikonna 在 2018/10/07 创建!
 * Created by Hykilpikonna on 2018/10/07!
 * Github: https://github.com/hykilpikonna
 * Meow!
 *
 * @author Hykilpikonna 
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<div class="hy-row">
    <div class="row">
        <div class="col-sm">
            <h4 class="ui header">%course-name%</h4>
        </div>
    </div>
    <div class="row">
        <div class="col-sm">
            <div class="ui fluid input hy-input">
                <!--input id="ge-%id%" name="ge-input" coursename="%course-name%" type="text" placeholder="Grade"-->
                <div class="ui fluid search selection dropdown">
                    <input id="ge-%id%" name="ge-input" coursename="%course-name%" type="hidden">
                    <div class="default text">Grade</div>
                    <div class="menu">
                        %dropdown-entries%
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
