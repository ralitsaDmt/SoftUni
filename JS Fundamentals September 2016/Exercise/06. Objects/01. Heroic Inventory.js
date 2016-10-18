function main(input) {
    let heroData = [];

    for (let obj of input){
        let currentHero = obj.split(' / ');
        let name = currentHero[0];
        let level = Number(currentHero[1]);
        let items = [];
        if (currentHero.length > 2){
            items = currentHero[2].split(', ');
        }

        let hero = {
            name: name,
            level: level,
            items: items
        };
        heroData.push(hero);
    }

    console.log(JSON.stringify(heroData));
}

main([
    'Isacc / 25 / Apple, GravityGun',
    'Derek / 12 / BarrelVest, DestructionSword',
    'Hes / 1 '

]);