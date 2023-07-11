package web;

import datos.CategoriaDAO;
import dominio.Categoria;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ServletControlador")
public class ServletControlador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String accion = request.getParameter("accion");

        if (accion != null) {
            switch (accion) {
                case "editarcategoria":
                    this.editarCategoria(request, response);
                    break;
                default:
                    this.accionDefault(request, response);
            }
        } else {
            this.accionDefault(request, response);
        }
    }
    
    //Metodo para listar de manera default
    private void accionDefault(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<Categoria> categorias = new CategoriaDAO().Listar();
        System.out.println("Categorias" + categorias);
        HttpSession sesion = request.getSession();
        sesion.setAttribute("categorias", categorias);

        response.sendRedirect("categorias.jsp");
    }

    private void editarCategoria(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idCategoria = Integer.parseInt(request.getParameter("idcategoria"));

        Categoria categoria = new CategoriaDAO().encontrar(new Categoria(idCategoria));

        request.setAttribute("categoria", categoria);

        // Establecer un atributo en la sesión para indicar que estamos en modo de edición
        HttpSession session = request.getSession();
        session.setAttribute("modoEdicion", true);

        // Redireccionar a la página de categorías donde se mostrará el formulario de edición
        request.getRequestDispatcher("editarCategoria.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String accion = request.getParameter("accion");

        if (accion != null) {
            switch (accion) {
                case "insertar":
                    this.insertarCategoria(request, response);
                    break;
                case "actualizar":
                    this.actualizarCategoria(request, response);
                    break;
                case "eliminar":
                    this.eliminarCategoria(request, response);
                    break;
                case "activar":
                    this.activar(request, response);
                    break;
                case "desactivar":
                    this.desactivar(request, response);
                    break;
                default:
                    this.accionDefault(request, response);
            }
        } else {
            this.accionDefault(request, response);
        }
    }

    private void activar(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int idCategoriaActivar = Integer.parseInt(request.getParameter("idcategoria"));
        int registrosModificadosActivar = new CategoriaDAO().activarCategoria(idCategoriaActivar);
        // Redireccionar o realizar acciones adicionales según tus necesidades
        response.sendRedirect(request.getContextPath() + "/ServletControlador");
    }

    private void desactivar(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int idCategoriaDesactivar = Integer.parseInt(request.getParameter("idcategoria"));
        int registrosModificadosDesactivar = new CategoriaDAO().desactivarCategoria(idCategoriaDesactivar);
        // Redireccionar o realizar acciones adicionales según tus necesidades
        response.sendRedirect(request.getContextPath() + "/ServletControlador");
    }

    //creamos un método para insertar una categoria a nuestra tabla
    private void insertarCategoria(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Recuperar los valores del formulario para guardar en la base de datos
        String nombre = request.getParameter("nombre");
        String descripcion = request.getParameter("descripcion");

        // Crear el nuevo objeto de Categoria (modelo)
        Categoria categoria = new Categoria(nombre, descripcion, 1);

        // Insertar el nuevo registro en la base de datos
        int registrosModificados = new CategoriaDAO().insertar(categoria);

        // Mostrar en consola los datos ingresados
        System.out.println("registrosModificados: " + registrosModificados);

        // Redireccionar o realizar acciones adicionales según tus necesidades
        response.sendRedirect(request.getContextPath() + "/ServletControlador");
    }

    private void actualizarCategoria(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int idCategoria = Integer.parseInt(request.getParameter("idcategoria"));
        String nombre = request.getParameter("nombre");
        String descripcion = request.getParameter("descripcion");

        Categoria categoria = new Categoria(idCategoria, nombre, descripcion, 1);

        int registrosModificados = new CategoriaDAO().actualizar(categoria);

        System.out.println("Registros modificados: " + registrosModificados);

        response.sendRedirect(request.getContextPath() + "/ServletControlador");
        
        
    }

    private void eliminarCategoria(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idCategoria = Integer.parseInt(request.getParameter("idcategoria"));
        // Lógica para eliminar el registro en la base de datos utilizando CategoriaDAO
        CategoriaDAO categoriaDAO = new CategoriaDAO();
        Categoria categoria = new Categoria(idCategoria);
        int registrosModificados = categoriaDAO.eliminar(categoria);

        // Verificar si la eliminación fue exitosa y redirigir al listado de categorías
        if (registrosModificados > 0) {
            response.sendRedirect(request.getContextPath() + "/ServletControlador");
        } else {
            // Manejar el caso de error al eliminar el registro, redirigir a una página de error, mostrar un mensaje, etc.
        }
    }
}
