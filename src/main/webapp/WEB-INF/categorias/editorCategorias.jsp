<%-- 
    Document   : editorCategoria
    Created on : 05/07/2023, 22:45:17
    Author     : Jonathan Diaz
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Editor de Categoría</title>
        <%@include file="../../head.jsp" %>
    </head>
    <body class="hold-transition skin-blue-light sidebar-mini">
        <div class="wrapper">
            <%@include file="../../header.jsp" %>
            <aside class="main-sidebar">
                <%@include file="../../index.jsp" %>
            </aside>
            <div class="content-wrapper">
                <section class="content">
                    <div class="row">
                        <div class="col-md-12">
                            <div class="box">
                                <div class="box-header with-border">
                                    <h3 class="box-title">Editor de Categoría</h3>
                                </div>
                                <div class="box-body">
                                    <form action="${pageContext.request.contextPath}/ServletControlador?accion=actualizar" method="POST" class="was-validated">
                                        <input type="hidden" name="accion" value="actualizar">
                                        <input type="hidden" name="idcategoria" value="${categoria.idcategoria}">
                                        <div class="form-group">
                                            <label for="nombre">Nombre:</label>
                                            <input type="text" class="form-control" id="nombre" name="nombre" pattern="[A-Za-z]+" value="${categoria.nombre}" required>
                                        </div>
                                        <div class="form-group">
                                            <label for="descripcion">Descripción:</label>
                                            <input type="text" class="form-control" id="descripcion" name="descripcion" value="${categoria.descripcion}" required>
                                        </div>
                                        <button type="submit" class="btn btn-primary">Actualizar</button>
                                        <button type="button" class="btn btn-default" onclick="window.location.href = '${pageContext.request.contextPath}/ServletControlador'">Cancelar</button>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </section>
            </div>
            <%@include file="../../footer.jsp" %>
        </div>
        <%@include file="../../javascript.jsp" %>
    </body>
</html>
