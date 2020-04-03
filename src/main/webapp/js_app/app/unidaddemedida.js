/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function () {
    
    
      $('#btnAbrirNUnidaddeMedida').click(function () {
          
          //alert('sasas');
        $('#txtIdUnidaddeMedidaER').val("0");
        $('#txtNombreUnidaddeMedidaER').val("");
        $('.error-validation').fadeOut();
        $('#actionUnidaddeMedida').val("addUnidaddeMedida");
        $('#tituloModalManUnidaddeMedida').html("REGISTRAR UNIDAD DE MEDIDA");
        $('#ventanaModalManUnidaddeMedida').modal('show');
//        
    });
//    

       $('#btnRecorrer').click(function () {
           
           
  $("#id_tabla_unidaddemedida tbody tr").each(function (index) {
                var campo1, campo2, campo3;
              var campotexto = "#txtComentario"+$(this).attr("codigoUnidaddeMedida");
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
           
           
        //alert(  $('#txtNombreUnidaddeMedidaER').val()+" "+$('#txtIdUnidaddeMedidaER').val()+" "+$('#actionUnidaddeMedida').val());   
           //$('#ventanaModalManUnidaddeMedida').modal('hide');
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
        //alert(  $('#txtNombreUnidaddeMedidaER').val()+" "+$('#txtIdUnidaddeMedidaER').val()+" "+$('#actionUnidaddeMedida').val());   
           //$('#ventanaModalManUnidaddeMedida').modal('hide');
           processAjaxUnidaddeMedida();
       });
//    
        $('#FrmUnidaddeMedida').submit(function () {
            Console.log("por aki");
//        $('#actionUnidaddeMedida').val("paginarUnidaddeMedida");
//        $('#nameFormUnidaddeMedida').val("FrmUnidaddeMedida");
//        $('#numberPageCategoryia').val("1");
//        $('#modalCargandoUnidaddeMedida').modal('show');
        //alert('procesar');
        //return false;
    });
    
    addEventosUnidaddeMedida();
    
});


function processAjaxUnidaddeMedida() {
//    var datosSerializadosCompletos = $('#' + $('#nameFormUnidaddeMedida').val()).serialize();
//    if ($('#nameFormUnidaddeMedida').val().toLowerCase() !== "frmunidaddemedida") {
//        datosSerializadosCompletos += "&txtNombreUnidaddeMedida=" + $('#txtNombreUnidaddeMedida').val();
//    }
//    datosSerializadosCompletos += "&numberPageUnidaddeMedida=" + $('#numberPageUnidaddeMedida').val();
//    datosSerializadosCompletos += "&sizePageUnidaddeMedida=" + $('#sizePageUnidaddeMedida').val();
//    
    $nombre_unidaddemedida=$('#txtNombreUnidaddeMedidaER').val();
    $id_unidaddemedida=$('#txtIdUnidaddeMedidaER').val();
    $accion=$('#actionUnidaddeMedida').val();
    alert("Par:"+$nombre_unidaddemedida+" "+$accion+" "+$id_unidaddemedida);
    $.ajax({
        url: '/DemoProduccion/UnidaddeMedidaController',
        type: 'POST',
        data: {accion:$accion,id_unidaddemedida:$id_unidaddemedida,nombre_unidaddemedida:$nombre_unidaddemedida},
        //dataType: 'json',
        success: function (jsonResponse) {
//            $('#modalCargandoUnidaddeMedida').modal("hide");
//            if ($('#actionUnidaddeMedida').val().toLowerCase() === "paginarunidaddemedida") {
//                listarUnidaddeMedida(jsonResponse.BEAN_PAGINATION);
//            } else {
//                if (jsonResponse.MESSAGE_SERVER.toLowerCase() === "ok") {
//                    viewAlert('success', getMessageServerTransaction($('#actionUnidaddeMedida').val(), 'UnidaddeMedida', 'a'));
//                    listarUnidaddeMedida(jsonResponse.BEAN_PAGINATION);
//                } else {
//                    viewAlert('warning', jsonResponse.MESSAGE_SERVER);
//                }
//            }
            $("#ventanaModalManUnidaddeMedida").modal("hide");
            //alert(jsonResponse.mensaje);
            viewAlertModal('success',jsonResponse.mensaje);
            //location.reload();
        },
        error: function (jsonerror) {
//            $('#modalCargandoUnidaddeMedida').modal("hide");
            $("#ventanaModalManUnidaddeMedida").modal("hide");
//            viewAlert('error', 'Erroe interno en el Servidor');
                viewAlert('error','Hubo un error al procesar');
        }
    });
    return false;
}


function addEventosUnidaddeMedida() {
    $('.editar-UnidaddeMedida').each(function () {
        $(this).click(function () {
            
//            $celda=$(this.parentElement.parentElement);
//            
//            $celda.each(function (index) {
//                var campo1, campo2, campo3;
//              var campotexto = "#txtComentario"+$(this).attr("codigoUnidaddeMedida");
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
            $('#txtIdUnidaddeMedidaER').val($(this.parentElement.parentElement).attr('codigounidaddemedida'));
            $('#txtNombreUnidaddeMedidaER').val($(this.parentElement.parentElement).attr('nombreUnidaddeMedida'));
            $('#actionUnidaddeMedida').val("updateUnidaddeMedida");
            $('#tituloModalManUnidaddeMedida').html("EDITAR UNIDAD DE MEDIDA");
            $('#ventanaModalManUnidaddeMedida').modal("show");
            document.getElementsByTagName("body")[0].style.paddingRight = "0";
        });
    });
    $('.eliminar-UnidaddeMedida').each(function () {
        $(this).click(function () {
            $('#txtIdUnidaddeMedidaER').val($(this.parentElement.parentElement).attr('idunidaddemedida'));
            viewAlertDelete("UnidaddeMedida");
            document.getElementsByTagName("body")[0].style.paddingRight = "0";
        });
    });
}