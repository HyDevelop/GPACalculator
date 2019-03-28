<%@ page import="cc.moecraft.school.Constants" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<script>
    class Constants
    {
        constructor()
        {
            this.client_id = "<%=Constants.GOOGLE_CLIENT_ID %>";
            this.api_url = "<%=request.getScheme() + "://" + request.getServerName() + ":" +
                               request.getServerPort() + request.getContextPath() + "/api"%>";
        }
    }

    const constants = new Constants();
</script>
