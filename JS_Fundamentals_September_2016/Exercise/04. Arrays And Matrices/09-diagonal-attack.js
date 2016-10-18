function diagonalAttack(matrixRows) {

    let matrix = matrixRows.map(
        row => row.split(' ').map(Number)
    );

    let primarySum = 0;
    let secondarySum = 0;

    for (let r = 0; r < matrix.length; r++){
        primarySum += matrix[r][r];
        secondarySum += matrix[r][matrix.length - r - 1];
    }

    if (primarySum == secondarySum){
        for (let r = 0; r < matrix.length; r++){
            for (let c = 0; c < matrix.length; c++){
                if (c != r && c != matrix.length - r - 1){
                    matrix[r][c] = primarySum;
                }
            }
        }
    }

    console.log(matrix.map(
        row => row.join(' ')
    ).join('\n'));

}

diagonalAttack(['1 1 1',
    '1 1 1',
    '1 1 0'

]);