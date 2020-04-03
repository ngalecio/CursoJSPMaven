/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function () {
    
    
      $('#btnAbrirNPresentacion').click(function () {
          
          //alert('sasas');
        $('#txtIdPresentacionER').val("0");
        $('#txtNombrePresentacionER').val("");
        $('.error-validation').fadeOut();
        $('#actionPresentacion').val("addPresentacion");
        $('#tituloModalManPresentacion').html("REGISTRAR PRESENTACION");
        $('#ventanaModalManPresentacion').modal('show');
//        
    });
//    

       $('#btnRecorrer').click(function () {
           
           
  $("#id_tabla_presentacion tbody tr").each(function (index) {
                var campo1, campo2, campo3;
              var campotexto = "#txtComentario"+$(this).attr("codigoPresentacion");
                alert($(campotexto).val() );
                $(this).children("td").each(function (index2) {
                    switch (index2) {
                        case 0:
                            campo1 = $(this).text();
                            break;
                        case 1:
                            campo2 = $(this).text();
                            break;
                        case 2:
                            campo3 = $(this).text();
                            break;
                    }
                $(this).css("background-color", "red");
                
                });
            alert(campo1 + ' - ' + campo2 + ' - ' + campo3);
   });
           
           
        //alert(  $('#txtNombrePresentacionER').val()+" "+$('#txtIdPresentacionER').val()+" "+$('#actionPresentacion').val());   
           //$('#ventanaModalManPresentacion').modal('hide');
//           var test = document.querySelectorAll('input[value][type="text"]:not([value=""])');
//           for(var b in test){
//                alert('sss'+b.value);
//}
var test = document.querySelectorAll('input[id^="txtComen"][type=text]');
alert(test);
for (var i = 0; i < test.length; i++) {
    //alert(test[i].value+' '+test[i].id+' ' +test[i].getAttribute('comentario')+" "+test[i].getAttribute('codigo'));
}


    
           //alert(test);
       });
       $('#btnGrabarModal').click(function () {
        //alert(  $('#txtNombrePresentacionER').val()+" "+$('#txtIdPresentacionER').val()+" "+$('#actionPresentacion').val());   
           //$('#ventanaModalManPresentacion').modal('hide');
           processAjaxPresentacion();
       });
//    
        $('#FrmPresentacion').submit(function () {
            Console.log("por aki");
//        $('#actionPresentacion').val("paginarPresentacion");
//        $('#nameFormPresentacion').val("FrmPresentacion");
//        $('#numberPageCategoryia').val("1");
//        $('#modalCargandoPresentacion').modal('show');
        //alert('procesar');
        //return false;
    });
    
    addEventosPresentacion();
    
});


function processAjaxPresentacion() {
//    var datosSerializadosCompletos = $('#' + $('#nameFormPresentacion').val()).serialize();
//    if ($('#nameFormPresentacion').val().toLowerCase() !== "frmpresentacion") {
//        datosSerializadosCompletos += "&txtNombrePresentacion=" + $('#txtNombrePresentacion').val();
//    }
//    datosSerializadosCompletos += "&numberPagePresentacion=" + $('#numberPagePresentacion').val();
//    datosSerializadosCompletos += "&sizePagePresentacion=" + $('#sizePagePresentacion').val();
//    
    $nombre_presentacion=$('#txtNombrePresentacionER').val();
    $id_presentacion=$('#txtIdPresentacionER').val();
    $accion=$('#actionPresentacion').val();
    alert("Par:"+$nombre_presentacion+" "+$accion+" "+$id_presentacion);
    $.ajax({
        url: '/DemoProduccion/PresentacionController',
        type: 'POST',
        data: {accion:$accion,id_presentacion:$id_presentacion,nombre_presentacion:$nombre_presentacion},
        //dataType: 'json',
        success: function (jsonResponse) {
//            $('#modalCargandoPresentacion').modal("hide");
//            if ($('#actionPresentacion').val().toLowerCase() === "paginarpresentacion") {
//                listarPresentacion(jsonResponse.BEAN_PAGINATION);
//            } else {
//                if (jsonResponse.MESSAGE_SERVER.toLowerCase() === "ok") {
//                    viewAlert('success', getMessageServerTransaction($('#actionPresentacion').val(), 'Presentacion', 'a'));
//                    listarPresentacion(jsonResponse.BEAN_PAGINATION);
//                } else {
//                    viewAlert('warning', jsonResponse.MESSAGE_SERVER);
//                }
//            }
            $("#ventanaModalManPresentacion").modal("hide");
            //alert(jsonResponse.mensaje);
            viewAlertModal('success',jsonResponse.mensaje);
            //location.reload();
        },
        error: function (jsonerror) {
//            $('#modalCargandoPresentacion').modal("hide");
            $("#ventanaModalManPresentacion").modal("hide");
//            viewAlert('error', 'Erroe interno en el Servidor');
                viewAlert('error','Hubo un error al procesar');
        }
    });
    return false;
}


function addEventosPresentacion() {
    $('.editar-Presentacion').each(function () {
        $(this).click(function () {
            
//            $celda=$(this.parentElement.parentElement);
//            
//            $celda.each(function (index) {
//                var campo1, campo2, campo3;
//              var campotexto = "#txtComentario"+$(this).attr("codigoPresentacion");
//                alert($(campotexto).val() );
//                $(this).children("td").each(function (index2) {
//                    switch (index2) {
//                        case 0:
//                            campo1 = $(this).text();
//                            break;
//                        case 1:
//                            campo2 = $(this).text();
//                            break;
//                        case 2:
//                            campo3 = $(this).text();
//                            break;
//                    }
//                $(this).css("background-color", "red");
//                
//                });
//            alert(campo1 + ' - ' + campo2 + ' - ' + campo3);
//   });
      //      alert($celda);
            $('#txtIdPresentacionER').val($(this.parentElement.parentElement).attr('codigopresentacion'));
            $('#txtNombrePresentacionER').val($(this.parentElement.parentElement).attr('nombrePresentacion'));
            $('#actionPresentacion').val("updatePresentacion");
            $('#tituloModalManPresentacion').html("EDITAR PRESENTACION");
            $('#ventanaModalManPresentacion').modal("show");
            document.getElementsByTagName("body")[0].style.paddingRight = "0";
        });
    });
    $('.eliminar-Presentacion').each(function () {
        $(this).click(function () {
            $('#txtIdPresentacionER').val($(this.parentElement.parentElement).attr('idpresentacion'));
            viewAlertDelete("Presentacion");
            document.getElementsByTagName("body")[0].style.paddingRight = "0";
        });
    });
}