function main(input) {
    let result = [];
    for (let entry of input){
        result.push(JSON.parse(entry));
    }

    input = result;
    //console.log(input);

    let unique = new Set();

    // Add first array to unique
    unique.add(input[0].sort((a, b) => b - a))  ;
    input.shift();
    // For each next array -> loop through arrays in unique and check if they are the same;
    //                     -> if same array found -> break and don't add array to unique
    //                                            -> else add array to unique

    for (let arr of input){
        arr = arr.sort((a, b) => b - a);
        let isUnique = true;
        for (let un of unique){
            un = un.sort((a, b) => b - a);
            if (arr.length == un.length) {
                let foundDifferent = false;
                for (let i = 0; i < arr.length; i++) {
                    if (arr[i] !== un[i]) {
                        foundDifferent = true;
                        break;
                    }
                }
                if (foundDifferent) break;
                isUnique = false;
            }
        }
        //console.log(unique);

        if (isUnique){
            unique.add(arr);
        }
    }

    //console.log(unique);

    // Make array of unique elements and sort it
    let sorted = [...unique.values()]
        .sort((a, b) => a.length - b.length);

    // Print the sorted array
    for (let arr of sorted){
        console.log(`[${arr.join(', ')}]`);
    }
}

main([
    "[-3, -2, -1, 0, 1, 2, 3, 4]",
    "[10, 1, -17, 0, 2, 13]",
    "[10, 1, -17, 0, 2, 13]",
    "[10, 2, -17, 0, 2, 13]",
    "[4, -3, 3, -2, 2, -1, 1, 0]"
]);