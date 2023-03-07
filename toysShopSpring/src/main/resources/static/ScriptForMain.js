function RequestNewToy() {
    this.reqButton = document.querySelectorAll('.new_note');
    this.checkBoxes = document.querySelectorAll('.checkBox');
    this.idToy = document.querySelectorAll('.notion_ID');
    this.quantityToy = document.querySelectorAll('.notion_q');
    this.checkedFlag = false;
    this.initSettings();
}

RequestNewToy.prototype.initSettings = function() {
    console.log("hello world, ", window.location.pathname);
    this.reqButton[0].addEventListener('click', () => {
        location.href = "http://localhost:8080/new";
    });
    this.reqButton[1].addEventListener('click', () => {
        this.reduceWonToys();
    });
}

RequestNewToy.prototype.reduceWonToys = function() {
    let createQuery = "";
    let count = 0;
    for (let i = 0; i < this.checkBoxes.length; i++) {
        if (this.checkBoxes[i].checked) {
            this.checkedFlag = true;
            count += 1;
            createQuery += "id" + count + "=" + this.idToy[i].innerHTML + "&";
            let quant = parseInt(this.quantityToy[i].innerHTML) - 1;
            createQuery += "quantity" + count + "=" + quant + "&";
        }
    }
    createQuery += "length=" + count;
    console.log("no hello world, ", createQuery);
    this.makeQuery(createQuery);
}

RequestNewToy.prototype.makeQuery = function(query) {
    let xhr = new XMLHttpRequest();
    xhr.onloadend = function(e) {
        console.log("hello ajax, ");
        location.href = "http://localhost:8080/main";
    }
    let uri = "http://localhost:8080/main";

    xhr.open("POST", uri, true);
    xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    xhr.send(query);
}

const buttonNew = new RequestNewToy();

