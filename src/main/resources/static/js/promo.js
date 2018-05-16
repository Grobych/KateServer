function getPromo() {
    var xhr = new XMLHttpRequest();
    xhr.open("GET", "/promo");
    xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    xhr.onload = function () {
        // do something to response
        console.log(this.responseText);

        var status = this.status;
        if(status==200){
            console.log("Текст ответа: " + this.responseText);
            var pr = JSON.parse(this.responseText);
            changePromo(pr.code);
        }
        else if(status==404)
            console.log("Ресурс не найден")
        else
            console.log(this.statusText)
    };
    xhr.send();
}

function changePromo(promo) {
    var promo_div = document.getElementById('promo_div');
    var text_to_change = promo_div.childNodes[0];
    text_to_change.nodeValue = promo;
}