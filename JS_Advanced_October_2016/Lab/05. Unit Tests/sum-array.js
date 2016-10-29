function sum(arr) {
    let sum = 0;

    for (let obj of arr){
        sum += Number(obj);
    }
    return sum;
}

module.exports = {sum};