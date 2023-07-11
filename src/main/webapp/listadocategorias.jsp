<%-- 
    Document   : listadoCategorias.jsp
    Created on : 05/07/2023
    Author     : Jonathan Diaz
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--centro del box para nuestra tabla-->
<div class="panel-bodytable-responsive" id="listadoregistro">
    <table class="table table-striped table-bordered table-condensed table-hover">
        <thead>
            <tr>
                <th>ID Categoría</th>
                <th>Nombre</th>
                <th>Descripción</th>
                <th>Condición</th>
                <th>Opciones</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="categoria" items="${categorias}">
                <tr>
                    <td>${categoria.idcategoria}</td>
                    <td>${categoria.nombre}</td>
                    <td>${categoria.descripcion}</td>
                    <td>${categoria.condicion}</td>
                    <td>
                        <div class="btn-group btn-group-xs">
                            <div class="btn-group m-1" role="group">
                                <form action="ServletControlador" method="GET">
                                    <input type="hidden" name="accion" value="editarcategoria">
                                    <input type="hidden" name="idcategoria" value="${categoria.idcategoria}">
                                    <button type="submit" class="btn btn-warning">
                                        <i class="fa fa-pencil"></i> Editar
                                    </button>
                                </form>
                            </div>
                            <div class="btn-group m-1" role="group"><p style="color: white">.A.</p></div>
                            <div class="btn-group m-1" role="group">
                                <form action="ServletControlador" method="POST">
                                    <input type="hidden" name="accion" value="eliminar">
                                    <input type="hidden" name="idcategoria" value="${categoria.idcategoria}">
                                    <!-- 
                                    <button type="submit" class="btn btn-danger">
                                        <i class="fa fa-trash"></i> Eliminar
                                    </button>
                                    -->  
                                </form>
                            </div>
                            <div class="btn-group m-1" role="group"><p style="color: white">.A.</p></div>
                            <div class="btn-group m-1" role="group">
                                <form action="ServletControlador" method="POST">
                                    <input type="hidden" name="idcategoria" value="${categoria.idcategoria}">
                                    <c:choose>
                                        <c:when test="${categoria.condicion == 0}">
                                            <input type="hidden" name="accion" value="activar">
                                            <button type="submit" class="btn btn-success">
                                                <i class="fa fa-check"></i> Activar
                                            </button>
                                        </c:when>
                                        <c:when test="${categoria.condicion == 1}">
                                            <input type="hidden" name="accion" value="desactivar">
                                            <button type="submit" class="btn btn-default">
                                                <i class="fa fa-times"></i> Desactivar
                                            </button>
                                        </c:when>
                                    </c:choose>
                                </form>
                            </div>
                        </div>
                    </td>
                </tr>
            </c:forEach>
        </tbody>

    </table>
</div>

<%@include file="javascript.jsp" %>

