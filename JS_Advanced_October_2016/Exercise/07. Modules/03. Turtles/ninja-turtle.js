//let Turtle = require('./turtle');

import { Turtle } from './turtle';

export class NinjaTurtle extends Turtle{
    constructor(name, age, gender, maskColor, weapon){
        super(name, age, gender);
        this.maskColor = maskColor;
        this.weapon = weapon;
        this.level = 0;
    }

    grow(age){
        age = Number(age);
        this._age += age;
        this.level += age;
    }

    toString(){
        let strToPrint = super.toString();
        strToPrint += this.extendToString();

        return strToPrint;
    }

    extendToString(){
        let firstThreeLettersOfName = this.name.substr(0, 3);
        if (this.level < 25){
            return `\n${firstThreeLettersOfName} wears a ${this.maskColor} mask, and is an apprentice with the ${this.weapon}.`;
        }

        if (this.level >= 25 && this.level < 100){
            return `\n${firstThreeLettersOfName} wears a ${this.maskColor} mask, and is smokin strong with the ${this.weapon}.`;
        }

        if (this.level >= 100){
            return `\n${firstThreeLettersOfName} wears a ${this.maskColor} mask, and is BEYOND GODLIKE with the ${this.weapon}.`;
        }
    }
}

//module.exports = NinjaTurtle;