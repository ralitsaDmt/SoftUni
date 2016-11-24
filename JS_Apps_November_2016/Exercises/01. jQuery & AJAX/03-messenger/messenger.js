function solve() {
    $('#submit').click(send);
    $('#refresh').click(refresh);

    let hostUrl = "https://messenger-4e6da.firebaseio.com/messages.json";

    function send() {
        let message = {
            author: $('#author').val(),
            content: $('#content').val(),
            timestamp: Date.now()
        };

        $.post(hostUrl, JSON.stringify(message)).then(refresh());

        $('#author').val('');
        $('#content').val('');
    }

    function refresh() {

        $.get(hostUrl).then((result) => {
            let keys = Object.keys(result)
                .sort((m1, m2) => result[m1].timestamp - result[m2].timestamp);

            $('#messages').empty();
            for (let key of keys){
                let msg = result[key];

                $('#messages').append(`${msg.author}: ${msg.content}\n`);
            }
        });
    }
}