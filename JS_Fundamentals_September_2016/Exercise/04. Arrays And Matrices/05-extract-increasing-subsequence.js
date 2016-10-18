function extractSubsequence(arr) {
    arr = arr.map(Number);

    let result = arr.filter((x, i) => x >= Math.max(...arr.slice(0, i + 1)));

    console.log(result.join('\n'));
}

extractSubsequence([1,
    3,
    2,
    15,
    10,
    12,
    3,
    2,
    24
]);