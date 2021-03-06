<!doctype html>
<html>
  <head lang="ko">
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="vendor/bootstrap_3.3.2/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="css/index.css" rel="stylesheet">
    <title>분석 결과</title>
  </head>
  <body class="container-fluid">

    <section class="mainSection container">
      <div class="contentBoxRow row">
          <div class="col-lg-4">
              <div class="panel">
                  <div class="panel-body text-center">
                      <svg id="genderChart"></svg>
                  </div>
                  <div class="contentSubject panel-footer">
                      GENDER
                  </div>
              </div>
          </div>

          <div class="col-lg-4">
              <div class="panel">
                  <div class="panel-body text-center">
                      <svg id="ageChart" width="300" height="200"></svg>
                  </div>
                  <div class="contentSubject panel-footer">
                      AGE
                  </div>
              </div>
          </div>

          <div class="col-lg-4">
              <div class="panel">
                  <div class="panel-body text-center">
                      컴퓨터과학
                  </div>
                  <div class="contentSubject panel-footer">
                      MAJOR
                  </div>
              </div>
          </div>
      </div>

      <div class="contentBoxRow row">
          <div class="col-lg-4">
              <div class="panel">
                  <div class="panel-body text-center">
                      ~~~~
                  </div>
                  <div class="contentSubject panel-footer">
                      AREA
                  </div>
              </div>
          </div>

          <div class="col-lg-4"></div>

          <div class="col-lg-4">
              <div class="panel">
                  <div class="panel-body text-center">
                      3.5
                  </div>
                  <div class="contentSubject panel-footer">
                      GRADE
                  </div>
              </div>
          </div>
      </div>

      <div class="contentBoxRow row">
          <div class="col-lg-4">
              <div class="panel">
                  <div class="panel-body text-center">
                      JAVA
                  </div>
                  <div class=" contentSubject panel-footer">
                      ABILIBILITY
                  </div>
              </div>
          </div>

          <div class="col-lg-4">
              <div class="panel">
                  <div class="panel-body text-center">
                      패기
                  </div>
                  <div class="contentSubject panel-footer">
                      Character
                  </div>
              </div>
          </div>

          <div class="col-lg-4">
              <div class="panel">
                  <div class="panel-body text-center">
                      AI 전문가
                  </div>
                  <div class="contentSubject panel-footer">
                      Career
                  </div>
              </div>
          </div>
      </div>
    </section>
  </body>

    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script src="vendor/bootstrap_3.3.2/js/bootstrap.min.js"></script>

    <!-- d3 JS -->
    <script src="http://d3js.org/d3.v3.min.js"></script>

    <script src="js/index.js"></script>
    <script src="js/test.js"></script>

    <script>
      INDEX.init();
      TEST.init();
    </script>
</html>