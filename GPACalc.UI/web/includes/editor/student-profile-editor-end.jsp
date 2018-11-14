<%--
 * 此文件由 Hykilpikonna 在 2018/10/07 创建!
 * Created by Hykilpikonna on 2018/10/07!
 * Github: https://github.com/hykilpikonna
 * Meow!
 *
 * @author Hykilpikonna 
--%>
<%@ page contentType="text/html;charset=UTF-8" %>

<div class="hy-operating-buttons uk-container">
    <button class="ui basic left floated labeled icon button" onclick="studentProfileAddEntry(countStudentProfileEditorEntries(), '', '', '')">
        <i class="plus icon"></i>
        Add Entry
    </button>
    <button class="ui basic blue right floated right labeled icon button" onclick="uploadStudentProfile()">
        <i class="upload icon"></i>
        Save
    </button>
    <button class="ui basic right floated labeled icon button" onclick="reloadSettings()">
        <i class="download icon"></i>
        Reload Old Settings
    </button>
</div>