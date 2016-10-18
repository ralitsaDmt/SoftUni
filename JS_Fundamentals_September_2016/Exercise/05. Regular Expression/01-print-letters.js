function printLetters([str]) {
    let result = Array.from(str).map((l, i) => `str[${i}] -> ${l}`);
    console.log(result.join('\n'));
}

printLetters(['Hello, world!']);