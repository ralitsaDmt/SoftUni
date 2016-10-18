function positiveNegativeNumbers(arr) {
    arr = arr.map(Number);

    let result = [];

    for (let item of arr){
        if (item < 0){
            result.unshift(item);
        }
        else{
            result.push(item);
        }
    }

    console.log(result);
}

positiveNegativeNumbers([10, 20, -2, -1, 30]);

