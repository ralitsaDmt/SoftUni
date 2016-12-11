
function showReceivedMessages() {

    let username = sessionStorage.getItem('username');
    let query = `messages?query={"recipient_username":"${username}"}&sort={"_kmd.lmt": -1}`;

    get('appdata', query, 'Kinvey')
        .then(loadReceivedMessagesSuccess)
        .catch(handleAjaxError);
}

function loadReceivedMessagesSuccess(response) {

    let table = $('<table>')
        .append($('<thead>')
            .append($('<tr>')
                .append($('<th>').text('From'))
                .append($('<th>').text('Message'))
                .append($('<th>').text('Date Received'))));

    let tbody = $('<tbody>');
    for (let obj of response){

        let senderName = obj.sender_name;
        let senderUsername = obj.sender_username;
        let date = obj._kmd.ect;
        let message = obj.text;

        let tr = $('<tr>')
            .append($('<td>').text(formatSender(senderName, senderUsername)))
            .append($('<td>').text(message))
            .append($('<td>').text(formatDate(date)));

        $(tbody).append(tr);
    }

    $(table).append(tbody);

    $('#myMessages').empty().append(table);

    showMyMessagesView();
}

function showSendMessageForm() {

    get('user', '', 'Kinvey')
        .then(loadUsersSuccess)
        .catch(handleAjaxError);
}

function loadUsersSuccess(response) {

    let users = [];
    let currentUsername = sessionStorage.getItem('username');
    for (let obj of response){
        if (obj.username != currentUsername){
            users.push(obj);
        }
    }

    $('#msgRecipientUsername').empty();
    for (let user of users){
        let name = user.name;
        let username = user.username;

        let option = $('<option>')
            .attr('value', username)
            .text(formatSender(name, username));

        $('#msgRecipientUsername').append(option);
    }

    showSendMessageView();
}

function showArchivedMessages() {

    let userId = sessionStorage.getItem('userId');
    let query = `messages?query={"_acl.creator":"${userId}"}&sort={"_kmd.lmt": -1}`;

    get('appdata', query, 'Kinvey')
        .then(loadArchivedMessagesSuccess)
        .catch(handleAjaxError);
}

function loadArchivedMessagesSuccess(response) {

    let table = $('<table>')
        .append($('<thead>')
            .append($('<tr>')
                .append($('<th>').text('To'))
                .append($('<th>').text('Message'))
                .append($('<th>').text('Date Sent'))
                .append($('<th>').text('Actions'))));

    let tbody = $('<tbody>');

    for (let obj of response){

        let username = obj.recipient_username;
        let message = obj.text;
        let date = formatDate(obj._kmd.ect);
        let messageId = obj._id;

        let tr = $('<tr>')
            .append($('<td>').text(username))
            .append($('<td>').text(message))
            .append($('<td>').text(date))
            .append($('<td>')
                .append($('<button>')
                    .text('Delete')
                    .click((id) => deleteMessage(messageId))));

        $(tbody).append(tr);
    }

    $(table).append(tbody);

    $('#sentMessages').empty().append(table);

    showArchiveSentView();
}

function deleteMessage(messageId) {

    let query = 'messages/' + messageId;
    deleteRequest('appdata', query, 'Kinvey')
        .then(deleteMessageSuccess)
        .catch(handleAjaxError);
}

function deleteMessageSuccess(response) {
    showArchivedMessages();
    showInfo('Message deleted.');
}

function sendMessage(event) {

    event.preventDefault();

    let sender_username = sessionStorage.getItem('username');
    let sender_name = sessionStorage.getItem('name');
    let recipient_username = $('#msgRecipientUsername option:selected').val();
    let text = $('#msgText').val();

    let data = {
        sender_username,
        sender_name,
        recipient_username,
        text,
    };

    post('appdata', 'messages', 'Kinvey', data)
        .then(sendMessageSuccess);
}

function sendMessageSuccess(response) {
    showInfo('Message sent.');
    showArchivedMessages();
}