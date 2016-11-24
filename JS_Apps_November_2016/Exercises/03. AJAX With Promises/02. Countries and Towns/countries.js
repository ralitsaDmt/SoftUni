function solveCountries() {

    const kinveyAppId = "kid_rkUVoxmzx";
    const serviceUrl = "https://baas.kinvey.com/appdata/" + kinveyAppId;
    const kinveyUsername = "guest";
    const kinveyPassword = "guest";
    const base64auth = btoa(kinveyUsername + ":" + kinveyPassword);
    const authHeaders = { "Authorization": "Basic " + base64auth };

    $('#btnDisplayCountries').click(loadCountries);
    $('#btnAddCountry').click(addCountry);

    function addCountry() {

        let name = $('#countryName').val();
        $('#countryName').val('');

        if (name !== ''){
            let country = {name};
            $.ajax({
                url: serviceUrl + "/countries",
                method: "POST",
                contentType: "application/json",
                headers: authHeaders,
                data: JSON.stringify(country),
                success: loadCountries,
                error: displayError
            });
        }
    }

    function loadCountries() {

        $.ajax({
            url: serviceUrl + "/countries",
            method: "GET",
            headers: authHeaders,
            success: displayCountries,
            error: displayError
        })
    }

    function displayCountries(data) {

        let table = $('<table>')
            .append($('<tr>')
                .append($('<th>').text("ID"))
                .append($('<th>').text('Country Name')));

        for (let country of data){
            let row = $('<tr>').attr('id', country._id)
                .append($('<td>').text(country._id))
                .append($('<td>').text(country.name))
                .append($('<td>')
                    .append($('<button>')
                        .attr('id', 'btnLoadEdit' + country._id)
                        .text("Edit country")
                        .click(() => loadEditCountry(country._id)))
                    .append($('<input>')
                        .attr('id', 'name' + country._id)
                        .css('display', 'none'))
                    .append($('<button>')
                        .attr('id', 'btnEdit' + country._id)
                        .text("Edit")
                        .css('display', 'none')
                        .click(() => editCountry(country._id))))
                .append($('<td>')
                    .append($('<button>')
                        .text('[Delete country]')
                        .click(() => deleteCountry(country._id))));

            table.append(row);
        }

        $('#displayCountries').empty().append($(table));
    }

    function deleteCountry(countryId) {

        $.ajax({
            url: serviceUrl + "/countries/" + countryId,
            method: "DELETE",
            headers: authHeaders,
            success: loadCountries,
            error: displayError
        });
    }

    function loadEditCountry(countryId) {

        $('#btnLoadEdit' + countryId).hide();
        $('#btnEdit' + countryId).show();
        $('#name' + countryId).show();
    }

    function editCountry(countryId) {
        let newCountry = $('#name' + countryId).val();

        console.log(newCountry);

        if (newCountry !== ''){
            let newName = {name: newCountry};

            $.ajax({
                url: serviceUrl + "/countries/" + countryId,
                method: "PUT",
                headers: authHeaders,
                contentType: "application/json",
                data: JSON.stringify(newName),
                success: loadCountries,
                error: displayError
            })
        }
    }

    function displayError(err) {
        console.log(err.statusText);
    }
}