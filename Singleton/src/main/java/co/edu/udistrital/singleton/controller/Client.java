package co.edu.udistrital.singleton.controller;

import co.edu.udistrital.singleton.model.CajeroAutomatico;
import co.edu.udistrital.singleton.model.CajeroAutomaticoS;
import co.edu.udistrital.singleton.model.CajeroPool;
import co.edu.udistrital.singleton.view.AbstractIn;
import co.edu.udistrital.singleton.view.AbstractOut;
import co.edu.udistrital.singleton.view.AbstractViewFactory;

/**
 * Cliente Orquestador que oculta la complejidad y maneja las vistas.
 *
 * @author Manuel Salazar
 */
public class Client {

    private final AbstractIn entrada;
    private final AbstractOut salida;
    private final CajeroPool sucursal;

    public Client(AbstractViewFactory vista) {
        this.entrada = vista.getIn();
        this.salida = vista.getOut();
        // Inicializamos el Singleton del Pool en el orquestador
        this.sucursal = CajeroPool.getInstance();
    }

    // --- ENCAPSULACIÓN DE I/O ---
    public void show(String st) {
        this.salida.show(st);
    }

    public void showError(String e) {
        this.salida.showError(e);
    }

    // Adaptamos el método para que imprima el mensaje antes de leer
    public String readString(String mensaje) {
        this.show(mensaje);
        return this.entrada.getString();
    }

    // --- ENCAPSULACIÓN DEL SINGLETON ---
    public CajeroAutomaticoS getCajeroSingleton() {
        return CajeroAutomaticoS.getInstance();
    }

    // --- ENCAPSULACIÓN DEL OBJECT POOL ---
    public CajeroAutomatico acquireCajeroFromPool() {
        CajeroAutomatico cajero = this.sucursal.acquire();
        if (cajero == null) {
            this.showError(">> ❌ Error: Todos los cajeros ocupados. Debe hacer fila.");
        }
        return cajero;
    }

    public void releaseCajeroToPool(CajeroAutomatico cajero) {
        if (cajero != null) {
            this.sucursal.release(cajero);
            this.show(">> Cajero [" + cajero.getNumeroSerie() + "] liberado exitosamente.");
        }
    }

    // --- VALIDACIONES ---
    public void verificarIdentidadEnMemoria(Object c1, Object c2) {
        this.show("¿Son el mismo objeto en memoria?: " + (c1 == c2));
    }
}
