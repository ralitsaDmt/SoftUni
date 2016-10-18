function matchDates(input) {
    let dates = [];
    for (let sent of input){
        let pattern = /\b(\d{1,2})-([A-Z][a-z]{2})-(\d{4})\b/g;

        let match = pattern.exec(sent);
        while (match){
            dates.push(match[0] + ` (Day: ${match[1]}, Month: ${match[2]}, Year: ${match[3]})`);
            match = pattern.exec(sent);
        }
    }

    console.log(dates.join('\n'));
}

matchDates(['1-Jan-1999 is a valid date.',
    'So is 01-July-2000.',
    'I am an awful liar, by the way',
   ' -- Ivo, 28-Sep-2016.'
]);