function oddNumbers(input) {
    input = input.map(Number);

    // let result = input.map((x, i) => {if (i % 2 != 0){ return x * 2}}).reverse();

    let result = input
        .filter((num, i) => i % 2 != 0)
        .map(num => num * 2)
        .reverse();
    console.log(result.join(' '));
}

oddNumbers(['3', '0', '10', '4', '7', '3']);