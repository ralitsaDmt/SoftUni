class Person{
    constructor(fn, ln, a, e){
        this.firstName = fn;
        this.lastName = ln;
        this.age = Number(a);
        this.email = e;
    }

    toString(){        
        return `${this.firstName} ${this.lastName} (age: ${this.age}, email: ${this.email})`;
    }
}

function getPersons() {
    class Person{
        constructor(fn, ln, a, e){
            this.firstName = fn;
            this.lastName = ln;
            this.age = a;
            this.email = e;
        }

        toString(){
            return `${this.firstName} ${this.lastName} (age: ${this.age}, email: ${this.email})`;
        }
    }

    return[
        new Person('Maria', 'Petrova', 22, 'mp@yahoo.com'),
        new Person('SoftUni'),
        new Person('Stephan', 'Nikolov', 25),
        new Person('Peter', 'Kolev', 24, 'ptr@gmail.com')
    ]
}

let p = new Person('Maria', 'Petrova', 23, 'mo@yahoo.com');
console.log(p.toString());
console.log('' + p);

console.log(getPersons());