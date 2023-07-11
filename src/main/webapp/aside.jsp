<%-- 
    Document   : aside.jsp
    Created on : 05/07/2023
    Author     : Jonathan Diaz
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@include file="head.jsp" %>
 <!-- Left side column. contains the logo and sidebar -->
            <aside class="main-sidebar">
                <!-- sidebar: style can be found in sidebar.less -->
                <section class="sidebar">
                    <!-- sidebar menu: : style can be found in sidebar.less -->
                    <ul class="sidebar-menu">
                        <li class="header"></li>
                        <li>
                            <a href="#">
                                <i class="fa fa-tasks"></i> <span>Escritorio</span>
                            </a>
                        </li>
                        <li class="treeview">
                            <a href="#"><i class="fa fa-laptop"></i>
                                <span>Transacciones</span>
                                <i class="fa fa-angle-left pull-right"></i>
                            </a>
                        </li>
                        
                        <ul class="treeview-menu">
                            <li><a href="transaccion.php"><i class="fa fa-circle-o"></i> Transaciones</a></li>
                            <li><a href="#"><i class="fa fa-circle-0"></i> Categorias</a></li>
                        </ul>

                        

                        <li class="treeview">
                            <a href="#">
                                <i class="fa fa-folder"></i> <span>Acceso</span>
                                <i class="fa fa-angle-left pull-right"></i>
                            </a>
                            <ul class="treeview-menu">
                                <li><a href="usuario.php"><i class="fa fa-circle-o"></i> Usuarios</a></li>
                                <li><a href="permiso.php"><i class="fa fa-circle-0"></i> Permisos</a></li>

                            </ul>
                        </li>
                        <li>
                            <a href="#">
                                <i class="fa fa-plus-square"></i> <span>Ayuda</span>
                                <small class="label pull-right bg-red">PDF</small>
                            </a>
                        </li>
                        <li>
                            <a href="#">
                                <i class="fa fa-info-circle"></i> <span>Acerca de...</span>
                                <small class="label pull-right bg-yellow">IT</small>
                            </a>
                        </li>
                    </ul>
                </section>
                <!--/.sidebar-->
            </aside>
 <%@include file="javascript.jsp" %>