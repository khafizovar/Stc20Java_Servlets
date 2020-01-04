<%--
  Created by IntelliJ IDEA.
  User: xMol4unx
  Date: 04.01.2020
  Time: 6:57
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="/WEB-INF/date.tld" prefix="datetag" %>
<%@taglib prefix="myTags" tagdir="/WEB-INF/tags" %>


<myTags:template>
    <jsp:attribute name="header">
        <h1>Users list</h1>
        (<datetag:DateTag plus="0"/>)
    </jsp:attribute>
    <jsp:body>

        <table class="table">
            <thead>
            <tr>
                <th>username</th>
                <th>email</th>
                <th>phone number</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="user" items="${users}">
                <tr>
                    <td>${user.name}</td>
                    <td>${user.email}</td>
                    <td>${user.phoneNumber}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>

        <br>
        <a href="/mobiles/">Main page</a>


    </jsp:body>
</myTags:template>