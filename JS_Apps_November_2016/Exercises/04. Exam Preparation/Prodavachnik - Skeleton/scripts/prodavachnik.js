function startApp() {
    sessionStorage.clear();
    showHideMenuLinks();
    showView('viewHome');

    // Bind the navigation menu links
    $('#linkHome').click(showHomeView);
    $('#linkLogin').click(showLoginView);
    $('#linkRegister').click(showRegisterView);
    $('#linkListAds').click(listAds);
    $('#linkCreateAd').click(showCreateAdView);
    $('#linkLogout').click(logoutUser);

// Bind the form submit buttons
    $('#buttonLoginUser').click(loginUser);
    $('#buttonRegisterUser').click(registerUser);
    $('#buttonCreateAd').click(createAd);
    $('#buttonEditAd').click(editAd);

// Bind info / error boxes
    $('#infoBox').click(function () {
        $(this).fadeOut();
    });

    $('#errorBox').click(function () {
        $(this).fadeOut();
    });

// Attach AJAX "loading" event listener
    $(document).on({
        ajaxStart: function () {
            $('#loadingBox').show();
        },
        ajaxStop: function () {
            $('#loadingBox').hide();
        }
    });
}