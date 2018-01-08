

$('#senha').keyup(function () {
    var getSenha = document.getElementById('senha');

    var json = {senha: getSenha.value}
    $.ajax({
       type: 'POST',
       url: '/senha',
       data:  JSON.stringify(json),
        success: function (data) {
            console.log(data);
            $('#score').text(data.score + "%");
            $('#level').text(data.level);
            alterarClass(data.score);
        },
        error: function () {
          console.log('erro no retorno');
        },
        contentType: "application/json",
        dataType: 'json'
    });
});

function alterarClass(score) {
    if(score >= 0 && score <= 20){
        removeClass();
        $("#score").addClass('semaforo1');
        $("#level").addClass('semaforo1');
    }else if(score > 20 && score <= 40){
        removeClass();
        $("#score").addClass('semaforo2');
        $("#level").addClass('semaforo2');
    }else if(score > 40 && score <= 60){
        removeClass();
        $("#score").addClass('semaforo3');
        $("#level").addClass('semaforo3');
    }else if(score > 60 && score <= 80){
        removeClass();
        $("#score").addClass('semaforo4');
        $("#level").addClass('semaforo4');
    }else if(score > 80 && score <= 100){
        removeClass();
        $("#score").addClass('semaforo5');
        $("#level").addClass('semaforo5');
    }
}

function removeClass() {
    $("#score").removeClass('semaforo1');
    $("#level").removeClass('semaforo1');
    $("#score").removeClass('semaforo2');
    $("#level").removeClass('semaforo3');
    $("#score").removeClass('semaforo3');
    $("#level").removeClass('semaforo4');
    $("#score").removeClass('semaforo4');
    $("#level").removeClass('semaforo5');
    $("#score").removeClass('semaforo5');
}