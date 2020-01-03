<%--
  Created by IntelliJ IDEA.
  User: xMol4unx
  Date: 03.01.2020
  Time: 12:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/WEB-INF/date.tld" prefix="datetag" %>
<%@taglib prefix="myTags" tagdir="/WEB-INF/tags" %>


<myTags:template>
    <jsp:attribute name="header">
        <h1>Login page</h1>
        (<datetag:DateTag plus="0"/>)
    </jsp:attribute>
    <jsp:body>

        <jsp:useBean id="mobile" class="org.lesson.pojo.Mobile" />
        <c:set target="${mobile}" property="model" value="FIRST" />
        <jsp:setProperty name="mobile" property="price" value="0" />

        <p style="color: red;">${errorMessage}</p>

        <form method="POST" action="${pageContext.request.contextPath}/login">
            <table border="0">
                <tr>
                    <td>User Name</td>
                    <td><input type="text" name="userName" value= "${user.userName}" /> </td>
                </tr>
                <tr>
                    <td>Password</td>
                    <td><input type="password" name="password" value= "${user.password}" /> </td>
                </tr>

                <tr>
                    <td colspan ="2">
                        <input type="submit" value= "Submit" />
                    </td>
                </tr>
            </table>
        </form>
    </jsp:body>
</myTags:template>