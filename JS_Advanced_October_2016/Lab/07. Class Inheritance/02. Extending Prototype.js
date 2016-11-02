class Person{
    constructor(name, email){
        this.name = name;
        this.email = email;
    }

    toString(){
        return `${this.constructor.name} (name: ${this.name}, email: ${this.email})`;
    }
}

class Teacher extends Person{
    constructor(name, email, subject){
        super(name, email);
        this.subject = subject;
    }
}

function extendClass(baseClass) {
    baseClass.prototype.species = "Human";
    baseClass.prototype.toSpeciesString = function () {
        return `I am ${this.species}. ${this.toString()}`;
    }
}

let p = new Person('maria', 'maria@gmail.com');
extendClass(Person);
console.log(p.toSpeciesString());