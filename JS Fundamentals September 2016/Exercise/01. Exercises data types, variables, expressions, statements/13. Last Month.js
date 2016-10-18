function LastMonth([day, month, year]) {

    let date = new Date(year, month, day);
    date.setMonth(date.getMonth() - 2);


    let y = date.getFullYear(), m = date.getMonth();
    let lastDay = new Date(y, m + 1, 0);

    console.log(lastDay.getDate());
}

LastMonth(['13','12','2004']);