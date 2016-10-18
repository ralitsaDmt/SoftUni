function TriangleArea(input) {
    let a = Number(input[0]);
    let b = Number(input[1]);
    let c = Number(input[2]);
    let p = (a  + b + c) / 2;

    let area = Math.sqrt(p * (p - a) * (p - b) * (p - c));

    console.log(area);
}

TriangleArea([2, 3.5, 4]);