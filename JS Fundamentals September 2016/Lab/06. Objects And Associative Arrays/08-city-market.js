function cityMarket(input) {

    let towns = new Map();

    for (let obj of input){
        let [town, product, amount, price] = obj.split(/\s+->\s+|\s+:\s+/g);
        amount = Number(amount);
        price = Number(price);

        //console.log([town, product, amount, price]);

        let totalSum = amount * price;

        if (!towns.has(town)){
            towns.set(town, new Map());
            towns.get(town).set(product, totalSum);
        }
        else{
            if (!towns.get(town).has(product)){
                towns.get(town).set(product, totalSum);
            }
            else{
                towns.get(town).set(product, town.get(product) + totalSum);
            }
        }
    }

    console.log(towns);

    for (let [town, value] of towns){
        console.log(`Town - ${town}`);
        for (let [product, price] of towns.get(town)){
            console.log(`$$$${product} : ${price}`);
        }
    }

}

cityMarket(['Sofia -> Laptops HP -> 200 : 2000',
'Sofia -> Raspberry -> 200000 : 1500',
'Sofia -> Audi Q7 -> 200 : 100000',
'Montana -> Portokals -> 200000 : 1',
'Montana -> Qgodas -> 20000 : 0.2',
'Montana -> Chereshas -> 1000 : 0.3'
]);