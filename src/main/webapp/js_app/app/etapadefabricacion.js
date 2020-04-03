/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function () {
    $('#btnBuscarTF').click(function()
    {
        buscarAjaxTecnicadeFabricacion();
        //alert('hola');
    });

    $('#btnAgregarTF').click(function()
    {
        //buscarAjaxTecnicadeFabricacion();
        var fila;
        var atributos;
            fila = "<tr ";
            atributos = "";
            atributos += "idcategoria='" + $('#txtCodigoTF').val() + "' ";
            atributos += "nombre='" + $('#txtNombreTF').val() + "' ";
            fila += atributos;
            fila += ">";
            fila += "<td class='align-middle'>" + $('#txtCodigoTF').val() + "</td>";
            fila += "<td class='align-middle'>" + $('#txtNombreTF').val() + "</td>";
            fila += "<td class='align-middle'>" + $('#txtTiempoTF').val() + "</td>";
            //fila += "<td class='text-center align-middle'><button class='btn btn-secondary btn-xs editar-Categoria'><i class='fa fa-edit'></i></button></td>";            
            fila +="<td class='text-center align-middle'><button class='btn btn-warning btn-xs editar-Producto'><i class='fa fa-edit'></i>Editar</button></td>";
            fila += "</tr>";
          //  alert(fila);
            $('#tbodyReceta').append(fila);
        //alert('hola');
    });
    
    $('#btnBuscarProducto').click(function()
    {
        buscarAjaxProduto();
        
    });
    
      $('#btnAbrirNProducto').click(function () {
          
          //alert('sasas');
        $('#txtIdProductoER').val("0");
        $('#txtCodigoProductoER').val("");
        $('#txtNombreProductoER').val("");
        $('#txtDescripcionProductoER').val("");
        $('#txtLoteProductoER').val("");
        $('#cboCategoria').val("0");
        $('#cboPresentacion').val("0");
        $('.error-validation').fadeOut();
        $('#actionProducto').val("addProducto");
        $('#tituloModalManProducto').html("REGISTRAR PRODUCTO");
        $('#ventanaModalManProducto').modal('show');
//        
    });
//    

       $('#btnRecorrer').click(function () {
           
           
  $("#id_tabla_producto tbody tr").each(function (index) {
                var campo1, campo2, campo3;
              var campotexto = "#txtComentario"+$(this).attr("codigoProducto");
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
           
           
        //alert(  $('#txtNombreProductoER').val()+" "+$('#txtIdProductoER').val()+" "+$('#actionProducto').val());   
           //$('#ventanaModalManProducto').modal('hide');
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
        //alert(  $('#txtNombreProductoER').val()+" "+$('#txtIdProductoER').val()+" "+$('#actionProducto').val());   
           //$('#ventanaModalManProducto').modal('hide');
           processAjaxProducto();
       });
//    
        $('#FrmProducto').submit(function () {
            Console.log("por aki");
//        $('#actionProducto').val("paginarProducto");
//        $('#nameFormProducto').val("FrmProducto");
//        $('#numberPageCategoryia').val("1");
//        $('#modalCargandoProducto').modal('show');
        //alert('procesar');
        //return false;
    });
    
    addEventosProducto();
    
});

function buscarAjaxTecnicadeFabricacion()
{
    
                $('#txtNombreTF').val("");
                $('#txtDescripcionTF').val("");
                $('#txtTiempoTF').val("0.00");
                //$('#cboCategoria').val("0");
                //$('#cboPresentacion').val("0");
    $codigo_tecnicadefabricacion=$('#txtCodigoTF').val();
    $accion="consultarTecnicadeFabricacion";
    alert($codigo_tecnicadefabricacion+" "+$accion)
        $.ajax({
        url: '/DemoProduccion/TecnicadeFabricacionController',
        type: 'POST',
        data: {accion:$accion
                ,id_tecnicadefabricacion:$codigo_tecnicadefabricacion                
            },
        //dataType: 'json',
        success: function (jsonResponse) {
//            $('#modalCargandoProducto').modal("hide");
//            if ($('#actionProducto').val().toLowerCase() === "paginarproducto") {
//                listarProducto(jsonResponse.BEAN_PAGINATION);
//            } else {
//                if (jsonResponse.MESSAGE_SERVER.toLowerCase() === "ok") {
//                    viewAlert('success', getMessageServerTransaction($('#actionProducto').val(), 'Producto', 'a'));
//                    listarProducto(jsonResponse.BEAN_PAGINATION);
//                } else {
//                    viewAlert('warning', jsonResponse.MESSAGE_SERVER);
//                }
//            }
            //$("#ventanaModalManProducto").modal("hide");
            //alert(jsonResponse);
            if (jsonResponse.respuestaJson.estado==="ok")
            {
                $('#txtNombreTF').val(jsonResponse.nombre);
                $('#txtDescripcionTF').val(jsonResponse.descripcion);
                
                   
            }
            else
            {
                viewAlert('error',jsonResponse.respuestaJson.mensaje);
            }
            
            //viewAlertModal('success',jsonResponse.mensaje);
            //location.reload();
        },
        error: function (jsonerror) {
//            $('#modalCargandoProducto').modal("hide");
            //$("#ventanaModalManProducto").modal("hide");
//            viewAlert('error', 'Erroe interno en el Servidor');
                viewAlert('error','Hubo un error al procesar');
        }
    });
    return false;
}

function buscarAjaxEtapaDetalle3()
{
//    $('#txtNombreProductoER').val("");
//    $('#txtDescripcionProductoER').val("");
//    $('#txtLoteProductoER').val("");
//    $('#cboCategoria').val("0");
//    $('#cboPresentacion').val("0");
    $codigo_producto = $('#txtCodigoProductoER').val();
    $accion = "listarEtapaDetalle";
    //alert('sasas');
    
}
function buscarAjaxEtapaDetalle()
{
    
//                    $('#txtNombreProductoER').val("");
//                $('#txtDescripcionProductoER').val("");
//                $('#txtLoteProductoER').val("");
//                $('#cboCategoria').val("0");
//                $('#cboPresentacion').val("0");
    $codigo_producto=$('#txtCodigoProductoER').val();
    $accion="listarEtapaDetalle";
    
    alert('xzxxx'+$codigo_producto);
        $.ajax({
        url: '/DemoProduccion/EtapaDetalleController',
        type: 'POST',
        data: {accion:$accion
                ,codigo_producto:$codigo_producto                
            },
        //dataType: 'json',
        success: function (jsonResponse) {
//            $('#modalCargandoProducto').modal("hide");
//            if ($('#actionProducto').val().toLowerCase() === "paginarproducto") {
//                listarProducto(jsonResponse.BEAN_PAGINATION);
//            } else {
//                if (jsonResponse.MESSAGE_SERVER.toLowerCase() === "ok") {
//                    viewAlert('success', getMessageServerTransaction($('#actionProducto').val(), 'Producto', 'a'));
//                    listarProducto(jsonResponse.BEAN_PAGINATION);
//                } else {
//                    viewAlert('warning', jsonResponse.MESSAGE_SERVER);
//                }
//            }
//          
            //$("#ventanaModalManProducto").modal("hide");
            //
            alert(' sas:'+JSON.stringify(jsonResponse));
            //alert(jsonResponse);
        var fila;
        var atributos;
        $('#tbodyEtapa').empty();
        $.each(jsonResponse, function (index, value) {
                fila = "<tr ";
                atributos = "";
                atributos += "codigo_tecnicadefabricacion='" + value.codigo_tecnicadefabricacion + "' ";
                
                fila += atributos;
                fila += ">";
                fila += "<td class='align-middle'>" + value.codigo_tecnicadefabricacion + "</td>";
                fila += "<td class='align-middle'>" + value.descripcion_tecnicadefabricacion + "</td>";
                fila += "<td class='align-middle'>" + value.tiempo + "</td>";
                //fila += "<td class='text-center align-middle'><button class='btn btn-secondary btn-xs editar-Categoria'><i class='fa fa-edit'></i></button></td>";            
                fila += "<td class='text-center align-middle'><button class='btn btn-warning btn-xs editar-Producto'><i class='fa fa-edit'></i>Editar</button></td>";
                fila += "</tr>";
            $('#tbodyReceta').append(fila);
        });
            viewAlert('success','Datos Cargados');
            
//            if (jsonResponse.respuestaJson.estado==="ok")
//            {
//                $('#txtNombreProductoER').val(jsonResponse.nombre);
//                $('#txtDescripcionProductoER').val(jsonResponse.descripcion);
//                $('#txtLoteProductoER').val(jsonResponse.lote);
//                $('#cboCategoria').val(jsonResponse.codigo_categoria);
//                $('#cboPresentacion').val(jsonResponse.codigo_presentacion);
//                
//                   
//            }
//            else
//            {
//                viewAlert('error',jsonResponse.respuestaJson.mensaje);
//            }
            
            //viewAlertModal('success',jsonResponse.mensaje);
            //location.reload();
        },
        error: function (jsonerror) {
//            $('#modalCargandoProducto').modal("hide");
            //$("#ventanaModalManProducto").modal("hide");
//            viewAlert('error', 'Erroe interno en el Servidor');
                viewAlert('error','Hubo un error al procesar');
        }
    });
    return false;
}

function buscarAjaxProduto()
{
    
                    $('#txtNombreProductoER').val("");
                $('#txtDescripcionProductoER').val("");
                $('#txtLoteProductoER').val("");
                $('#cboCategoria').val("0");
                $('#cboPresentacion').val("0");
    $codigo_producto=$('#txtCodigoProductoER').val();
    $accion="consultarProducto";
    //alert($codigo_producto);
        $.ajax({
        url: '/DemoProduccion/ProductoController',
        type: 'POST',
        data: {accion:$accion
                ,id_producto:$codigo_producto                
            },
        //dataType: 'json',
        success: function (jsonResponse) {
//            $('#modalCargandoProducto').modal("hide");
//            if ($('#actionProducto').val().toLowerCase() === "paginarproducto") {
//                listarProducto(jsonResponse.BEAN_PAGINATION);
//            } else {
//                if (jsonResponse.MESSAGE_SERVER.toLowerCase() === "ok") {
//                    viewAlert('success', getMessageServerTransaction($('#actionProducto').val(), 'Producto', 'a'));
//                    listarProducto(jsonResponse.BEAN_PAGINATION);
//                } else {
//                    viewAlert('warning', jsonResponse.MESSAGE_SERVER);
//                }
//            }
            //$("#ventanaModalManProducto").modal("hide");
            if (jsonResponse.respuestaJson.estado==="ok")
            {
                $('#txtNombreProductoER').val(jsonResponse.nombre);
                $('#txtDescripcionProductoER').val(jsonResponse.descripcion);
                $('#txtLoteProductoER').val(jsonResponse.lote);
                $('#cboCategoria').val(jsonResponse.codigo_categoria);
                $('#cboPresentacion').val(jsonResponse.codigo_presentacion);
                buscarAjaxEtapaDetalle();
                
            }
            else
            {
                viewAlert('error',jsonResponse.respuestaJson.mensaje);
            }
            
            //viewAlertModal('success',jsonResponse.mensaje);
            //location.reload();
        },
        error: function (jsonerror) {
//            $('#modalCargandoProducto').modal("hide");
            //$("#ventanaModalManProducto").modal("hide");
//            viewAlert('error', 'Erroe interno en el Servidor');
                viewAlert('error','Hubo un error al procesar');
        }
    });
    return false;
}
function processAjaxProducto() {
//    var datosSerializadosCompletos = $('#' + $('#nameFormProducto').val()).serialize();
//    if ($('#nameFormProducto').val().toLowerCase() !== "frmproducto") {
//        datosSerializadosCompletos += "&txtNombreProducto=" + $('#txtNombreProducto').val();
//    }
//    datosSerializadosCompletos += "&numberPageProducto=" + $('#numberPageProducto').val();
//    datosSerializadosCompletos += "&sizePageProducto=" + $('#sizePageProducto').val();
//    
    $nombre_producto=$('#txtNombreProductoER').val();
    $id_producto=$('#txtCodigoProductoER').val();
    $accion=$('#actionProducto').val();
    $descripcion_producto=$('#txtDescripcionProductoER').val();
    $lote_producto=$('#txtLoteProductoER').val();
    $codigo_categoria=$('#cboCategoria').val();
    $codigo_presentacion=$('#cboPresentacion').val();
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
        numero:$id_producto,
        cliente:$nombre_producto
        ,detalle:$arreglo
    }
    //b.append(a);

    //alert(JSON.stringify(cab));
    //alert(JSON.stringify($arreglo));
//    alert(a.serialize());
    //alert("Par:"+$nombre_producto+" "+$accion+" "
     //       +$id_producto+" "+$descripcion_producto+" "+$lote_producto
      //      +" "+$costo_producto+" "+$factor_producto+" "+$codigo_unidaddemedida
      //      );
    $.ajax({
        url: '/DemoProduccion/ProductoController',
        type: 'POST',
        data: {accion:$accion
                ,id_producto:$id_producto
                ,nombre_producto:$nombre_producto
                ,descripcion_producto:$descripcion_producto
                ,lote_producto:$lote_producto
                ,codigo_categoria:$codigo_categoria
                ,codigo_presentacion:$codigo_presentacion
            },
        //dataType: 'json',
        success: function (jsonResponse) {
//            $('#modalCargandoProducto').modal("hide");
//            if ($('#actionProducto').val().toLowerCase() === "paginarproducto") {
//                listarProducto(jsonResponse.BEAN_PAGINATION);
//            } else {
//                if (jsonResponse.MESSAGE_SERVER.toLowerCase() === "ok") {
//                    viewAlert('success', getMessageServerTransaction($('#actionProducto').val(), 'Producto', 'a'));
//                    listarProducto(jsonResponse.BEAN_PAGINATION);
//                } else {
//                    viewAlert('warning', jsonResponse.MESSAGE_SERVER);
//                }
//            }
            $("#ventanaModalManProducto").modal("hide");
            //alert(jsonResponse.mensaje);
            viewAlertModal('success',jsonResponse.mensaje);
            //location.reload();
        },
        error: function (jsonerror) {
//            $('#modalCargandoProducto').modal("hide");
            $("#ventanaModalManProducto").modal("hide");
//            viewAlert('error', 'Erroe interno en el Servidor');
                viewAlert('error','Hubo un error al procesar');
        }
    });
    return false;
}


function addEventosProducto() {
    $('.editar-Producto').each(function () {
        $(this).click(function () {
            
//            $celda=$(this.parentElement.parentElement);
//            
//            $celda.each(function (index) {
//                var campo1, campo2, campo3;
//              var campotexto = "#txtComentario"+$(this).attr("codigoProducto");
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
            $('#txtIdProductoER').val($(this.parentElement.parentElement).attr('codigoproducto'));
            $('#txtCodigoProductoER').val($(this.parentElement.parentElement).attr('codigoProducto'));
            $('#txtNombreProductoER').val($(this.parentElement.parentElement).attr('nombreProducto'));
            $('#txtDescripcionProductoER').val($(this.parentElement.parentElement).attr('descripcionProducto'));
            $('#txtLoteProductoER').val($(this.parentElement.parentElement).attr('lote'));
            //$('#txtCodigoUnidaddeMedidaER').val($(this.parentElement.parentElement).attr('codigounidaddemedida'));
            $('#cboCategoria').val($(this.parentElement.parentElement).attr('codigocategoria'));
            $('#cboPresentacion').val($(this.parentElement.parentElement).attr('codigopresentacion'));                        
            $('#actionProducto').val("updateProducto");
            $('#tituloModalManProducto').html("EDITAR PRODUCTO");
            $('#ventanaModalManProducto').modal("show");
            document.getElementsByTagName("body")[0].style.paddingRight = "0";
        });
    });
    $('.eliminar-Producto').each(function () {
        $(this).click(function () {
            $('#txtIdProductoER').val($(this.parentElement.parentElement).attr('idproducto'));
            viewAlertDelete("Producto");
            document.getElementsByTagName("body")[0].style.paddingRight = "0";
        });
    });
}