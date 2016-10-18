function main(input) {
    let catalogue = new Set();
    input.forEach(x => catalogue.add(x));

    let sorted = [...catalogue]
        .sort((a, b) =>
        {
            let x = a.length - b.length;
            return x == 0 ? a.localeCompare(b) : x
        });
    console.log(sorted.join('\n'));
}

main([
    'Denise',
    'Ignatius',
    'Iris',
    'Isacc',
    'Indie',
    'Dean',
    'Donatello',
    'Enfuego',
    'Benjamin',
    'Biser',
    'Bounty',
    'Renard',
    'Rot'
]);