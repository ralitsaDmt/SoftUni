function solve() {
    class Melon{
       constructor(weight, melonSort){
           if (new.target === Melon){
                throw new TypeError ("Abstract class cannot be instantiated directly");
           }
           this.weight = Number(weight);
           this.melonSort = melonSort;
           this.elementName = this.getElementName();
           this._elementIndex = this.weight * this.melonSort.length;
       }

        get elementIndex(){
            return this._elementIndex;
        }

        getElementName(){
            let name = this.constructor.name;
            let index = name.indexOf("melon");
            return name.substring(0, index);
        }

        toString(){
            let str = `Element: ${this.elementName}\n`;
            str += `Sort: ${this.melonSort}\n`;
            str += `Element Index: ${this.elementIndex}`;

            return str;
        }
    }

    class Watermelon extends Melon{
        constructor(weight, melonSort){
            super(weight, melonSort);
        }
    }

    class Firemelon extends Melon{
        constructor(weight, melonSort){
            super(weight, melonSort);
        }
    }

    class Earthmelon extends Melon{
        constructor(weight, melonSort){
            super(weight, melonSort);
        }
    }

    class Airmelon extends Melon{
        constructor(weight, melonSort){
            super(weight, melonSort);
        }
    }

    class Melolemonmelon extends Watermelon{
        constructor(weight, melonSort){
            super(weight, melonSort);
            this.elementsCollection = ['Water', 'Fire', 'Earth', 'Air'];
            this.elementName = this.morph();
        }

        morph(){
            this.elementName = this.elementsCollection.shift();
            this.elementsCollection.push(this.elementName);
            return this.elementName;
        }
    }

    return {Melon, Watermelon, Firemelon, Earthmelon, Airmelon, Melolemonmelon};
}

let result = solve();

let firemelon = new result.Watermelon(5, "Rotten");
console.log(firemelon.toString());
// console.log('======================');

// let melon = new result.Melolemonmelon(4, 'HoneyBeam'); // water
// console.log(melon.toString()); // fire
// console.log('======================');
//
// melon.morph();
// console.log(melon.toString()); // fire
// console.log('======================');
//
// melon.morph();
// console.log(melon.toString()); // earth
// console.log('======================');
//
// melon.morph();
// console.log(melon.toString()); // air
// console.log('======================');
//
// melon.morph();
// console.log(melon.toString()); // water
// console.log('======================');
//
// melon.morph();
// console.log(melon.toString()); // fire
// console.log('======================');
//
// melon.morph();
// console.log(melon.toString()); // earth