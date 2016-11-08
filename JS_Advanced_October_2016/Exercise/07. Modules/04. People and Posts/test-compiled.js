class Post {
    constructor(title, body, author) {
        this.title = title;
        this.body = body;
        this.author = author;
    }

    addToSelector(selector) {
        let domRepresentation = this.createDom();

        let elements = $(selector);

        for (let element of elements) {
            $(element).append($(domRepresentation).clone());
        }
    }

    createDom() {
        let domRepresentation = $('<div>').addClass(`post ${ this.author }`).append($('<h3>').addClass("title").text(this.title)).append($('<p>').addClass("body").text(this.body)).append($('<p>').addClass("author").text(this.author));

        return domRepresentation;
    }
}

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

function solve() {
    let person = new Person("Odry", 23);
    let post = new Post('Title', "Post body", "Unknown");

    person.addToSelector('.test');
    post.addToSelector('.test');
}

//# sourceMappingURL=test-compiled.js.map