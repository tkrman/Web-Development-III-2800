


function validateText(textInputID)
{
    var htmlInputText = document.getElementById(textInputID);
    var text = htmlInputText.value;

  
    var regex = /[^A-Za-z0-9]/g;

    if (text.search( regex) != -1)
    {
        newText = text.replace(regex, "");
        htmlInputText.value = newText;
        //alert("alphanumeric chars only please");

    }

}


