function concatenateAndReverse(input) {
    let joinStrins = input.join('');
    let result = Array.from(joinStrins).reverse();

    console.log(result.join(''));
}

concatenateAndReverse(['I', 'am', 'concatenated']);