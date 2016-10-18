function aggregateElement(input) {
    let elements = input.map(Number);

    aggregate(elements, 0, (a,b) => a + b);
    aggregate(elements, 0, (a,b) => a + 1/b);
    aggregate(elements, '', (a,b) => a + b);

    function aggregate(arr, initVal, func) {

        let sum = arr.reduce(func, initVal);
        // let val = initVal;
        // for (let i = 0; i < arr.length; i++){
        //     val = func(val, arr[i]);
        // }
        console.log(sum);
    }
}

aggregateElement([1, 2, 3]);