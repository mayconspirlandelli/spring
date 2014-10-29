<%-- 
    Document   : inserir-docente-form
    Created on : 29/10/2014, 10:04:42
    Author     : maycon
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Listagem de Docentes</title>
    </head>
    <body>
        <h3>Docentes Cadastrados</h3>
        <h3><a href="form">+ Novo Docente</h3></a>
        <c:if test="${!empty docenteList}">
        <table border="1">
            <tr>
                <th>Nome</th>
                <th>Matrícula</th>
                <th>Titulação</th>
                <th>&nbsp;</th>                
            </tr>
            <c:forEach items="${docenteList}" var="docente">
                <tr>
                    <td>${docente.nome}</td>
                    <td>${docente.matricula}</td>
                    <td>${docente.titulacao}</td>
                    <td><a href="remover/${docente.id}">Excluir</a></td>
                </tr>                
            </c:forEach>            
        </table>
    </c:if>            
</body>
</html>
