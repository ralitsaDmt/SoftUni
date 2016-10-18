function equalNeighbours(matrixRows) {
    let matrix = matrixRows.map(
        row => row.split(' ')
    );

    let count = 0;
    for (let r = 0; r < matrix.length - 1 ; r++){
        for (let c = 0; c < matrix[r].length ; c++){
            if (matrix[r][c] == matrix[r + 1][c]){
                count++;
            }
        }
    }

    for (let r = 0; r < matrix.length; r++){
        for (let c = 0; c < matrix[r].length - 1; c++){
            if (matrix[r][c] == matrix[r][c + 1]){
                count++;
            }
        }
    }

    console.log(count);

    // console.log(matrix.map(
    //     row => row.join(' ')
    // ).join('\n'));
}

equalNeighbours(['2 2 5 7 4',
'4 0 5 3 4',
'2 5 5 4 2']
);