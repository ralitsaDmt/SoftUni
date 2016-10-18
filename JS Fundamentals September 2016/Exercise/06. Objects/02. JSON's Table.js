function table(input) {
    let html = '<table>\n';

    function htmlEscape(text) {
        text = text.toString();
        let map = {'"': '&quot;', '&': '&amp;', "'": '&#39;', '<': '&lt;', '>':'&gt;'};
        return text.replace(/[\"&'<>"]/g, ch => map[ch]);
    }

    for (let obj of input){
        let data = JSON.parse(obj);
        let name = data.name;
        let position = data.position;
        let salary = data.salary;

        html += '\t<tr>\n';
        html += `\t\t<td>${htmlEscape(name)}</td>\n`;
        html += `\t\t<td>${htmlEscape(position)}</td>\n`;
        html += `\t\t<td>${htmlEscape(salary)}</td>\n`;
        html += '\t<tr>\n';
    }

    html += '</table>';
    console.log(html);
}

table([
    '{"name":"Pesho","position":"Promenliva","salary":100000}',
    '{"name":"Teo","position":"Lecturer","salary":1000}',
    '{"name":"Georgi","position":"Lecturer","salary":1000}'

])