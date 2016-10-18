function QuadraticEquation([a, b, c]) {
    let d = b * b - (4 * a * c);

    if (d < 0){
        console.log('No');
    }
    else if (d == 0){
        let x = (-b + Math.sqrt(d)) / (2 * a);
        console.log(x);
    }
    else{
        let sqrt = Math.sqrt(d);
        let x1 = ((b * -1) + sqrt) / (2 * a);
        let x2 = (-b - sqrt) / (2 * a);
        console.log(Math.min(x1, x2));
        console.log(Math.max(x1, x2));
    }
}

QuadraticEquation([1, -12, 36]);