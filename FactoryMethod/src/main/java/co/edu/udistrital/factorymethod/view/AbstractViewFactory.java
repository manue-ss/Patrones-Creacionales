package co.edu.udistrital.factorymethod.view;

/**
 *
 * @author Estudiantes
 */
public interface AbstractViewFactory {
    
    public abstract AbstractIn getIn();
    
    public abstract AbstractOut getOut();
}
