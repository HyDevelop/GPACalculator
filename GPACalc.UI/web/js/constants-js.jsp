<%@ page import="cc.moecraft.school.Constants" %><%--
 * 此文件由 Hykilpikonna 在 2018/10/20 创建!
 * Created by Hykilpikonna on 2018/10/20!
 * Github: https://github.com/hykilpikonna
 * QQ: admin@moecraft.cc -OR- 871674895
 *
 * @author Hykilpikonna 
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<script>
    class Constants
    {
        constructor()
        {
            this.client_id = "<%=Constants.GOOGLE_CLIENT_ID %>";
        }
    }

    const constants = new Constants();
</script>
