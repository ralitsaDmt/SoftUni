function attachEvents() {

    const kinveyAppId = "kid_HyMdlDEGl";
    const serviceUrl = "https://baas.kinvey.com/appdata/";
    const kinveyUsername = "guest";
    const kinveyPassword = "guest";
    const base64auth = btoa(kinveyUsername + ":" + kinveyPassword);
    const authHeaders = { "Authorization": "Basic " + base64auth };

    $(document).ready(loadPlayers);

    $('#addPlayer').click(addPlayer);
    $('#save').click(() => saveGame($.parseJSON(sessionStorage.getItem('player')), true));
    $('#reload').click(() => reloadBullets($.parseJSON(sessionStorage.getItem('player'))));

    function loadPlayers() {
        $.ajax({
            method: "GET",
            url: serviceUrl + kinveyAppId + "/players",
            headers: authHeaders,
            success: displayPlayers,
            error: displayError
        })
    }

    function displayPlayers(data) {

        $('#players').empty();

        for (let player of data){
            let playerDiv = `<div class="player" data-id="${player._id}">` +
                                `<div class="row">` +
                                    `<label>Name:</label>` +
                                    `<label class="name">${player.name}</label>` +
                                `</div>` +
                                `<div class="row">` +
                                    `<label>Money:</label>` +
                                    `<label class="money">${player.money}</label>` +
                                `</div>` +
                                `<div class="row">` +
                                    `<label>Bullets:</label>` +
                                    `<label class="bullets">${player.bullets}</label>` +
                                `</div>` +
                                `<button class="play">Play</button>` +
                                `<button class="delete">Delete</button>` +
                            `</div>`;

            $('#players').append(playerDiv);

            $('div[data-id=' + player._id + '] button.delete').click(() => deletePlayer(player._id));
            $('div[data-id=' + player._id + '] button.play').click(() => saveGame(player, false));
        }
    }

    function addPlayer() {
        let name = $('#addName').val();
        let money = 500;
        let bullets = 6;

        $('#addName').val('');

        let newPlayer = {name, money, bullets};

        $.ajax({
            method: "POST",
            url: serviceUrl + kinveyAppId + "/players",
            headers: authHeaders,
            data: newPlayer,
            success: loadPlayers,
            error: displayError
        });
    }

    function deletePlayer(playerId) {
        $.ajax({
            method: "DELETE",
            url: serviceUrl + kinveyAppId + "/players/" + playerId,
            headers: authHeaders,
            success: loadPlayers,
            error: displayError
        })
    }
    
    function saveGame(player, shouldStop) {
        let reqPlayer = {
            name: player.name,
            money: Number(player.money),
            bullets: Number(player.bullets)
        };

        if (shouldStop){
            $.ajax({
                method: "PUT",
                url: serviceUrl + kinveyAppId + "/players/" + player._id,
                headers: authHeaders,
                data: reqPlayer,
                success: () => stopGame(player),
                error: displayError
            })
        }
        else{
            $.ajax({
                method: "PUT",
                url: serviceUrl + kinveyAppId + "/players/" + player._id,
                headers: authHeaders,
                data: reqPlayer,
                success: () => loadGame(player),
                error: displayError
            })
        }
    }

    function loadGame(player) {
        $('#save, #reload, #canvas').show();
        loadCanvas(player);
    }

    function stopGame() {
        $('#save, #reload, #canvas').hide();

        let intervalId = Number(sessionStorage.getItem('canvasIntervalId'));
        clearInterval(intervalId);

        loadPlayers();
    }

    function reloadBullets(player) {

        player.money = Number(player.money) - 60;
        player.bullets = Number(player.bullets) + 6;

        let reqPlayer = {money: player.money, bullets: player.bullets};

        let intervalId = Number(sessionStorage.getItem('canvasIntervalId'));
        clearInterval(intervalId);

        $.ajax({
            method: "PUT",
            url: serviceUrl + kinveyAppId + "/players/" + player._id,
            headers: authHeaders,
            data: reqPlayer,
            success: () => loadGame(player),
            error: displayError
        })
    }

    function displayError(err) {
        console.log(err.statusText);
    }
}