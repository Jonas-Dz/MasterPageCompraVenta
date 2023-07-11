package dominio;
/*
Autor: Jonathan Diaz
Explicacion: Metodos getter y setter, ademas de nuestra sobrecarga de constructores
*/
public class Categoria {

    private int idcategoria;
    private String nombre;
    private String descripcion;
    private int condicion;

    //Crear el constructor vacio
    public Categoria() {

    }

    //creamos un constructor de id
    public Categoria(int idcategoria) {
        this.idcategoria = idcategoria;
    }

    //creamos un constructor con los atributos excluyendo el id
    public Categoria(String nombre, String descripcion, int condicion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.condicion = condicion;
    }
    public Categoria(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        
    }

    //creamos el ultimo constructor con todos los atributos
    public Categoria(int idcategoria, String nombre, String descripcion, int condicion) {
        this.idcategoria = idcategoria;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.condicion = condicion;
    }

    public Categoria(int idcategoria, String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public Categoria(int idcategoria, int condicion) {
        this.idcategoria = idcategoria;
        this.condicion = condicion;
    }
    
    
    
    //creamos los metodos set
    public void setIdcategoria(int idcategoria) {
        this.idcategoria = idcategoria;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setCondicion(int condicion) {
        this.condicion = condicion;
    }
    
    //creamos los metodos get
    public int getIdcategoria() {
        return idcategoria;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getCondicion() {
        return condicion;
    }

    @Override
    public String toString() {
        return "Categoria{" + "idcategoria=" + idcategoria + ", nombre=" + nombre + ", descripcion=" + descripcion + ", condicion=" + condicion + '}';
    }
}