class Circle{
    constructor(r){
        this.radius = Number(r);
    }

    // this is new property
    // it is calculated when called
    
    get diameter() {
        return this.radius * 2;
    }

    // setting diameter
    // this will overwrite the radius!!!!
    
    set diameter(d){
        this.radius = d / 2;
    }

    get area(){
        return Math.PI * Math.pow(this.radius, 2);
    }
}