function CountLetters([word, letter]) {
    let count = 0;
    for (let l of word){
        if (l == letter){
            count++;
        }
    }
    return count;
}

console.log(CountLetters(['worlld', 'l']));