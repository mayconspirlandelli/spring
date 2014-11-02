<%-- 
    Document   : produtoFormView
    Created on : 02 nov 2014, 10:14:36
    Author     : Maycon Spirlandelli
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/htm; charset=UTF-8">
        <title>Formulário do Produto</title>
        <style type="text/css">
            <%@include file="/css/stylesheet.css" %>
        </style>
    </head>
    <body>
<!--        A tag "commandName" é para indicar que vincula esta view com o modelo "clientService".-->
        <form:form method="POST" commandName="produtoService" action="produtoSalvoView.html">
            <div align="center"><br><br>
                <table class="tabelaRich500">
                    <tr>
                        <td colspan="2" style="text-align: center;" class="rowDarkGreen">
                            <label class="titulos">Formulário de Cadastro de Produto</label>
                        </td>
                    </tr>
                    <tr><td>&nbsp;</td><td></td></tr>
                    <tr>
                        <td class="alignRight">
                            <form:label path="produto.nome" cssClass="labelsBold">Nome:</form:label>
                        </td>
                        <td class="alignLeft">
                            <form:input path="produto.nome" />
                        </td>
                    </tr>
                    <tr>
                        <td class="alignRight">
                            <form:label path="produto.codigo" cssClass="labelsBold">Codigo:</form:label>
                        </td>
                        <td class="alignLeft">
                            <form:input path="produto.codigo" />
                        </td>
                    </tr>                    
                    <tr>
                        <td class="alignRight">
                            <form:label path="produto.preco" cssClass="labelsBold">Preço:</form:label>
                        </td>
                        <td class="alignLeft">
                            <form:input path="produto.preco" />
                        </td>
                    </tr>                    
                    <tr><td>&nbsp;</td><td></td></tr>
                    <tr>
                        <td colspan="2" class="alignCenter">
                            <input type="submit" value="Salvar"/>
                        </td>
                    </tr>
                    <tr><td>&nbsp;</td><td></td></tr>
                </table>
            </div>
        </form:form>
        <br><br>
        <a href="index.htm" class="hiperlink">Início.</a><br>
    </body>
</html>
