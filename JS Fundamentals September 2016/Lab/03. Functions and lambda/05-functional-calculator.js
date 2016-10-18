function calculator([num1, num2, op]) {
    num1 = Number(num1);
    num2 = Number(num2);

    let calc = function (a, b, op) { return op(a, b)};

    let add = function (a, b) { return a + b };
    let subtract = function (a, b) { return a - b };
    let multiply = function (a, b) { return a * b };
    let divide = function (a, b) { return a / b };

    switch (op){
        case '+': return calc(num1, num2, add); break;
        case '-': return calc(num1, num2, subtract); break;
        case '*': return calc(num1, num2, multiply); break;
        case '/': return calc(num1, num2, divide); break;
    }
}

console.log(calculator(['2', '6', '-']));