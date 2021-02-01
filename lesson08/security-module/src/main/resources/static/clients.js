
var stomp = null;

// подключаемся к серверу по окончании загрузки страницы
window.onload = function() {
    connect();
};

function connect() {
    var socket = new SockJS('/socket');
    stomp = Stomp.over(socket);
    stomp.connect({}, function (frame) {
        console.log('Connected: ' + frame);
        stomp.subscribe('/topic/clients-list', function (product) {
            renderItem(product);
        });
    });
}

// хук на интерфейс
$(function () {
    $("form").on('submit', function (e) {
        e.preventDefault();
    });
    $( "#send" ).click(function() { sendContent(); });
});

// отправка сообщения на сервер
function sendContent() {
    stomp.send("/clients-list", {}, JSON.stringify({
        'id' : $("#id").val(),
        'name': $("#name").val(),
        'passport': $("#passport").val()
    }));
}

// рендер сообщения, полученного от сервера
function renderItem(clientJson) {
    var client = JSON.parse(clientJson.body);
    $("#table").append("<tr>" +
        "<td>" +client.id +"</td>" +
        "<td>" +client.name +"</td>" +
        "<td>" +client.passport +"</td>" +
        // "<td><a href='/clients-list/" + product.id +"/bucket'>Add to bucket</a></td>" +
        "</tr>");
}
