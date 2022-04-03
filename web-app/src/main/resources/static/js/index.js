$(document).ready(update_values);

function update_valuesB(){
    alert("Inici");
    $.getJSON('http://localhost:8080/organic', function(data) {
        $('#organic_quantity_div').append
        ('<h2>data[0]<\h2>');
    });

}


function update_values(){
    alert("comemnca");
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/organic",
        dataType: "text"
    }).done(function (res) {
        // Your `success` code
        alert("yupiiiiii");
    }).fail(function (jqXHR, textStatus, errorThrown) {
        alert("AJAX call failed: " + textStatus + ", " + errorThrown);
    });
}


