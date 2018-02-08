$(document).ready(function() {
    // 파일 타입 체크
    $('#fileSelect').on('change', function(e) {
        var selectFile = this.value;
        if(selectFile.slice(selectFile.indexOf(".") + 1).toLowerCase() != 'csv') {
            alert('csv 파일을 업로드해주세요.');
            // 입력 값 초기화
        }
    });


});