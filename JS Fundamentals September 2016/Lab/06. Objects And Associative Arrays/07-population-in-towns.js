function populationInTowns(input) {

    let towns = new Map();

    for (let instance of input){
        let data = instance.split(/\s+<->\s+/g);

        let town = data[0];
        let population = Number(data[1]);

        if (towns.has(town)){
            towns.set(town, towns.get(town) + population);
        }
        else{
            towns.set(town, population);
        }
    }

    for (let [key, value] of towns){
        console.log(`${key} : ${value}`);
    }

}

populationInTowns(['Istanbul <-> 100000',
'Honk Kong <-> 2100004',
'Jerusalem <-> 2352344',
'Mexico City <-> 23401925',
'Istanbul <-> 1000'

]);