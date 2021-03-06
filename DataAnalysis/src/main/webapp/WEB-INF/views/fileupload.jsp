<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%> 
<c:set var="contextPath" value="<%= request.getContextPath()%>"></c:set>  
<html>
  <head lang="ko">
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="${contextPath}/resource/vendor/bootstrap_3.3.2/css/bootstrap.min.css" rel="stylesheet">
    
    <!-- Custom CSS -->
    <link href="${contextPath}/resource/css/main.css" rel="stylesheet">
    <link href="${contextPath}/resource/css/fileUpload.css" rel="stylesheet">

    <title>Name</title>
  </head>
  <body class="container">
    <nav class="navbar navbar-fixed-top main_color">
      <div class="container-fluid">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span> 
          </button>
          <a class="navbar-brand" href="#">Name</a>
        </div>
        <div class="collapse navbar-collapse" id="myNavbar">
          <ul class="nav navbar-nav">
            <li class="active"><a href="#">Home</a></li>
            <li><a href="#">Page 1</a></li>
            <li><a href="#">Page 2</a></li>
            <li><a href="#">Page 3</a></li>
          </ul>
        </div>
      </div>
    </nav>
    
    <form id="submitData" method="post" enctype="multipart/form-data" action="./csvFileSubmit.do">
      <div class="form-group col-lg-offset-3 col-lg-6">
        <div class="form-group row">
          <label for="nameInput" id="nameInputLabel" class="col-sm-2 col-form-label">이름: </label>
          <div class="col-sm-10">
            <input type="text" name="csvFileName" id= "nameInput" class="form-control" required>
          </div>
        </div>
        
      </div>
      <div class="form-group col-lg-offset-3 col-lg-6">
        <small id="fileUploadHelp" class="form-text text-muted">csv는 아래와 같이 정해진 열 순서대로 입력된 파일이어야 합니다.</small>
        <div class="row block_row">
          <table class="table table-bordered block_row">
            <thead>
              <tr>
                <th class="block_col">성별</th>
                <th class="block_col">나이</th>
                <th class="block_col">전공</th>
                <th class="block_col">지역</th>
                <th class="block_col">학점</th>
                <th class="block_col">IT역량</th>
                <th class="block_col">성향</th>
                <th class="block_col">커리어</th>
              </tr>
            </thead>
          </table>
        </div>
        <input type="file" accept=".csv" aria-describedby="fileUploadHelp" name="fileSelect" id= "fileSelect" class="form-control" required>
      </div>
      <div class="form-group col-lg-offset-3 col-lg-6">
        <button type="submit" class="btn btn-secondary btn-lg btn-block col-lg-12 button_submit">분석하기</button>
      </div>
    </form>

    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script src="${contextPath}/resource/vendor/bootstrap_3.3.2/js/bootstrap.min.js"></script>
    <script src="${contextPath}/resource/vendor/bootstrap_fileupload/bootstrap-filestyle.min.js"> </script>

    <!-- d3 JS -->
    <script src="https://d3js.org/d3.v3.min.js"></script>
    <script>
      $('#fileSelect').filestyle({
				buttonName : 'btn-danger',
        buttonText : ' csv 파일 선택하기'
      });
      
      $()
    </script>
    <script src="${contextPath}/resource/js/fileUpload.js"></script>

  </body>
</html>