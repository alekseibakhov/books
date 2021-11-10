let user = {
    name: 'Alex',
    surname: 'Bakhov',

    get fullName() {
        return this.name +" "+ this.surname;
    },

    set fullName(value) {
      [this.name, this.surname] = value.split(' ');
    }
}

console.log(user.fullName);
user.fullName = 'Anna Polyakova';
console.log(user.fullName);
