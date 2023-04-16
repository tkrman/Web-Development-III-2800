if (!z)
    var z = {}

if (!z.y) 
{
    z.y = 
        {
        showProgress: function (data) 
            {
            var inputId = data.source.id;
           
            var progressbarId = inputId.substring(0, inputId.length - "name".length)
                    + "pole";
             //alert( "id:" + inputId + " " + progressbarId );
            if (data.status == "begin")
                Element.show(progressbarId);
            else if (data.status == "success")
                Element.hide(progressbarId);
            }
        }
        
       
}