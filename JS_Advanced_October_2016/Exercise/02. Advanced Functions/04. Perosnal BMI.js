function solve(name, age, weight, height) {
    let bmi = '';
    let person = {
        name: name,
        personalInfo: {
            age: age,
            weight: Number(weight),
            height: Number(height)
        },
        BMI: (() => {
            let w = weight;
            let h = height;

            return bmi = Number((w / Math.pow(h / 100, 2)).toFixed(0));
        })(),
        status: (() => {
            let state = "";
            if (bmi < 18.5) {
                state = 'underweight';
            }
            else if (bmi >= 18.5 && bmi < 25) {
                state = 'normal';
            }
            else if (bmi >= 25 && bmi < 30) {
                state = 'overweight';
            }
            else if (bmi >= 30) {
                state = "obese";
            }

            return state;
        })()
    };

    if (person.status === 'obese'){
        person.recommendation = 'admission required';
    }

    console.log(person);;
    //return person;
}

solve('Honey Boo Boo', 9, 57, 137);