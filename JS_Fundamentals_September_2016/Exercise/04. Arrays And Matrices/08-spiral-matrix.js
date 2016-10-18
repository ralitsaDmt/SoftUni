function spiralMatrix([input]) {

    let [rows, cols] = input.split(' ').map(Number);
    let matrix = [];
    for (let i = 0; i < rows; i++){
        matrix.push([]);
        for (let j = 0; j < cols; j++){
            matrix[i].push(0);
        }
    }


    let element = 0;
    let col = -1;
    let row = 1;
    while (element < rows * cols)
    {

        row--;
        col++;
        while (col < cols && matrix[row][col] == 0)
        {
            element++;
            matrix[row][col] = element;
            col++;
        }
        col--;
        row--;
        while (row >= 0 && matrix[row][col] == 0)
        {
            element++;
            matrix[row][col] = element;
            row--;
        }
        row++;
        col--;
        while (col >= 0 && matrix[row][col] == 0)
        {
            element++;
            matrix[row][col] = element;
            col--;
        }
        row++;
        col++;
        while (row < rows && matrix[row][col] == 0)
        {
            element++;
            matrix[row][col] = element;
            row++;
        }
    }

    console.log(
        matrix.map(row => row.join(' '))
            .join('\n'));

}

spiralMatrix(['5 5']);