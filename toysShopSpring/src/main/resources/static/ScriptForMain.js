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
    this.reqButton[2].addEventListener('click', () => {
        this.saveFileOnServer();
        this.testRestApi();
    });
}

RequestNewToy.prototype.reduceWonToys = function() {
    let createQuery = "";
    let count = 0;
    for (let i = 0; i < this.checkBoxes.length; i++) {
        if (this.checkBoxes[i].checked) {
            let quant = parseInt(this.quantityToy[i].innerHTML) - 1;
            if (quant > -1) {
                this.checkedFlag = true;
                count += 1;
                createQuery += "id" + count + "=" + this.idToy[i].innerHTML + "&";
                createQuery += "quantity" + count + "=" + quant + "&";
            }
        }
    }
    createQuery += "length=" + count;
    console.log("no hello world, ", createQuery);
    if (this.checkedFlag) this.makeQuery(createQuery);
}

RequestNewToy.prototype.makeQuery = function(query) {
    let xhr = new XMLHttpRequest();
    xhr.onloadend = function(e) {
        location.href = "http://localhost:8080/main";
    }
    let uri = "http://localhost:8080/main";

    xhr.open("POST", uri, true);
    xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    xhr.send(query);
}

RequestNewToy.prototype.saveFileOnServer = function() {
    let url = new URL("http://localhost:8080/ajaxpost");
    fetch(url, {method: 'POST'})
            .then(response => {
                document.getElementById("noteSavings").innerHTML = "???????????? ??????????????????";
                setTimeout(() => {
                    document.getElementById("noteSavings").innerHTML = "";
                }, 1200);
            });

}

RequestNewToy.prototype.testRestApi = function() {
    let dataString;
    let url = new URL("http://localhost:8080/fetchpost");
    fetch(url, {
            method: 'GET',
            headers: {
                'Content-Type': 'application/json;charset=utf-8'
            }})
            .then(response => response.text())
            .then(data => {
                dataString = data;
//                console.log(dataString);
                let tempLink = document.createElement("a");
                let taBlob = new Blob([dataString], {type: 'text/plain'});
                tempLink.setAttribute('href', URL.createObjectURL(taBlob));
                tempLink.setAttribute('download', `data.txt`);
                tempLink.click();
                URL.revokeObjectURL(tempLink.href);
            });
    
    
    
//    let xhr = new XMLHttpRequest();
//    xhr.onloadend = function(e) {
//        console.log(this.responseText);
//    }
//    let uri = "http://localhost:8080/fetchpost";
//
//    xhr.open("GET", uri, true);
//    xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
//    xhr.send();

//    let tempLink = document.createElement("a");
//    let taBlob = new Blob([dataString], {type: 'text/plain'});
//    tempLink.setAttribute('href', URL.createObjectURL(taBlob));
//    tempLink.setAttribute('download', `data.txt`);
//    tempLink.click();
//    URL.revokeObjectURL(tempLink.href);
}

const buttonNew = new RequestNewToy();

