function ImperialUnits([inches]) {



    let feet = Math.floor(inches / 12);
    inches %= 12;

    console.log(`${feet}'-${inches}"`);
}

ImperialUnits([11]);