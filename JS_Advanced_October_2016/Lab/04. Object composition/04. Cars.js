
function createCar(commands){



    let carManager = (function (){

        let cars = new Map;

        function create (name, key, parent) {
            if (key == null){
                cars.set(name, {});
                return;
            }
            cars.set(name, Object.create(cars.get(parent)));
        }

        function set(name, key, value) {

            cars.get(name)[key] = value;
        }

        function print (name) {
            let obj = cars.get(name);

            let objKeys = Object.keys(cars.get(name))
                .map(k => `${k}:${cars.get(name)[k]}`);

            let parent = obj;
            while (parent = Object.getPrototypeOf(parent)){
                let o = Object.keys(parent)
                    .map(k => `${k}:${parent[k]}`);
                objKeys = objKeys.concat(o);
            }

            console.log(objKeys.join(", "));
        }

        return {create, set, print};
    })();

    for (let command of commands){
        let commandParameters = command.split(/\s+/);
        let action = commandParameters.shift();
        carManager[action](...commandParameters);
    }

}


createCar (['create pesho','create gosho inherit pesho','create stamat inherit gosho','set pesho rank number1','set gosho nick goshko','print stamat']
);
