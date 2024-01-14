
    $('document').ready(function(){
    $('#styleCode').on('change',function (){
        $('#measurementid').empty().append('<option value="null">-Select-</option>');
        var styleId=$(this).val();
        var href="http://localhost:8089/style/"+styleId
        $.get(href,function (style,status){
            var styleMeasurement = style.styleMeasurement;
            for(var i=0; i<= styleMeasurement.length-1; i++){
                $('#measurementid').append('<option value=" '+styleMeasurement[i].id+' ">'+styleMeasurement[i].name+'</option>');
            }
        })
    })
})

