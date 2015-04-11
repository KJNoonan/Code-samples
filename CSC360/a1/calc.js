/*****************************************************
 * Kevin Noonan
 * A Measurement application that will convert length measurements
 * 4/11/2015
 *****************************************************/
var reset = function(){
  var iUnits, cUnits;
  document.getElementById("result").innerHTML = "";
  document.getElementById("number").value = "";
  document.getElementById("units").selectedIndex = 0;
  document.getElementById("cUnits").selectedIndex = 1;

}
var calcFunct = function(){
   var initNumber, initUnits, cUnits, cNumber, output;
  iNumber = document.getElementById("number").value;
  iUnits = document.getElementById("units").value;
  cUnits = document.getElementById("cUnits").value;
  iNumber = Number(iNumber);
  if(iUnits === "in"){
    if(cUnits === "ft"){
      cNumber = iNumber*(1/12);
    }else if(cUnits === "cm"){
      cNumber = iNumber*2.54;
    }else if(cUnits === "ms"){
      cNumber = iNumber*0.0254;
    }else if(cUnits === "in"){
      cNumber = iNumber;
    }
  }else if(iUnits === "ft"){
    if(cUnits === "ft"){
      cNumber = iNumber;
    }else if(cUnits === "cm"){
      cNumber = iNumber * 30.48;
    }else if(cUnits === "ms"){
      cNumber = iNumber * 0.3048;
    }else if(cUnits === "in"){
      cNumber = iNumber * 12;
    }
  }else if(iUnits === "cm"){
    if(cUnits === "ft"){
      cNumber = iNumber * 0.0328084;
    }else if(cUnits === "cm"){
      cNumber = iNumber;
    }else if(cUnits === "ms"){
      cNumber = iNumber * 0.01;
    }else if(cUnits === "in"){
      cNumber = iNumber * 0.393701;
    }
  }else if(iUnits === "ms"){
    if(cUnits === "ft"){
      cNumber = iNumber * 3.28084;
    }else if(cUnits === "cm"){
      cNumber = iNumber * 100;
    }else if(cUnits === "ms"){
      cNumber = iNumber;
    }else if(cUnits === "in"){
      cNumber = iNumber * 39.3701;
    }
  }
 if(isNaN(cNumber)){
    document.getElementById("result").innerHTML = "Number field must contain valid numbers";
 }else{
    output = "Converted Measurement: " + Math.round(cNumber * 100)/100 + " " + backToUnitNames(cUnits);
    document.getElementById("result").innerHTML = output;  
  }
}

function backToUnitNames(val){
  var i = 0;
  for(; i < units.length; i+=1){
    if(val === units[i].value){
      return units[i].text;
    }
  }
  return "WHATS?";
}

var units = [
	    {text:"inches", value:"in"}, 
	    {text:"feet", value:"ft"}, 
	    {text:"centimeters", value:"cm"}, 
	    {text:"meters", value:"ms"}
	    ];

window.onload = function(){
  
  var initSelect =  document.getElementById("units");
  var convSelect =  document.getElementById("cUnits");
  var i = 0;

  var opt1, opt2;

  for (; i<units.length; i +=1){
    opt1 = document.createElement('option');
    opt1.setAttribute('value', units[i].value);
    opt1.appendChild(document.createTextNode(units[i].text));
    opt2 = document.createElement('option');
    opt2.setAttribute('value', units[i].value);
    opt2.appendChild(document.createTextNode(units[i].text));
    initSelect.appendChild(opt1);
    convSelect.appendChild(opt2);
  }
  initSelect.selectedIndex = 0;
  convSelect.selectedIndex = 1;
  document.getElementById("calc").onclick = calcFunct;
  document.getElementById("reset").onclick = reset;
  document.getElementById("number").onkeypress = isNumbers(event);
}