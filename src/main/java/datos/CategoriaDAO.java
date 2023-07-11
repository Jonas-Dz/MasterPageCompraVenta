package datos;

import com.mysql.cj.protocol.Resultset;
import dominio.Categoria;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Kevin Chala
 */
public class CategoriaDAO {

    private static final String SQL_SELECT = "SELECT * FROM categoria";
    private static final String SQL_SELECT_BY_ID = "SELECT * FROM categoria where idcategoria=?";
    private static final String SQL_INSERT = "INSERT INTO categoria(nombre,descripcion,condicion) VALUES (?,?,1)";
    private static final String SQL_UPDATE = "UPDATE categoria set nombre=?, descripcion=? where idcategoria=?";
    private static final String SQL_DELETE = "DELETE FROM categoria WHERE idcategoria=?";
    private static final String SQL_ACTIVAR = "UPDATE categoria set condicion=1 where idcategoria=?";
    private static final String SQL_DESACTIVAR = "UPDATE categoria set condicion=0 where idcategoria=?";

    //Creamos un metodo para poder listar los datos de mi tabla
    public List<Categoria> Listar() {

        //Inicializamos una variable de tipo conexion
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Categoria categoria = null;
        List<Categoria> categorias = new ArrayList<>();
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int idcategoria = rs.getInt("idcategoria");
                String nombre = rs.getString("nombre");
                String descripcion = rs.getString("descripcion");
                int condicion = rs.getInt("condicion");
                System.out.println(idcategoria + "" + nombre + "" + descripcion + "" + condicion);
                categoria = new Categoria(idcategoria, nombre, descripcion, condicion);
                categorias.add(categoria);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return categorias;

    }

    //metodo para poder encontar un registro
    public Categoria encontrar(Categoria categoria) {

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_BY_ID);
            stmt.setInt(1, categoria.getIdcategoria());
            rs = stmt.executeQuery();
            //posiciono en el primer registro que me devuelve
            rs.absolute(1);
            //Obtenemos los datos mediante JavaBeans
            String nombre = rs.getString("nombre");
            String descripcion = rs.getString("descripcion");
            //seteamos los parametros
            categoria.setNombre(nombre);
            categoria.setDescripcion(descripcion);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return categoria;
    }

    //vamos a crear un metodo para insertar un registro en la base de datos
    public int insertar(Categoria categoria) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            // Ingresamos los datos en la BDD mediante los JavaBeans
            stmt.setString(1, categoria.getNombre());
            stmt.setString(2, categoria.getDescripcion());
            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    }

    //creamos un metodo para actualizar un registro
    public int actualizar(Categoria categoria) {

        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            //Seteamos los parametros de la BDD a traves de JavaBeans
            stmt.setString(1, categoria.getNombre());
            stmt.setString(2, categoria.getDescripcion());
            stmt.setInt(3, categoria.getIdcategoria());
            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    }

    public int activarCategoria(int idCategoria) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement("UPDATE categoria SET condicion = 1 WHERE idcategoria = ?");
            stmt.setInt(1, idCategoria);
            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    }

    public int desactivarCategoria(int idCategoria) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement("UPDATE categoria SET condicion = 0 WHERE idcategoria = ?");
            stmt.setInt(1, idCategoria);
            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    }

    public int eliminar(Categoria categoria) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, categoria.getIdcategoria());
            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    }

    public static void main(String[] args) {
        CategoriaDAO categoria = new CategoriaDAO();
        categoria.Listar();

    }

}
