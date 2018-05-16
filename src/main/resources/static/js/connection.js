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
