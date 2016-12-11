
function saveAuthInSession(response) {
    let userId = response._id;
    let username = response.username;
    let name = response.name;
    let authToken = response._kmd.authtoken;

    sessionStorage.setItem('userId', userId);
    sessionStorage.setItem('username', username);
    sessionStorage.setItem('name', name);
    sessionStorage.setItem('authToken', authToken);

    $('#spanMenuLoggedInUser').text("Welcome, " + username + "!");
    $('#viewUserHomeHeading').text('Welcome, ' + username + '!');
}

function showInfo(message) {
    $('#infoBox').text(message);
    $('#infoBox').show();
    setTimeout(function() {
        $('#infoBox').fadeOut();
    }, 3000);
}

function showError(message) {
    $('#errorBox').text('Error: ' + message);
    $('#errorBox').show();
    $('#errorBox').click(function () {
        $('#errorBox').fadeOut();
    })
}

function handleAjaxError(response) {
    let errorMsg = JSON.stringify(response);
    if (response.readyState === 0)
        errorMsg = "Cannot connect due to network error.";
    if (response.responseJSON &&
        response.responseJSON.description)
        errorMsg = response.responseJSON.description;
    showError(errorMsg);
}

function formatDate(dateISO8601) {
    let date = new Date(dateISO8601);
    if (Number.isNaN(date.getDate()))
        return '';
    return date.getDate() + '.' + padZeros(date.getMonth() + 1) +
        "." + date.getFullYear() + ' ' + date.getHours() + ':' +
        padZeros(date.getMinutes()) + ':' + padZeros(date.getSeconds());

    function padZeros(num) {
        return ('0' + num).slice(-2);
    }
}

function formatSender(name, username) {
    if (!name)
        return username;
    else
        return username + ' (' + name + ')';
}
