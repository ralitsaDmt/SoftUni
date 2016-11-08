//let Turtle = require('./turtle');

import { Turtle } from './turtle';

export class EvkodianTurtle extends Turtle{
    constructor(name, age, gender, evkodiumValue){
        super(name, age, gender);
        this._evkodium = evkodiumValue;
    }

    get evkodium(){
        let density = this.gender === 'male' ? this.age * 3 : this.age * 2;
        return {
            value: this._evkodium,
            density: density
        };
    }

    toString(){
        let strToPrint = super.toString();
        let evkodium = this.evkodium;
        strToPrint += `\nEvkodium: ${evkodium.value * evkodium.density}`;

        return strToPrint;
    }
}

//module.exports = EvkodianTurtle;