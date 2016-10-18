function printArrayWithGivenDelimiter(input) {

    let array = input.slice(0, input.length - 1);
    let delimiter = input[input.length - 1];

    console.log(array.join(delimiter));
}

printArrayWithGivenDelimiter(['one', 'two', 'three', '=']);