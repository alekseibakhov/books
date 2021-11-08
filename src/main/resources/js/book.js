const url = new URL(window.location);
let bookIndex = url.searchParams.get('book_index');
let books = !localStorage.task ? [] : JSON.parse(localStorage.getItem('task')); // если в браузере уже есть массив, то используем его
const getBook = document.querySelector('.book_base');

getBook.innerHTML = `
        <header class="updown">
                <h1>${books[bookIndex].name}</h1>
        </header>
        <div class="main">
            <div class="leftright"></div>
            <div class="center">
                <img class="image" src="img/library.jpg" alt="библиотека" width="200" height="180"">
                <ul class="list">
                    <li>${books[bookIndex].name}</li>
                    <li>${books[bookIndex].author}</li>
                    <li>${books[bookIndex].date}</li>
                    <li>${books[bookIndex].genre}</li>
                    <li>${books[bookIndex].numOfPages}</li>
                </ul>
    
            </div>
            <div class="leftright"></div>
        </div>
        <footer class="updown">
            <p><a href="library2.html"> Назад </a></p>
        </footer>
`