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
   
   function validateInput(inputText)
   {
      var htmlInputText = document.getElementById(inputText);
      var text = htmlInputText.value;
       
      var regex = /^[-+]?([0-9][0-9]?|999)$/;
      
      if(text.search(regex) != -1)
      {
          newText = text.replace(regex, "0");
          htmlInputText.value = newText;
          alert('Please input numeric characters only');
          
      }
   }
   
   

