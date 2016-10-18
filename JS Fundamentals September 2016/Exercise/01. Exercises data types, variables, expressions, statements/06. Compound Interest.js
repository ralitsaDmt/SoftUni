function CompoundInteres(input) {
    let sum = Number(input[0]);
    let rate = Number(input[1]) / 100;
    let freq = 12 / Number(input[2]);
    let length = Number(input[3]);

    let interest = sum * Math.pow((1 + rate / freq  ), freq * length);

    console.log(interest.toFixed(2));
}

CompoundInteres([100000, 5, 12, 25]);