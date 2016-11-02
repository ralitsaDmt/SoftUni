let meteo = (function () {
    let id = 0;
    
    return class MeteoStage{
        constructor(temperature, humidity, pressure, windSpeed){
            this.id = id;
            this.temperature = temperature;
            this.humidity = humidity;
            this.pressure = pressure;
            this.windSpeed = windSpeed;
            id++;
        }

        toString(){
            let weather;
            if ((this.temperature < 20) && (this.pressure < 700 || this.pressure > 900) && (this.windSpeed > 25)){
                weather = 'Stormy';
            }
            else{
                weather = 'Not stormy';
            }

            return `Reading ID: ${this.id}\nTemperature: ${this.temperature}*C\nRelative Humidity: ${this.humidity}%\nPressure: ${this.pressure}hpa\nWind Speed: ${this.windSpeed}m/s\nWeather: ${weather}`;
        }
    }
})();

let weather = new meteo(32, 66, 760, 12);

console.log(weather.toString());