class TitleBar{
    constructor(title){
        this.title = title;
        this.menu = [];
        this.menuHTML = {};
    }

    addLink(href, name){
        let link = $(`<a class="menu-link" href="${href}">${name}</a>`);
        this.menu.push(link);
    }

    appendTo(selector){
        $(selector).append(this.generate());
    }

    generate(){
        let html = $(`<header class="header">
            <div class="header-row">
            <a class="button">&#9776;</a>
        <span class="title">${this.title}</span>
            </div>
            <div class="drawer">
                <nav class="menu">
                </nav>
            </div>
        </header>`);

        this.menuHTML = html.find('.menu');
        for (let link of this.menu){
            this.menuHTML.append(link);
        }

        let button = html.find('.button');

        button.click(this.toggle.bind(this));

        return html;
    }

    toggle(){
        let menu = this.menuHTML.parent();

        if (menu.css('display') == 'none'){
            menu.css('display', 'block');
        }
        else{
            menu.css('display', 'none');
        }
    }
}