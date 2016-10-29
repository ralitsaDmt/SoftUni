function domSearch(selector, casing) {
    let content = $(selector);
    let addControls = $('<div>').addClass('add-controls')
        .append($('<label>Enter text: </label>')
            .append($('<input>')))
        .append($('<a>Add</a>').addClass('button').css('display', 'inline-block'));
    let searchControls = $('<div>').addClass('search-controls')
        .append($('<label>Search: </label>')
            .append($('<input>')));
    let resultControls = $('<div>').addClass('result-controls')
        .append($('<ul>').addClass('items-list'));

    content.append(addControls).append(searchControls).append(resultControls);

    $('.add-controls .button').on('click', function(){
        let text = $('.add-controls input').val();
        $('.result-controls ul')
            .append($('<li>').addClass('list-item')
                .append($('<a>X</a>').addClass('button'))
                .append($('<strong>').text(text)));
        $('.add-controls input').val('')
    });

    $('ul').on('click', 'a',  function(){
        $(this).parent().remove()
    });

    $('.search-controls input').on('input', function(){
        let searched = $('.search-controls input').val();
        if(casing === true){
            $('.items-list li').each((index, item) => {
                let str = item.textContent.slice(1);
                if(str.includes(searched)){
                    $(item).removeAttr('style')
                } else {
                    $(item).attr('style', 'display: none')
                }
            })
        } else {
            searched = searched.toLowerCase();
            $('.items-list li').each((index, item) => {
                let str = item.textContent.slice(1).toLowerCase();
                if(str.indexOf(searched) > -1){
                    $(item).removeAttr('style')
                } else {
                    $(item).attr('style', 'display: none')
                }
            })
        }
    })
}



// function domSearch(selector, cs) {
//
//     let addControls = $('<div>')
//         .addClass('add-controls')
//         .append($('<label>').text('Enter text: ').append($('<input>')))
//         .append($('<a>')
//             .addClass('button')
//             .css('display', 'inline-block')
//             .text('Add')
//             .click(function () {
//                 let elementText = $('label input');
//                 let newElement = $('<li>')
//                     .addClass('list-item')
//                     .append($('<a>')
//                         .addClass('button')
//                         .text('X')
//                         .click(function () {
//                             $(this).parent().remove();
//                         }))
//                     .append($('<strong>')
//                         .text(elementText.val().trim()));
//
//                 $('ul.items-list').append(newElement);
//                 elementText.val('');
//             }));
//
//     let searchControls = $('<div>')
//         .addClass('search-controls')
//         .append($('<label>')
//             .text('Search: ')
//             .append($('<input>')
//                 .on('input', function () {
//                     let needle = $(this).val();
//                     let items = $('.list-item strong').toArray();
//                     for (let item of items){
//                         let current = $(item);
//
//                         if (cs){
//                             if (current.text().indexOf(needle) < 0){
//                                  current.parent().css('display', 'none');
//                             }
//                             else{
//                                 current.parent().css('display', '');
//                             }
//                         }
//                         else{
//                             if (current.text().toLowerCase().indexOf(needle.toLowerCase()) < 0){
//                                 current.parent().css('display', 'none');
//                             }
//                             else{
//                                 current.parent().css('display', '');
//                             }
//                         }
//                     }
//                 })));
//    
//     let resultControls = $('<div>')
//         .addClass('result-controls')
//         .append($('<ul>')
//             .addClass('items-list'));
//    
//     $(selector)
//         .append(addControls)
//         .append(searchControls)
//         .append(resultControls);
// }
