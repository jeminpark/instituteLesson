/**
 * 
 */


const choiceAllBox = document.querySelector("choiceAll");

choiceAllBox

if(document.querySelector("#choiceAll").checked === true){
	
	alert("hi");
	choiceAll();
}
function choiceAll(){
	$(".box1").checked= true;
	
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