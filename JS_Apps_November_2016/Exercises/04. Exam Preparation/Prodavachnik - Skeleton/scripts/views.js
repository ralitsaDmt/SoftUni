
function showHideMenuLinks() {
    $('#linkHome').show();

    if (sessionStorage.getItem('authToken')){
        $('#linkLogin').hide();
        $('#linkRegister').hide();
        $('#linkListAds').show();
        $('#linkCreateAd').show();
        $('#linkLogout').show();
    }
    else{
        $('#linkLogin').show();
        $('#linkRegister').show();
        $('#linkListAds').hide();
        $('#linkCreateAd').hide();
        $('#linkLogout').hide();
    }
}

function showView(viewName) {
    $('main > section').hide();
    $('#' + viewName).show();
}

function showHomeView() {
    showView('viewHome');
}

function showLoginView() {
    showView('viewLogin');
}

function showRegisterView() {
    showView('viewRegister');
}

function showCreateAdView() {
    showView('viewCreateAd');
}

function showEditAdView() {
    showView('viewEditAd');
}

function showListAdsView() {
    showView('viewAds');
}

function showAdDetails() {
    showView('viewDisplayAd');
}
