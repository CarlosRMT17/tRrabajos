public interface Nacionalidad {
    double veracidad();

    static Nacionalidad paraPais(String nombrePais) {
        if (nombrePais.equals("Argentina")) {
            return new Argentina();
        } else {
            return new Extranjero();
        }
    }
}
