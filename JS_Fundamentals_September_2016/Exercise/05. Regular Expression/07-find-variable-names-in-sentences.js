function findVariables([str]) {
    let pattern = /\b[_][a-zA-Z0-9]*\b/g;

    let variables = [];
    let match = pattern.exec(str);

    while (match){
        variables.push(match[0].slice(1));
        match = pattern.exec(str);
    }

    console.log(variables.join(','));
}

findVariables(['The _id and _age variables are both integers.']);