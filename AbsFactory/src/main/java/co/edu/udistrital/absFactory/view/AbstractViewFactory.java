package co.edu.udistrital.operaciones.view;

/**
 *
 * @author Estudiantes
 */
public interface AbstractViewFactory {
    
    public abstract AbstractIn getIn();
    
    public abstract AbstractOut getOut();
}
