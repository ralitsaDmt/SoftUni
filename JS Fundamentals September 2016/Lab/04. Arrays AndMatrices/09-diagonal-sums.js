function diagonalSums(matrixRows) {
    let matrix = matrixRows.map(
        row => row.split(' ').map(Number)
    );

    let mainSum = 0, secondarySum = 0;
    for (let i = 0; i < matrix.length; i++){
        mainSum += matrix[i][i];
        secondarySum += matrix[i][matrix[i].length - i - 1];
    }

    console.log(`${mainSum} ${secondarySum}`);

    // console.log(matrix.map(
    //     row => row.join(' ')
    // ).join('\n'));
}

diagonalSums(['3 5 17',
    '-1 7 14',
    '1 -8 89']
);