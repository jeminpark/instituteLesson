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