
function showHideMenuLinks() {

    if (!sessionStorage.getItem('authToken')){
        $('#linkMenuAppHome').show();
        $('#linkMenuLogin').show();
        $('#linkMenuRegister').show();
        $('#linkMenuUserHome').hide();
        $('#linkMenuMyMessages').hide();
        $('#linkMenuArchiveSent').hide();
        $('#linkMenuSendMessage').hide();
        $('#linkMenuLogout').hide();
        $('#spanMenuLoggedInUser').hide();
    }
    else{
        $('#linkMenuAppHome').hide();
        $('#linkMenuLogin').hide();
        $('#linkMenuRegister').hide();
        $('#linkMenuUserHome').show();
        $('#linkMenuMyMessages').show();
        $('#linkMenuArchiveSent').show();
        $('#linkMenuSendMessage').show();
        $('#linkMenuLogout').show();
        $('#spanMenuLoggedInUser').show();
    }
}

function hideInfoBoxes() {
    $('#loadingBox').hide();
    $('#infoBox').hide();
    $('#errorBox').hide();
}

function showView(viewName) {
    $('main > section').hide();
    $('#' + viewName).show();
}

function showHomeAppView() {
    showView('viewAppHome');
}

function showLoginView() {
    showView('viewLogin');
    $('#formLogin').trigger('reset');
}

function showRegisterView() {
    showView('viewRegister');
    $('#formRegister').trigger('reset');
}

function showUserHomeView() {
    showView('viewUserHome');
}

function showMyMessagesView() {
    showView('viewMyMessages');
}

function showArchiveSentView() {
    showView('viewArchiveSent');
}

function showSendMessageView() {
    showView('viewSendMessage');
    $('#formSendMessage').trigger('reset');
}
