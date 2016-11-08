
class Person {
    constructor(name, age) {
        this.name = name;
        this.age = Number(age);
    }

    addToSelector(selector) {
        let domRepresentation = this.createDom();
        let elements = $(selector);

        for (let element of elements) {
            $(element).append($(domRepresentation).clone());
        }
    }

    createDom() {
        let domRepresentation = $('<div>').addClass(`person ${ this.name }`).append($('<p>').addClass("name").text(this.name)).append($('<p>').addClass("age").text(this.age)).append($('<div>').addClass(`posts ${ this.name }`));

        return domRepresentation;
    }
}

module.exports = Person;

//# sourceMappingURL=person-compiled.js.map