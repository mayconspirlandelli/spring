<%-- 
Document   : cliente
Created on : 12 mai 2011, 21:26:00
Author     : vinicius
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <title>Página do Cliente.</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <style type="text/css">
            <%@include file="/css/stylesheet.css" %>
        </style>
    </head>
    <body>
        <c:if test="${fn:trim(cliente.cpf) == null or fn:trim(cliente.cpf) == 0}" >
            <c:redirect url="login.jsp" />
        </c:if>
        <c:if test="${fn:trim(cliente.cpf) != null and fn:trim(cliente.cpf) != 0}" >
            <div align="center"><br><br>
                <table class="tabelaRich500">
                    <tr>
                        <td colspan="2" style="text-align: center;" class="rowDarkGreen">
                            <label class="titulos">Página de cliente</label>
                        </td>
                    </tr>
                    <tr>
                        <td class="alignRight">
                            <label class="labelsBold">Nome:</label>
                        </td>
                        <td class="alignLeft">
                            <label class="infoMessage">${cliente.nome}</label>
                        </td>
                    </tr>
                    <tr>
                        <td class="alignRight">
                            <label class="labelsBold">Telefone fixo:</label>
                        </td>
                        <td class="alignLeft">
                            <label class="infoMessage">${cliente.telefoneFixo}</label>
                        </td>
                    </tr>
                    <tr>
                        <td class="alignRight">
                            <label class="labelsBold">Telefone celular:</label>
                        </td>
                        <td class="alignLeft">
                            <label class="infoMessage">${cliente.telefoneCelular}</label>
                        </td>
                    </tr>
                    <tr>
                        <td class="alignRight">
                            <label class="labelsBold">Sexo:</label>
                        </td>
                        <td class="alignLeft">
                            <label class="infoMessage">${cliente.sexo}</label>
                        </td>
                    </tr>
                    <tr>
                        <td class="alignRight">
                            <label class="labelsBold">Usuário:</label>
                        </td>
                        <td class="alignLeft">
                            <label class="infoMessage">${cliente.usuario}</label>
                        </td>
                    </tr>
                    <tr>
                        <td class="alignRight">
                            <label class="labelsBold">Data de nascimento:</label>
                        </td>
                        <td class="alignLeft">
                            <label class="infoMessage">
                                <fmt:formatDate pattern="MM/dd/yyyy" value="${cliente.dataNascimento}" />
                            </label>                            
                        </td>
                    </tr>
                    <tr>
                        <td class="alignRight">
                            <label class="labelsBold">CPF:</label>
                        </td>
                        <td class="alignLeft">
                            <label class="infoMessage">${cliente.cpf}</label>
                        </td>
                    </tr>
                    <tr>
                        <td class="alignRight">
                            <label class="labelsBold">Administrador:</label>
                        </td>
                        <td class="alignLeft">
                            <label class="infoMessage">
                                <c:if test="${cliente.administrador}">Sim</c:if>
                                <c:if test="${!cliente.administrador}">Não</c:if>
                                </label>
                         </td>
                        </tr>
                    </table>
                </div>
        </c:if>
        <br><br>
        <a href="index.html" class="hiperlink">Início.</a><br>
        <a href="atualizarCliente.html" class="hiperlink">Atualizar dados do cliente.</a><br>
        <a href="excluirCliente.html" class="hiperlink">Excluir cadastro do cliente.</a><br>
        <a href="logout.html" class="hiperlink">Logout.</a><br>
    </body>
</html>
