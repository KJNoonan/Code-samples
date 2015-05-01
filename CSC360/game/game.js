// Demo code for the Archaeology game
//
// Loaded by game.html
// Uses GameBoard object defined in board.js
//

// Warning! The function tryDig and the variable board are global variables!
var success = 0, fail = 0, eRuins = 0;

$(function () {
  board = new GameBoard();
  board.setBoard();
 
  var siteList = $('#siteList');
  siteList.append("<br><b><u>Ruins</u></b><br>");
  $.each(board.ruins, function(index, value){
    siteList.append(value.name+"&nbsp;");
    //+Array(value.size+1).join("<span id="+value.name+">&#8962;</span>")+'<br>');
    for(i=0; i<value.size; i++){
      siteList.append("<span id="+value.name+(i+1)+">&#8962;&nbsp;</span>");  
    }
    siteList.append("<br>");
  });

  var stats = $('#stats');
  stats.append("<hr><b><u>Game Statistics</b></u>");
  stats.append("<br>Total Digs: <span id=\"total\">"+(fail+success)+"</span>");
  stats.append("<br>Successful Digs: <span id=\"pass\">"+success+"</span>");
  stats.append("<br>Excavated Ruins: <span id=\"ruins\">"+eRuins+"</span>");

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
  var button = document.getElementById('digBtn');
  button.addEventListener('click', tryDig, false);

});

function tryDig(){
  var targetCell = $('#rowSelection').val()+ $('#colSelection').val();
  var targetObj = board.dig(targetCell);

  if(targetObj){
      success++;
      $("#"+targetObj.name+targetObj.successes).css('color', 'red')
      $("#cell"+targetCell).html('=');
      $("#cell"+targetCell).css('color', 'red');  
      if(targetObj.successes === targetObj.size){
        eRuins++;
        $('#output').html("<p class=\"success\">Congrats! You Completed the "+targetObj.name+"</p>");
        $("#output").show(1000).delay(3000).hide(750);
      }else{
        $('#output').html("<p class=\"success\">Success! You found a piece of the "+targetObj.name+"</p>");
        $("#output").show(1000).delay(3000).hide(750);
      }
   }
  else {
      fail++;
      $("#cell"+targetCell).html('O').css('color', 'green');
      $('#output').html("<p class=\"fail\">You Found Nothing</p>"); 
      $("#output").show(1000).delay(3000).hide(750);   
    }

    $('#total').html(fail+success);
    $('#pass').html(success);
    $('#ruins').html(eRuins);
    
}

