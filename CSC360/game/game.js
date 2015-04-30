// Demo code for the Archaeology game
//
// Loaded by game.html
// Uses GameBoard object defined in board.js
//

// Warning! The function tryDig and the variable board are global variables!

$(function () {
  
  /*tryDig = function(targetCell)
  {
    var targetObj = board.dig(targetCell);
  
    if (targetObj) {
      alert('Success finding the ' + targetObj.name);
      $("#cell"+targetCell).html('=');
      $("#cell"+targetCell).css('color', 'red');
    }
    else {
      alert('Failure!');
      $("#cell"+targetCell).html('O').css('color', 'green');
    }
  }*/
    
    
  board = new GameBoard();
  board.setBoard();
 
  var siteList = $('#siteList');
  $.each(board.ruins, function(index, value){
    siteList.append(value.name+Array(value.size+1).join("&#8962;")+'<br>');

  });

  var colSelect = $('#colSelection');
  for (i = 0; i < board.columns.length; i++) {
    var col = board.columns[i];
    colSelect.append($('<option></option>').val(col).html(col));
  }
  
  var rowSelect = $('#rowSelection');
  for (i = 0; i < board.rows.length; i++) {
    var col = board.rows[i];
    rowSelect.append($('<option></option>').val(col).html(col));
  }

  //tryDig("c4");

});