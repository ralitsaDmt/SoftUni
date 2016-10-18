function FigureOfFourSquares([n]) {
    let mid = n - 2;
    let height = 0;

    if (n % 2 == 0){
        height = n - 1;
    }
    else{
        height = n;
    }

    for (let i = 0; i < height; i++){
        if (i == 0 ||
            i == height - 1 ||
            i == Math.floor((n - 1) / 2)){
            console.log(`+${'-'.repeat(mid)}+${'-'.repeat(mid)}+`);
        }
        else{
            console.log(`|${' '.repeat(mid)}|${' '.repeat(mid)}|`);
        }
    }
}

FigureOfFourSquares([5]);