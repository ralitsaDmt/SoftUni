function printNthElemetn(input) {
    let array = input.slice(0, input.length - 1);
    let step = input[input.length - 1];
    let result = array.filter((x, i) => i % step == 0);

    console.log(result.join('\n'));
}

printNthElemetn([5, 20, 31, 4, 20, 2]);