$(document).ready(update_values);


function update_values(){
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/organic",
        dataType: "text"
    }).done(function (res) {
        $('#organic_quantity_div').append('<h2>'+res+' kgs'+'<\h2>');
    }).fail(function (jqXHR, textStatus, errorThrown) {
        alert("AJAX call failed: " + textStatus + ", " + errorThrown);
    });

    $.ajax({
        type: "GET",
        url: "http://localhost:8080/strawberries",
        dataType: "text"
    }).done(function (res) {
        $('#strawberries_quantity_div').append('<h3>'+res+' kgs'+'<\h2>');
    }).fail(function (jqXHR, textStatus, errorThrown) {
        alert("AJAX call failed: " + textStatus + ", " + errorThrown);
    });

    $.ajax({
        type: "GET",
        url: "http://localhost:8080/potatoes",
        dataType: "text"
    }).done(function (res) {
        $('#potatoes_quantity_div').append('<h3>'+res+' kgs'+'<\h2>');
    }).fail(function (jqXHR, textStatus, errorThrown) {
        alert("AJAX call failed: " + textStatus + ", " + errorThrown);
    });

    $.ajax({
        type: "GET",
        url: "http://localhost:8080/oranges",
        dataType: "text"
    }).done(function (res) {
        $('#oranges_quantity_div').append('<h3>'+res+' kgs'+'<\h2>');
    }).fail(function (jqXHR, textStatus, errorThrown) {
        alert("AJAX call failed: " + textStatus + ", " + errorThrown);
    });

    $.ajax({
        type: "GET",
        url: "http://localhost:8080/lettuces",
        dataType: "text"
    }).done(function (res) {
        $('#lettuces_quantity_div').append('<h3>'+res+' kgs'+'<\h2>');
    }).fail(function (jqXHR, textStatus, errorThrown) {
        alert("AJAX call failed: " + textStatus + ", " + errorThrown);
    });
}





function add_organic() {
    let quantitat = document.getElementById("organic_quantity").value;
    let url = 'http://localhost:8080/organic/' + quantitat;
    $.ajax({
        url: url,
        type: 'POST',
        success: function(result) {alert("S'ha afegit la quantitat de matèria orgànica correctament.")}
    });
}