let url = "https://baas.kinvey.com/appdata/kid_BJe588Szx/football-matches";
let headers = {
    "Authorization": "Basic Z3Vlc3Q6Z3Vlc3Q=",
    "Content-Type": "application/json"
};

let myBets = [];

(function () {
    $('#bets').on('click', function () {
        let table = $('<table>');
        let head = $('<tr>');
        head
            .append('<th>Home Team</th>')
            .append('<th>Away Team</th>')
            .append('<th>Start</th>')
            .append('<th>Bet On</th>')
            .append('<th>Ratio</th>')
            .append('<th>Value</th>')
            .append('<th>Estimated Winnings</th>');

        table.append(head);

        myBets.forEach(function (elem) {
            let row = $('<tr>');
            row
                .append('<td>' + elem.homeTeam + '</td>')
                .append('<td>' + elem.awayTeam + '</td>')
                .append('<td>' + elem.time + '</td>')
                .append('<td>' + elem.betType + '</td>')
                .append('<td>' + elem.betRatio + '</td>')
                .append('<td>' + elem.betValue + '</td>')
                .append('<td>' + elem.estimatedWin + '</td>');
            table.append(row);
        });

        $('.content-holder').empty();
        $('.content-holder').append(table);
    });

    $('#matches').on('click', function () {
        $.ajax({
            method: 'GET',
            url: url,
            headers: headers,
            success: function (success) {
                let table = $('<table>');
                let head = $('<tr>');
                head
                    .append('<th>Id</th>')
                    .append('<th>Home Team</th>')
                    .append('<th>Away Team</th>')
                    .append('<th>Start</th>')
                    .append('<th>Win</th>')
                    .append('<th>Draw</th>')
                    .append('<th>Lose</th>')
                    .append('<th>Bet</th>')
                    .append('<th>Bet On</th>')
                    .append('<th>Submit</th>');
                table.append(head);
                success = success.sort(function (elem1, elem2) {
                    let time1 = elem1.time.split(" ")[0];
                    let format1 = elem1.time.split(" ")[1];

                    let time2 = elem2.time.split(" ")[0];
                    let format2 = elem2.time.split(" ")[1];

                    let hour1 = Number(time1.split(":")[0]);
                    let minutes1 = Number(time1.split(":")[1]);

                    let hour2 = Number(time2.split(":")[0]);
                    let minutes2 = Number(time2.split(":")[1]);

                    let result = format1.localeCompare(format2);

                    if (result == 0) {
                        result = hour1 - hour2;
                    }

                    if (result == 0) {
                        result = minutes1 - minutes2;
                    }

                    return result;
                });
                success.forEach(function (elem) {
                    let row = $('<tr>');
                    row
                        .append('<td id="match-' + elem.id + '">' + elem.id + '</td>')
                        .append('<td id="match-' + elem.id + '-home">' + elem.home + '</td>')
                        .append('<td id="match-' + elem.id + '-away">' + elem.away + '</td>')
                        .append('<td id="match-' + elem.id + '-time">' + elem.time + '</td>')
                        .append('<td id="match-' + elem.id + '-win">' + elem.ratio["1"] + '</td>')
                        .append('<td id="match-' + elem.id + '-draw">' + elem.ratio["x"] + '</td>')
                        .append('<td id="match-' + elem.id + '-lose">' + elem.ratio["2"] + '</td>');

                    let hasBet = false;

                    myBets.forEach(function (myBet) {
                        if (myBet.id == elem.id) {
                            hasBet = true;
                        }
                    });

                    if (!hasBet) {
                        row
                            .append('<td id="match-' + elem.id + '-bet"><input type="number" min="1" max="1000000" /></td>')
                            .append('<td id="match-' + elem.id + '-bet-type">' +
                                '<select>' +
                                '   <option>Win</option>' +
                                '   <option>Draw</option>' +
                                '   <option>Lose</option>' +
                                    '</select>' +
                                '</td>')
                            .append('<td id="match-' + elem.id + '-button"><button>Bet</button></td>');
                    } else {
                        row
                            .append('<td id="match-' + elem.id + '-bet"><input type="number" min="1" max="1000000" disabled/></td>')
                            .append('<td id="match-' + elem.id + '-bet-type"><select disabled></select></td>')
                            .append('<td id="match-' + elem.id + '-button"><button disabled>Bet</button></td>');
                    }

                    table.append(row);
                });

                $('.content-holder').empty();
                $('.content-holder').append(table);

                $('.content-holder table tr td button').on('click', function (ev) {
                    let currentId = Number($(this).parent().attr('id').replace('match-', '').replace('-button', ''));
                    let value = Number($('#match-' + currentId + '-bet input').val());
                    let betType = $('#match-' + currentId + '-bet-type select option:selected').text().toString().toLowerCase();

                    let ratio = Number($('#match-' + currentId + '-' + betType).text());

                    let homeTeam = $('#match-' + currentId + '-home').text();
                    let awayTeam = $('#match-' + currentId + '-away').text();
                    let time = $('#match-' + currentId + '-time').text();

                    let bet = {
                        id: currentId,
                        homeTeam: homeTeam,
                        awayTeam: awayTeam,
                        time: time,
                        betType: betType,
                        betRatio: ratio,
                        betValue: value,
                        estimatedWin: (ratio * value).toFixed(2)
                    };

                    myBets.push(bet);

                    $('#matches').click();
                });
            },
            error: function (error) {
                console.log(error);
            }
        });
    });
}());