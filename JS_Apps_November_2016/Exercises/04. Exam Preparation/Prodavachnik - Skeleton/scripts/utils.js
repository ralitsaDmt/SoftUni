
function showInfo(message) {
    $('#infoBox').text(message);
    $('#infoBox').show();
    setTimeout(function () {
        $('#infoBox').fadeOut()
    }, 3000);
}

function showError(message) {
    $('#errorBox').text(message);
    $('#errorBox').show();
}

function handleAjaxError(response) {
    let errorMsg = JSON.stringify(response);

    if (response.readyState === 0){
        errorMsg = "Cannot cnnect due to newtwork error.";
    }

    if (response.responseJSON && response.responseJSON.description){
        errorMsg = response.responseJSON.description;
    }

    showError(errorMsg);
}

function getKinveyAuth() {
    return {'Authorization': 'Kinvey ' + sessionStorage.getItem('authToken')}
}