
function openModal(data) {
	document.getElementById('modal1').style.display = 'block';
	location.href = data;
}

function closeModal() {
	document.getElementById('modal').style.display = 'none';
	location.href = "main.html"
}

function login(){
	const id = document.getElementById("id").value;
	const userDatas = [];
	for(let i = 0; i < sessionStorage.length; i++){
		const key = sessionStorage.key(i);
		if(key == "user"){
			const userData = JSON.parse(sessionStorage.getItem(key));
			userDatas.push(userData);
		}
	}
	let flag = false;
	for(let i = 0; i < userDatas.length; i++){
		const user = userDatas[i];
		if(user.id == id){
			flag = true;
			break;
		}
	}
	if(flag){
		sessionStorage.setItem("id",id);
		closeModal();
	}
	else{
		alert("없는 아이디 입니다.");
	}
}

function makeId(){
	const userInfo = {
		id: document.getElementById("id").value,
		pw: document.getElementById("password").value,
		email: document.getElementById("email").value,
		name: document.getElementById("name").value
	  };
	  sessionStorage.setItem("user",JSON.stringify(userInfo));
	closeModal();
}

function checkId() { 
    alert("사용 가능한 아이디입니다.");
}

