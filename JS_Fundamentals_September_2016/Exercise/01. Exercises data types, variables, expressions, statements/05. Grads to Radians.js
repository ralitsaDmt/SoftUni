function GradsToDegree([n]) {
    let grad = Number(n);

    let degree = grad * 0.9 % 360;

    if (degree < 0){
        degree = 360 + degree;
    }
    console.log(degree);
}

GradsToDegree([-50])