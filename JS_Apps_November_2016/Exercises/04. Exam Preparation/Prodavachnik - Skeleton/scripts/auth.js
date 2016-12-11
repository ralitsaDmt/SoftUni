
const kinveyBaseUrl = "https://baas.kinvey.com";
const kinveyAppKey = "kid_ByRqcS7fg";
const kinveyAppSecret = "8df7250e60ab449ebed5df48e5dc4c9f";
const kinveyAppAuthHeaders = { 'Authorization': 'Basic ' + btoa(kinveyAppKey + ':' + kinveyAppSecret)};

function registerUser() {
    let username = $('#formRegister input[name=username]').val();
    let password = $('#formRegister input[name=passwd]').val();
    
    let userData = {username, password};
    
    $.ajax({
        method: "POST",
        url: kinveyBaseUrl + '/user/' + kinveyAppKey,
        headers: kinveyAppAuthHeaders,
        data: userData,
        success: registerSuccess,
        error: handleAjaxError
    });

    function registerSuccess(userInfo) {
        saveAuthInSession(userInfo);
        showHideMenuLinks();
        listAds();
        showInfo('User successfully registered.');
    }
}

function loginUser() {
    let username = $('#formLogin input[name=username]').val();
    let password = $('#formLogin input[name=passwd]').val();

    let userData = {username, password};

    $.ajax({
        method: "POST",
        url: kinveyBaseUrl + '/user/' + kinveyAppKey + '/login',
        headers: kinveyAppAuthHeaders,
        data: userData,
        success: loginSuccess,
        error: handleAjaxError
    });

    function loginSuccess(userInfo) {
        saveAuthInSession(userInfo);
        showHideMenuLinks();
        listAds();
        showInfo('Login successful.');
    }
}

function logoutUser() {
    sessionStorage.clear();
    showHideMenuLinks();
    showHomeView();
    $('#loggedInUser').text('');
    showInfo('Logout successful.');
}

function saveAuthInSession(userInfo) {
    let userAuth = userInfo._kmd.authtoken;
    sessionStorage.setItem('authToken', userAuth);

    let userId = userInfo._id;
    sessionStorage.setItem('userId', userId);

    let username = userInfo.username;
    $('#loggedInUser').text('Welcome, ' + username + '!');
}