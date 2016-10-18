function PrimeChecker(n) {
    if (n <= 0 || n == 1){
        return false;
    }
    let i = 2;
    let isPrime = true;
    while (i <= Math.sqrt(n)){
        if (n % i == 0){
            isPrime = false;
        }
        i++;
    }

    return isPrime;
}

console.log(PrimeChecker(10));