let Article = require('./Article');

class TableArticle extends Article {
    constructor(title, content) {
        super(title, content);
        this._headings = null;
        this._data = null;
    }

    loadData(headings, data) {
        this._headings = headings;
        this._data = data;
    }

    getElementString() {
        let tr = $('<tr>');
        for (let heading of this._headings) {
            tr.append($('<th>').text(heading));
        }

        let table = $('<table>').addClass('table').append($(tr));

        for (let data of this._data) {
            let tr = $('<tr>');
            for (let h of this._headings) {
                let prop = h.split(/\s+/).join('').toLowerCase();

                $(tr).append($('<td>').text(data[prop]));
            }
            $(table).append($(tr));
        }

        let article = $('<div>').addClass('article').append($('<div>').addClass('article-title').text(this.title)).append($('<p>').text(this.content)).append($(table));

        return article;
    }
}

module.exports = TableArticle;

//# sourceMappingURL=TableArticle-compiled.js.map