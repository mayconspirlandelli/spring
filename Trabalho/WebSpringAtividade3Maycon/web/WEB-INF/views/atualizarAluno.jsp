<%-- 
    Document   : atualizarAluno
    Created on : 13/11/2014, 11:25:25
    Author     : maycon
--%>

<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Formulário para cadastro de cliente</title>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <style type="text/css">
            <%@include file="/css/stylesheet.css" %>
        </style>
    </head>
    <body>
        <form:form method="POST" commandName="aluno" action="alunoAtualizado.htm">
            <div align="center"><br><br>
                <table class="tabelaRich750">
                    <tr>
                        <td colspan="3" style="text-align: center;" class="rowDarkGreen">
                            <label class="titulos">Formulário para atualização de cliente</label>
                        </td>
                    </tr>
                    <tr><td>&nbsp;</td><td></td><td></td></tr>
                    <tr>
                        <td class="alignRight">
                            <form:label path="nome" cssClass="labelsBold">Nome:</form:label>
                        </td>
                        <td class="alignLeft">
                            <form:input path="nome" />
                        </td>
                        <td style="text-align: left;"><form:errors path="nome" cssClass="errorMessage" /></td>
                    </tr>
                    <tr>
                        <td class="alignRight">
                            <form:label path="numeroMatricula" cssClass="labelsBold">Número Matrícula:</form:label>
                        </td>
                        <td class="alignLeft">
                            <form:input path="numeroMatricula" />
                        </td>
                        <td class="alignLeft"><form:errors path="numeroMatricula" cssClass="errorMessage" /></td>
                    </tr>
                    <tr>
                        <td class="alignRight">
                            <form:label path="anoIngresso" cssClass="labelsBold">Ano de Ingresso:</form:label>
                        </td>
                        <td class="alignLeft">
                            <form:input path="anoIngresso" />
                        </td>
                        <td class="alignLeft"><form:errors path="anoIngresso" cssClass="errorMessage" /></td>
                    </tr>
                    <tr>
                        <td class="alignRight">
                            <form:label path="cpf" cssClass="labelsBold">CPF:</form:label>
                        </td>
                        <td class="alignLeft">
                            <form:input path="cpf" />
                        </td>
                        <td class="alignLeft"><form:errors path="cpf" cssClass="errorMessage" /></td>
                    </tr>
                    <tr><td>&nbsp;</td><td></td><td></td></tr>
                    <tr>
                        <td colspan="3" class="alignCenter">
                            <input type="submit" value="Salvar"/>
                        </td>
                    </tr>
                </table>
            </div>
        </form:form>
        <br><br>
        <a href="index.html" class="hiperlink">Início.</a><br>
        <a href="cliente.html" class="hiperlink">Página do cliente.</a><br>
        <a href="mostraClientes.html" class="hiperlink">Mostrar clientes.</a>
    </body>
</html>