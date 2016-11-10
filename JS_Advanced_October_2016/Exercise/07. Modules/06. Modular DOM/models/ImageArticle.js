let Article = require('./Article');

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

module.exports = ImageArticle;