function captureNumbers(input) {

    let numbers = [];
    let pattern = /[0-9]+/g;

    for (let sentence of input){
        let match = pattern.exec(sentence);
        while (match){
            numbers.push(match[0]);
            match = pattern.exec(sentence);
        }
    }

    console.log(numbers.join(' '));
}

captureNumbers(['The300',
'What is that?',
    'I think it’s the 3rd movie.',
    'Lets watch it at 22:45']
);