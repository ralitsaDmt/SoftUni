
function bindLinks() {
    $('#linkMenuAppHome').click(showHomeAppView);
    $('#linkMenuLogin').click(showLoginView);
    $('#linkMenuRegister').click(showRegisterView);
    $('#linkMenuUserHome').click(showUserHomeView);
    $('#linkMenuMyMessages').click(showReceivedMessages);
    $('#linkMenuArchiveSent').click(showArchivedMessages);
    $('#linkMenuSendMessage').click(showSendMessageForm);
    $('#linkMenuLogout').click(logoutUser);

    $('#linkUserHomeMyMessages').click(showReceivedMessages);
    $('#linkUserHomeSendMessage').click(showSendMessageForm);
    $('#linkUserHomeArchiveSent').click(showArchivedMessages);
}

function bindButtons() {
    $('#formLogin').submit(loginUser);
    $('#formRegister').submit(registerUser);

    $('#formSendMessage').submit(sendMessage);
}

$("#infoBox, #errorBox").click(function() {
    $(this).fadeOut();
});

$(document).on({
    ajaxStart: function() { $("#loadingBox").show() },
    ajaxStop: function() { $("#loadingBox").hide() }
});