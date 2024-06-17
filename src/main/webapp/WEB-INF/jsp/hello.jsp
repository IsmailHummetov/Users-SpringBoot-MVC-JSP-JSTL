<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 16-Jun-24
  Time: 5:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<html>
<head>
    <title>Hello</title>
</head>
<body>
Hello ${name}
<c:set var = "salary" value = "${2000*2}"/>
<c:set var = "salary" value = "${salary*3}"/>
${salary}
</body>
</html>
