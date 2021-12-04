public class ValorAtributo {
    private double probabilidad;
    private String atributo;
    private String valor;

    public ValorAtributo(double probabilidad, String atributo, String valor) {
        this.probabilidad = probabilidad;
        this.atributo = atributo;
        this.valor = valor;
    }

    public void setProbabilidad(double probabilidad) {
        this.probabilidad = probabilidad;
    }

    public void setAtributo(String atributo) {
        this.atributo = atributo;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public double getProbabilidad() {
        return probabilidad;
    }

    public String getAtributo() {
        return atributo;
    }

    public String getValor() {
        return valor;
    }

    @Override
    public String toString() {
        return valor;
    }
}
