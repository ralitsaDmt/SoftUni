function magicMatrix(matrixRows) {
    let matrix = matrixRows.map(
        row => row.split(' ').map(Number)
    );

    let sum = matrix[0].reduce((a, b) => (a + b));

    for (let row = 1; row < matrix.length; row++){
        let sumRow = matrix[row].reduce((a, b) => (a + b));
        if (sum != sumRow){
            return false;
        }
    }

    for (let col = 0; col < matrix[0].length; col++){
        let sumCol = 0;
        for (let row = 0; row < matrix.length; row++){
            sumCol += matrix[row][col];
        }

        if (sumCol != sum){
            return false;
        }
    }

    return true;
}

console.log(magicMatrix(['11 32 45',
    '21 0 1',
    '21 1 1'

]));