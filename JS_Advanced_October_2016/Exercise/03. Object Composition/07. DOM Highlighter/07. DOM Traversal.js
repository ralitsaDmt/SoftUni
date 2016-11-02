function domHighlight (selector) {
    let start = $(selector);
    let maxDepth = 0;
    let maxDepthElement = '';

    let x = $('#content');
    console.log(x);
    function setDepth(depth, element) {
        if (depth > maxDepth){
            maxDepth = depth;
            maxDepthElement = element;
        }
        let children = $(element).children();
        //console.log(children);
        children.each((index, element) => setDepth(depth + 1, element));
    }

    setDepth(1, start);
    let jqueryElement = $(maxDepthElement);
    jqueryElement.addClass('highlight');

    while(maxDepth){
        //console.log(jqueryElement);
        jqueryElement = jqueryElement.parent();
        jqueryElement.addClass('highlight');
        maxDepth--;
    }
}

domHighlight('#content');

