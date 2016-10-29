
function processCommands(commands) {

    let commandProcessor = (function(){
        let text = '';
        return {
            append: (t) => text += t,
            removeStart: (count) => text = text.slice(count),
            removeEnd: (count) => text = text.slice(0, text.length - count),
            print: () => console.log(text)
        };
    })();

    for (let cmd of commands){
        let [cmdName, arg] = cmd.split(' ');
        commandProcessor[cmdName](arg);
    }
}

processCommands(['append 123', 'append 45', 'removeStart 2', 'removeEnd 1', 'print']); // 34


//
// comProcesor.append('pesho');
// comProcesor.print();
// comProcesor.append('gosho');
// comProcesor.print();