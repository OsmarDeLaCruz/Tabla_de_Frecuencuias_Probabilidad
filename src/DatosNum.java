import java.util.Arrays;

public class DatosNum extends DataSet{

    public DatosNum(String[] datos){
        super(datos);
    }

    private int buscar(double[] arr, double elemento, int limite){
        for (int i = 0; i < limite; i++){
            if (arr[i] == elemento){
                return i;
            }
        }
        return -1;
    }

    public double[] convertToDouble(String[] datos) {
        double[] resultado = new double[datos.length];
        for (int i = 0; i < datos.length; i++) {
            resultado[i] = Double.parseDouble(datos[i]);
        }
        return resultado;
    }


    @Override
    public void calcularfrecuencia() {
        System.out.println("Tabla de frecuencia simple para datos númericos:");
        double[] elemento = new double[datos.length];
        int[] frecuencia = new int[datos.length];
        int datosUnicos = 0;

        for (String dato : datos){
            try{
                double numero = Double.parseDouble(dato);
                int indice = buscar(elemento,numero,datosUnicos);
                if (indice == -1){
                    elemento[datosUnicos] = numero;
                    frecuencia[datosUnicos] = 1;
                    datosUnicos ++;
                } else {
                    frecuencia[indice]++;
                }
            } catch (NumberFormatException excep){
                System.out.println("Dato invalido "+dato+", ignorado");
            }
        }
        for (int i = 0; i < datosUnicos; i++){
            System.out.println(elemento[i]+": "+frecuencia[i]);
        }
    }

    public void agrupar(){
        double[] datosNum = convertToDouble(datos);
        Agrupar.agruparClase(datosNum);
    }
}
