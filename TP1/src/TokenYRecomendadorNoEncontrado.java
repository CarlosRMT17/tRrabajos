public class TokenYRecomendadorNoEncontrado extends RuntimeException {
  public TokenYRecomendadorNoEncontrado() {
    super("No se encontró el token con ese nombre y recomendador.");
  }
}