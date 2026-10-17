package co.edu.udistrital.singleton.view;

/**
 *
 * @author Estudiantes
 */
public interface AbstractViewFactory {
    
    public abstract AbstractIn getIn();
    
    public abstract AbstractOut getOut();
}
