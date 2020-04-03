/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function () {
    
    
      $('#btnAbrirNMateriaPrima').click(function () {
          
          //alert('sasas');
        $('#txtIdMateriaPrimaER').val("0");
        $('#txtNombreMateriaPrimaER').val("");
        $('#txtDescripcionMateriaPrimaER').val("");
        $('#txtCostoMateriaPrimaER').val("0.00");
        $('#txtFactorMateriaPrimaER').val("0.00");
        $('#txtLoteMateriaPrimaER').val("");
        $('#cboUnidaddeMedida').val("0");
        $('.error-validation').fadeOut();
        $('#actionMateriaPrima').val("addMateriaPrima");
        $('#tituloModalManMateriaPrima').html("REGISTRAR MATERIA PRIMA");
        $('#ventanaModalManMateriaPrima').modal('show');
//        
    });
//    

       $('#btnRecorrer').click(function () {
           
           
  $("#id_tabla_materiaprima tbody tr").each(function (index) {
                var campo1, campo2, campo3;
              var campotexto = "#txtComentario"+$(this).attr("codigoMateriaPrima");
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
           
           
        //alert(  $('#txtNombreMateriaPrimaER').val()+" "+$('#txtIdMateriaPrimaER').val()+" "+$('#actionMateriaPrima').val());   
           //$('#ventanaModalManMateriaPrima').modal('hide');
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
        //alert(  $('#txtNombreMateriaPrimaER').val()+" "+$('#txtIdMateriaPrimaER').val()+" "+$('#actionMateriaPrima').val());   
           //$('#ventanaModalManMateriaPrima').modal('hide');
           processAjaxMateriaPrima();
       });
//    
        $('#FrmMateriaPrima').submit(function () {
            Console.log("por aki");
//        $('#actionMateriaPrima').val("paginarMateriaPrima");
//        $('#nameFormMateriaPrima').val("FrmMateriaPrima");
//        $('#numberPageCategoryia').val("1");
//        $('#modalCargandoMateriaPrima').modal('show');
        //alert('procesar');
        //return false;
    });
    
    addEventosMateriaPrima();
    
});


function processAjaxMateriaPrima() {
//    var datosSerializadosCompletos = $('#' + $('#nameFormMateriaPrima').val()).serialize();
//    if ($('#nameFormMateriaPrima').val().toLowerCase() !== "frmmateriaprima") {
//        datosSerializadosCompletos += "&txtNombreMateriaPrima=" + $('#txtNombreMateriaPrima').val();
//    }
//    datosSerializadosCompletos += "&numberPageMateriaPrima=" + $('#numberPageMateriaPrima').val();
//    datosSerializadosCompletos += "&sizePageMateriaPrima=" + $('#sizePageMateriaPrima').val();
//    
    $nombre_materiaprima=$('#txtNombreMateriaPrimaER').val();
    $id_materiaprima=$('#txtIdMateriaPrimaER').val();
    $accion=$('#actionMateriaPrima').val();
    $descripcion_materiaprima=$('#txtDescripcionMateriaPrimaER').val();
    $lote_materiaprima=$('#txtLoteMateriaPrimaER').val();
    $costo_materiaprima=$('#txtCostoMateriaPrimaER').val();
    $factor_materiaprima=$('#txtFactorMateriaPrimaER').val();
    $codigo_unidaddemedida=$('#cboUnidaddeMedida').val();
var $arreglo = [];
    var a={
        codigo:'1',
        nombre:'nombre'
    };
    $arreglo.push(a);
    var a={
        codigo:'2',
        nombre:'nombre2'
    };
    $arreglo.push(a);
    var cab={
        numero:$id_materiaprima,
        cliente:$nombre_materiaprima
        ,detalle:$arreglo
    }
    //b.append(a);

    //alert(JSON.stringify(cab));
    //alert(JSON.stringify($arreglo));
//    alert(a.serialize());
    //alert("Par:"+$nombre_materiaprima+" "+$accion+" "
     //       +$id_materiaprima+" "+$descripcion_materiaprima+" "+$lote_materiaprima
      //      +" "+$costo_materiaprima+" "+$factor_materiaprima+" "+$codigo_unidaddemedida
      //      );
    $.ajax({
        url: '/DemoProduccion/MateriaPrimaController',
        type: 'POST',
        data: {accion:$accion
                ,id_materiaprima:$id_materiaprima
                ,nombre_materiaprima:$nombre_materiaprima
                ,descripcion_materiaprima:$descripcion_materiaprima
                ,lote_materiaprima:$lote_materiaprima
                ,costo_materiaprima:$costo_materiaprima
                ,factor_materiaprima:$factor_materiaprima
                ,codigo_unidaddemedida:$codigo_unidaddemedida
            },
        //dataType: 'json',
        success: function (jsonResponse) {
//            $('#modalCargandoMateriaPrima').modal("hide");
//            if ($('#actionMateriaPrima').val().toLowerCase() === "paginarmateriaprima") {
//                listarMateriaPrima(jsonResponse.BEAN_PAGINATION);
//            } else {
//                if (jsonResponse.MESSAGE_SERVER.toLowerCase() === "ok") {
//                    viewAlert('success', getMessageServerTransaction($('#actionMateriaPrima').val(), 'MateriaPrima', 'a'));
//                    listarMateriaPrima(jsonResponse.BEAN_PAGINATION);
//                } else {
//                    viewAlert('warning', jsonResponse.MESSAGE_SERVER);
//                }
//            }
            $("#ventanaModalManMateriaPrima").modal("hide");
            //alert(jsonResponse.mensaje);
            viewAlertModal('success',jsonResponse.mensaje);
            //location.reload();
        },
        error: function (jsonerror) {
//            $('#modalCargandoMateriaPrima').modal("hide");
            $("#ventanaModalManMateriaPrima").modal("hide");
//            viewAlert('error', 'Erroe interno en el Servidor');
                viewAlert('error','Hubo un error al procesar');
        }
    });
    return false;
}


function addEventosMateriaPrima() {
    $('.editar-MateriaPrima').each(function () {
        $(this).click(function () {
            
//            $celda=$(this.parentElement.parentElement);
//            
//            $celda.each(function (index) {
//                var campo1, campo2, campo3;
//              var campotexto = "#txtComentario"+$(this).attr("codigoMateriaPrima");
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
            $('#txtIdMateriaPrimaER').val($(this.parentElement.parentElement).attr('codigomateriaprima'));
            $('#txtNombreMateriaPrimaER').val($(this.parentElement.parentElement).attr('nombreMateriaPrima'));
            $('#txtDescripcionMateriaPrimaER').val($(this.parentElement.parentElement).attr('descripcionMateriaPrima'));
            $('#txtLoteMateriaPrimaER').val($(this.parentElement.parentElement).attr('lote'));
            $('#txtCostoMateriaPrimaER').val($(this.parentElement.parentElement).attr('costo'));
            $('#txtFactorMateriaPrimaER').val($(this.parentElement.parentElement).attr('factor'));
            //$('#txtCodigoUnidaddeMedidaER').val($(this.parentElement.parentElement).attr('codigounidaddemedida'));
            $('#cboUnidaddeMedida').val($(this.parentElement.parentElement).attr('codigounidaddemedida'));
            
            $('#actionMateriaPrima').val("updateMateriaPrima");
            $('#tituloModalManMateriaPrima').html("EDITAR MATERIA PRIMA");
            $('#ventanaModalManMateriaPrima').modal("show");
            document.getElementsByTagName("body")[0].style.paddingRight = "0";
        });
    });
    $('.eliminar-MateriaPrima').each(function () {
        $(this).click(function () {
            $('#txtIdMateriaPrimaER').val($(this.parentElement.parentElement).attr('idmateriaprima'));
            viewAlertDelete("MateriaPrima");
            document.getElementsByTagName("body")[0].style.paddingRight = "0";
        });
    });
}