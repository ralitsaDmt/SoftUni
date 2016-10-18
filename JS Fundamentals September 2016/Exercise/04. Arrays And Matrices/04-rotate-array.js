function rotateArray(input) {

    let step = Number(input[input.length - 1]);
    let arr = input.splice(0, input.length - 1);




    for (let i = 0; i < step % arr.length; i++){
        let last = arr.pop();
        arr.unshift(last);
    }

    console.log(arr.join(' '));
}

rotateArray([1, 2, 3, 4, 2]);