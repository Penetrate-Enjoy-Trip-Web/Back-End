let loginCheck = document.getElementById('loginCheck');
let registerCheck = document.getElementById('registerCheck');
let logoutCheck = document.getElementById('logoutCheck');
let mypageCheck = document.getElementById('mypageCheck');

if (window.sessionStorage.id) {
    loginCheck.style.display = 'none';
    registerCheck.style.display = 'none';
    logoutCheck.style.display = 'content';
    mypageCheck.style.display = 'content';
} else {
    loginCheck.style.display = 'content';
    registerCheck.style.display = 'content';
    logoutCheck.style.display = 'none';
    mypageCheck.style.display = 'none';
}

function logout() {
    window.sessionStorage.removeItem('id');
}