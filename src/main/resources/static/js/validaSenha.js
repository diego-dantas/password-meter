

$('#senha').keyup(function () {
    var getSenha = document.getElementById('senha');

    var json = {senha: getSenha.value}
    $.ajax({
       type: 'POST',
       url: '/senha',
       data:  JSON.stringify(json),
        success: function (data) {
            console.log(data);
            $('#score').text(data.score);
            $('#level').text(data.level);
        },
        error: function () {
          console.log('erro no retorno');
        },
        contentType: "application/json",
        dataType: 'json'
    });
});

