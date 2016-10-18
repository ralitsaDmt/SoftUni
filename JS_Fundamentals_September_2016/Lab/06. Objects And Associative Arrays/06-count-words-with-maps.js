function countWordsWithMaps(input) {
    let words = input[0].toLowerCase().match(/\w+/g);

    let result = new Map();

    for (let word of words){
        if (result.has(word)){
            result.set(word, result.get(word) + 1);
        }
        else
        {
            result.set(word, 1);
        }
    }

    let newResult = new Map([...result].sort());

    for (let [key, value] of newResult){
        console.log(`'${key}' -> ${value} times`);
    }
}

countWordsWithMaps(['JS devs use Node.js for server-side JS. JS devs use JS. -- JS for devs --'])