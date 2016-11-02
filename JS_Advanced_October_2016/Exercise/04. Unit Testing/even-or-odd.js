function isOddOrEven(n) {
    if (typeof n !== "string"){
        return undefined;
    }
    else{
        return n.length % 2 == 0 ? "even" : "odd";
    }
}

//console.log(isOddOrEven("mocha"));
module.exports = {isOddOrEven};