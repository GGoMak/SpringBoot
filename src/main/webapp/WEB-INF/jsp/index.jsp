<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML>
<html>
<head>
    <title>스프링부트 웹서비스</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>

<h1>스프링부트로 시작하는 웹 서비스</h1>
<div class="col-md-12">
    <div class="row">
        <div class="col-md-6">
        </div>
    </div>
    <br>

    <!-- 게시글 출력 -->

    <table class="table table-horizontal table-bordered">
        <thead class="thead-strong">
        <tr>
            <th>게시글번호</th>
            <th>제목</th>
            <th>작성자</th>
            <th>최종수정일</th>
        </tr>
        </thead>
        <tbody id="tbody">
        <c:forEach items="${posts}" var="row">
            <tr>
                <td>${row.id}</td>
                <td><a href="/posts/update/${row.id}">${row.title}</a></td>
                <td>${row.author}</td>
                <td>${row.modifiedDate}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <!-- Pagination -->

    <div style="width: 100%; text-align: center">
        <div style="display: inline-block;">
            <nav aria-label="Page navigation example">
                <ul class="pagination">
                    <c:if test="${pageMaker.page.page < 1}">
                        <li class="page-item"><a class="page-link" href="<c:url value="/?page=${pageMaker.page.page-1}&keyword=${pageMaker.page.keyword}"/>">이전</a></li>
                    </c:if>
                    <c:forEach begin="${pageMaker.startPage}" end="${pageMaker.endPage}" var="pageNum">
                        <li class="page-item"><a class="page-link" href="<c:url value="/?page=${pageNum}&keyword=${pageMaker.page.keyword}"/>">${pageNum}</a></li>
                    </c:forEach>
                    <c:if test="${pageMaker.page.page <= pageMkaer.endpage}">
                    <li class="page-item"><a class="page-link" href="<c:url value="/?page=${pageMaker.page.page+1}&keyword=${pageMaker.page.keyword}"/>">다음</a></li>
                    </c:if>
                </ul>
            </nav>
        </div>
    </div>

    <!-- 검색 창 -->

    <form>
        <div class="form-group row justify-content-center">
            <div class="w100" style="padding-right:10px">
                <select class="form-control form-control-sm" name="searchType" id="searchType">
                    <option value="title">제목</option>
                    <option value="content">본문</option>
                    <option value="author">작성자</option>
                </select>
            </div>
            <div class="w300" style="padding-right:10px">
                <input type="text" class="form-control form-control-sm" name="keyword" id="keyword">
            </div>
            <div>
                <button class="btn btn-sm btn-primary" id="btnSearch" type="submit">검색</button>
            </div>
        </div>
    </form>

    <!-- 로그인, 글쓰기 -->

    <div style="float: right;">
        <c:if test="${userName != null}">
        Logged in as: <span id="user">${userName}</span>
        <a href="/logout" class="btn btn-info active" role="button">Logout</a>
        </c:if>
        <c:if test="${userName == null}">
            <a href="/user/login" class="btn btn-dark active" role="button">로그인</a>
        </c:if>
        <a href="/posts/save" role="button" class="btn btn-primary">글 등록</a>
    </div>
</div>

<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<!--index.js 추가-->
<script src="/js/app/index.js"></script>
<script src="/js/app/paging.js"></script>
</body>
</html>