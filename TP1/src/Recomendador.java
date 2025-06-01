public class Recomendador {
    private String nombre;
    private int edad;
    private double patrimonio;
    private Nacionalidad nacionalidad;
    private ColorPelo colorPelo;

    private Recomendador(String nombre, int edad, double patrimonio, Nacionalidad nacionalidad, ColorPelo colorPelo) {
        this.nombre = nombre;
        this.edad = edad;
        this.patrimonio = patrimonio;
        this.nacionalidad = nacionalidad;
        this.colorPelo = colorPelo;
    }

    public static Recomendador conNombre(String nombre, int edad, double patrimonio, String nacionalidad, String colorPelo)
            throws ColorDePeloNoReconocido, NacionalidadNoReconocida {
        return new Recomendador(
                nombre,
                edad,
                patrimonio,
                Nacionalidad.paraPais(nacionalidad),
                ColorPelo.conDescripcion(colorPelo)
        );
    }


    public double calcularPrediccionDeTokenConValor(double valorActual) {
        double aumento = colorPelo.calcularAumentoPara(this);
        double veracidad = nacionalidad.veracidad();
        double resultado = valorActual + (aumento * veracidad);
        return Math.max(resultado, 0);
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public double getPatrimonio() {
        return patrimonio;
    }
}
