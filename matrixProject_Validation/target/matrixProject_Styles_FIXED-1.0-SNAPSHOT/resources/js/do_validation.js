/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */

function validateText(inputText)
   {
      var htmlInputText = document.getElementById(inputText);
      var text = htmlInputText.value;
       
      var regex = /[^0-9]/;
      
      if(text.search(regex) != -1)
      {
          newText = text.replace(regex, "");
          htmlInputText.value = newText;
          alert('Please input numeric characters only');
          
      }      
   }
   
   function validateInput(inputText)
   {
       var htmlInputText = document.getElementById(inputText);
       
       var strPart1 = "submitFormId:j_idt9:";
       var strPart2 = ":j_idt11:";
       var strPart3 = ":cellInput";

       var numOfRows = parseInt(document.getElementById("submitFormId:rowInput").value);
       var numOfCols = parseInt(document.getElementById("submitFormId:columnInput").value);

       for(var i = 0; i < numOfRows; i++) 
       {
           for(var j = 0; j < numOfCols; j++) 
           {
               var htmlInput = document.getElementById(strPart1 + i + strPart2 + j + strPart3);
               var text = htmlInput.value;
               var regex = /^[^0-9]/;

               if (text.search(regex) != -1)
               {
                   newText = text.replace(regex, "");
                   htmlInput.value = newText;
                   alert("Numbers only please!");
               }
           }
       }             
   }
   
   function validateSize(inputText)
   {
      var htmlInputText = document.getElementById(inputText);
      var text = htmlInputText.value;
       
      var regex = /([1-9]|[1-9][0-9]|[1-9][0-9][0-9])/;
      
      if(text.search(regex) == -1)
      {
          newText = text.replace(0, "1");
          htmlInputText.value = newText;
          alert('Size cannot be less than 1 x 1');
          
      }
      
   }
   
   
   
   

