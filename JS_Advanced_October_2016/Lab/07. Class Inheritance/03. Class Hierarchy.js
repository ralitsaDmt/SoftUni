function solve() {
    class Figure{
        constructor(){
            if (new.target === Figure){
                throw new Error ("Ти си тупонар!")
            }
        }

        toString(){
            return this.constructor.name;
        }
    }

    class Circle extends Figure{
        constructor(radius){
            super();
            this.radius = radius;
        }

        toString(){
            return `${super.toString()} - radius: ${this.radius}`;
        }

        get area(){
            return Math.PI * this.radius * this.radius;
        }
    }

    class Rectangle extends Figure{
        constructor(w, h){
            super();
            this.width = w;
            this.height = h;
        }

        toString(){
            return `${super.toString()} - width: ${this.width}, height: ${this.height}`;
        }

        get area(){
            return this.width * this.height;
        }
    }

    return {Figure, Circle, Rectangle}
}

let newF = new Circle(5);
console.log(newF.toString());

let rect = new Rectangle(3, 5);
console.log(rect);