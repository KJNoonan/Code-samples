// Demo code for the Archaeology game
//
// Loaded by game.html
// Uses GameBoard object defined in board.js
//

// Warning! The function tryDig and the variable board are global variables!

$(function () {
    
  board = new GameBoard();
  board.setBoard();
 
  var siteList = $('#siteList');
  $.each(board.ruins, function(index, value){
    siteList.append(value.name+"&nbsp;");
    //+Array(value.size+1).join("<span id="+value.name+">&#8962;</span>")+'<br>');
    for(i=0; i<value.size; i++){
      siteList.append("<span id="+value.name+i+">&#8962;&nbsp;</span>");  
    }
    siteList.append("<br>");
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

  $('#digBtn').onclick() = function(){tryDig()};
});

function tryDig(){
  var targetCell = $('#rowSelection').val()+ $('#colSelection').val();
  var targetObj = board.dig(targetCell);

  if(targetObj){
    alert('Success finding the ' + targetObj.name);
      $("#cell"+targetCell).html('=');
      $("#cell"+targetCell).css('color', 'red');
  }
  else {
      alert('Failure!');
      $("#cell"+targetCell).html('O').css('color', 'green');
    }
}