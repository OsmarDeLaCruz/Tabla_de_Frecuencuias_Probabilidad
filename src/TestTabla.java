public class TestTabla {
    public static void main(String[] args) {
        String[] datosC = {"roj","azul","rojo","verde","azul","rojo"};
        double[] datosN = {1,2.4,3,4,5,6,7,8,9,10,11,1,55,6,43,43,567,56,12,87,546,234,6,435,34,678,0,231,54,76,8,9,45,23,12,56,43,23,12,65,786,};
        DataSet ds = new DatosCaracter(datosC);
        ds.calcularfrecuencia();
        System.out.println();

        System.out.println("Tabla de frecuencia para datos agrupados (númericos):");
        Agrupar.agruparClase(datosN);
    }
}
