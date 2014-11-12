<%-- 
    Document   : mostraClientes
    Created on : 08 sept. 2014, 14:07:00
    Author     : Maycon Spirlandelli
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mostra Clientes - DAO</title>
        <style type="text/css">
            <%@include file="/css/stylesheet.css" %>
        </style>
    </head>
    <body>
        <div align="center"><br>
            <table class="tabelaRich750">
                <tbody>
                    <tr class="rowDarkGreen">
                        <td style="text-align: center;" class="labelsBranco">CPF(click para atualizar)</td>
                        <td style="text-align: center;" class="labelsBranco">Nome</td>
                        <td style="text-align: center;" class="labelsBranco">Telefone Fixo</td>
                        <td style="text-align: center;" class="labelsBranco">Celular</td>
                        <td style="text-align: center;" class="labelsBranco">Sexo</td>
                        <td style="text-align: center;" class="labelsBranco">Usuario</td>
                        <td style="text-align: center;" class="labelsBranco">Data Nasc.</td>                        
                        <td style="text-align: center;" class="labelsBranco">Administrador</td>                        
                        <td style="text-align: center;" class="labelsBranco">Excluir cliente</td>                        

                    </tr>
                    <c:if test="${!empty listaClientes}">
                        <c:forEach var="cliente" items="${listaClientes}">
                            <tr>
                                <td style="vertical-align: top; text-align: center;">
                                    <a href="atualizarCliente?cpf=${cliente.cpf}"  class="hiperlink">
                                        <c:out value="${cliente.cpf}" />
                                    </a>                                    
                                </td>
                                <td class="alignLeft"><c:out value="${cliente.nome}" /></td>                               
                                <td class="alignLeft"><c:out value="${cliente.telefoneFixo}" /></td>                               
                                <td class="alignLeft"><c:out value="${cliente.telefoneCelular}" /></td>
                                <td class="alignLeft"><c:out value="${cliente.sexo}" /></td>
                                <td class="alignLeft"><c:out value="${cliente.usuario}" /></td>
                                <td class="alignLeft"><c:out value="${cliente.dataNascimento}" /></td>                                
                                <td class="alignLeft">   
                                    <c:if test="${cliente.administrador}">Sim</c:if>
                                    <c:if test="${!cliente.administrador}">Não</c:if>
                                    </td>
                                    <td class="alignCenter">
                                        <a href="excluirCliente?cpf=${cliente.cpf}" class="hiperlink">Exluir</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </c:if>
                </tbody>
            </table>
            <label class="errorTitle">${message}</label>
        </div>
        <br>
        <a href="index.html" class="hiperlink">Início</a><br>
        <a href="produto.html" class="hiperlink">Página de produtos</a><br>
        <a href="cadastrarProduto.html" class="hiperlink">Cadastrar produto</a>
    </body>
</html>
