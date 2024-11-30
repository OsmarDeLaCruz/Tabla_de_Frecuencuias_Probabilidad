public class DatosCaracter extends DataSet{

    public DatosCaracter(String[] datos){
        super(datos);
    }

    private int buscar(String[] arreglo, String elemento, int lim){
        for (int i = 0; i < lim; i++){
            if (arreglo[i].equals(elemento)){
                return i;
            }
        }
        return -1;
    }

    @Override
    public void calcularfrecuencia() {
        String[] elemento = new String[datos.length];
        int[] frecuencia = new int[datos.length];
        int datosUnicos = 0;

        for (String dato : datos){
            int indice = buscar(elemento, dato,datosUnicos);
            if(indice == -1){
                elemento[datosUnicos] = dato;
                frecuencia[datosUnicos] = 1;
                datosUnicos ++;
            } else {
                frecuencia[indice]++;
            }
        }

        System.out.println("Tabla de frecuencias: ");
        for (int i = 0; i < datosUnicos; i++){
            System.out.println(elemento[i]+": "+frecuencia[i]);
        }
    }

    public void agrupar(){
        System.out.println("La agrupación no aplica para datos del tipo caracter");
    }
}
