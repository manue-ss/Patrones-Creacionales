package co.edu.udistrital.singleton.view;

/**
 *
 * @author Manuel Salazar
 */
public class ConsoleOut implements AbstractOut {

    @Override
    public void show(String st) {
        System.out.println(st);
    }
    
    @Override
    public void showError(String e){
        System.err.println(e);
    }

}
