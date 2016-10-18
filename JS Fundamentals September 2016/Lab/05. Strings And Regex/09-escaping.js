function escaping(items) {
    return '<ul>\n' +
            items
                .map(htmlEscape)
                .map(
                    item => `\t<li>${item}</li>`)
                .join('\n')
            + '\n</ul>\n';


    function htmlEscape(text) {
        let map = {'"': '&quot;', '&': '&amp;', "'": '&#39;', '<': '&lt;', '>':'&gt;'};
        return text.replace(/[\"&'<>"]/g, ch => map[ch]);
    }
}

console.log(escaping(['<b>unescaped text</b>', 'normal text']));