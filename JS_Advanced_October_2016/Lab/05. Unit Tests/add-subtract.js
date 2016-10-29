// function createCalculator() {
//     let value = 0;
//     return {
//         add: function(num) { value += Number(num); },
//         subtract: function(num) { value -= Number(num); },
//         get: function() { return value; }
//     }
// }
//
//
// module.exports = {createCalculator};
//
let func = (function createAddSubtractModule() {
    let value = 0;
    return {
        add: function(num) { value += Number(num); },
        subtract: function(num) { value -= Number(num); },
        get: function() { return value; }
    }
})();

func.add();
func.add();
console.log(func.get());