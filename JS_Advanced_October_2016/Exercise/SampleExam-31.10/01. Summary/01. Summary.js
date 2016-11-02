function addSummary(selector) {

    function elementsWithTagStrong() {
        let content = $('#content').children();
        let elements = content.find('strong');
        let summaryElements = [];
        for (let element of elements){
            summaryElements.push($(element).text());
        }
        return summaryElements;
    }

    function createSummaryFragment(elements){
        let fragment = $('<div>').attr('id', 'summary')
            .append($('<h2>').text('Summary'))
            .append($('<p>').text(elements.join('')));
        return fragment;
    }

    let summaryBtn = $(selector);
    summaryBtn.on('click', function () {
        let elements = elementsWithTagStrong();
        let fragment = createSummaryFragment(elements);
        $('#content').append(fragment);
    });
}

