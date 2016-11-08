class BaseElement{
    constructor(){
        if (new.target == BaseElement){
            throw new TypeError("Abstract class cannot be instantiated directly.");
        }
        this._element = null;
    }

    appendTo(selector){
        let element = this.createElement();
    }

    createElement(){
        let value = this.getElementString();
    }

    getElementString(){}
}