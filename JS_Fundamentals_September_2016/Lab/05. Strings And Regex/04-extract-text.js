function extractText([text]) {

    let startIndex = text.indexOf('(');


    let result = [];

    while (startIndex > -1){
        let endIndex = text.indexOf(')', startIndex);

        if (endIndex == -1){
            break;
        }
        result.push((text.substring(startIndex + 1, endIndex)));
        startIndex = text.indexOf('(', endIndex + 1);
    }

    console.log(result.join(', '));
}

extractText(['Rakiya (Bulgarian brandy) is self-made liquor (alcoholic drink)']);