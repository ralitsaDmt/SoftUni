function roadRadar([speed, zone]) {

    function getLimit(zone) {
        switch (zone){
            case 'motorway': return 130;
            case 'interstate': return 90;
            case 'city': return 50;
            case 'residential': return 20;
        }
    }

    let limit = getLimit(zone);


    if (speed > limit && speed <= limit + 20){
        console.log('speeding');
    }
    else if (speed > limit + 20 && speed <= limit + 40){
        console.log('excessive speeding');
    }
    else if (speed > limit + 40){
        console.log('reckless driving');
    }
}

roadRadar([120, 'interstate']);