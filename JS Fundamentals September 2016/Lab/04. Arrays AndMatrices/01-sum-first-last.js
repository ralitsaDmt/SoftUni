function firstAndLast(arr) {
    let num1 = Number(arr[0]);
    let num2 = Number(arr[arr.length - 1]);

    let sum = num1 + num2;

    return sum;
}

console.log(firstAndLast([1, 2, 3]));