<%-- 
    Document   : categorias.jsp
    Created on : 05/07/2023
    Author     : Jonathan Diaz
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Categorías</title>
        <%@include file="head.jsp" %>
    </head>
    <body class="hold-transition skin-blue-light sidebar-mini">


        <div class="wrapper">
            <%@include file="header.jsp" %>
            <%@include file="aside.jsp" %>
            <div class="content-wrapper">
                <!--main content-->
                <section class="content">
                    <div class="row">
                        <div class="col-md-12">
                            <div class="box">
                                <div class="box-header with-border">
                                    <h1 class="box-title">Tabla
                                        <button class="btn btn-success" onclick="mostrarFormulario()">
                                            <i class="fa fa-plus-circle"></i> AGREGAR
                                        </button>
                                    </h1>
                                    <div class="box-tools pull-right"></div>
                                </div> 
                                <!--/.box-header-->
                            </div>
                            <%@include file="listadocategorias.jsp" %>
                        </div>
                    </div>
                </section>
                <div class="panel-body" style="height: 400px; display: none;" id="formularioregistros">
                    <h1>Formulario</h1>
                    <form action="${pageContext.request.contextPath}/ServletControlador?accion=insertar" method="POST" class="was-validated">
                        <input type="hidden" id="id" name="id" />
                        <div class="form-group">
                            <label for="nombre">Nombre:</label>
                            <input type="text" id="nombre" name="nombre" class="form-control" pattern="[A-Za-z]+" required placeholder='Ingrese solo letras' />
                            <div class="invalid-feedback"></div>
                        </div>
                        <div class="form-group">
                            <label for="descripcion">Descripción:</label>
                            <textarea id="descripcion" name="descripcion" class="form-control" required placeholder='Descripción'></textarea>
                        </div>
                        <button type="submit" class="btn btn-primary">Guardar</button>
                        <button type="button" class="btn btn-default" onclick="window.location.href = '${pageContext.request.contextPath}/ServletControlador'">Cancelar</button>

                    </form>
                </div>
            </div>
        </div>
    </body>
    <%@include file="footer.jsp" %>

    <%@include file="javascript.jsp" %>
</html>
