public interface ColorPelo {
    double calcularAumentoPara(Recomendador recomendador);

    static ColorPelo conDescripcion(String color) throws ColorDePeloNoReconocido {
        return switch (color) {
            case "Colorado" -> new Colorado();
            case "Morocho" -> new Morocho();
            case "Rubio" -> new Rubio();
            default -> throw new ColorDePeloNoReconocido("El color de pelo ingresado es incorrecto.");
        };
    }

    class Colorado implements ColorPelo {
        @Override
        public double calcularAumentoPara(Recomendador recomendador) {
            return (recomendador.getPatrimonio() / 10) + (recomendador.getEdad() * 3);
        }
    }

    class Morocho implements ColorPelo {
        @Override
        public double calcularAumentoPara(Recomendador recomendador) {
            return (recomendador.getEdad() * recomendador.getPatrimonio()) / 10000000;
        }
    }

    class Rubio implements ColorPelo {
        @Override
        public double calcularAumentoPara(Recomendador recomendador) {
            return recomendador.getPatrimonio() - (recomendador.getEdad() * 175_000.0);
        }
    }
}