function lookupChar(str, index) {
    if (typeof str !== "string" || typeof index !== "number" || !Number.isInteger(index)){
        return undefined;
    }

    if (index >= str.length || index < 0){
        return "Incorrect index";
    }

    return str[index];
}

//console.log(lookupChar("papa", 0));
module.exports = {lookupChar};