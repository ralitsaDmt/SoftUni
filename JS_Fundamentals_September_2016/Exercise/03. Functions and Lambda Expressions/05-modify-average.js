function modifyAverage(input) {
    let num = input[0];

    function sumDigits(n) {
        let sum = 0;
        while(n > 0){
            sum += n % 10;
            n = Math.floor(n / 10);
        }
        return sum;
    }

    let average = sumDigits(num) / num.toString().length;
    while (average <= 5){
      num += '9';
      average = sumDigits(num) / num.length;
    }

    console.log(num);
}

modifyAverage([5835]);