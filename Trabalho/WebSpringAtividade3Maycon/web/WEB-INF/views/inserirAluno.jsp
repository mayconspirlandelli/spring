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
        <title>Formul�rio para cadastro de cliente</title>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <style type="text/css">
            <%@include file="/css/stylesheet.css" %>
        </style>
    </head>
    <body>
        <form:form method="POST" commandName="cliente" action="clienteCadastrado.html" >
            <div align="center"><br><br>
                <table class=" tabelaRich750">
                    <tr>
                        <td colspan="3" style="text-align: center;" class="rowDarkGreen">
                            <label class="titulos">Formul�rio de Cadastro de Cliente</label>
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
                            <form:label path="telefoneFixo" cssClass="labelsBold">Telefone fixo:</form:label>
                        </td>
                        <td class="alignLeft">
                            <form:input path="telefoneFixo" />
                        </td>
                        <td class="alignLeft"><form:errors path="telefoneFixo" cssClass="errorMessage" /></td>
                    </tr>
                    <tr>
                        <td class="alignRight">
                            <form:label path="telefoneCelular" cssClass="labelsBold">Telefone celular:</form:label>
                        </td>
                        <td class="alignLeft">
                            <form:input path="telefoneCelular" />
                        </td>
                        <td class="alignLeft"><form:errors path="telefoneCelular" cssClass="errorMessage" /></td>
                    </tr>
                    <tr>
                        <td class="alignRight">
                            <form:label path="sexo" cssClass="labelsBold">Sexo:</form:label>
                        </td>
                        <td class="alignLeft">
                                <form:radiobutton path="sexo" value="feminino" label="Feminino" /><br>
                                <form:radiobutton path="sexo" value="masculino" label="Masculino" />
                        </td>
                        <td class="alignLeft"><form:errors path="sexo" cssClass="errorMessage" /></td>
                    </tr>
                    <tr>
                        <td class="alignRight">
                            <form:label path="usuario" cssClass="labelsBold">Usu�rio:</form:label>
                        </td>
                        <td class="alignLeft">
                            <form:input path="usuario"/>
                        </td>
                        <td class="alignLeft"><form:errors path="usuario" cssClass="errorMessage" /></td>
                    </tr>
                    <tr>
                        <td class="alignRight">
                            <form:label path="senha" cssClass="labelsBold">Senha:</form:label>
                        </td>
                        <td class="alignLeft">
                            <form:password path="senha"/>
                        </td>
                        <td class="alignLeft"><form:errors path="senha" cssClass="errorMessage" /></td>
                    </tr>
                    <%-- tr>
                        <td class="alignRight">
                            <form:label path="dataNascimento" cssClass="labelsBold">Data de nascimento:</form:label>
                        </td>
                        <td class="alignLeft">
                            <form:input path="dataNascimento" maxlength="10"/>
                        </td>
                        <td class="alignLeft"><form:errors path="dataNascimento" cssClass="errorMessage" /></td>
                    </tr --%>
                    <%-- Exemplo para usar formado de Date. 
                    <fmt:formatDate value="${yourObject.date}" var="dateString" pattern="dd/MM/yyyy" />
                        <form:input path="date" value="${dateString} .. />
                    --%>
                    <tr>
                        <td class="alignRight">
                            <form:label path="cpf" cssClass="labelsBold">CPF:</form:label>
                        </td>
                        <td class="alignLeft">
                            <form:input path="cpf"/>
                        </td>
                        <td class="alignLeft"><form:errors path="cpf" cssClass="errorMessage" /></td>
                    </tr>
                    <tr>
                        <td class="alignRight">
                            <form:label path="administrador" cssClass="labelsBold">Administrador:</form:label>
                        </td>
                        <td class="alignLeft">
                                <form:radiobutton path="administrador" value="false" label="N�o" /><br>
                                <form:radiobutton path="administrador" value="true" label="Sim" />
                        </td>
                        <td class="alignLeft"><form:errors path="administrador" cssClass="errorMessage" /></td>
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
        <a href="index.html" class="hiperlink">In�cio.</a><br>
        <a href="cliente.html" class="hiperlink">P�gina do cliente.</a>
    </body>
</html>