function sortArray(array) {

    array = array.sort().sort((a, b) => (a.length - b.length));

    console.log(array.join('\n'));
}

sortArray(['alpha',
    'beta',
    'gamma'])