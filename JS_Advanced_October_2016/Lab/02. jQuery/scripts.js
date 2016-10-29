// 02. Search in list

function search() {
    let searchText = $('#searchText').val();
    let matches = 0;

    $('#towns li').each((index, item) => {
        if (item.textContent.includes(searchText)){
            $(item).css("font-weight", "bold");
            matches++;
        }
        else{
            $(item).css("font-weight", "");
        }
    });
    $('#result').text(matches + " matches found.");
}

// 03. Countries table

function initializeTable() {
    $('#createLink').click(createCountry);

    function createCountry() {
        let country = $('#newCountryText').val();
        let capital = $('#newCapitalText').val();
        addCountryToTable(country, capital, true);
        $('#newCountryText').val('');
        $('#newCapitalText').val('');
        fixRowLinks();
    }


    function addCountryToTable(country, capital) {
        let row = $('<tr>')
            .append($("<td>").text(country))
            .append($("<td>").text(capital))
            .append($("<td>")
                .append($("<a href='#'>[Up]</a>").click(moveRowUp))
                .append(" ")
                .append($("<a href='#'>[Down]</a>").click(moveRowDown))
                .append(" ")
                .append($("<a href='#'>[Delete]</a>").click(deleteRow)));
        row.css('display','none');
        $("#countriesTable").append(row);
        row.fadeIn();
    }


    function fixRowLinks() {
        // Show all links in the table
        $('#countriesTable a').css('display', 'inline');

        // Hide [Up] link in first table data row
        let tableRows = $('#countriesTable tr');
        $(tableRows[2]).find("a:contains('Up')")
            .css('display', 'none');

        // Hide the [Down] link in the last table row
        $(tableRows[tableRows.length - 1]).find("a:contains('Down')")
            .css('display', 'none');
    }


    function moveRowUp() {
        let row = $(this).parent().parent();
        row.fadeOut(function() {
            row.insertBefore(row.prev());
            row.fadeIn();
            fixRowLinks();
        });
    }


    function moveRowDown() {
        let row = $(this).parent().parent();
        row.fadeOut(function() {
            row.insertAfter(row.next());
            row.fadeIn();
            fixRowLinks();
        });
    }


    function deleteRow() {
        let row = $(this).parent().parent();
        row.fadeOut(function() {
            row.remove();
            fixRowLinks();
        });
    }
}

// 04. Link Buttons

// function attachEvents() {
//     $('a.button').on('click', buttonClicked);
//
//     function buttonClicked() {
//         $('.selected').removeClass('selected');
//         $(this).addClass('selected');
//     }
// }

// 05. Selectable Towns

function attachEvents() {
    $('#items').on('click', 'li', function () {
        let li = $(this);
        if (li.attr('data-selected')){
            li.removeAttr('data-selected');
            li.css('background', '');
        }
        else{
            li.attr('data-selected', 'true');
            li.css('background', '#DDD');
        }
    });

    $('#showTownsButton').on('click', function () {
        let selLi = $('#items li[data-selected=true]');
        let towns = selLi.toArray()
            .map(li => li.textContent)
            .join(', ');
        $('#selectedTowns')
            .text("Selected towns: " + towns);
    })
}