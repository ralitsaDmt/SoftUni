function solve(order) {
    let offer = {};

    offer.model = order.model;

    function MinEngine(power) {

        if (power <= 90){
            return {power: 90, volume: 1800};
        }
        else if(power <= 120){
            return {power: 120, volume: 2400};
        }
        else {
            return {power: 200, volume: 3500};
        }
    }
    offer.engine = MinEngine(Number(order.power));

    offer.carriage = {type: order.carriage, color: order.color};

    let wheels = Number(order.wheelsize);
    let wheelsize = wheels % 2 == 0 ? wheels - 1 : wheels;
    offer.wheels = [wheelsize, wheelsize, wheelsize, wheelsize];

    return offer;
}

console.log(solve({
        model: 'Opel Vectra',
        power: 110,
        color: 'grey',
        carriage: 'coupe',
        wheelsize: 17
    }
));

