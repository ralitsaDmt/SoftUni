function ColorfulNumbers(input) {
    let num = Number(input[0]);

    let result = '<ul>\n';
    for (let i = 1; i <= num; i++){
        let color = 'blue';
        if (i % 2 != 0){
            color = 'green';
        }
        result += `\t<li><span style="color: ${color}">${i}</span></li>`;
    }
    result += '</ul>';
    return result;
}

ColorfulNumbers([10]);