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

class TitleBar extends BaseElement{
    constructor(title){
        super();
        this.title = title;
        this.links = [];
    }

    addLink(href, name){
        let link = $('<a>')
            .addClass('menu-link')
            .attr('href', href)
            .text(name);
        this.links.push(link);
    }

    getElementString(){

        let nav = $('<nav>').addClass('menu');

        let first = true;
        this.links.forEach(l => {
            if (first){
                $(nav).append(l);
                first = false;
            }
            else {
                nav.append('|');
                nav.append(l);
            }
        });

        let header = $('<header>').addClass('header')
            .append($('<div>')
                .append($('<span>').addClass('title').text(this.title)))
            .append($('<div>')
                .append($(nav)));

        return header;
    }
}

class Footer extends BaseElement{
    constructor(message){
        super();
        this.message = message;
    }

    getElementString(){
        return $('<footer>').text('Copyright &copy; ' + this.message);
    }
}

class Article extends BaseElement{
    constructor(title, content){
        super();
        this.title = title;
        this.content = content;
        this.timestamp = Date.now();
    }

    getElementString(){
        return $('<div>').addClass('article')
            .append($('<div>').addClass('article-title').text(this.title))
            .append($('<p>').text(this.content));
    }
}

class ImageArticle extends Article{
    constructor(title, content,image){
        super(title, content);
        this.image = image;
    }

    getElementString(){
        return $('<div>').addClass('article')
            .append($('<div>').addClass('article-title').text(this.title))
            .append($('<div>').addClass('image')
                .append($('<img>').attr('src', this.image)))
            .append($('<p>').text(this.content));
    }
}

class TableArticle extends Article{
    constructor(title, content){
        super(title, content);
        this._headings = null;
        this._data = null;
    }

    loadData(headings, data){
        this._headings = headings;
        this._data = data;
    }

    getElementString(){
        let tr = $('<tr>');
        for (let heading of this._headings){
            tr.append($('<th>').text(heading))
        }

        let table = $('<table>').addClass('table')
            .append($(tr));

        for (let data of this._data){
            let tr = $('<tr>');
            for (let h of this._headings){
                let prop = h.split(/\s+/).join('').toLowerCase();

                $(tr).append($('<td>').text(data[prop]));
            }
            $(table).append($(tr));
        }

        let article = $('<div>').addClass('article')
            .append($('<div>').addClass('article-title').text(this.title))
            .append($('<p>').text(this.content))
            .append($(table));

        return article;
    }
}