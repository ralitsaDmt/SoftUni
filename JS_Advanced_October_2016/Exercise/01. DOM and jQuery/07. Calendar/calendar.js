function calendar([day, month, year]) {

    let monthNames = ["January", "February", "March", "April", "May", "June",
        "July", "August", "September", "October", "November", "December"
    ];
    let dayNames = ["Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"];

    let monthName = monthNames[month - 1];

    let calendar = $('<table>')
        .append($('<caption>')
            .text(monthName + ' ' + year));
    let tableBody = $('<tbody>');
    let row = $('<tr>');
    for (let dayName of dayNames){
        row.append($('<td>').text(dayName));
    }
    tableBody.append(row);

    let date = new Date(year, month - 1, day);
    let daysCount = new Date(year, month, 0).getDate();

    // get first day of month as day of week
    let firstDayOfMonth = new Date(year, month - 1, 1);
    let firstDayOfWeek = firstDayOfMonth.getDay();
    if (firstDayOfWeek == 0){
        firstDayOfWeek = 7;
    }

    let currentDay = 0;
    let week = 0;
    while(currentDay < daysCount){
        row = $('<tr>');
        week++;
        for (let i = 0; i < 7; i++){
            if (week == 1 && i < firstDayOfWeek - 1){
                row.append($('<td>'));
            }
            else if (currentDay >= daysCount){
                row.append($('<td>'));
            }
            else{
                currentDay++;
                if (currentDay == date.getDate()){
                    row.append($('<td>').addClass('today').text(currentDay));
                }
                else{
                    row.append($('<td>').text(currentDay));
                }
            }
        }
        tableBody.append(row);
    }


    calendar.append(tableBody);
    $('div#content').append(calendar);

    let caption = $('caption')[0];
    console.log(caption.textContent);
}

//calendar([17, 1,2016]);