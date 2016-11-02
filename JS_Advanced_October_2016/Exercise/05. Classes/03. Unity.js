class Rat{
    constructor(name){
        this.name = name;
        this.united = {};
    }

    unite(otherRat){
        if (otherRat instanceof Rat){
            this.united[otherRat.name] = otherRat;
        }
    }

    getRats(){
        let list = [];
        let keys = Object.keys(this.united);
        for (let key of keys){
            list.push(this.united[key]);
        }
        return list;
    }

    toString(){
        console.log(this.name);
        let list = Object.keys(this.united);
        console.log(list.join('##'));
    }
}

let rat1 = new Rat('pesho');
console.log(rat1);
let rat2 = new Rat('gosho');
let rat3 = new Rat('stamat');
let rat4 = 'misho';

rat1.unite(rat2);
rat1.unite(rat3);
rat1.unite(rat4);
//
// rat1.toString();

let list = rat1.getRats();
console.log(list);
