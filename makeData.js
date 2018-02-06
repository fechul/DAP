var data = [];

var gender = ['M','W'];
var age = 0;
var area = ['서울', '인천', '경기도', '부산', '강원도', '전라도', '충청도', '경상도'];
var height= 0;
var weight= 0;
var language = ['C', 'Java', 'Python', 'C++', 'Javascript', 'Go'];
var like = ['AI', 'Bigdata', 'Cloud', 'Blockchain'];
var blood = ['A', 'B', 'O', 'AB'];
var codingScore = 0;
var interviewScore = 0;
var grade = 0;

var makeRandomIdx = function(limit, dup) {
	if(dup) {
		var num = Math.floor(Math.random() * 3) + 1;
		var res = [];
		while(1) {
			if(res.length == num) {
				break;
			}
			var resNum = Math.floor(Math.random() * limit);
			if(res.indexOf(resNum) == -1) {
				res.push(resNum);
			}
		}

		return res;
	} else {
		return (Math.floor(Math.random() * limit));
	}
};

var makeRandomNum = function(start, end) {
	var num = Math.floor(Math.random() * (end-start+1));
	return num + start;
};

var json = {
	'gender': '',
	'age': 0,
	'area': '',
	'height': 0,
	'weight': 0,
	'language': [],
	'like': [],
	'blood': '',
	'codingScore': 0,
	'interviewScore': 0,
	'grade': 0
};

for(var i = 0; i < 100; i++) {
	json = {};

	json.gender = gender[makeRandomIdx(2, false)];

	json.age = makeRandomNum(20, 30);

	json.area = makeRandomIdx(8, false);

	if(gender == 'M')
		json.height = makeRandomNum(165, 185);
	else
		json.height = makeRandomNum(150, 170);

	if(gender == 'M')
		json.weight = makeRandomNum(60, 90);
	else
		json.weight = makeRandomNum(40, 60);

	json.language = makeRandomIdx(6, true);

	json.like = makeRandomIdx(4, true);

	json.blood = makeRandomIdx(4, false);

	json.codingScore = makeRandomNum(0, 100);

	json.interviewScore = makeRandomNum(0, 100);

	json.grade = makeRandomNum(20, 45) / 10;

	data.push(json);
}

console.log(data);

