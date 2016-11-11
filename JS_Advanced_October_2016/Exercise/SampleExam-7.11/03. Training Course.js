class TrainingCourse{
    constructor(title, trainer){
        this.title = title;
        this.trainer = trainer;
        this._topics = [];
    }

    addTopic(title, date){
        let topic = {title: title, date: date};

        this._topics.push(topic);
        this._topics.sort((a,b) => a.date > b.date);

        return this;
    }

    get firstTopic(){
        let firstTopic = this._topics[0];

        return firstTopic != undefined ? {
            title: firstTopic.title,
            date: firstTopic.date
        } : undefined;
    }

    get lastTopic(){
        let lastTopic =  this._topics[this._topics.length - 1];

        return lastTopic != undefined ? {
            title: lastTopic.title,
            date: lastTopic.date
        } : undefined;
    }

    toString(){
        let strToPrint = `Course "${this.title}" by ${this.trainer}`;

        if (this._topics.length > 0){
            for (let topic of this._topics){
                strToPrint += `\n * ${topic.title} - ${topic.date}`;
            }
        }
        else{
            strToPrint += '\n';
        }
        return strToPrint;
    }
}

let js = new TrainingCourse("JS Intro", "Svetlin Nakov");
console.log("First topic: " + JSON.stringify(js.firstTopic));
console.log("Last topic: " + JSON.stringify(js.lastTopic));
console.log("" + js);

js.addTopic("Maps", new Date(2016, 9, 6, 18, 0));
js.addTopic("JS Overview", new Date(2016, 8, 27, 18, 0));
js.addTopic("Program Logic", new Date(2016, 8, 29, 18, 0));
js.addTopic("Arrays", new Date(2016, 9, 3, 18, 0));
console.log("First topic: " + JSON.stringify(js.firstTopic));
console.log("Last topic: " + JSON.stringify(js.lastTopic));
console.log("" + js);

let php = new TrainingCourse("PHP Intro", "Ivan Yonkov")
    .addTopic("Strings", new Date(2017, 2, 16, 18, 0))
    .addTopic("PHP First Steps", new Date(2017, 2, 12, 18, 0))
    .addTopic("Arrays", new Date(2017, 2, 14, 18, 0));
console.log("" + php);
