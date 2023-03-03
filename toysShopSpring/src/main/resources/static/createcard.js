function CreateCard() {
    this.uploadButton = document.getElementById("files");
    this.form = document.getElementById("newNote");
    this.formSubmitButton = document.getElementById("json");
    this.returnToMain = document.getElementById("return");
//    this.id = document.getElementById("idMysql");
    this.initSettings();
}

CreateCard.prototype.initSettings = function() {
    this.uploadButton.addEventListener('change', () => {
        this.testInfo();
    });
    this.formSubmitButton.addEventListener('click', () => {
        this.form.submit();
    });
    this.returnToMain.addEventListener('click', () => {
        location.href = "http://localhost:8080/main";
    });
}

CreateCard.prototype.testInfo = function() {
    let file = this.uploadButton.files[0];
    let filename = this.uploadButton.files[0].name;
    let value = this.uploadButton.value;
    console.log(filename, " ", value);
    let reader = new FileReader();
    // reader.onload = function() {
    //    console.log(reader.result);
    // };
    // reader.readAsText(file);
//    this.form.submit();
    
}

const creatCard = new CreateCard();

