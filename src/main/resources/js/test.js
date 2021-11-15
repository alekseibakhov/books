fetch('https://jsonplaceholder.typicode.com/users')
    .then(response => response.json())
    .then(json => console.log(json));

let promise = await fetch('https://jsonplaceholder.typicode.com/users');
console.log(promise.ok);