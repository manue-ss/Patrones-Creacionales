
package co.edu.udistrital.operaciones.view;

/**
 *
 * @author Estudiantes
 */
public class ConsoleViewFactory implements AbstractViewFactory {
    @Override
    public AbstractIn getIn(){
        return new ConsoleIn();
    }
    
    @Override
    public AbstractOut getOut(){
        return new ConsoleOut();
    }
}
