// function postFetch() {
//     const url = "http://localhost:8080/saveservlet";
//
//     function sendRequest(method, url, body = null) {
//         return fetch(url, {
//             method: method,
//             body: JSON.stringify(body),
//             headers: {
//                 "Content-type": "application/json"
//             }
//         }).then(response => {
//             return response.json()
//         })
//     }
//
//     let body = {
//         id: 1,
//         name: "Alex",
//         author: "asd",
//         date: 144,
//         genre: "triller"
//     }
//     sendRequest("POST", url, body).then(data => console.log(data));
// }
// function postXML(){
//     window.addEventListener("DOMContentLoaded", () => {
//
//         function req(e) {
//             e.preventDefault(); // отменяет стандартное поведение браузера (перезагрузка страницы)
//             let body = {
//                 name:"asd",
//                 author: "asfa",
//                 date:123,
//                 genre:"asaf",
//                 // id:Math.random()
//             }
//             let json = JSON.stringify(body);
//
//
//             //             СТАРЫЙ СПОСОБ, работает
//             let request = new XMLHttpRequest();
//             request.open("POST", "http://localhost:8080/saveservlet");
//             request.setRequestHeader("Content-type", "application/json; charset=utf-8");
//             request.send(json);
//             request.addEventListener("load", function () {  // load не позволяет отслеживать стадии /
//                 // readystatechange отслеживаем стадии обработки
//                 //  страницы (открыта, загружается, загружена)
//                 if (request.readyState === 4 && request.status === 200) {
//                     let data = JSON.parse(request.response);
//                     console.log(data);
//                     // createDiv(data);
//                 } else console.error("ups");
//             })
//         }
//
//         function createDiv(elem) {
//             elem.forEach(item => {
//                 let card = document.createElement(`div`);
//
//                 // card.classList.add(`card`); // стилизация
//
//                 card.innerHTML = `
//                     <div>${item.name}${item.author}</div>
//                     <div>${item.genre}${item.date}</div>
//                     `;
//                 // выбираем класс, куда вставляем       //добавляем в конец
//                 document.querySelector('.app').appendChild(card);
//             })
//         }
//
//         document.querySelector(".btn").addEventListener("click", (e) => req(e));
//
//     })
// }
// function getXML() {
//     window.addEventListener("DOMContentLoaded", () => {
//
//         function req(e) {
//             e.preventDefault(); // отменяет стандартное поведение браузера (перезагрузка страницы)
//
//             //             СТАРЫЙ СПОСОБ, работает
//             let request = new XMLHttpRequest();
//             request.open("GET", "http://localhost:8080/saveservlet");
//             request.setRequestHeader("Content-type", "application/json; charset=utf-8");
//             request.send();
//             request.addEventListener("load", function () {  // load не позволяет отслеживать стадии /
//                 // readystatechange отслеживаем стадии обработки
//                 //  страницы (открыта, загружается, загружена)
//                 if (request.readyState === 4 && request.status === 200) {
//                     let data = JSON.parse(request.response);
//                     createDiv(data);
//                 } else console.error("не так");
//             })
//
//             function createDiv(elem) {
//                 elem.forEach(item => {
//                     let card = document.createElement(`div`);
//
//                     // card.classList.add(`card`); // стилизация
//
//                     card.innerHTML = `
//                     <div>${item.name}${item.author}</div>
//                     <div>${item.genre}${item.date}</div>
//                     `;
//                     // выбираем класс, куда вставляем       //добавляем в конец
//                     document.querySelector('.app').appendChild(card);
//                 })
//             }
//
//
//             document.querySelector(".btn").addEventListener("click", (e) => req(e));
//         }
//     })
// }
//
// function getFetch() {
//     window.addEventListener("DOMContentLoaded", () => {
//
//         function req(e) {
//             e.preventDefault(); // отменяет стандартное поведение браузера (перезагрузка страницы)
//
//             fetch("http://localhost:8080/saveservlet")
//                 .then(data => data.json())
//                 .then(data => createDiv(data));
//         }
//
//         function createDiv(elem) {
//             elem.forEach(item => {
//                 let card = document.createElement(`div`);
//
//                 // card.classList.add(`card`); // стилизация
//
//                 card.innerHTML = `
//                     <div>${item.name}${item.author}</div>
//                     <div>${item.genre}${item.date}</div>
//                     `;
//                 // выбираем класс, куда вставляем       //добавляем в конец
//                 document.querySelector('.app').appendChild(card);
//             })
//         }
//
//         document.querySelector(".btn").addEventListener("click", (e) => req(e));
//
//     })
//
// }
//
