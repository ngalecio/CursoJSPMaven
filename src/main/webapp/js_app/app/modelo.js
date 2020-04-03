/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function encodeImagetoBase64(element) {

	  var file = element.files[0];

	  var reader = new FileReader();

	  reader.onloadend = function() {
          
          var b64 = reader.result.replace(/^data:.+;base64,/, '');
          
	    //$(".link").attr("href",b64);

	    //$(".link").text(b64);
        $('#textobase64').val(b64);
        $('#my_image').attr('src','data:image/gif;base64,'+b64);
	  }

	  reader.readAsDataURL(file);

	}

$(document).ready(function () {
      $('#btnFileBase64').click(function () {
                  //$('#my_image').attr('src','../../fotos/foto1.jpg');
                  var string1 = $("#textobase64").val();
                  $('#my_image').attr('src','data:image/gif;base64,'+string1);
                  
                  alert('asas');
          $element=$("#id_foto");
          	  var file = $element.files[0];

//	  var reader = new FileReader();
//
//	  reader.onloadend = function() {
//
//	    $(".link").attr("href",reader.result);
//
//	    $(".link").text(reader.result);
//
//
//	  }
//
//	  reader.readAsDataURL(file);
//          alert('hola');
        });
    
    $('#btnSubirFoto').click(function () {
        alert('aaa');
        processAjaxSubirFoto();
    });
    
    
      $('#btnAbrirNCategoria').click(function () {
          
          //alert('sasas');
        $('#txtIdCategoriaER').val("0");
        $('#txtNombreCategoriaER').val("");
        $('.error-validation').fadeOut();
        $('#actionCategoria').val("addCategoria");
        $('#tituloModalManCategoria').html("REGISTRAR CATEGORIA");
        $('#ventanaModalManCategoria').modal('show');
//        
    });
//    

       $('#btnRecorrer').click(function () {
           
           
  $("#id_tabla_categoria tbody tr").each(function (index) {
                var campo1, campo2, campo3;
              var campotexto = "#txtComentario"+$(this).attr("codigoCategoria");
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
           
           
        //alert(  $('#txtNombreCategoriaER').val()+" "+$('#txtIdCategoriaER').val()+" "+$('#actionCategoria').val());   
           //$('#ventanaModalManCategoria').modal('hide');
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
        //alert(  $('#txtNombreCategoriaER').val()+" "+$('#txtIdCategoriaER').val()+" "+$('#actionCategoria').val());   
           //$('#ventanaModalManCategoria').modal('hide');
           processAjaxCategoria();
       });
//    
        $('#FrmCategoria').submit(function () {
            Console.log("por aki");
//        $('#actionCategoria').val("paginarCategoria");
//        $('#nameFormCategoria').val("FrmCategoria");
//        $('#numberPageCategoryia').val("1");
//        $('#modalCargandoCategoria').modal('show');
        //alert('procesar');
        //return false;
    });
    
    addEventosCategoria();
    
});

function processAjaxSubirFoto() {
//    var datosSerializadosCompletos = $('#' + $('#nameFormCategoria').val()).serialize();
//    if ($('#nameFormCategoria').val().toLowerCase() !== "frmcategoria") {
//        datosSerializadosCompletos += "&txtNombreCategoria=" + $('#txtNombreCategoria').val();
//    }
//    datosSerializadosCompletos += "&numberPageCategoria=" + $('#numberPageCategoria').val();
//    datosSerializadosCompletos += "&sizePageCategoria=" + $('#sizePageCategoria').val();
//    
    $nombre_categoria=$('#txtNombreCategoriaER').val();
    $id_categoria=$('#txtIdCategoriaER').val();
    $accion="subirfotoProducto";
    $fotobase64=$('#textobase64').val();
    alert("Par:"+$nombre_categoria+" "+$accion+" "+$id_categoria);
    $.ajax({
        url: '/DemoProduccion/ProductoController',
        type: 'POST',
        data: {accion:$accion,id_producto:$id_categoria,fotobase64:$fotobase64},
        //dataType: 'json',
        success: function (jsonResponse) {

            //alert(jsonResponse.mensaje);
            viewAlertModal('success',jsonResponse.mensaje);
            //location.reload();
        },
        error: function (jsonerror) {
//            $('#modalCargandoCategoria').modal("hide");
//            viewAlert('error', 'Erroe interno en el Servidor');
                viewAlert('error','Hubo un error al procesar');
        }
    });
    return false;
}


function processAjaxCategoria() {
//    var datosSerializadosCompletos = $('#' + $('#nameFormCategoria').val()).serialize();
//    if ($('#nameFormCategoria').val().toLowerCase() !== "frmcategoria") {
//        datosSerializadosCompletos += "&txtNombreCategoria=" + $('#txtNombreCategoria').val();
//    }
//    datosSerializadosCompletos += "&numberPageCategoria=" + $('#numberPageCategoria').val();
//    datosSerializadosCompletos += "&sizePageCategoria=" + $('#sizePageCategoria').val();
//    
    $nombre_categoria=$('#txtNombreCategoriaER').val();
    $id_categoria=$('#txtIdCategoriaER').val();
    $accion=$('#actionCategoria').val();
    //alert("Par:"+$nombre_categoria+" "+$accion+" "+$id_categoria);
    $.ajax({
        url: '/DemoProduccion/CategoriaController',
        type: 'POST',
        data: {accion:$accion,id_categoria:$id_categoria,nombre_categoria:$nombre_categoria},
        //dataType: 'json',
        success: function (jsonResponse) {
//            $('#modalCargandoCategoria').modal("hide");
//            if ($('#actionCategoria').val().toLowerCase() === "paginarcategoria") {
//                listarCategoria(jsonResponse.BEAN_PAGINATION);
//            } else {
//                if (jsonResponse.MESSAGE_SERVER.toLowerCase() === "ok") {
//                    viewAlert('success', getMessageServerTransaction($('#actionCategoria').val(), 'Categoria', 'a'));
//                    listarCategoria(jsonResponse.BEAN_PAGINATION);
//                } else {
//                    viewAlert('warning', jsonResponse.MESSAGE_SERVER);
//                }
//            }
            $("#ventanaModalManCategoria").modal("hide");
            //alert(jsonResponse.mensaje);
            viewAlertModal('success',jsonResponse.mensaje);
            //location.reload();
        },
        error: function (jsonerror) {
//            $('#modalCargandoCategoria').modal("hide");
            $("#ventanaModalManCategoria").modal("hide");
//            viewAlert('error', 'Erroe interno en el Servidor');
                viewAlert('error','Hubo un error al procesar');
        }
    });
    return false;
}


function addEventosCategoria() {
    $('.editar-Categoria').each(function () {
        $(this).click(function () {
            
            $celda=$(this.parentElement.parentElement);
            
            $celda.each(function (index) {
                var campo1, campo2, campo3;
              var campotexto = "#txtComentario"+$(this).attr("codigoCategoria");
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
      //      alert($celda);
            $('#txtIdCategoriaER').val($(this.parentElement.parentElement).attr('codigocategoria'));
            $('#txtNombreCategoriaER').val($(this.parentElement.parentElement).attr('nombreCategoria'));
            $('#actionCategoria').val("updateCategoria");
            $('#tituloModalManCategoria').html("EDITAR CATEGORIA");
            $('#ventanaModalManCategoria').modal("show");
            document.getElementsByTagName("body")[0].style.paddingRight = "0";
        });
    });
    $('.eliminar-Categoria').each(function () {
        $(this).click(function () {
            $('#txtIdCategoriaER').val($(this.parentElement.parentElement).attr('idcategoria'));
            viewAlertDelete("Categoria");
            document.getElementsByTagName("body")[0].style.paddingRight = "0";
        });
    });
}