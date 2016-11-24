function attachEvents() {

    const kinveyAppId = "kid_r1xUOrGGg";
    const serviceUrl = "https://baas.kinvey.com/appdata/" + kinveyAppId;
    const kinveyUsername = "guest";
    const kinveyPassword = "guest";
    const base64auth = btoa(kinveyUsername + ":" + kinveyPassword);
    const authHeaders = { "Authorization": "Basic " + base64auth };

    $('button.add').click(addCatch);
    $('button.load').click(loadCatches);

    function loadCatches() {
        $.ajax({
            url: serviceUrl + "/biggestCatches",
            method: "GET",
            contentType: "application/json",
            headers: authHeaders,
            success: displayCatches,
            error: displayError
        });
    }

    function displayCatches(data) {
        $('#catches').empty();

        for (let fish of data){
            let catchDiv = $('<div>').addClass('catch').attr('id', fish._id);

            catchDiv.append($('<label>').text('Angler'))
                .append($('<input>')
                    .attr('type', 'text')
                    .attr('class', 'angler')
                    .attr('value', fish.angler))
                .append($('<label>').text('Weight'))
                .append($('<input>')
                    .attr('type', 'number')
                    .attr('class', 'weight')
                    .attr('value', fish.weight))
                .append($('<label>').text('Species'))
                .append($('<input>')
                    .attr('type', 'text')
                    .attr('class', 'species')
                    .attr('value', fish.species))
                .append($('<label>').text('Location'))
                .append($('<input>')
                    .attr('type', 'text')
                    .attr('class', 'location')
                    .attr('value', fish.location))
                .append($('<label>').text('Bait'))
                .append($('<input>')
                    .attr('type', 'text')
                    .attr('class', 'bait')
                    .attr('value', fish.bait))
                .append($('<label>').text('Capture Time'))
                .append($('<input>')
                    .attr('type', 'number')
                    .attr('class', 'captureTime')
                    .attr('value', fish.captureTime))
                .append($('<button>')
                    .addClass('update')
                    .text('Update')
                    .click(() => updateCatch(fish._id)))
                .append($('<button>')
                    .addClass('delete')
                    .text('Delete')
                    .click(() => deleteCatch(fish._id)));

            $('#catches').append(catchDiv);
        }
    }

    function updateCatch(catchId) {

        let angler = $('#' + catchId + ' input.angler').val();
        let weight = Number($('#' + catchId + ' input.weight').val());
        let species = $('#' + catchId + ' input.species').val();
        let location = $('#' + catchId + ' input.location').val();
        let bait = $('#' + catchId + ' input.bait').val();
        let captureTime = Number($('#' + catchId + ' input.captureTime').val());

        let requestBody = {angler, weight, species, location, bait, captureTime};

        $.ajax({
            url: serviceUrl + "/biggestCatches/" + catchId,
            method: "PUT",
            headers: authHeaders,
            data: requestBody,
            error: displayError
        })
    }

    function deleteCatch(catchId) {
        $.ajax({
            url: serviceUrl + "/biggestCatches/" + catchId,
            method: "DELETE",
            headers: authHeaders,
            success: loadCatches,
            error: displayError
        })
    }
    
    function addCatch() {

        let angler = $('#addForm input.angler').val();
        let weight = Number($('#addForm input.weight').val());
        let species = $('#addForm input.species').val();
        let location = $('#addForm input.location').val();
        let bait = $('#addForm input.bait').val();
        let captureTime = Number($('#addForm input.captureTime').val());

        let requestBody = {angler, weight, species, location, bait, captureTime};

        $.ajax({
            url: serviceUrl + "/biggestCatches",
            method: "POST",
            contentType: "application/json",
            headers: authHeaders,
            data: JSON.stringify(requestBody),
            success: clearFields,
            error: displayError
        });
    }

    function clearFields() {
        $('#addForm input.angler').val('');
        $('#addForm input.weight').val('');
        $('#addForm input.species').val('');
        $('#addForm input.location').val('');
        $('#addForm input.bait').val('');
        $('#addForm input.captureTime').val('');

        loadCatches();
    }

    function displayError(err) {
        console.log(err.statusText);
    }
}