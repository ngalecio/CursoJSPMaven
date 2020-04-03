<%-- 
    Document   : index
    Created on : 18-mar-2020, 22:32:58
    Author     : certus3
--%>

<%@page import="ModeloDAO.UnidaddeMedidaDAO"%>
<%@page import="Modelo.UnidaddeMedida"%>
<%@page import="java.util.Iterator"%>
<%@page import="Modelo.MateriaPrima"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html class="no-js" lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <title>My App</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="shortcut icon" type="image/png" href="assets/images/icon/favicon.ico">
    <link rel="stylesheet" href="<%out.print(getServletContext().getContextPath()); %>/assets/css/bootstrap.min.css">
    <link rel="stylesheet" href="<%out.print(getServletContext().getContextPath()); %>/assets/css/font-awesome.min.css">
    <link rel="stylesheet" href="<%out.print(getServletContext().getContextPath()); %>/assets/css/themify-icons.css">
    <link rel="stylesheet" href="<%out.print(getServletContext().getContextPath()); %>/assets/css/metisMenu.css">
    <link rel="stylesheet" href="<%out.print(getServletContext().getContextPath()); %>/assets/css/owl.carousel.min.css">
    <link rel="stylesheet" href="<%out.print(getServletContext().getContextPath()); %>/assets/css/slicknav.min.css">
    <!-- amchart css -->
    <link rel="stylesheet" href="https://www.amcharts.com/lib/3/plugins/export/export.css" type="text/css" media="all" />
    <!-- others css -->
    <link rel="stylesheet" href="<%out.print(getServletContext().getContextPath()); %>/assets/css/typography.css">
    <link rel="stylesheet" href="<%out.print(getServletContext().getContextPath()); %>/assets/css/default-css.css">
    <link rel="stylesheet" href="<%out.print(getServletContext().getContextPath()); %>/assets/css/styles.css">
    <link rel="stylesheet" href="<%out.print(getServletContext().getContextPath()); %>/assets/css/responsive.css">
    <!-- modernizr css -->
    <script src="<%out.print(getServletContext().getContextPath()); %>/assets/js/vendor/modernizr-2.8.3.min.js"></script>
</head>
    <%   
        ArrayList<MateriaPrima> listamateriaprima= ModeloDAO.MateriaPrimaDAO.listar();
        Iterator<MateriaPrima> it = listamateriaprima.iterator();

    %>
<body>
    <!--[if lt IE 8]>
            <p class="browserupgrade">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade your browser</a> to improve your experience.</p>
        <![endif]-->
    <!-- preloader area start -->
    <div id="preloader">
        <div class="loader"></div>
    </div>
    <!-- preloader area end -->
    <!-- page container area start -->
    <div class="page-container">
        <!-- sidebar menu area start -->
        <div class="sidebar-menu">

                    <jsp:include page="../../menu.jsp"/>
        </div>
        <!-- sidebar menu area end -->
        <!-- main content area start -->
        <div class="main-content">
            <!-- header area start -->
            <div class="header-area">
                <div class="row align-items-center">
                    <!-- nav and search button -->
                    <div class="col-4 clearfix">
                        <div class="nav-btn pull-left" style="margin-top: 0px">
                            <span></span>
                            <span></span>
                            <span></span>
                        </div>
                    </div>
                    <!-- profile info & task notification -->
                    <div class="col-8 clearfix">
                        <ul class="notification-area pull-right">
                            <li>
                                <a href="">
                                    Cerrar Sessión
                                    <i class="fa fa-sign-out" aria-hidden="true"></i>
                                </a>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
            <!-- header area end -->
            <div class="main-content-inner">
                <div class="row" style="padding-top: 30px">
                    <div class="col-12">
                        <div class="card">
                            <div class="card-body">
                                <h6>MateriaPrimas</h6>
                                <input type="hidden" id="actionMateriaPrima" name="action" value="paginarMateriaPrima">
                                <form id="FrmMateriaPrima">
                                    <div class="row mt-3">
                                        <div class="form-group col-sm-9 col-12">
                                            <input type="text"
                                                   id="txtNombreMateriaPrima"
                                                   name ="txtNombreMateriaPrima"
                                                   class="form-control form-control-sm"
                                                   placeholder="Nombre"
                                                   />
                                        </div>
                                         <div class="form-group col-sm-3 col-12">
                                             <button type="submit" class="btn btn-primary btn-xs mr-3" id="btnBuscarMateriaPrima">
                                                 <i class="fa fa-search" aria-hidden="true"></i>
                                                 Buscar
                                             </button>
                                             <button  type="button" class="btn btn-primary btn-xs" id="btnAgregarMateriaPrima">
                                                 <i class="fa fa-plus" aria-hidden="true"></i>
                                                 
                                             </button>
                                             <button type="button" id="btnAbrirNMateriaPrima" class="btn btn-primary btn-xs" data-toggle="tooltip" title="Agregar MateriaPrima"><i class="fa fa-plus-square" aria-hidden="true"></i></button>
                                             <button type="button" id="btnRecorrer" class="btn btn-primary btn-xs" data-toggle="tooltip" title="Recorrer"><i class="fa fa-tasks" aria-hidden="true"></i></button>
                                        </div>
                                    </div>
                                    
                                </form>
                                <div class="row">
                                    <div class="col-12">
                                        <div class="table-responsive">
                                            <table class="table table-hover table-bordered" id="id_tabla_materiaprima">
                                                <thead class="bg-primary">
                                                    <tr class="text-white">
                                                        <th style="width: 5%">ID</th>
                                                        
                                                        <th>Nombre</th>
                                                        <th>Descripcion</th>
                                                        <th>Lote</th>
                                                        <th>Costo</th>
                                                        <th>Factor</th>
                                                        <th>Uni.Medida</th>
                                                        <th style="width: 20%">Acciones</th>
                                                        
                                                </tr>    
                                                </thead>
                                                <tbody id="tbodyMateriaPrima">
                                                      <% while(it.hasNext()) {
                                                          MateriaPrima cat= it.next();
                    
                %>
                <tr codigoMateriaPrima="<%=cat.getCodigo() %>" 
                    nombreMateriaPrima="<%=cat.getNombre() %>" 
                    descripcionMateriaPrima="<%=cat.getDescripcion()%>" 
                    lote="<%=cat.getLote()%>" 
                    costo="<%=cat.getCosto()%>" 
                    factor="<%=cat.getFactor() %>"
                    codigounidaddemedida="<%=cat.getCodigo_unidaddemedida() %>"
                    style="height:20px">
                    <td><%= cat.getCodigo() %></td>    
                    
                    <td><%= cat.getNombre() %></td>    
                    <td><%= cat.getDescripcion() %></td>    
                    <td><%= cat.getLote()%></td>    
                    <td><%= cat.getCosto().toString() %></td>    
                    <td><%= cat.getFactor().toString() %></td>    
                    <td><%= cat.getDescripcion_unidaddemedida()%></td>    
                    <td class="text-center">
                        <button class='btn btn-warning btn-xs editar-MateriaPrima'><i class='fa fa-edit'></i>Editar</button>
                        <button class='btn btn-danger btn-xs eliminar-MateriaPrima'><i class='fa fa-trash'></i>Eliminar</button>
                        
                    </td>
                    													<td>

                                                                            
															<!--div class="hidden-sm hidden-xs action-buttons">
																<a class="blue" href="#">
																	<i class="ace-icon fa fa-search-plus bigger-130"></i>
																</a>

																<a class="green" href="#">
																	<i class="ace-icon fa fa-pencil bigger-130"></i>
																</a>

																<a class="red" href="#">
																	<i class="ace-icon fa fa-trash-o bigger-130"></i>
																</a>
															</div-->

															
														</td>
                </tr>
            <% }%>
                                                </tbody>
                                                
                                            </table>
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-md-3 col-12">
                                        <select id="sizePageMateriaPrima" name="sizePageMateriaPrima"
                                                class="form-control form-control-sm">
                                            <option value="10">10</option>
                                            <option value="15">15</option>
                                            <option value="20">20</option>
                                        </select>
                                    </div>
                                    <div class="col-md-9 col-12">
                                        <nav>
                                            <ul id="paginationMateriaPrima" class="pagination pagination-sm justify-content"></ul>
                                        </nav>
                                        
                                    </div>
                                </div>
                            </div>
                            
                        </div>
                        
                    </div>
                    
                </div>
            </div>
        </div>
        <!-- main content area end -->
        <!-- footer area start-->
                    <div id="ventanaModalManMateriaPrima" class="modal" tabindex="-1" role="dialog" data-backdrop="static" data-keyboard="false">
                <div class="modal-dialog modal-lg" role="document">
                    <div class="modal-content">
                        <form id="FrmMateriaPrimaModal">
                            <div class="modal-header">
                                <h6 class="modal-title" id="tituloModalManMateriaPrima"></h6>
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div>
                            <div class="modal-body">
                                <div class="row">
                                <div class="col-6">
                                    <div class="form-group">
                                        <label for="txtNombreMateriaPrimaER">NOMBRE</label>
                                        <input type="text" id="txtNombreMateriaPrimaER" name="txtNombreMateriaPrimaER" class="form-control form-control-sm" placeholder="NOMBRE">
                                        <div class="error-validation" id="validarNombreMateriaPrimaER">Ingrese MateriaPrima</div>
                                    </div>
                                </div>
                                <div class="col-6">
                                    <div class="form-group">
                                        <label for="txtDescripcionMateriaPrimaER">DESCRIPCION</label>
                                        <input type="text" id="txtDescripcionMateriaPrimaER" name="txtDescripcionMateriaPrimaER" 
                                               class="form-control form-control-sm" placeholder="DESCRIPCION">
                                        <div class="error-validation" id="validarDescripcionMateriaPrimaER">Ingrese Descripcion MateriaPrima</div>
                                    </div>
                                </div>                                    
                                    
                                </div>
                                <div class="row">
                                <div class="col-6">
                                    <div class="form-group">
                                        <label for="txtLoteMateriaPrimaER">Lote</label>
                                        <input type="text" id="txtLoteMateriaPrimaER" name="txtLoteMateriaPrimaER" class="form-control form-control-sm" placeholder="LOTE">
                                        
                                    </div>
                                </div>
                                <div class="col-6">
                                    <div class="form-group">
                                        <label for="txtCostoMateriaPrimaER">Costo</label>
                                        <input type="text" id="txtCostoMateriaPrimaER" name="txtCostoMateriaPrimaER" 
                                               class="form-control form-control-sm" placeholder="COSTO">
                                        
                                    </div>
                                </div>                                    
                                    
                                </div>
                                
                                  <div class="row">
                                <div class="col-6">
                                    <div class="form-group">
                                        <label for="txtFactorMateriaPrimaER">Factor</label>
                                        <input type="text" id="txtFactorMateriaPrimaER" name="txtFactorMateriaPrimaER" 
                                               class="form-control form-control-sm" placeholder="FACTOR">
                                        
                                    </div>
                                </div>
                                <div class="col-6">
                                    <div class="form-group">
                                        <label for="txtCodigoUnidaddeMedidaER">Unidad de Medida</label>
                                        
                                        <select name="cboUnidaddeMedida" id="cboUnidaddeMedida" class="form-control form-control-sm">
                                            <option value="0">Seleccione Unidad</option>
                                            <% for (UnidaddeMedida uni : UnidaddeMedidaDAO.listar()) {%>
                                            <option value="<%=uni.getCodigo()%>"><%=uni.getNombre()%></option>
                                            <% }%>
                                                    </select>
                                        
                                    </div>
                                </div>                                    
                                    
                                </div>
                                <input type="hidden" id="txtIdMateriaPrimaER" name="txtIdMateriaPrimaER" value="">
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-secondary btn-xs" data-dismiss="modal">CERRAR</button>
                                <button id="btnGrabarModal" type="button" class="btn btn-primary btn-xs">GUARDAR</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        <jsp:include page="../../footer.jsp"/>
        
        <!-- footer area end-->
    </div>
    <!-- page container area end -->
    <!-- jquery latest version -->
    <script src="<%out.print(getServletContext().getContextPath()); %>/assets/js/vendor/jquery-2.2.4.min.js"></script>
    <!-- bootstrap 4 js -->
    <script src="<%out.print(getServletContext().getContextPath()); %>/assets/js/popper.min.js"></script>
    <script src="<%out.print(getServletContext().getContextPath()); %>/assets/js/bootstrap.min.js"></script>
    <script src="<%out.print(getServletContext().getContextPath()); %>/assets/js/owl.carousel.min.js"></script>
    <script src="<%out.print(getServletContext().getContextPath()); %>/assets/js/metisMenu.min.js"></script>
    <script src="<%out.print(getServletContext().getContextPath()); %>/assets/js/jquery.slimscroll.min.js"></script>
    <script src="<%out.print(getServletContext().getContextPath()); %>/assets/js/jquery.slicknav.min.js"></script>

    <!-- start chart js -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.7.2/Chart.min.js"></script>
    <!-- start highcharts js -->
    <script src="https://code.highcharts.com/highcharts.js"></script>
    <!-- start zingchart js -->
    <script src="https://cdn.zingchart.com/zingchart.min.js"></script>
    <script>
        zingchart.MODULESDIR = "https://cdn.zingchart.com/modules/";
        ZC.LICENSE = ["569d52cefae586f634c54f86dc99e6a9", "ee6b7db5b51705a13dc2339db3edaf6d"];
    </script>
    <!-- all line chart activation -->
    <script src="<%out.print(getServletContext().getContextPath()); %>/assets/js/line-chart.js"></script>
    <!-- all pie chart -->
    <script src="<%out.print(getServletContext().getContextPath()); %>/assets/js/pie-chart.js"></script>
    <!-- others plugins -->
    <script src="<%out.print(getServletContext().getContextPath()); %>/assets/js/plugins.js"></script>
    <script src="<%out.print(getServletContext().getContextPath()); %>/assets/js/scripts.js"></script>
    <script src="<%out.print(getServletContext().getContextPath());%>/js_app/utilities/utilities.js"></script>
    <script src="<%out.print(getServletContext().getContextPath());%>/js_app/view/jquery.Pagination.min.js"></script>
      <script src="<%out.print(getServletContext().getContextPath());%>/js_app/view/sweetalert.min.js"></script>
    <script src="<%out.print(getServletContext().getContextPath());%>/js_app/app/materiaprima.js"></script>
</body>

</html>
