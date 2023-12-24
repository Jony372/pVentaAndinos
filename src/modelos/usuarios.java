
package modelos;

public class usuarios {
    private static String ID, nUsuario, pass, nombre;

    public static String getNombre() {
        return nombre;
    }

    public static void setNombre(String nombre) {
        usuarios.nombre = nombre;
    }
    private static int tipo;

    public static String getID() {
        return ID;
    }

    public static void setID(String ID) {
        usuarios.ID = ID;
    }

    public static int getTipo() {
        return tipo;
    }

    public static void setTipo(int tipo) {
        usuarios.tipo = tipo;
    }

    public static String getnUsuario() {
        return nUsuario;
    }

    public static void setnUsuario(String nUsuario) {
        usuarios.nUsuario = nUsuario;
    }

    public static String getPass() {
        return pass;
    }

    public static void setPass(String pass) {
        usuarios.pass = pass;
    }

    
}
