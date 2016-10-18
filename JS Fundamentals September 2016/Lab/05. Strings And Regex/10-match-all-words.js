function matchAllWords(text) {
    if (Array.isArray(text)){
        text = text[0];
    }
    let result = text.match(/\w+/g);
    return result.join('|');

}

console.log(matchAllWords(['A Regular Expression needs to have the global flag in order to match all occurrences in the text']));