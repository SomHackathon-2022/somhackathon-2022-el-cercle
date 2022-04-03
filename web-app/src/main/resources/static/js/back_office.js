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

function add_strawberries() {
    let quantitat = document.getElementById("strawberries_quantity").value;
    let url = 'http://localhost:8080/strawberries/' + quantitat;
    $.ajax({
        url: url,
        type: 'POST',
        success: function(result) {alert("S'ha afegit la quantitat de maduixes correctament.")}
    });
}

function add_potatoes() {
    let quantitat = document.getElementById("potatoes_quantity").value;
    let url = 'http://localhost:8080/potatoes/' + quantitat;
    $.ajax({
        url: url,
        type: 'POST',
        success: function(result) {alert("S'ha afegit la quantitat de patates correctament.")}
    });
}

function add_oranges() {
    let quantitat = document.getElementById("oranges_quantity").value;
    let url = 'http://localhost:8080/oranges/' + quantitat;
    $.ajax({
        url: url,
        type: 'POST',
        success: function(result) {alert("S'ha afegit la quantitat de taronges correctament.")}
    });
}

function add_lettuces() {
    let quantitat = document.getElementById("lettuces_quantity").value;
    let url = 'http://localhost:8080/lettuces/' + quantitat;
    $.ajax({
        url: url,
        type: 'POST',
        success: function(result) {alert("S'ha afegit la quantitat d'enciams correctament.")}
    });
}