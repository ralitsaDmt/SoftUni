function main(input) {

    let systems = new Map();

    for (let obj of input){
        let [system, component, subcomponent] = obj.split(" | ");

        if (!systems.has(system)){
            systems.set(system, new Map());
            systems.get(system).set(component, []);
            systems.get(system).get(component).push(subcomponent);

        }
        else{
            if (!systems.get(system).has(component)){
                systems.get(system).set(component, []);
                systems.get(system).get(component).push(subcomponent);
            }
            else{
                systems.get(system).get(component).push(subcomponent);
            }
        }
    }

    // Sort systems
    let keys = [...systems.keys()];
    keys = keys.sort((a, b) =>
    {
        let x = systems.get(b).size - systems.get(a).size;
        return x == 0 ? a.localeCompare(b) : x;
    });

    for (let key of keys){
        console.log(key);

        let sortedComponents = [...systems.get(key).keys()];
        sortedComponents = sortedComponents.sort(
            (a, b) => systems.get(key).get(b).length - systems.get(key).get(a).length
        );

        for (let comp of sortedComponents){
            console.log(`|||${comp}`);
            console.log(`||||||${systems.get(key).get(comp).join('\n||||||')}`);
        }
    }
    //
    // console.log(keys);
    //
    //
    // console.log(systems);


}

main([
    'SULS | Main Site | Home Page',
    'SULS | Main Site | Login Page',
    'SULS | Main Site | Register Page',
    'SULS | Judge Site | Login Page',
    'SULS | Judge Site | Submittion Page',
    'Lambda | CoreA | A23',
    'SULS | Digital Site | Login Page',
    'Lambda | CoreB | B24',
    'Lambda | CoreA | A24',
    'Lambda | CoreA | A25',
    'Lambda | CoreC | C4',
    'Indice | Session | Default Storage',
    'Indice | Session | Default Security'

]);