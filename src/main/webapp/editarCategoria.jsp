<%-- 
    Document   : editarCategoria.jsp
    Created on : 05/07/2023
    Author     : Jonathan Diaz
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar Categoría</title>
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
                                    <h1 class="box-title">Editar Categoría</h1>
                                </div>
                                <!--/.box-header-->
                                <div class="box-body">
                                    <form action="${pageContext.request.contextPath}/ServletControlador?accion=actualizar" method="POST" class="was-validated">
                                        <input type="hidden" name="accion" value="actualizar">
                                        <div class="form-group" style="display: none;">
                                            <label for="idcategoria">ID Categoría:</label>
                                            <input type="text" id="idcategoria" name="idcategoria" value="${categoria.idcategoria}" readonly class="form-control">
                                        </div>
                                        <div class="form-group">
                                            <label for="nombre">Nombre:</label>
                                            <input type="text" id="nombre" name="nombre" pattern="[A-Za-z]+" value="${categoria.nombre}" class="form-control" required>
                                        </div>
                                        <div class="form-group">
                                            <label for="descripcion">Descripción:</label>
                                            <textarea id="descripcion" name="descripcion" class="form-control" required>${categoria.descripcion}</textarea>
                                        </div>
                                        <button type="submit" class="btn btn-primary">Actualizar</button>
                                        <button type="button" class="btn btn-default" onclick="window.location.href = '${pageContext.request.contextPath}/ServletControlador'">Cancelar</button>
                                    </form>
                                </div>
                                <!--/.box-body-->
                            </div>
                        </div>
                    </div>
                </section>
            </div>
        </div>
        <%@include file="footer.jsp" %>
        <%@include file="javascript.jsp" %>
    </body>
</html>
