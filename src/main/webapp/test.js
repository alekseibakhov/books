window.addEventListener("DOMContentLoaded", () => {
    // const addBtn = document.getElementById("btn")
    const descript = document.querySelector('.scrollspy-example')
    //добавление на страницу
    const url = "http://localhost:8080/saveservlet";
    const btn = document.getElementById("add-task");
    const title = document.getElementById("description-name");
    const author = document.getElementById("description-author");
    const date = document.getElementById("description-date");
    const genre = document.getElementById("description-genre");
    const numOfPages = document.getElementById("description-numberOfPages")

//функция добавления элементов из servlet
    req();

    function req() {
        // e.preventDefault(); // отменяет стандартное поведение браузера (перезагрузка страницы)

        fetch("http://localhost:8080/saveservlet")
            .then(data => data.json())
            .then(data => createDiv(data)).then(upgrade);


    }
    function upgrade() {
        title.value = "";
        author.value = "";
        date.value = "";
        genre.value = "";
        numOfPages.value = "";
    }

//метод добавления элементов
    function createDiv(elem) {
        descript.innerHTML = "";
        elem.forEach(item => {

            let card = document.createElement(`div`);

            descript.innerHTML += `

        <ul class="list-group list-group-horizontal">
            <li class="list-group-item">${item.id}</li>
            <li class="list-group-item">${item.title}</li>
            <li class="list-group-item">${item.author}</li>
            <li class="list-group-item">${item.author}</li>
            <li class="list-group-item">${item.date}</li>
            <li class="list-group-item">${item.genre}</li>
            <li class="list-group-item">${item.numOfPages}</li>

        </ul>

                    
                    `;
            //добавляем в конец
            descript.appendChild(card);
        })
    }

    function sendRequest(method, url, body = null) {

        return fetch(url, {
            method: method,
            body: JSON.stringify(body),
            headers: {
                "Content-type": "application/json"
            }
        }).then(response => {
            return response.json()
        })
    }

    function createBody() {
        return body = {
            title: title.value,
            author: author.value,
            date: date.value,
            genre: genre.value,
            numOfPages: numOfPages.value
        }
    }



    btn.addEventListener("click", () => {

        sendRequest("POST", url, createBody());
        req();
    });


})