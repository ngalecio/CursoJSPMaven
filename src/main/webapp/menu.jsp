<div class="sidebar-header">
    <div class="logo">
        <a href="<%out.print(getServletContext().getContextPath()); %>/index.jsp"><img src="<%out.print(getServletContext().getContextPath()); %>/assets/images/icon/logo.png" alt="logo"></a>
    </div>
    <br>
    <h6 class="text-center" style="color: aliceblue"><i class="fa fa-user"></i> <strong>JCode</strong></h6>
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
                        <li><a href="<%out.print(getServletContext().getContextPath()); %>/jsp_app/mantenimiento/productos.jsp"><i class="fa fa-archive"></i> Productos</a></li>
                        <li><a href=""><i class="fa fa-archive"></i> Productos</a></li>
                    </ul>
                </li>
            </ul>
        </nav>
    </div>
</div>