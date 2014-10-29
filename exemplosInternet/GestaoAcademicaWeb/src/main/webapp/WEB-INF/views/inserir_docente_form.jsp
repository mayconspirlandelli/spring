<%-- 
    Document   : inserir-docente-form
    Created on : 29/10/2014, 10:04:42
    Author     : maycon
--%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Cadastro de Docentes</title>
    </head>
    <body>        

        <h3>Formulário de Cadastro de Docentes</h3>
        <form:form method="post" action="adicionar.html" commandName="docente">
            <table>
                <tr>
                    <td>Nome:</td>
                    <td><form:input path="nome" /></td>
                </tr>                
                <tr>
                    <td>Matrícula:</td>
                    <td><form:input path="matricula" /></td>
                </tr>                
                <tr>
                    <td>Titulação:</td>
                    <td><form:input path="titulacao" /></td>
                </tr>                
                <tr>
                    <td colspan="2"></td>
                <input type="submit" value="Salvar" />
            </tr>                
        </table>               

    </form:form>
</body>
</html>
