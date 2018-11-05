<%--
 * 此文件由 Hykilpikonna 在 2018/10/07 创建!
 * Created by Hykilpikonna on 2018/10/07!
 * Github: https://github.com/hykilpikonna
 * Meow!
 *
 * @author Hykilpikonna 
--%>
<%@ page contentType="text/html;charset=UTF-8" %>

<div class="hy-operating-buttons">
    <button class="ui basic teal labeled icon button" onclick="studentProfileAddEntry(0, '', '', '')">
        <i class="plus icon"></i>
        Add Entry
    </button>
    <button class="ui basic labeled icon button" onclick="loadOldProfileFromServer()">
        <i class="download icon"></i>
        Reload Old Settings
    </button>
    <button class="ui green right labeled icon button" onclick="uploadNewSettings()">
        <i class="upload icon"></i>
        Upload New Settings
    </button>
</div>