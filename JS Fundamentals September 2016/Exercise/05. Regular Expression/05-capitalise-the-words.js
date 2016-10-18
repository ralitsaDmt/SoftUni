function capitalise([input]) {
    let words = input.split(' ');

    let capitalised = [];

    for (let word of words){
        capitalised.push(word.charAt(0).toUpperCase() + word.slice(1).toLowerCase());
    }

    console.log(capitalised.join(' '));
}

capitalise(['some oTher more']);