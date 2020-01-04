<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="/WEB-INF/date.tld" prefix="datetag" %>
<%@taglib prefix="myTags" tagdir="/WEB-INF/tags" %>


<myTags:template>
    <jsp:attribute name="header">
        <h1>Mobile info</h1>
        (<datetag:DateTag plus="0"/>)
    </jsp:attribute>
   <jsp:body>

   <ul class="list-group">
       <li class="list-group-item">${mobile.id}</li>
       <li class="list-group-item">${mobile.model}</li>
       <li class="list-group-item">${mobile.price}</li>
       <li class="list-group-item">${mobile.manufacturer}</li>
    </ul>

    <br>
    <a href="/mobiles/">Main page</a>


   </jsp:body>
</myTags:template>