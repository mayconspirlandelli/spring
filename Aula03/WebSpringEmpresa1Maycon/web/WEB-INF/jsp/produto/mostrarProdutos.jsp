<%-- 
    Document   : mostraProdutos
    Created on : 2 sept. 2010, 17:22:00
    Author     : vinicius
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mostra Produtos - DAO</title>
        <style type="text/css">
            <%@include file="/css/stylesheet.css" %>
        </style>
    </head>
    <body>
        <div align="center"><br>
            <table class="tabelaRich750">
                <tbody>
                    <tr class="rowDarkGreen">
                        <td style="text-align: center;" class="labelsBranco">Código(click para atualizar)</td>
                        <td style="text-align: center;" class="labelsBranco">Nome</td>
                        <td style="text-align: center;" class="labelsBranco">Preço</td>
                        <td style="text-align: center;" class="labelsBranco">Descrição</td>
                        <td style="text-align: center;" class="labelsBranco">Excluir produto</td>
                    </tr>
                    <c:if test="${!empty listaProdutos}">
                        <c:forEach var="produto" items="${listaProdutos}">
                            <tr>
                                <td style="vertical-align: top; text-align: center;">
                                    <!-- Testa se o usuario é administrador, se sim, apresenta o link para alterar.-->
                                    <c:if test ="${cliente.administrador}">
                                        <a href="atualizarProduto?codigo=${produto.codigo}"  class="hiperlink">
                                            <c:out value="${produto.codigo}" />
                                        </a>
                                    </c:if>
                                    <!-- Testa se o usuario é administrador, se NÃO, não mostra opçao de alterar.-->
                                    <c:if test ="${!cliente.administrador}">                                        
                                        <c:out value="${produto.codigo}" />                                        
                                    </c:if>

                                </td>
                                <td class="alignLeft"><c:out value="${produto.nome}" /></td>
                                <td class="alignCenter"><c:out value="${produto.preco}" /></td>
                                <td class="alignLeft"><c:out value="${produto.descricao}" /></td>
                                <td class="alignCenter">
                                    <a href="excluirProduto?codigo=${produto.codigo}" class="hiperlink">Exluir</a>
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
