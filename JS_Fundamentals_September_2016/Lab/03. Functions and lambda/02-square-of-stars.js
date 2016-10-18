function squareOfStars(n) {
    for (let i = 0; i < n; i++){
        printStars(n);
    }

    function printStars(count) {
        console.log('* '.repeat(count));
    }
}

squareOfStars(5);