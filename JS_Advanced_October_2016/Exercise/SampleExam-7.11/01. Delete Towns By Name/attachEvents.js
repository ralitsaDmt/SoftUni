function attachEvents() {

    let deleteBtn = $('#btnDelete');
    deleteBtn.on('change', function () {
        let townName = $('#townName').text();

        console.log(townName);
    })

}