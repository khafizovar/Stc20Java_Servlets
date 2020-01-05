<%--
  Created by IntelliJ IDEA.
  User: xMol4unx
  Date: 03.01.2020
  Time: 12:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
