function cookingByNumbers(input) {
    let num = Number(input[0]);
    let operations = input.splice(1,5);

    let cook = (num, op) => op(num);

    let chop = num => num / 2;
    let dice = num => Math.sqrt(num);
    let spice = num => num + 1;
    let bake = num => num * 3;
    let fillet = num => num - num * 0.2;

    for (let op of operations){
        switch (op){
            case 'chop': num = (cook(num, chop)); break;
            case 'dice': num = (cook(num, dice)); break;
            case 'spice': num = (cook(num, spice)); break;
            case 'bake': num = (cook(num, bake)); break;
            case 'fillet': num = (cook(num, fillet)); break;
        }
        console.log(num);
    }
}

cookingByNumbers([9, 'dice', 'spice', 'chop', 'bake', 'fillet']);