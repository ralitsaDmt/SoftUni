function PointInRectangle(input) {
    let x = Number(input[0]);
    let y = Number(input[1]);
    let xMin = Number(input[2]);
    let xMax = Number(input[3]);
    let yMin = Number(input[4]);
    let yMax = Number(input[5]);

    let isInside = x >= xMin &&
                    x <= xMax &&
                    y >= yMin &&
                    y <= yMax;

    if (isInside)return("inside");
    else return ("outside");
}

console.log(PointInRectangle([8, -1, 2, 12, -3, 3]));