let loginCheck = document.getElementById('loginCheck');
let registerCheck = document.getElementById('registerCheck');
let logoutCheck = document.getElementById('logoutCheck');
let mypageCheck = document.getElementById('mypageCheck');

function logout() {
    window.sessionStorage.removeItem('id');
}