<%-- 
    Document   : alunos
    Created on : 13/11/2014, 11:24:48
    Author     : maycon
--%>

<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Exibir Alunos - DAO</title>
        <style type="text/css">
            <%@include file="/css/stylesheet.css" %>
        </style>
    </head>
    <body>
        <div align="center"><br>
            <table class="tabelaRich750">
                <tbody>
                    <tr class="rowDarkGreen">
                        <td style="text-align: center;" class="labelsBranco">Atualizar</td>
                        <td style="text-align: center;" class="labelsBranco">Nome</td>
                        <td style="text-align: center;" class="labelsBranco">Matrícula</td>
                        <td style="text-align: center;" class="labelsBranco">CPF</td>
                        <td style="text-align: center;" class="labelsBranco">Ano Ingresso</td>
                        <td style="text-align: center;" class="labelsBranco">Excluir</td>                        

                    </tr>
                    <c:if test="${!empty listaAlunos}">
                        <c:forEach var="aluno" items="${listaAlunos}">
                            <tr>
                                <td style="vertical-align: top; text-align: center;">
                                     <a href="atualizarAluno?cpf=${aluno.cpf}"  class="hiperlink">
                                         <c:out value="${aluno.alunoId}" />                                        
                                    </a>                                    
                                </td>                                
                                <td class="alignLeft"><c:out value="${aluno.nome}" /></td>                               
                                <td class="alignLeft"><c:out value="${aluno.numeroMatricula}" /></td>
                                <td class="alignLeft"><c:out value="${aluno.cpf}" /></td>
                                <td class="alignLeft"><c:out value="${aluno.anoIngresso}" /></td>                                
                                <td class="alignCenter">
                                    <a href="excluirAluno?cpf=${aluno.cpf}" class="hiperlink">Exluir</a>
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
        <a href="cadastrarAluno.htm" class="hiperlink">Cadastrar novo aluno.</a>
    </body>
</html>
