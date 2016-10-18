function extractLinks(input) {

    let links = [];

    let pattern = /(www)\.([-a-zA-Z0-9]+)(\.[a-z]+)+/g;

    for (let sentence of input){
        let match = pattern.exec(sentence);
        while (match){
            links.push(match[0]);
            match  = pattern.exec(sentence);
        }
    }

    console.log(links.join('\n'));
}

extractLinks(['Join WebStars now for free, at www.web-stars.com',
    'You can also support our partners:',
'Internet - www.internet.com',
'WebSpiders - www.webspid-e.yhijk.rs101.com',
'Sentinel - www.sentinel.-ko'
]);