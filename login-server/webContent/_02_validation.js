/**
 * 
 */

function checkSelectAll(){
	const privateCheck = document.querySelectorAll('input[name = "necessary"]');
	const privateChecked = document.querySelectorAll('input[name = "necessary"]:checked');
	const choiceCheck = document.querySelectorAll('input[name = "choice"]');
	const choiceChecked = document.querySelectorAll('input[name = "choice"]:checked');
	const choiceAll = document.querySelector('input[name = "choiceAll"]');
	
	
	console.log(privateCheck.length);
	console.log(privateChecked.length);
	console.log(choiceCheck.length);
	console.log(choiceChecked.length);
	console.log(privateCheck.length+choiceCheck.length);
	if((privateCheck.length+choiceCheck.length) === (privateChecked.length + choiceChecked.length)){
		choiceAll.checked = true;
		
	}
	else{
		choiceAll.checked = false;
	}
}


function checkAllBox(selectAll){
	const privateCheck = document.getElementsByName('necessary');
	const choiceCheck = document.getElementsByName('choice');
	
	privateCheck.forEach(e =>{
		e.checked = selectAll.checked;
	})
	choiceCheck.forEach(e =>{
		e.checked = selectAll.checked;
	})
	
}


function checkVal(form){
	
	let cnt = 0;
	for(let i=0; i<form.necessary.length; i++){
		
		if(form.necessary[i].checked === true){
			cnt++;
		}
	}
	if(cnt === 2){
		form.submit();
	}
	else{
		document.querySelector("p#error").innerHTML = `${"다음단계로 넘어가시려면 반드시 필수항목의 사항을 체크 표시하여야합니다."}`;
	}
	
}

function passwordTest(){
	let pw1 = document.querySelector("#pw1").value;
	let pw2 = document.querySelector("#pw2").value;
	
	if(pw1 !=="" && pw2 !==""){
		
		if(pw1 === pw2){
			return true;
		}
		else{
			alert("비밀번호가 일치하지 않습니다.");
			document.querySelector("#pw1").value = "";
			document.querySelector("#pw2").value = "";
			//console.log(pw1);
			//console.log(pw2);
			document.querySelector("#pw1").focus();
		}
	}
	
	
}
function dataChange(form){
	const joinData = form;
	
	checkInfo(joinData);
}
function checkBirth(){
	
	const year = document.querySelector("#yyyy").value;
	const date = document.querySelector("#dddd").value;
	
	if(year >= 1900 && year <= 2021){
		if(date >= 1 && date <= 31){
			return true;
		}
		else{
			alert("날짜를 다시 입력해주세요. 1~31");
			$("#dddd").val("");
			$("#dddd").focus();
		}
		
	}
	else{
		alert("연도를 다시 입력해주세요. 1900 ~ 2021")
		$("#yyyy").val("");
		$("#yyyy").focus();
	}
	
	
	
}


function checkInfo(data){
	const id = data.id.value;
	const pw1 = data.pw1.value;
	const pw2 = data.pw2.value;
	const name = data.names.value;
	const yyyy = data.yyyy.value;
	const mmmm = data.mmmm.value;
	const dddd = data.dddd.value;
	const gender = data.gender.value;
	const mobile = data.mobile.value;
	
	if(id === "" || pw1 === "" || pw2 === "" || name === "" ||
		yyyy === "" || mmmm === "" || dddd === "" || gender === "" || mobile === "" ){
			document.querySelector("p#errorMsg").innerHTML = `${"인적사항을 정확히 기입해 주세요."}`;
	}
	else{
		data.submit();
	}
	
}

/*function checkInfo(data){
	let cnt = 0;
	for(let i=0; i<data.required.length; i++){
		
		const formValue = data.required[i].value;
		if(formValue !== ""){
			cnt++;
			console.log(formValue);
			console.log(cnt);
		}
	}
	if(cnt === 9){
		data.submit();
	}
	else{
		document.querySelector("p#errorMsg").innerHTML = `${"인적사항을 정확히 기입해주세요."}`;
	}
}
*/
function checkEmail(){
	const inputEmail = document.querySelector("#email").value;
	
	let emailEx = /^[A-Za-z0-9_]+[A-Za-z0-9]*[@]{1}[A-Za-z0-9]+[A-Za-z0-9]*[.]{1}[A-Za-z]{1,3}$/;


	if(inputEmail.match(emailEx) != null){
		
		return false;
	}
	else{
		alert("이메일 형식이 올바르지 않습니다.");
		$("#email").val("");
		$("#email").focus();
		return true;
	}
}


function loginCheck(form){
	const id = form.id.value;
	const pw = form.pw.value;
	
	
	if(id !== "" && pw !== ""){
		window.sessionStorage.setItem("login", id);
		form.submit();
	}
	else{
		document.querySelector("#errorMsg").innerHTML = `${"아이디 또는 비밀번호를 입력해주세요."}`;
		$(document).ready(function(){
			$("input[name = id]").focus();
		})
	}

	
	
}

const boardControl = function(boardNo, like, Id){
	this.boardNo = boardNo;
	this.like = like;
	this.Id = Id;
	
}

function checkContent(form){
	
	const subtitle = form.subtitle.value;
	const content = form.content.value;
	const password = form.password.value;
	
	if(subtitle === ""){
		$('#errorMsg').text("제목을 입력하세요.");
	}
	else if(content === ""){
		$('#errorMsg').text("내용을 입력하세요.");
	}
	else if(password === ""){
		$('#errorMsg').text("비밀번호를 입력하세요.");
	}
	else if(subtitle !== "" && content !== "" && password !== ""){
		
		new BoardControl();
		form.submit();
	}
}

function updateKey(form){
	const password = form.password.value;
	
	if(password !== ""){
		form.submit();
		
	}
	else{
		document.querySelector("#errorMsg3").innerHTML = `${"비밀번호를 입력해주세요."}`
	}

}
function btnClick(){
	window.sessionStorage.removeItem("login");
	location.href = "_09_logoutPro.jsp";
}
const likeOn = 1;
const likeOff = 0;

let likeCheck = likeOff;

const users = function(){
	
}

function likeClick(){
		
	
	const loginInfo = window.sessionStorage.getItem("login");
	
	if(loginInfo !== ""){		
		
		if(likeCheck === likeOn){
			
			likeCheck = likeOff;
			document.querySelector("#likePanel").innerHTML = `${"👍"}`;
		}
		else{
			likeCheck = likeOn;
			document.querySelector("#likePanel").innerHTML = `${"0"}`;
		}
	}
	else{
		alert("로그인 먼저 해주세요.");
	}
}




