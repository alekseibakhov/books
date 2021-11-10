const url = new URL(window.location);
let bookIndex = url.searchParams.get('book_index');
let books = !localStorage.task ? [] : JSON.parse(localStorage.getItem('task')); // если в браузере уже есть массив, то используем его
const getBook = document.querySelector('.book_base');
console.log(url);
getBook.innerHTML = ` 
        
<div class="card" style="width: 18rem; flex-direction: row">
    <img src="img/library.jpg" class="card-img-top" style="" alt="книга">
    <div class="card-body" >
        <h5 class="card-title" style="width: 400px">${books[bookIndex].name}</h5>
        <ul class="card-text">
            <li>${books[bookIndex].author}</li>
            <li>${books[bookIndex].date}</li>
            <li>${books[bookIndex].genre}</li>
            <li>${books[bookIndex].numOfPages}</li>
        </ul>
        <a href="/books/library.html" class="btn btn-primary" style="margin-top: 150px">назад</a>

    </div>
</div>
`

