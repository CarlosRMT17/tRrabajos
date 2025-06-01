public class Prediccion {
    private double valor;

    public Prediccion(double valor) {
        this.valor = valor;
    }

    public boolean comparar(double otraPrediccion, double precision) {
        return Math.abs(valor - otraPrediccion) < precision;
    }

    public boolean compararEnPesos(double valorEnPesos, double precision) {
        double valorEnPesosPropio = valor * 1200;
        double diferencia = Math.abs(valorEnPesosPropio - valorEnPesos);
        return diferencia < precision;
    }

    public double getValor() {
        return valor;
    }
}
