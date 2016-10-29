function processCommands(arr) {
    let commandProcessor = (function () {
        let list = [];
        return {
            add: (newItem) => list.push(newItem),
            remove: (item) => list = list.filter(t => t != item),
            print: () => console.log(list)
        };
    })();

    for (let cmd of arr){
        let [cmdName, arg] = cmd.split(' ');
        commandProcessor[cmdName](arg);
    }
}

processCommands(['add hello', 'add again', 'remove hello', 'add again', 'print']);