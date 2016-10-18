function Chessboard(n) {

    let html = '<div class="chessboard">\n';

    for (let i = 0; i < n; i++){
        html += "\t<div>\n";
        let color = 'black';

        if (i % 2 != 0){
            color = 'white';
        }

        for (let j = 0; j < n; j++){
            html += `\t<span class="${color}"></span>\n`;
            if (color == 'white'){
                color = 'black';
            }
            else{
                color = 'white';
            }
        }
        html += "\t</div>\n"
    }
    html += "</div>";

    return html;
}