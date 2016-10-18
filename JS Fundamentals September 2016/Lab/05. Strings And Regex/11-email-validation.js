function emailValidation([email]) {

    let pattern = /^[a-zA-Z0-9]+\@[a-z]+\.[a-z]+$/g;
    let result = pattern.test(email);

    if (result) return 'Valid';
    else return 'Invalid';
}

console.log(emailValidation());