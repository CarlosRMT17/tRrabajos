public class Token {
    private String nombre;
    private double valorActual;
    private Recomendador recomendador;

    private Token(String nombre, double valorActual, Recomendador recomendador) throws RecomendadorInvalido {
        if (recomendador == null) {
            throw new RecomendadorInvalido();
        }
        this.nombre = nombre;
        this.valorActual = valorActual;
        this.recomendador = recomendador;
    }

    public static Token conNombre(String nombre, double valorActual, Recomendador recomendador) {
        try {
            return new Token(nombre, valorActual, recomendador);
        } catch (RecomendadorInvalido e) {
            throw new RuntimeException(e);
        }
    }

    public String getNombre() {
        return nombre;
    }

    public String getNombreDelRecomendador() {
        return recomendador.getNombre();
    }

    public double calcularPrediccion() {
        return recomendador.calcularPrediccionDeTokenConValor(valorActual);
    }
}
