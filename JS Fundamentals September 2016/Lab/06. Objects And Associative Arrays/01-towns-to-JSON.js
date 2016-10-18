function townsToJSON(input) {

    let towns = [];
    for (let town of input.slice(1)){
        let [name, lat, long] = town.split("|")
            .map(t => t.trim())
            .filter(t => t != '');
        let obj = {
            Town: name,
            Latitude: Number(lat),
            Longitude: Number(long)
        };

        towns.push(obj);
    }

    console.log(JSON.stringify(towns));
}

townsToJSON(['| Town | Latitude | Longitude |',
    '| Sofia | 42.696552 | 23.32601 |',
    '| Beijing | 39.913818 | 116.363625 |']
);