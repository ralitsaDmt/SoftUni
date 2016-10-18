function sumByTowns(data) {

    let sums = {};
    for (let i = 0; i < data.length; i += 2){

        let town = data[i];
        let income  = Number(data[i + 1]);

        if (!sums[town]){
            sums[town] = 0;
        }
        sums[town] += income;
    }

    console.log(JSON.stringify(sums));
}

sumByTowns(['Sofia', 20,
            'Varna', 3,
            'Sofia', 5,
            'Varna', 4
            ]);