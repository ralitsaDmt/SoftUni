function solveTowns() {

    const kinveyAppId = "kid_rkUVoxmzx";
    const serviceUrl = "https://baas.kinvey.com/appdata/" + kinveyAppId;
    const kinveyUsername = "guest";
    const kinveyPassword = "guest";
    const base64auth = btoa(kinveyUsername + ":" + kinveyPassword);
    const authHeaders = { "Authorization": "Basic " + base64auth };

    $('#btnSelectCountry').click(loadCountries);
    $('#btnViewTowns').click(loadTowns);
    $('#btnAddTown').click(addTown);



    function addTown() {

        let townName = $('#townName').val();
        let countryId = $('#countries').val();

        $('#townName').val('');

        if (townName !== '' && countryId){
            let town = {name: townName, country_id: countryId};

            $.ajax({
                url: serviceUrl + "/towns",
                method: "POST",
                headers: authHeaders,
                contentType: "application/json",
                data: JSON.stringify(town),
                success: loadTowns,
                error: displayError
            });
        }
    }

    function loadTowns() {
        let selectedCountryId = $('#countries').val();

        let requestUrl = serviceUrl + `/towns/?query={"country_id":"${selectedCountryId}"}`;

        $.ajax({
            url: requestUrl,
            method: "GET",
            headers: authHeaders,
            success: displayTowns,
            error: displayError
        });
    }

    function displayTowns(data) {
        let table = $('<table>')
            .append($('<tr>')
                .append($('<th>').text("Town ID"))
                .append($('<th>').text("Town Name")));

        for (let town of data){
            let tr = $('<tr>')
                .append($('<td>').text(town._id))
                .append($('<td>').text(town.name))
                .append($('<td>')
                    .append($('<button>')
                        .attr('id', 'btnLoadEdit' + town._id)
                        .text("Edit town")
                        .click(() => loadEditTown(town._id)))
                    .append($('<input>')
                        .attr('id', 'name' + town._id)
                        .css('display', 'none'))
                    .append($('<button>')
                        .attr('id', 'btnEdit' + town._id)
                        .text("Edit")
                        .css('display', 'none')
                        .click(() => editTown(town._id))))
                    .append($('<td>')
                        .append($('<button>')
                            .text('[Delete town]')
                            .click(() => deleteTown(town._id))));
            table.append(tr);
        }

        $('#displayTowns').empty().append(table);
    }

    function loadEditTown(townId) {

        $('#btnLoadEdit' + townId).hide();
        $('#btnEdit' + townId).show();
        $('#name' + townId).show();
    }

    function editTown(townId) {
        let newTown = $('#name' + townId).val();
        let countryId = $('#countries').val();

        if (newTown !== ''){
            let newName = {name: newTown, country_id: countryId};

            $.ajax({
                url: serviceUrl + "/towns/" + townId,
                method: "PUT",
                headers: authHeaders,
                contentType: "application/json",
                data: JSON.stringify(newName),
                success: loadTowns,
                error: displayError
            })
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
        $('#countries').empty();

        for (let country of data){
            let option = $('<option>')
                .text(country.name)
                .val(country._id);

            $('#countries').append(option);
        }
    }

    function deleteTown(townId) {

        $.ajax({
            url: serviceUrl + "/towns/" + townId,
            method: "DELETE",
            headers: authHeaders,
            success: loadTowns,
            error: displayError
        });
    }

    function displayError(err) {
        console.log(err.statusText);
    }
}