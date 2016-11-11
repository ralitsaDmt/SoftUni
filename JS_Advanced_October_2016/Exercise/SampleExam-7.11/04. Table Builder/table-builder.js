function tableBuilder(selector) {
    return {
        createTable: function (columnNames) {

            let headings = $('<tr>');
            for (let heading of columnNames){
                headings.append($('<th>').text(heading));
            }

            let table = $('<table>').append($(headings));

            $(selector).append($(table));
        },
        fillData: function (dataRows) {
            return true;
        }
    }
}
