<%-- 
    Document   : administrador
    Created on : 19 mai 2011, 09:49:31
    Author     : vinicius
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style type="text/css">
            <%@include file="/css/stylesheet.css" %>
        </style>
    </head>
    <body>
        <div align="center"><br><br>
            <table class="tabelaRich500">
                <tr>
                    <td class="rowDarkGreen">
                        <label class="titulos">${message}</label>
                    </td>
                </tr>
                <tr><td><br></td></tr>
                <tr>
                    <td class="alignCenter">
                        <a href="index.html" class="hiperlink">Início.</a>
                    </td>
                </tr>
                <tr><td><br></td></tr>
                <tr>
                    <td class="alignCenter">
                        <a href="cliente.html" class="hiperlink">Página de clientes.</a>
                    </td>
                </tr>
                <tr><td><br></td></tr>
                <tr>
                    <td class="alignCenter">
                        <a href="produto.html" class="hiperlink">Página de produtos.</a>
                    </td>
                </tr>
                <tr><td><br></td></tr>
            </table>
        </div>

    </body>
</html>
