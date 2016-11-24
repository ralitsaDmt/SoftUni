function loadCommits() {

    $('#commits').empty();

    let url = "https://api.github.com/repos/" + $('#username').val() + '/' + $('#repo').val() + '/commits';



    $.get(url)
        .then(displayCommits)
        .catch(displayError);

    function displayCommits(commits) {

        $('#username').val('');
        $('#repo').val('');

        $('#commits').empty()

        for (let commit of commits){
            $('#commits').append($('<li>')
                .text(commit.commit.author.name + ':' + commit.commit.message));
        }
    }

    function displayError(error) {
        $('#commits').append($('<li>')
            .text("Error: " + error.status + ' (' + error.statusText + ')'));
    }
}