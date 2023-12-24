
package modelos;

public class productos {
    private static String ID, name, tipo;
    private static int exist, gasGar, cant;

    public static int getCant() {
        return cant;
    }

    public static void setCant(int cant) {
        productos.cant = cant;
    }
    private static double precio;
    
    public static String[] getDatos(){
        return new String[] {ID,name,String.valueOf(precio),String.valueOf(exist),tipo,String.valueOf(gasGar)};
    }

    public static void setDatos(String[] datos){
        ID = datos[0];
        name = datos[1];
        precio = Double.parseDouble(datos[2]);
        exist = Integer.parseInt(datos[3]);
        tipo = datos[4];
        gasGar = Integer.parseInt(datos[5]);
    }
    
    public static String getID() {
        return ID;
    }

    public static void setID(String ID) {
        productos.ID = ID;
    }

    public static String getName() {
        return name;
    }

    public static void setName(String name) {
        productos.name = name;
    }

    public static String getTipo() {
        return tipo;
    }

    public static void setTipo(String tipo) {
        productos.tipo = tipo;
    }

    public static int getExist() {
        return exist;
    }

    public static void setExist(int exist) {
        productos.exist = exist;
    }

    public static int getGasGar() {
        return gasGar;
    }

    public static void setGasGar(int gasGar) {
        productos.gasGar = gasGar;
    }

    public static double getPrecio() {
        return precio;
    }

    public static void setPrecio(double precio) {
        productos.precio = precio;
    }
}
