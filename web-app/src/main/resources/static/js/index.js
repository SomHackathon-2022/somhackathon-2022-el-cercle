var img_array = ['images/img_1_sol.png', 'images/img_2_sol_fertil.png', 'images/img_3_sol_conreat.png', 'images/img_4_restaurant_tancat.png', 'images/img_5_restaurant_obert.png'];
var indexes = [0,0,0,0,     0,0,0,0,    0,0,0,0,    0,0,0,0]

function changeImg(index) {
    var id = "btn" + index;
    document.getElementById(id).src = img_array[indexes[index]];
    indexes[index] ++;
    if (indexes[index] == img_array.length - 1) {
        indexes[index] = -1;

    }
}