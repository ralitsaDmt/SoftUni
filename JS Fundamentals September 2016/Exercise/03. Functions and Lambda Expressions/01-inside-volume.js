function insideVolume(input) {
    input = input.map(Number);

    for (let i = 0; i < input.length; i+=3){
        let x = input[i];
        let y = input[i + 1];
        let z = input[i + 2];

        if (x <= 50 && x >= 10 && y >= 20 && z >= 15 && y <= 80 && z <= 50){
            console.log('inside');
        }
        else{
            console.log('outside');
        }
    }
}

insideVolume([13.1, 50, 31.5, 50, 80, 50, -5, 18, 43]
);