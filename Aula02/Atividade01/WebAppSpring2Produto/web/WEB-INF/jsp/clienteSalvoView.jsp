<%-- 
    Document   : clienteSalvoView
    Created on : 12 mai 2011, 15:38:02
    Author     : vinicius
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cliente Inserido</title>
        <style type="text/css">
            <%@include file="/css/stylesheet.css" %>
        </style>
    </head>
    <body>
        <div align="center"><br><br>
            <table class="tabelaRich500">
                <tr>
                    <td colspan="2" style="text-align: center;" class="rowDarkGreen">
                        <label class="titulos">Dados do cliente cadastrado:</label>
                    </td>
                </tr>
                <tr><td>&nbsp;</td><td></td></tr>
                <tr>
                    <td class="alignRight">
                        <label class="labelsBold">Nome:</label>
                    </td>
                    <td class="alignLeft">
                        <label class="infoMessage">${clienteService.cliente.nome}</label>
                    </td>
                </tr>
                <tr>
                    <td class="alignRight">
                        <label class="labelsBold">Telefone:</label>
                    </td>
                    <td class="alignLeft">
                        <label class="infoMessage">${clienteService.cliente.telefone}</label>
                    </td>
                </tr>
                <tr>
                    <td class="alignRight">
                        <label class="labelsBold">Email:</label>
                    </td>
                    <td class="alignLeft">
                        <label class="infoMessage">${clienteService.cliente.email}</label>
                    </td>
                </tr>
                <tr>
                    <td class="alignRight">
                        <label class="labelsBold">Sexo:</label>
                    </td>
                    <td class="alignLeft">
                        <label class="infoMessage">${clienteService.cliente.sexo}</label>
                    </td>
                </tr>
                <tr>
                    <td colspan="2" style="text-align: center;" class="rowDarkGreen">
                        <label class="titulos">${clienteService}</label>
                    </td>
                </tr>
            </table>
        </div>
        <br><br>
        <a href="index.htm" class="hiperlink">Início.</a><br>
        <a href="clienteFormView.htm" class="hiperlink">Formulário de cadastro de cliente.</a><br>
    </body>
</html>
