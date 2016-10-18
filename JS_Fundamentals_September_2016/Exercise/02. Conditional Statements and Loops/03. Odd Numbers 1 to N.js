function OddNumbers1ToN(input) {
    let n = Number(input[0]);

    for (let i = 1; i <= n; i++){
        if (i % 2 != 0){
            console.log(i);
        }
    }
}

OddNumbers1ToN([5]);