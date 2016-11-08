class Numberbox{
    constructor(label, selector, minValue, maxValue){
        this._label = label;
        this._selector = selector;
        this._elements = $(selector);

        this._minValue = Number(minValue);
        this._maxValue = Number(maxValue);
        this._value = this._elements.val();

        let self= this;
        this._elements.on("change", function (ev) {
            self.value = $(this).val();
        })
    }

    get label(){
        return this._label;
    }

    get elements(){
        return this._elements;
    }

    get value(){
        return this._value;
    }

    set value(val){
        if (val < this._minValue || val > this._maxValue){
            throw new Error();
        }

        this._value = val;
        this._elements.each(function (index, elem) {
            $(elem).val(val);
        })
    }
}

module.exports = Numberbox;