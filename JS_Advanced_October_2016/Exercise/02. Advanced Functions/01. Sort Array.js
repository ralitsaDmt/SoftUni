function sortArray(arr, sortMethod) {

    let asc = function (a, b) {
        return a - b;
    };

    let desc = function (a,b) {
        return b - a;
    };

    let sortingStrategies = {
        'asc': asc,
        'desc': desc
    };

    return arr.sort(sortingStrategies[sortMethod]);
}
console.log(sortArray([14, 7, 17, 6, 8], 'desc'));;