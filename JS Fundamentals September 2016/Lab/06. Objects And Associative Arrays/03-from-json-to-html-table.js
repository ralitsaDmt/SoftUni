function fromJSONToHTMLTable(input){
    let data = JSON.parse(input);

    let html = '<table>\n';
    html += '\t<tr>';

    function htmlEscape(text) {
        text = text.toString();
        let map = {'"': '&quot;', '&': '&amp;', "'": '&#39;', '<': '&lt;', '>':'&gt;'};
        return text.replace(/[\"&'<>"]/g, ch => map[ch]);
    }

    for (let key of Object.keys(data[0])){
        html += `<th>${(key)}</th>`;
    }
    html += '</tr>\n';

    for (let obj of data){
        html += '\t<tr>';

        for (let key of Object.keys(obj)){
            html += `<td>${htmlEscape(obj[key])}</td>`;
        }

        html +=  `</tr>\n`;
    }

    html += '</table>';
    console.log(html);
}

fromJSONToHTMLTable(['[{"Name":"Tomatoes & Chips","Price":2.35},{"Name":"J&B Chocolate","Price":0.96}]']);
