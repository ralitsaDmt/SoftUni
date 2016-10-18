function FilterByAge([minAge, nameA, ageA, nameB, ageB]) {
    let personA = {name: nameA, age: Number(ageA)};
    let personB = {name: nameB, age: Number(ageB)};

    let people = [personA, personB];

    for (let p of people){
        if (p.age >= minAge){
            console.log(p);
        }
    }
}

FilterByAge(['12','Ivan','15','Asen','9']);
