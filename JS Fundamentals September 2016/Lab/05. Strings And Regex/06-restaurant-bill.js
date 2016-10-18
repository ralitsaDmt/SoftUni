function restaurantBill(arr) {

    let purchases = [];
    let sum = 0;
    for (let i = 0; i < arr.length; i+=2){
        let product = arr[i];
        let price = arr[i + 1];

        purchases.push(product);
        sum += Number(price);
    }

    console.log(`You purchased ${purchases.join(', ')} for a total sum of ${sum}`);
}

restaurantBill(['Beer Zagorka', '2.65', 'Tripe soup', '7.80','Lasagna', '5.69']);