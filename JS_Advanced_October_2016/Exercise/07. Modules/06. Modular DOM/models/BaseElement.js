class BaseElement{
    constructor(){
        if (new.target == BaseElement){
            throw new TypeError("Abstract class cannot be instantiated directly.");
        }

        this._element = null;
    }

    appendTo(selector){
        this.createElement();
        $(selector).append(this._element);
    }

    createElement(){
        this._element = this.getElementString();
    }

    getElementString(){
    }
}

module.exports = BaseElement;