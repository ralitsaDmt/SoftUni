export class Turtle{
    constructor(name, age, gender){
        if (new.target === Turtle){
            throw new Error("Abstract class cannot be instantiated directly.");
        }
        this._name = name;
        this._age = Number(age);
        this._gender = gender;
    }

    get name(){
        return this._name;
    }

    get age(){
        return this._age;
    }

    get gender(){
        return this._gender;
    }

    grow(age){
        this._age += Number(age);
    }

    toString(){
        let strToPrint = `Turtle: ${this._name}\n`;
        strToPrint += `Aged - ${this._age}; Gender - ${this._gender}`;
        return strToPrint;
    }
}

//module.exports = Turtle;