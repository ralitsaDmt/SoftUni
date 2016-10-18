function firstAndLastKNumbers(arr) {
    arr = arr.map(Number);
    let k = arr[0];
    let elements = arr.splice(1);

    console.log(elements.slice(0, k));
    let index = elements.length - k;
    if (index >= 0){
        console.log(elements.slice(index));
    }
}

firstAndLastKNumbers(['3',
    '6', '7', '8', '9']
);