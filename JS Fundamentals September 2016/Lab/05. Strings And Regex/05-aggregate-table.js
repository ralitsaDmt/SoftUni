function aggregateTable(lines) {
    let sum = 0;
    let list = [];

    for (let line of lines){
        let townData = line.split("|").filter(val => val != '');
        let town = townData[0].trim();
        let income = Number(townData[1].trim());

        list.push(town);
        sum += income;
    }

    console.log(list.join(', '));
    console.log(sum);
}

aggregateTable(['| Sofia           | 300',
    '| Veliko Tarnovo  | 500',
    '| Yambol          | 275']
);