let ext = (function () {
    let id = 0;

    return class ExtensibleObject{
        constructor(){
            this.id = id;
            id++;
        }

        extend(template){
            for (let prop in template){
                if (!this.hasOwnProperty(prop)){
                    if (typeof template[prop] === 'function'){
                        ExtensibleObject.prototype[prop] = template[prop];
                    }
                    else{
                        this[prop] = template[prop];
                    }
                }
            }
        }
    }
})();

let template = {
    extensionData: 5,
    newData: 'String',
    method: function () {
        return 10;
    }
};

let testObj = new ext();
let testObj1= new ext();

testObj.extend(template);
console.log(testObj);

template = {
    data: 'kur',
    method: function () {
        return 'kor';
    }
};
testObj1.extend(template);
console.log(testObj1);
