function templateFormat(input) {

    let xml = '<?xml version="1.0" encoding="UTF-8"?>\n<quiz>\n' + formatQuestions(input) + '</quiz>';

    function formatQuestions(input) {
        let format = '';
        for (let i = 0; i < input.length; i+=2){
            let question = input[i];
            let answer = input[i + 1];

            format += `\t<question>\n\t\t${question}\n\t</question>\n`;

            format += `\t<answer>\n\t\t${answer}\n\t</answer>\n`;

        }

        return format;
    }

    return xml;
}

console.log(templateFormat(["Who was the forty-second president of the U.S.A.?", "William Jefferson Clinton"]));