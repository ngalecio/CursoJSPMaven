/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function () {
    
    
      $('#btnAbrirNTecnicadeFabricacion').click(function () {
          
          //alert('sasas');
        $('#txtIdTecnicadeFabricacionER').val("0");
        $('#txtNombreTecnicadeFabricacionER').val("");
        $('#txtDescripcionTecnicadeFabricacionER').val("");
        $('#txtCostoTecnicadeFabricacionER').val("0.00");
        $('#txtFactorTecnicadeFabricacionER').val("0.00");
        $('#txttiempoTecnicadeFabricacionER').val("");        
        $('.error-validation').fadeOut();
        $('#actionTecnicadeFabricacion').val("addTecnicadeFabricacion");
        $('#tituloModalManTecnicadeFabricacion').html("REGISTRAR TECNICA DE FABRICACION");
        $('#ventanaModalManTecnicadeFabricacion').modal('show');
//        
    });
//    

       $('#btnRecorrer').click(function () {
           
           
  $("#id_tabla_tecnicadefabricacion tbody tr").each(function (index) {
                var campo1, campo2, campo3;
              var campotexto = "#txtComentario"+$(this).attr("codigoTecnicadeFabricacion");
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
           
           
        //alert(  $('#txtNombreTecnicadeFabricacionER').val()+" "+$('#txtIdTecnicadeFabricacionER').val()+" "+$('#actionTecnicadeFabricacion').val());   
           //$('#ventanaModalManTecnicadeFabricacion').modal('hide');
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
        //alert(  $('#txtNombreTecnicadeFabricacionER').val()+" "+$('#txtIdTecnicadeFabricacionER').val()+" "+$('#actionTecnicadeFabricacion').val());   
           //$('#ventanaModalManTecnicadeFabricacion').modal('hide');
           processAjaxTecnicadeFabricacion();
       });
//    
        $('#FrmTecnicadeFabricacion').submit(function () {
            Console.log("por aki");
//        $('#actionTecnicadeFabricacion').val("paginarTecnicadeFabricacion");
//        $('#nameFormTecnicadeFabricacion').val("FrmTecnicadeFabricacion");
//        $('#numberPageCategoryia').val("1");
//        $('#modalCargandoTecnicadeFabricacion').modal('show');
        //alert('procesar');
        //return false;
    });
    
    addEventosTecnicadeFabricacion();
    
});


function processAjaxTecnicadeFabricacion() {
//    var datosSerializadosCompletos = $('#' + $('#nameFormTecnicadeFabricacion').val()).serialize();
//    if ($('#nameFormTecnicadeFabricacion').val().toLowerCase() !== "frmtecnicadefabricacion") {
//        datosSerializadosCompletos += "&txtNombreTecnicadeFabricacion=" + $('#txtNombreTecnicadeFabricacion').val();
//    }
//    datosSerializadosCompletos += "&numberPageTecnicadeFabricacion=" + $('#numberPageTecnicadeFabricacion').val();
//    datosSerializadosCompletos += "&sizePageTecnicadeFabricacion=" + $('#sizePageTecnicadeFabricacion').val();
//    
    $nombre_tecnicadefabricacion=$('#txtNombreTecnicadeFabricacionER').val();
    $id_tecnicadefabricacion=$('#txtIdTecnicadeFabricacionER').val();
    $accion=$('#actionTecnicadeFabricacion').val();
    $descripcion_tecnicadefabricacion=$('#txtDescripcionTecnicadeFabricacionER').val();
    $tiempo_tecnicadefabricacion=$('#txtTiempoTecnicadeFabricacionER').val();
    $costo_tecnicadefabricacion=$('#txtCostoTecnicadeFabricacionER').val();
    $factor_tecnicadefabricacion=$('#txtFactorTecnicadeFabricacionER').val();
    
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
        numero:$id_tecnicadefabricacion,
        cliente:$nombre_tecnicadefabricacion
        ,detalle:$arreglo
    }
    //b.append(a);

    //alert(JSON.stringify(cab));
    //alert(JSON.stringify($arreglo));
//    alert(a.serialize());
    alert("Par:"+$nombre_tecnicadefabricacion+" "+$accion+" "
            +$id_tecnicadefabricacion+" "+$descripcion_tecnicadefabricacion+" "+$tiempo_tecnicadefabricacion
            +" "+$costo_tecnicadefabricacion+" "+$factor_tecnicadefabricacion+" "
            );
    $.ajax({
        url: '/DemoProduccion/TecnicadeFabricacionController',
        type: 'POST',
        data: {accion:$accion
                ,id_tecnicadefabricacion:$id_tecnicadefabricacion
                ,nombre_tecnicadefabricacion:$nombre_tecnicadefabricacion
                ,descripcion_tecnicadefabricacion:$descripcion_tecnicadefabricacion
                ,tiempo_tecnicadefabricacion:$tiempo_tecnicadefabricacion
                ,costo_tecnicadefabricacion:$costo_tecnicadefabricacion
                ,factor_tecnicadefabricacion:$factor_tecnicadefabricacion                
            },
        //dataType: 'json',
        success: function (jsonResponse) {
//            $('#modalCargandoTecnicadeFabricacion').modal("hide");
//            if ($('#actionTecnicadeFabricacion').val().toLowerCase() === "paginartecnicadefabricacion") {
//                listarTecnicadeFabricacion(jsonResponse.BEAN_PAGINATION);
//            } else {
//                if (jsonResponse.MESSAGE_SERVER.toLowerCase() === "ok") {
//                    viewAlert('success', getMessageServerTransaction($('#actionTecnicadeFabricacion').val(), 'TecnicadeFabricacion', 'a'));
//                    listarTecnicadeFabricacion(jsonResponse.BEAN_PAGINATION);
//                } else {
//                    viewAlert('warning', jsonResponse.MESSAGE_SERVER);
//                }
//            }
            $("#ventanaModalManTecnicadeFabricacion").modal("hide");
            //alert(jsonResponse.mensaje);
            viewAlertModal('success',jsonResponse.mensaje);
            //location.reload();
        },
        error: function (jsonerror) {
//            $('#modalCargandoTecnicadeFabricacion').modal("hide");
            $("#ventanaModalManTecnicadeFabricacion").modal("hide");
//            viewAlert('error', 'Erroe interno en el Servidor');
                viewAlert('error','Hubo un error al procesar');
        }
    });
    return false;
}


function addEventosTecnicadeFabricacion() {
    $('.editar-TecnicadeFabricacion').each(function () {
        $(this).click(function () {
            
//            $celda=$(this.parentElement.parentElement);
//            
//            $celda.each(function (index) {
//                var campo1, campo2, campo3;
//              var campotexto = "#txtComentario"+$(this).attr("codigoTecnicadeFabricacion");
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
            $('#txtIdTecnicadeFabricacionER').val($(this.parentElement.parentElement).attr('codigotecnicadefabricacion'));
            $('#txtNombreTecnicadeFabricacionER').val($(this.parentElement.parentElement).attr('nombreTecnicadeFabricacion'));
            $('#txtDescripcionTecnicadeFabricacionER').val($(this.parentElement.parentElement).attr('descripcionTecnicadeFabricacion'));
            $('#txtTiempoTecnicadeFabricacionER').val($(this.parentElement.parentElement).attr('tiempo'));
            $('#txtCostoTecnicadeFabricacionER').val($(this.parentElement.parentElement).attr('costo'));
            $('#txtFactorTecnicadeFabricacionER').val($(this.parentElement.parentElement).attr('factor'));
            //$('#txtCodigoUnidaddeMedidaER').val($(this.parentElement.parentElement).attr('codigounidaddemedida'));
//            $('#cboUnidaddeMedida').val($(this.parentElement.parentElement).attr('codigounidaddemedida'));
            
            $('#actionTecnicadeFabricacion').val("updateTecnicadeFabricacion");
            $('#tituloModalManTecnicadeFabricacion').html("EDITAR TECNICA DE FABRICACION");
            $('#ventanaModalManTecnicadeFabricacion').modal("show");
            document.getElementsByTagName("body")[0].style.paddingRight = "0";
        });
    });
    $('.eliminar-TecnicadeFabricacion').each(function () {
        $(this).click(function () {
            $('#txtIdTecnicadeFabricacionER').val($(this.parentElement.parentElement).attr('idtecnicadefabricacion'));
            viewAlertDelete("TecnicadeFabricacion");
            document.getElementsByTagName("body")[0].style.paddingRight = "0";
        });
    });
}