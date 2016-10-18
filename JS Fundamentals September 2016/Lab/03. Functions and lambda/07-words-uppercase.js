function wordsUppercase([str]) {

    let result = str.toUpperCase().match(/([a-zA-Z0-9]+)/g);
    console.log(result);
    // let regex = /([a-zA-Z0-9]+)/g;
    // let result = str.match(regex);
    //
    // result = result.map(s => s.toUpperCase());
    // let string = result.join(", ");
    //
    // console.log(string);
}

wordsUppercase(['Hi, I am Roli!']);