function evenPositionElements(arr) {
    console.log(arr.filter((x, i) => i % 2 == 0).join(" "));
}

evenPositionElements([1, 2, 3, 4, 5]);