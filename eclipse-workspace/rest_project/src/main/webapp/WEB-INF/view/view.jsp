<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<% request.setCharacterEncoding("UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상세 조회</title>
<style>
    #tr_btn_modify {
        display: none;
    }
</style>
<script>
    function backToList(frm) {
        frm.action = "${contextPath}/notice/list";
        frm.submit();
    }
    function fn_enable() {
        document.querySelector('#i_title').disabled = false;
        document.querySelector('#i_content').disabled = false;
        document.querySelector('#tr_btn').style.display = 'none';
        document.querySelector('#tr_btn_modify').style.display = 'table-row';
    }
    function fn_modify_article(frm) {
        frm.action = "${contextPath}/notice/edit";
        frm.submit();
    }
    function fn_remove(url, no) {
        let form = document.createElement("form");
        form.setAttribute("method", "post");
        form.setAttribute("action", url);
        let input = document.createElement("input");
        input.setAttribute("type", "hidden");
        input.setAttribute("name", "articleNo");
        input.setAttribute("value", no);
        form.appendChild(input);
        document.body.appendChild(form);
        form.submit();
    }
</script>
</head>
<body>
    <form name="articleForm" method="post" action="${contextPath}">
        <table border="0" align="center">
            <tbody>
                <tr>
                    <td width="150" align="center" bgcolor="#FF9933">글번호</td>
                    <td>
                        <input type="text" value="${article.article_no}" disabled/>
                        <input type="hidden" value="${article.article_no}" name="articleNo"/>
                    </td>
                </tr>
                <tr> 
                    <td width="150" align="center" bgcolor="#FF9933">작성자</td>
                    <td>
                        <input type="text" value="${article.write_id}" name="writer" disabled/>
                    </td>
                </tr>
                <tr> 
                    <td width="150" align="center" bgcolor="#FF9933">제목</td>
                    <td>
                        <input type="text" value="${article.title}" name="title" id="i_title" disabled/>
                    </td>
                </tr>
                <tr> 
                    <td width="150" align="center" bgcolor="#FF9933">내용</td>
                    <td>
                        <textarea rows="20" cols="60" name="content" id="i_content" disabled>${article.content}</textarea>
                    </td>
                </tr>
                <tr> 
                    <td width="20%" align="center" bgcolor="#FF9933">작성일</td>
                    <td>
                        <input type="text" value="${article.write_date}" disabled/>
                    </td>
                </tr>
                <tr id="tr_btn">
                    <td colspan="2" align="center">
                        <input type="button" value="수정" onclick="fn_enable()" />
                        <input type="button" value="삭제" onclick="fn_remove('${contextPath}/notice/remove', '${article.article_no}')" />
                        <input type="button" value="목록보기" onclick="backToList(articleForm)" />
                    </td>
                </tr>
                <tr id="tr_btn_modify">
                    <td colspan="2" align="center">
                        <input type="button" value="저장" onclick="fn_modify_article(articleForm)" />
                        <input type="button" value="취소" onclick="backToList(articleForm)" />
                    </td>
                </tr>
            </tbody>
        </table>
    </form>
</body>
</html>