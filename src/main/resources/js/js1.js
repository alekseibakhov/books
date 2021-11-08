const addTskBtn = document.getElementById('add-task');
const inputName = document.getElementById('description-name');
const inputAuthor = document.getElementById('description-author');
const inputDate = document.getElementById('description-date');
const inputGenre = document.getElementById('description-genre');
const inputNumOfPages = document.getElementById('description-numberOfPages');

const descript = document.querySelector('.class');

function Task(name, author, date, genre, numOfPages) { // наша таска
    this.name = name;
    this.author = author;
    this.date = date;
    this.genre = genre;
    this.numOfPages = numOfPages;

}

let tasks; // хранение массива введенных данных

// кнопка добавить
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
        <div class="list-wrapper">
            <div class="name">${task.name}</div>
            <div class="author">${task.author}</div>
            <div class="date">${task.date}</div>
            <div class="genre">${task.genre}</div>
            <div class="numberOfPages">${task.numOfPages}</div>
            <button onclick="deleteTask(${index})" class="delete"> delete</button>
        </div>
        `;
}
const deleteTask = index => {
    tasks.splice(index, 1);
    updateLocal();
    fillHtmllist();
}
fillHtmllist();

