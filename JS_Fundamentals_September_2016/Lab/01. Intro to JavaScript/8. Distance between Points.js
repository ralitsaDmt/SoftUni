function Distance([x1, y1, x2, y2]) {
    let sideA = Math.pow(Math.abs(x1 - x2), 2);
    let sideB = Math.pow(Math.abs(y1 - y2), 2);

    let dist = Math.sqrt(sideA + sideB)
    console.log(dist);
}

Distance([2, 4, 5, 0]);