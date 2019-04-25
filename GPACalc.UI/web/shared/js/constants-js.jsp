<%@ page import="cc.moecraft.school.Constants" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<script>
    class Constants
    {
        constructor()
        {
            this.client_id = "<%=Constants.GOOGLE_CLIENT_ID %>";
            this.base_url = "<%=request.getScheme().toLowerCase().replace("http", "https") + "://" +
                request.getServerName() + request.getContextPath()%>";
            this.api_url = this.base_url + "/api";
        }
    }

    const constants = new Constants();
</script>
