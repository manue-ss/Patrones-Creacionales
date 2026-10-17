package co.edu.udistrital.operaciones.view;

/**
 *
 * @author Estudiantes
 */
public class PaneViewFactory implements AbstractViewFactory {

    @Override
    public AbstractIn getIn() {
        return new PaneIn();

    }

    @Override
    public AbstractOut getOut() {
        return new PaneOut();
    }

}
