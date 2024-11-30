public abstract class DataSet {
    protected String[] datos;

    public DataSet(String[] datos){
        if(datos == null || datos.length == 0){
            throw new IllegalArgumentException("Data set nulo/vacío");
        }
        this.datos = datos;
    }

    public String[] getDatos() {
        return datos;
    }
    public void setDatos(String[] datos) {
        this.datos = datos;
    }

    public abstract void calcularfrecuencia();

    public void agrupar(){
        throw new UnsupportedOperationException("Agrupación no implementada");
    }
}
