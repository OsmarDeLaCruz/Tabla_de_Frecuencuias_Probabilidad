import java.util.Arrays;

public class Agrupar {

    private static double minimo(double[] datos){
        double minimo = datos[0];
        for (double dato : datos){
            if(dato < minimo){
                minimo = dato;
            }
        }
        return minimo;
    }

    private static double maximo(double[] datos){
        double maximo = datos[0];
        for (double dato : datos){
            if (dato > maximo){
                maximo = dato;
            }
        }
        return maximo;
    }

    public static void agruparClase(double[] datos){
        int n = datos.length;
        double minimo = minimo(datos);
        double maximo = maximo(datos);
        double rango = maximo - minimo;

        int k = (int) Math.ceil(1 + 3.322 * Math.log10(n));
        double amplitud = Math.ceil(rango/k);

        double[] limiteInferior = new double[k];
        double[] limiteSuperior = new double[k];
        int[] frecuencias = new int[k];
        double[] puntosM = new double[k];
        int[] frecuenciaAcumulada = new int[k];
        double[] frecuenciaRelativa = new double[k];
        double[] frecuenciaRA = new double[k];
        double[] porcentaje = new double[k];

        limiteInferior[0] = minimo;
        for (int i = 0; i < k; i++){
            limiteSuperior[i] = limiteInferior[i] + amplitud -1;
            if (i < k-1){
                limiteInferior[i+1] = limiteSuperior[i]+1;
            }
        }

        for (double dato : datos){
            for(int i = 0; i < k; i++){
                if (dato >= limiteInferior[i] && dato <= limiteSuperior[i]){
                    frecuencias[i]++;
                    break;
                }
            }
        }

        double totalFr=0;
        double totalPorcentaje = 0;
        int acumulacion = 0;
        for (int i = 0; i < k; i++){
            puntosM[i] = (limiteInferior[i] + limiteSuperior[i])/2;
            acumulacion += frecuencias[i];
            frecuenciaAcumulada[i] = acumulacion;
            frecuenciaRelativa[i] = (double) frecuencias[i] /n;
            totalFr += frecuenciaRelativa[i];
            frecuenciaRA[i] = (double) frecuenciaAcumulada[i]/n;
            porcentaje[i] = frecuenciaRelativa[i]*100;
            totalPorcentaje += porcentaje[i];
        }

        System.out.printf("%-6s%-15s%-12s%-12s%-10s%-10s%-10s%-12s%n","Clase", "Límite Clases", "Frecuencia", "Punto Med.", "Fa", "Fr", "fra", "Porcentaje");
        for (int i = 0; i < k; i++){
            System.out.printf("%-6d%-15s%-12d%-12.2f%-10d%-10.2f%-10.2f%-12.2f%n",i+1,String.format("%.0f - %.0f",limiteInferior[i],limiteSuperior[i]),
                    frecuencias[i],puntosM[i],frecuenciaAcumulada[i],frecuenciaRelativa[i],frecuenciaRA[i],porcentaje[i]);
        }
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("Total:  \t\t\tn = "+n+" \t\t\t\t\t\t\tfr = "+ totalFr+" \t\t\t\t% = "+Math.round(totalPorcentaje));


        
    }
}
