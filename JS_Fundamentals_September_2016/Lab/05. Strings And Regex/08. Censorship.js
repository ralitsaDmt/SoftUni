function censor(input) {
    let text = input[0];
    let words = input.slice(1);

    for (let current of words) {
        let replaced = '-'.repeat(current.length);
        while (text.indexOf(current) > -1) {
            text = text.replace(new RegExp(current, 'g'), replaced);
        }
    }
    return text;
}

console.log(censor(['roses are red, violets are blue', ', violets are', 'red']));
