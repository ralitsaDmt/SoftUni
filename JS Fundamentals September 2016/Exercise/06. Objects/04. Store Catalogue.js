function main(input) {
    let products = [];
    let initials = new Set();

    for (let obj of input){
        let data = obj.split(' : ');
        let product = data[0];
        let price = Number(data[1]);

        let entry = {product: product, price: price};
        products.push(entry);
        initials.add(product[0].toUpperCase());
    }

    // Sort products
    products = products.sort((a, b) => a.product.localeCompare(b.product));
    // Sort initials
    initials = [...initials.values()].sort();


    for (let initial of initials){
        console.log(initial);
        for (let product of products){
            if (product.product[0].toUpperCase() === initial){
                console.log(`  ${product.product}: ${product.price}`);
            }
        }
    }
}

main([
    'Banana : 2',
    'Rubic\'s Cube : 5',
    'Raspberry P : 4999',
    'Rolex : 100000',
    'Rollon : 10',
    'Rali Car : 2000000',
    'Pesho : 0.000001',
    'Barrel : 10'
]);