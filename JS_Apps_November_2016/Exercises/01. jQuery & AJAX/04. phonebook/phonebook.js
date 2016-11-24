function attachEvents() {

    $('#btnLoad').click(loadPhonebookEntries);
    $('#btnCreate').click(createEntry);

    let hostUrl = "https://phonebook-nakov.firebaseio.com/phonebook.json";

    function createEntry() {
        let name = $('#person').val();
        let number = $('#phone').val();

        $('#person').val('');
        $('#phone').val('');

        let newEntry = {
            person: name,
            phone: number
        };

        $.post(hostUrl, JSON.stringify(newEntry))
            .then(loadPhonebookEntries);
    }

    function loadPhonebookEntries() {
        $.get(hostUrl)
            .then(displayPhonebookEntries)
            .catch(displayError);
    }

    function displayPhonebookEntries(data) {

        $('ul#phonebook').empty();

        for (let key in data){
            let entry = data[key];

            let li = $('<li>').text(entry.person + ':' + entry.phone + ' ')
                .append($('<button>').text('[Delete]').click(() => deleteEntry(key)));
            $('ul#phonebook').append(li);
        }
    }

    function deleteEntry(key) {
        let delUrl = `https://phonebook-nakov.firebaseio.com/phonebook/${key}.json`;

        $.ajax({
            url: delUrl,
            type: "DELETE",
            success: loadPhonebookEntries,
            error: displayError
        });
    }

    function displayError(err) {
        //console.log("Error: " + err.statusCode);
    }
}