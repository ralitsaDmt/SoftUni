function wordOccurrences([sentence, str]) {
    let patternStr = `\\b(${str})\\b`;

    let pattern = new RegExp(patternStr, 'gi');

    let count = (sentence.match(pattern) || []).length;
    console.log(count);
}

wordOccurrences(['The waterfall was so high, that the child couldn’t see its peak.',
    'the']);

