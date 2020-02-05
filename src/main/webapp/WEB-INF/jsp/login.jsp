<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>

<html>
<head>
    <title>스프링부트 웹서비스</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>

<div class="col-md-12">
    <div class="row">
        <div class="col-md-6">
            <form>
                <div class="form-group">
                    <label for="exampleInputEmail1">이메일</label>
                    <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter email">
                    <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
                </div>
                <div class="form-group">
                    <label for="exampleInputPassword1">패스워드</label>
                    <input type="password" class="form-control" id="exampleInputPassword1" placeholder="Password">
                </div>
                <a href="/oauth2/authorization/google" class="btn btn-secondary active" role="button">구글 로그인</a>
                <a href="/oauth2/authorization/naver" class="btn btn-success active" role="button">네이버 로그인</a>
                <a href="/oauth2/authorization/kakao" class="btn btn-warning active" role="button">카카오 로그인</a>
                <button type="submit" class="btn btn-primary">로그인</button>
            </form>
        </div>
    </div>
</div>

<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<!--index.js 추가-->
<script src="/js/app/index.js"></script>
<script src="/js/app/paging.js"></script>
</body>
</html>