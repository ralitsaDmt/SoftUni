
function registerUser(event) {
    event.preventDefault();

    let username = $('#registerUsername').val();
    let password = $('#registerPasswd').val();
    let name = $('#registerName').val();

    let data = {username, password, name};

    post('user', '', 'Basic', data)
        .then(registerSuccess)
        .catch(handleAjaxError);
}

function registerSuccess(response) {
    showInfo('User registration successful.');
    saveAuthInSession(response);
    showUserHomeView();
    showHideMenuLinks();
}

function loginUser(event) {
    event.preventDefault();

    let username = $('#loginUsername').val();
    let password = $('#loginPasswd').val();

    let data = {username, password};

    post('user', 'login', 'Basic', data)
        .then(loginSuccess)
        .catch(handleAjaxError);
}

function loginSuccess(response) {
    showInfo('Login successful.');
    saveAuthInSession(response);
    showUserHomeView();
    showHideMenuLinks();
}

function logoutUser() {
    post('user', '_logout', 'Kinvey')
        .then(logoutSuccess)
        .catch(handleAjaxError);
}

function logoutSuccess(response) {
    showInfo('Logout successful.');
    sessionStorage.clear();
    showHideMenuLinks();
    showHomeAppView();
}


