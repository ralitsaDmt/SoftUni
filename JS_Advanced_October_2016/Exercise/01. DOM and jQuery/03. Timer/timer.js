function timer() {
    let startBtn = $("#start-timer");
    let stopBtn = $("#stop-timer");

    let hours = $("#hours");
    let minutes = $("#minutes");
    let seconds = $("#seconds");

    let interval = undefined;
    let totalSeconds  = 0;

    startBtn.on("click", function () {
        if (interval == undefined){
            interval = setInterval(step, 1000);
        }
    });

    stopBtn.on("click", function () {
        clearInterval(interval);
        interval = undefined;
    });

    function step() {
        //console.log("kur");
        totalSeconds++;

        seconds.text(formatTime(totalSeconds % 60));
        let mins = totalSeconds / 60;
        minutes.text(formatTime(mins % 60));
        let h = totalSeconds / 3600;
        hours.text(formatTime(h));
    }

    function formatTime(num) {
        //console.log("kur");
        return pad(Math.floor(num));
    }

    function pad(num) {
        if (num <= 9){
            num = `0${num}`;
        }
        return num;
    }
}