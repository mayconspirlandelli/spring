<%-- 
    Document   : cadastroCliente
    Created on : 19 mai 2011, 17:04:14
    Author     : vinicius
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <title>Formulário para cadastro de produto</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <style type="text/css">
            <%@include file="/css/stylesheet.css" %>
        </style>
    </head>
    <body>
        <form:form method="POST" commandName="cliente" action="autenticar.html">
            <div align="center"><br><br>
                <table class="tabelaRich500">
                    <tr>
                        <td colspan="2" style="text-align: center;" class="rowDarkGreen">
                            <label class="titulos">Formulário de Autenticação de Usuário</label>
                        </td>
                    </tr>
                    <tr><td>&nbsp;</td><td></td></tr>
                    <tr>
                        <td class="alignRight">
                            <form:label path="usuario" cssClass="labelsBold">Usuário:</form:label>
                        </td>
                        <td class="alignLeft">
                            <form:input path="usuario" />
                        </td>
                    </tr>
                    <tr>
                        <td class="alignRight">
                            <form:label path="senha" cssClass="labelsBold">Senha:</form:label>
                        </td>
                        <td class="alignLeft">
                            <form:password path="senha" />
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2" class="alignCenter">
                            <label class="errorMessage">${message}</label>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2" class="alignCenter">
                            <input type="submit" value="Autenticar"/>
                        </td>
                    </tr>
                </table>
            </div>
        </form:form>
        <br>
        <a href="index.html" class="hiperlink">Início.</a><br>
    </body>
</html>