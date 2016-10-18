function main(input) {
    let juices = {};
    let bottles = {};

    for (let obj of input){
        let data = obj.split(' => ');
        let juice = data[0];
        let quantity = Number(data[1]);

        if (juices[juice] === undefined){
            juices[juice]= quantity;
        }
        else{
            juices[juice] += quantity;
        }

        if (juices[juice] >= 1000){
            if (bottles[juice] === undefined){
                bottles[juice] = Math.floor(juices[juice] / 1000);
                juices[juice] -= 1000 * bottles[juice];
            }
            else{
                bottles[juice] += Math.floor(juices[juice] / 1000);
                juices[juice] -= 1000 * bottles[juice];
            }
        }
    }

    for (let key of Object.keys(bottles)){
        console.log(`${key} => ${bottles[key]}`);
    }
}

main([
    'Kiwi => 234',
    'Pear => 2345',
    'Watermelon => 3456',
    'Kiwi => 4567',
    'Pear => 5678',
    'Watermelon => 6789'


]);