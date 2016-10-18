function Rounding(input) {
    let num = parseFloat(input[0]);
    let prec = Number(input[1]);

    console.log(Math.round(num * Math.pow(10, prec)) / Math.pow(10, prec));
    //console.log(num.toFixed(prec));
}

Rounding([3.1415926535897932384626433832795, 2]);