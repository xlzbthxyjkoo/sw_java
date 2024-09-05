<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<% request.setCharacterEncoding("UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글쓰기</title>
<style>
    .class-caption {
        width:100px;
    }
    .class-content {
        width:500px;
    }
</style>
<script>
    function backToList(frm) {
        frm.action = "${contextPath}/notice/list";
        frm.submit();
    }
    async function sendArticle(frm) {
        let article = {title: document.querySelector('#title').value
            , content: document.querySelector("#content").value,
        };    

        try {
            const response = await fetch("${contextPath}/api/addarticle", {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: article,
            });

        } catch(err) {
            alert(err);
        }
    }
</script>
</head>
<body>
    <h1 style="text-align: center;">글쓰기</h1>
    <form name="articleForm" method="post" action="${contextPath}/notice/addarticle">
        <table border="0" align="center">
            <tbody>
                <tr>
                    <td align="right" class="class-caption">글제목: </td>
                    <td colspan="2">
                        <input type="text" maxlength="100" id="i_title" class="class-content" />
                    </td>
                </tr>
                <tr>
                    <td align="right" valign="top" class="class-caption"><br/>글내용:</td>
                    <td colspan="2">
                        <textarea id="i_content" rows="10" maxlength="2000" class="class-content"></textarea>
                    </td>
                </tr>
                <tr>
                    <td align="right">
                    </td>
                    <td colspan="2">
                        <input type="button" value="저장" onclick="sendArticle(articleForm)" />
                        <input type="button" value="목록보기" onClick="backToList(articleForm)" />
                    </td>
                </tr>
            </tbody>
        </table>
    </form>
</body>
</html>