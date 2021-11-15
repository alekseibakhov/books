const addTskBtn = document.getElementById('add-task');
const inputName = document.getElementById('description-name');
const inputAuthor = document.getElementById('description-author');
const inputDate = document.getElementById('description-date');
const inputGenre = document.getElementById('description-genre');
const inputNumOfPages = document.getElementById('description-numberOfPages');

const descript = document.querySelector('.scrollspy-example');

function Task(name, author, date, genre, numOfPages) { // наша таска
    this.name = name;
    this.author = author;
    this.date = date;
    this.genre = genre;
    this.numOfPages = numOfPages;

}
let tasks; // хранение массива введенных данных
addTskBtn.addEventListener('click', () => {
    tasks.push(new Task(inputName.value, inputAuthor.value, inputDate.value, inputGenre.value, inputNumOfPages.value));
    updateLocal();
    fillHtmllist();
    inputName.value = '';
    inputAuthor.value = '';
    inputDate.value = '';
    inputGenre.value = '';
    inputNumOfPages.value = '';
})
!localStorage.task ? tasks = [] : tasks = JSON.parse(localStorage.getItem('task')); // если в браузере уже есть массив, то используем его
const updateLocal = () => {         //для хранения массива в браузере в application / local storage
    localStorage.setItem('task', JSON.stringify(tasks)); //localStorage глобальная переменная
}
const fillHtmllist = () => {
    descript.innerHTML = ''; // перед отправкой на страницу данных мы очищаем таблицу
    if (tasks.length > 0) {
        tasks.forEach((item, index) => {
                descript.innerHTML += createTempl(item, index);
            }
        )
    }
}
let createTempl = (task, index) => {
    return ` 

        
        <ul class="list-group list-group-horizontal">
            <button style="width: 70px" onclick="get(${index})" type="button" class="btn btn-outline-primary">${index+1}</button>
            <li class="list-group-item">${task.name}</li>
            <li class="list-group-item">${task.author}</li>
            <li class="list-group-item">${task.date}</li>
            <li class="list-group-item">${task.genre}</li>
            <li class="list-group-item">${task.numOfPages}</li>
            <button onclick="deleteTask(${index})" type="button" class="btn btn-outline-primary">delete</button>
        </ul>
        `;
}
let get = index => {
    window.open('book.html?book_index='+index,"_self")
}

const deleteTask = index => {
    tasks.splice(index, 1);
    updateLocal();
    fillHtmllist();
}
fillHtmllist();

