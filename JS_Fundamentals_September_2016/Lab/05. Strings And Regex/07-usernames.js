function usernames(input) {

    let usernames = [];
    for (let email of input){

        let split = email.split('@');

        let name = split[0];
        let ext = '';

        let splitExt = split[1].split('.');
        for (let e of splitExt){
            ext += e[0];
        }

        let username = name + '.' + ext;
        usernames.push(username);
    }

    console.log(usernames.join(', '));
}

usernames(['peshoo@gmail.com', 'todor_43@mail.dir.bg', 'foo@bar.com']);