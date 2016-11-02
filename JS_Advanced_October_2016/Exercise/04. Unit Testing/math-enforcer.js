let mathEnforcer = {
    addFive: (num) => {
        if (typeof num !== "number"){
            return undefined;
        }
        return num + 5;
    },
    subtractTen: (num) => {
        if (typeof num !== "number"){
            return undefined;
        }
        return num -10;
    },
    sum: (num1, num2) => {
        if (typeof num1 !== "number" || typeof num2 !== "number"){
            return undefined;
        }
        return num1 + num2;
    }
};

module.exports = {mathEnforcer};

console.log(mathEnforcer.addFive('f'));
console.log(mathEnforcer.addFive(6));
console.log(mathEnforcer.subtractTen("f"));
console.log(mathEnforcer.subtractTen(10));
console.log(mathEnforcer.sum("f", "m"));
console.log(mathEnforcer.sum(6, "m"));
console.log(mathEnforcer.sum(6, 10));
console.log(mathEnforcer.sum(NaN, 6));
console.log(mathEnforcer.sum(NaN, NaN));

console.log(mathEnforcer.sum(Number.POSITIVE_INFINITY, Number.NEGATIVE_INFINITY));

