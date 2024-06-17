<%@ page import="ResumeJpaDb.Entity.User" %><%--
  Created by IntelliJ IDEA.
  User: user
  Date: 05-Jun-24
  Time: 17:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update</title>
    <script src="https://kit.fontawesome.com/aec1554bc2.js" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</head>
<body>
<%
    User u = (User) request.getAttribute("user");
%>
    <form action="userupdate" method="post" class="container" style="margin-top: 30px;">
        <input type="hidden" name="id" value="<%=u.getId()%>">
        <div class="form-group">
            <label for="Firstname">Firstname</label>
            <input type="text" class="form-control" name="firstname" value="<%=u.getFirstname()%>">
        </div>
        <div class="form-group">
            <label for="Lastname">Lastname</label>
            <input type="text" class="form-control" name="lastname" value="<%=u.getLastname()%>">
        </div>
        <div class="form-group">
            <label for="Email">Email address</label>
            <input type="email" class="form-control" name="email" value="<%=u.getEmail()%>">
        </div>
        <div class="form-group">
            <label for="Phone">Phone number</label>
            <input type="text" class="form-control" name="phone" value="<%=u.getPhone()%>">
        </div>
        <div class="form-group">
            <label for="ProfileDescription">Profile Description</label>
            <input type="text" class="form-control" name="profile_description" value="<%=u.getProfileDescription()%>">
        </div>
        <div class="form-group">
            <label for="Address">Address</label>
            <input type="text" class="form-control" name="address" value="<%=u.getAddress()%>">
        </div>
        <button type="submit" name="action" value="save" class="btn btn-primary">Save</button>
    </form>
</form>
</body>
</html>
