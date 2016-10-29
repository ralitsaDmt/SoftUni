let createBook = (function createBook() {
    let id = 1;
    return function (selector, titleName, authorName, isbn) {

        let fragment = document.createDocumentFragment();
        let container = $(selector);

        let div = $("<div>");
        div.attr("id", "book" + id);
        id++;

        let paragraphTitle = $("<p>");
        let paragraphAuthor = $("<p>");
        let paragraphISBN = $("<p>");
        let selectBtn = $("<button>Select</button>");
        let deselectBtn = $("<button>Deselect</button>");

        paragraphTitle.text(titleName);
        paragraphAuthor.text(authorName);
        paragraphISBN.text(isbn);

        paragraphTitle.addClass("title");
        paragraphAuthor.addClass("author");
        paragraphISBN.addClass("isbn");

        selectBtn.on("click", function () {
            div.css("border", "2px solid blue");
        });

        deselectBtn.on("click", function () {
            div.css("border", "");
        });

        div
            .append(paragraphTitle)
            .append(paragraphAuthor)
            .append(paragraphISBN)
            .append(selectBtn)
            .append(deselectBtn);

        div.appendTo(fragment);
        container.append(fragment);
    }
}());