package co.edu.udistrital.operaciones.view;

public class ArchiveViewFactory implements AbstractViewFactory {

    private String rutaEntrada;
    private String rutaSalida;

    // Modificamos el constructor para recibir las rutas
    public ArchiveViewFactory(String rutaEntrada, String rutaSalida) {
        this.rutaEntrada = rutaEntrada;
        this.rutaSalida = rutaSalida;
    }

    @Override
    public AbstractIn getIn() {
        return new ArchiveIn(rutaEntrada);
    }

    @Override
    public AbstractOut getOut() {
        return new ArchiveOut(rutaSalida);
    }
}
