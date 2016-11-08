//let Turtle = require('./turtle');

import { Turtle } from './turtle';

export class GalapagosTurtle extends Turtle{
    constructor(name, age, gender){
        super(name, age, gender);
        this._thingsEaten = [];
    }

    get thingsEaten(){
        return this._thingsEaten;
    }

    eat(food){
        this._thingsEaten.push(food);
    }

    grow(age){
        this._age += Number(age);
        this._thingsEaten = [];
    }

    toString(){
        let strToPrint = super.toString();
        strToPrint += `\nThings, eaten this year: ${this._thingsEaten.join(', ')}`;

        return strToPrint;
    }
}


//module.exports = GalapagosTurtle;

// let turtle = new GalapagusTurtle('Mikelanjelo', 23, 'm');
// turtle.eat('cucumber');
// console.log(turtle.toString());;
// turtle.grow(5);
// console.log(turtle.toString());


