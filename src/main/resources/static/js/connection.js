function send( data ) {
    var xhr = new XMLHttpRequest();
    var params = 'json=' + JSON.stringify(data);
    xhr.open("POST", '/save?' + params, true);
    alert(xhr.getAsString);
    //xhr.send();
}

function submit() {
    let form = document.forms["form"];
    let fd = new FormData(form);
    let data = {};
    for (let [key, prop] of fd) {
        data[key] = prop;
    }
    data = JSON.stringify(data, null, 2);
    data = data.replace(/\r?\n/g, "");
    data = "json=" + data;

    var xhr = new XMLHttpRequest();
    xhr.open("POST", "/submit");
    xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    xhr.onload = function () {
        // do something to response
        console.log(this.responseText);
    };
    xhr.send(data);

    toPage('/promo.html')
}
function getReport() {
    var password = prompt("Введите пароль");
    validPassword(password);
}
function getAllQuest() {
    var xhr = new XMLHttpRequest();

    xhr.open("GET", "/getAll");
    xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    xhr.onload = function () {
        // do something to response
        var status = this.status;
        if(status==200){
            var res = JSON.parse(this.responseText);
            if (res.length > 0) {
                var br = document.createElement('br');
                for (var i = 0; i < res.length; i++) {
                    var div = document.createElement('div');
                    div.innerHTML = getQuestionnaireRes(res[i]);
                    document.body.appendChild(div);
                }
            }
        }
        else if(status==404)
            console.log("Ресурс не найден")
        else
            console.log(this.statusText)
    };
    xhr.send(null);
}

function getQuestionnaireRes(res) {
    return " <br/>-------------------------------------------------------------"
        + " <br/>Имя                                   : "+res.question1
        + " <br/>Является ли клиентом                  : "+res.question2
        + " <br/>Как долго пользовался услугами        : "+res.question3
        + " <br/>Какими услугами пользовался           : "+res.question4
        + " <br/>Оценка качеству                       : "+res.question5
        + " <br/>Степень довольства                    : "+res.question6
        + " <br/>Устраивает ли цена                    : "+res.question7
        + " <br/>Почему перестал пользоваться услугами : "+res.question8
        + " <br/>Обратится ли в будущем                : "+res.question9
        + " <br/>Из каких источников узнал о БАСИ Плюс : "+res.question10
        + " <br/>Сколько готов тратить                 : "+res.question11
        + " <br/>Как долго готов ожидать               : "+res.question12
        + " <br/>Позиции или трафик                    : "+res.question13
        + " <br/>Что понравилось в работе              : "+res.question14
        + " <br/>Что не понравилось                    : "+res.question15
        + " <br/>Пожелания                             : "+res.question16
        + " <br/>-------------------------------------------------------------\n\n"

}

function validPassword(password) {
    var xhr = new XMLHttpRequest();

    xhr.open("POST", "/password");
    xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    xhr.onload = function () {
        var status = this.status;
        if(status==200){
            if (this.responseText == "true"){
                toPage("/result.html");
            }
            else alert("Неверный пароль!");
        }
        else if(status==404)
            console.log("Ресурс не найден")
        else
            console.log(this.statusText)
    };
    xhr.send("password="+password);
}