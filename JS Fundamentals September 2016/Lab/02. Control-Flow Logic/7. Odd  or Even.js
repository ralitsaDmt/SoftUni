function EvenOrOdd(input) {
    let num = Number(input[0]);

    let reminder = num % 2;

    if (reminder == 0){
        console.log("even");
    }
    else if (reminder == Math.round(reminder)){
        console.log("odd");
    }
    else {
        console.log("invalid");
    }
}

EvenOrOdd([2]);