function addRemove(commands) {

    let arr = [];

    let num = 0;
    for (let command of commands){
        num++;
        if (command === 'add'){
            arr.push(num);
        }
        else if (command === 'remove' && arr.length > 0){
            arr.pop();
        }
    }

    if (arr.length != 0){
        console.log(arr.join('\n'));
    }
    else console.log('Empty');
}

addRemove(['add',
    'add',
    'remove',
    'add',
    'add',
    'add'
]);