function triangleOfStars(n) {
    for (let i = 1; i <= n; i++){
        printStars(i);
    }
    for (let i = n - 1; i > 0; i--){
        printStars(i);
    }

    function printStars(size){
        console.log('*'.repeat(size));
    }
}

triangleOfStars(5);