//let Turtle = require('./turtle');

import { Turtle } from './turtle';

export class WaterTurtle extends Turtle{
    constructor(name, age, gender, waterPool){
        super(name, age, gender);
        this._waterPool = waterPool;
    }

    get currentWaterPool(){
        return this._waterPool;
    }

    travel(waterPool){
        this._waterPool = waterPool;
        this._age += 5;
    }

    toString(){
        let strToPrint = super.toString();
        strToPrint += `\nCurrently inhabiting ${this.currentWaterPool}`;

        return strToPrint;
    }
}

//module.exports = WaterTurtle;

