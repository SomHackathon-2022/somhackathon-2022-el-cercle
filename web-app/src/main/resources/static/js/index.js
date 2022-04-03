$(document).ready(update_values);


function update_values(){
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/organic",
        dataType: "text"
    }).done(function (res) {
        $('#organic_quantity_div').append('<h2>'+res+'<\h2>');
    }).fail(function (jqXHR, textStatus, errorThrown) {
        alert("AJAX call failed: " + textStatus + ", " + errorThrown);
    });
}


