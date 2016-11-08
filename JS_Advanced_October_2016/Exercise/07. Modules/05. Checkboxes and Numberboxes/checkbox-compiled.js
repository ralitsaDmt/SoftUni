class Checkbox {
    constructor(label, selector) {
        this._label = label;
        this._selector = selector;
        this._elements = $(selector);
        this._value = this._elements.is(":checked");

        let self = this;
        this._elements.on('change', function (ev) {
            self.value = $(this).is(":checked");
        });
    }

    get label() {
        return this._label;
    }

    get elements() {
        return this._elements;
    }

    get value() {
        return this._value;
    }

    set value(value) {
        if (value != true && value != false) {
            throw new Error();
        }

        this._value = value;
        this._elements.each(function (index, elem) {
            $(elem).prop("checked", value);
        });
    }
}

module.exports = Checkbox;

//# sourceMappingURL=checkbox-compiled.js.map