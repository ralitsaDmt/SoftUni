function formFiller(input) {

    let name = input.shift();
    let email = input.shift();
    let number = input.shift();

    let text = input;

    text.forEach(elem => {
        let userName = new RegExp('\<\\![a-zA-Z]+\\!\>', 'g');
        let emailReg = new RegExp('\<\\@[a-zA-Z]+\\@\>', 'g');
        let numberReg = new RegExp('\<\\+[a-zA-Z]+\\+\>', 'g');

        elem = elem.replace(userName, name);
        elem = elem.replace(emailReg, email);
        elem = elem.replace(numberReg, number);

        console.log(elem);
    });
}

formFiller(['Pesho',
        'pesho@softuni.bg',
        '90-60-90',
        'Hello, <!username!>!',
    'Welcome to your Personal profile.',
    'Here you can modify your profile freely.',
    'Your current username is: <!fdsfs!>. Would you like to change that? (Y/N)',
    'Your current email is: <@DasEmail@>. Would you like to change that? (Y/N)',
    'Your current phone number is: <+number+>. Would you like to change that? (Y/N)'
]);