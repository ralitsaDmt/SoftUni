function main(input) {

    let register = new Map();

    for (let obj of input){
        let data = obj.split(' | ');
        let brand = data[0].trim();
        let model = data[1].trim();
        let producedCars = Number(data[2].trim());

        if (!register.has(brand)){
            register.set(brand, new Map);
            register.get(brand).set(model, producedCars);
        }
        else{
            if (!register.get(brand).has(model)){
                register.get(brand).set(model, producedCars);
            }
            else{
                register.get(brand).set(model, register.get(brand).get(model) + producedCars);
            }
        }
    }

    for (let [br, models] of register){
        console.log(br);
        for (let [model, count] of register.get(br)){
            console.log(`###${model} -> ${count}`);
        }
    }

    //console.log(register);
}

main([
    'Audi | Q7 | 1000',
    'Audi | Q6 | 100',
    'BMW | X5 | 1000',
    'BMW | X6 | 100',
    'Citroen | C4 | 123',
    'Volga | GAZ-24 | 1000000',
    'Lada | Niva | 1000000',
    'Lada | Jigula | 1000000',
    'Citroen | C4 | 22',
    'Citroen | C5 | 10'
]);