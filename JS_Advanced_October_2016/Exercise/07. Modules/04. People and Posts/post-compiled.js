
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

module.exports = Post;

//# sourceMappingURL=post-compiled.js.map