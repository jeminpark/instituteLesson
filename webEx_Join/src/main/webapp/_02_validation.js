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
	let pw1 = document.getElementById("pw1").value;
	let pw2 = document.getElementById("pw2").value;
	
	if(pw1 !=="" && pw2 !==""){
		
		if(pw1 === pw2){
			
		}
		else{
			alert("비밀번호가 일치하지 않습니다.");
			
		}
	}
	
}
function dataChange(form){
	const joinData = form;
	
	checkInfo(joinData);
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
	if(cnt === 10){
		//form.submit();
	}
	else{
		document.querySelector("p#errorMsg").innerHTML = `${"인적사항을 정확히 기입해주세요."}`;
	}
}