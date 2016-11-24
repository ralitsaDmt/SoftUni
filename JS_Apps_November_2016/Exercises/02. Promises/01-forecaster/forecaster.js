function attachEvents() {

    let symbols = {
        sunny: '&#x2600;',
        partlysunny: '&#x26C5;',
        overcast: '&#x2601;',
        rain: '&#x2614;',
        degrees: '&#176;'
    };

    $('#submit').click(getWeather);

    function getWeather() {
        let url = "https://judgetests.firebaseio.com/locations.json";

        let locationCode = '';

        $.get(url)
            .then(getLocationCode)
            .then(getCurrentConditions)
            .then(get3dayForecast)
            .catch(displayError);

        function getLocationCode(data) {
            let inputLocation = $('#location').val();
            for (let item of data){
                if (item.name === inputLocation){
                    locationCode = item.code;
                    return;
                }
            }
        }

        function getCurrentConditions() {
            let url = `https://judgetests.firebaseio.com/forecast/today/${locationCode}.json`;

            $.get(url)
                .then(displayCurrentConditions)
                .catch(displayError);
        }

        function displayCurrentConditions(data) {
            $('#forecast').css('display', 'block');

            let name = data.name;
            let forecast = data.forecast;

            let spanSymbol = getSpanSymbol(forecast);
            let spanConditions = getSpanConditions(name, forecast);

            $('#current').empty()
                .append($('<div>').addClass('label').text('Current conditions'))
                .append(spanSymbol)
                .append(spanConditions);
        }

        function getSpanConditions(name, forecast) {
            let amplitude = getAmplitude(forecast);
            let condition = forecast.condition;

            return $('<span>').addClass('condition')
                .append($('<span>').addClass('forecast-data').html(name))
                .append($('<span>').addClass('forecast-data').html(amplitude))
                .append($('<span>').addClass('forecast-data').html(condition));
        }

        function getAmplitude(forecast) {
            return forecast.low + symbols.degrees + '/' + forecast.high + symbols.degrees;
        }

        function getSpanSymbol(forecast) {
            let symbol = getSymbolCondition(forecast);

            return $('<span>')
                .addClass('condition symbol')
                .html(symbol);
        }

        function getSymbolCondition(forecast) {
            let condition = forecast.condition.split(' ').join('').toLowerCase();
            return symbols[condition];
        }

        function get3dayForecast(data) {
            let url = `https://judgetests.firebaseio.com/forecast/upcoming/${locationCode}.json `;

            $.ajax({
                url: url,
                success: display3DayForecast,
                error: displayError
            });
        }

        function display3DayForecast(data) {

            let forecasts = data.forecast;

            let upcoming = $('#upcoming');

            for (let forecast of forecasts){
                let forecastSpan = getForecastSpan(forecast);

                upcoming.append(forecastSpan);
            }
        }

        function getForecastSpan(forecast) {
            let symbol = getSymbolCondition(forecast);
            let amplitude = getAmplitude(forecast);
            let conditions = forecast.condition;

            let upcomingSpan = $('<span>').addClass('upcoming');

            let symbolSpan = $('<span>').addClass('symbol').html(symbol);
            let amplitudeSpan = $('<span>').addClass('forecast-data').html(amplitude);
            let conditionSpan = $('<span>').addClass('forecast-data').html(conditions);

            upcomingSpan
                .append(symbolSpan)
                .append(amplitudeSpan)
                .append(conditionSpan);

            return upcomingSpan;
        }

        function displayError(err) {

        }
    }
}