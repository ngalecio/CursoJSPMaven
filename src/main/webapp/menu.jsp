<div class="sidebar-header">
    <div class="logo">
        <a href="<%out.print(getServletContext().getContextPath()); %>/index.jsp"><img src="<%out.print(getServletContext().getContextPath()); %>/assets/images/icon/logocolmena.ico" alt="logo"></a>
    </div>
    <br>
    <h6 class="text-center" style="color: aliceblue"><i class="fa fa-user"></i> <strong>Colmena</strong></h6>
</div>
<div class="main-menu">
    <div class="menu-inner">
        <nav>
            <ul class="metismenu" id="menu">
                <li class="active"><a href="<%out.print(getServletContext().getContextPath()); %>/index.jsp"><i class="fa fa-home"></i> <span>Inicio</span></a></li>
                <li>
                    <a href="javascript:void(0)"><i class="fa fa-tag"></i><span>Mantenimientos</span></a>
                    <ul class="collapse">
                        <li><a href="<%out.print(getServletContext().getContextPath()); %>/jsp_app/mantenimiento/categorias.jsp"><i class="fa fa-cubes"></i> Categorias</a></li>
                        <li><a href="<%out.print(getServletContext().getContextPath()); %>/jsp_app/mantenimiento/unidaddemedida.jsp"><i class="fa fa-glass"></i> Unidad de Medida</a></li>
                        <li><a href="<%out.print(getServletContext().getContextPath()); %>/jsp_app/mantenimiento/presentacion.jsp"><i class="fa fa-leaf"></i> Presentaciones</a></li>
                        <li><a href="<%out.print(getServletContext().getContextPath()); %>/jsp_app/mantenimiento/producto.jsp"><i class="fa fa-archive"></i> Productos</a></li>
                        <li><a href="<%out.print(getServletContext().getContextPath()); %>/jsp_app/mantenimiento/materiaprima.jsp"><i class="fa fa-pencil"></i> Materia Prima</a></li>
                        <li><a href="<%out.print(getServletContext().getContextPath()); %>/jsp_app/mantenimiento/tecnicadefabricacion.jsp"><i class="fa fa-save"></i> Tecnicas de Fabricacion</a></li>
                        
                    </ul>
                </li>
                <li>
                                        <a href="javascript:void(0)"><i class="fa fa-adn"></i><span>Procesos</span></a>
                    <ul class="collapse">
                        <li><a href="<%out.print(getServletContext().getContextPath()); %>/jsp_app/procesos/receta.jsp"><i class="fa fa-adjust"></i> Receta</a></li>
                        <li><a href="<%out.print(getServletContext().getContextPath()); %>/jsp_app/procesos/etapadefabricacion.jsp"><i class="fa fa-barcode"></i> Etapas de Fabricacion</a></li>
                        <li><a href="<%out.print(getServletContext().getContextPath()); %>/jsp_app/mantenimiento/categorias.jsp"><i class="fa fa-magnet"></i> Orden de Trabajo</a></li>
                        <li><a href="<%out.print(getServletContext().getContextPath()); %>/jsp_app/mantenimiento/productos.jsp"><i class="fa fa-car"></i>Orden de Acondicionado</a></li>
                        
                    </ul>

                </li>
            </ul>
        </nav>
    </div>
</div>