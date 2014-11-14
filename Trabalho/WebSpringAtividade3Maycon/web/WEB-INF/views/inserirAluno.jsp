<%-- 
    Document   : inserirAluno
    Created on : 13/11/2014, 11:25:58
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
        <form:form method="POST" commandName="aluno" action="alunoCadastrado.html" >
            <div align="center"><br><br>
                <table class=" tabelaRich750">
                    <tr>
                        <td colspan="3" style="text-align: center;" class="rowDarkGreen">
                            <label class="titulos">Formulário de Cadastro de Aluno</label>
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
                        <td class="alignLeft"><form:errors path="nome" cssClass="errorMessage" /></td>
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
                        <form:input path="anoIngresso" maxlength="4" size="4" />
                        </td>
                        <td class="alignLeft"><form:errors path="anoIngresso" cssClass="errorMessage" /></td>
                    </tr>                    
                    <tr>
                        <td class="alignRight">
                            <form:label path="cpf" cssClass="labelsBold">CPF:</form:label>
                        </td>
                        <td class="alignLeft">
                        <form:input path="cpf" size="10" maxlength="11" />
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
        <a href="obterAlunos.htm" class="hiperlink">Mostrar alunos.</a>
    </body>
</html>