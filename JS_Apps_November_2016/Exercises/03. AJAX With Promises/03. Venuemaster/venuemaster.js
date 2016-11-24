function attachEvents() {
    const kinveyAppId = "kid_BJ_Ke8hZg";
    const serviceUrl = "https://baas.kinvey.com/";
    const kinveyUsername = "guest";
    const kinveyPassword = "pass";
    const base64auth = btoa(kinveyUsername + ":" + kinveyPassword);
    const authHeaders = { "Authorization": "Basic " + base64auth };

    $('#getVenues').click(getVenues);

    function getVenues() {
        let date = $('#venueDate').val();

        $.ajax({
            method: "POST",
            headers: authHeaders,
            url: serviceUrl + "rpc/" + kinveyAppId + "/custom/calendar?query=" + date,
            success: loadVenues,
            error: displayError
        })
    }

    function loadVenues(venuesData) {

        venuesData = venuesData.sort((a,b) => a.localeCompare(b));

        $('#venue-info').empty();

        for (let venue of venuesData){

            let url = serviceUrl + "appdata/" + kinveyAppId + '/venues/' + venue;

            $.ajax({
                url: url,
                method: "GET",
                headers: authHeaders,
                success: displayVenue,
                error: displayError
            });

        }
    }

    function displayVenue(venue) {

        let view = `<div class="venue" id="${venue._id}">` +
           `<span class="venue-name"><input class="info" type="button" value="More info">${venue.name}</span>` +
        `<div class="venue-details" style="display: none;">` +
            `<table>` +
            `<tr><th>Ticket Price</th><th>Quantity</th><th></th></tr>` +
        `<tr>` +
        `<td class="venue-price">${venue.price} lv</td>` +
        `<td><select class="quantity">` +
            `<option value="1">1</option>` +
            `<option value="2">2</option>` +
            `<option value="3">3</option>` +
            `<option value="4">4</option>` +
            `<option value="5">5</option>` +
            `</select></td>` +
            `<td><input class="purchase" type="button" value="Purchase"></td>` +
            `</tr>` +
            `</table>` +
            `<span class="head">Venue description:</span>` +
        `<p class="description">${venue.description}</p>` +
        `<p class="description">Starting time: ${venue.startingHour}</p>` +
        `</div>` +
        `</div>`;

        $('#venue-info').append(view);

        $('#' + venue._id + ' input[value="Purchase"]').click(() => buyTickets(venue._id, venue.price, venue.name));
        $('#' + venue._id).click(() => showMore(venue._id));
    }

    function buyTickets(venueId, price, name) {
        let qty = Number($('#' + venueId + ' select.quantity').val());
        price = Number(price);

        let span = `<span class="head">Confirm purchase</span>` +
                    `<div class="purchase-info">` +
                        `<span>${name}</span>` +
                        `<span>${qty} x ${price}</span>` +
                        `<span>Total: ${qty * price} lv</span>`+
                        `<input type="button" value="Confirm">` +
                    `</div>`;

        $('#venue-info').empty().append(span);

        $('.purchase-info input').click(() => confirmPurchase(venueId, qty));
    }

    function confirmPurchase(venueId, qty) {

        $.ajax({
            method: "POST",
            url: serviceUrl + "rpc/" + kinveyAppId + "/custom/purchase?venue=" + venueId + "&qty=" + qty,
            headers: authHeaders,
            success:(displayInfo),
            error: displayError
        })
    }

    function displayInfo(data) {
        $('#venue-info').empty().append(data.html);
    }


    function showMore(venueId) {
        $('#' + venueId + " .venue-details").css('display', 'block');
    }

    function displayError(err) {
        console.log(err.statusText);
    }

}