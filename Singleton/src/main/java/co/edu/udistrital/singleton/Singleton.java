package co.edu.udistrital.singleton;

import co.edu.udistrital.singleton.controller.Client;
import co.edu.udistrital.singleton.model.CajeroAutomatico;
import co.edu.udistrital.singleton.model.CajeroAutomaticoS;
import co.edu.udistrital.singleton.view.ConsoleViewFactory;

/**
 * Super Cliente que ejecuta las pruebas.
 * @author 11man
 */
public class Singleton {

    public static void main(String[] args) {
        // 1. Inyectamos la vista de consola al cliente orquestador
        Client cliente = new Client(new ConsoleViewFactory());

        // ==========================================
        // PRUEBA 1: CAJERO SINGLETON
        // ==========================================
        cliente.show("\n=================================");
        cliente.show(" PRUEBA 1: CAJERO SINGLETON");
        cliente.show("=================================");

        String p1 = cliente.readString("Ingrese el nombre de la primera persona:");
        CajeroAutomaticoS cajeroA = cliente.getCajeroSingleton();
        cliente.show(">> " + p1 + " usa el cajero con Serial: " + cajeroA.getNumeroSerie());

        String p2 = cliente.readString("\nIngrese el nombre de la segunda persona:");
        CajeroAutomaticoS cajeroB = cliente.getCajeroSingleton();
        cliente.show(">> " + p2 + " usa el cajero con Serial: " + cajeroB.getNumeroSerie());

        cliente.show("\n[Validación en Memoria]: ¿Ambos usaron el mismo objeto exacto?");
        cliente.verificarIdentidadEnMemoria(cajeroA, cajeroB);

        // ==========================================
        // PRUEBA 2: OBJECT POOL
        // ==========================================
        cliente.show("\n=================================");
        cliente.show(" PRUEBA 2: OBJECT POOL (Máx 4 Cajeros)");
        cliente.show("=================================");

        // Llenamos la capacidad máxima de la Pool (4 cajeros según tu modelo)
        String p3 = cliente.readString("Ingrese el nombre del Cliente 1:");
        CajeroAutomatico cajero1 = cliente.acquireCajeroFromPool();
        if (cajero1 != null) cliente.show(">> " + p3 + " usa el cajero Serial: " + cajero1.getNumeroSerie());

        String p4 = cliente.readString("\nIngrese el nombre del Cliente 2:");
        CajeroAutomatico cajero2 = cliente.acquireCajeroFromPool();
        if (cajero2 != null) cliente.show(">> " + p4 + " usa el cajero Serial: " + cajero2.getNumeroSerie());

        String p5 = cliente.readString("\nIngrese el nombre del Cliente 3:");
        CajeroAutomatico cajero3 = cliente.acquireCajeroFromPool();
        if (cajero3 != null) cliente.show(">> " + p5 + " usa el cajero Serial: " + cajero3.getNumeroSerie());

        String p6 = cliente.readString("\nIngrese el nombre del Cliente 4:");
        CajeroAutomatico cajero4 = cliente.acquireCajeroFromPool();
        if (cajero4 != null) cliente.show(">> " + p6 + " usa el cajero Serial: " + cajero4.getNumeroSerie());

        // Este cliente fallará porque la sucursal solo permite 4
        String p7 = cliente.readString("\nIngrese el nombre del Cliente 5 (Excedente):");
        CajeroAutomatico cajero5 = cliente.acquireCajeroFromPool(); 
        
        // Liberamos el primer cajero
        cliente.show("\nLiberando el cajero de " + p3 + "...");
        cliente.releaseCajeroToPool(cajero1);

        // El cliente 5 vuelve a intentar
        cliente.show("\n" + p7 + " vuelve a intentar...");
        CajeroAutomatico cajeroReciclado = cliente.acquireCajeroFromPool();
        if (cajeroReciclado != null) cliente.show(">> " + p7 + " usa el cajero Serial: " + cajeroReciclado.getNumeroSerie());

        cliente.show("\n[Validación]: ¿" + p7 + " usó el mismo cajero físico que dejó " + p3 + "?");
        cliente.verificarIdentidadEnMemoria(cajero1, cajeroReciclado);
    }
}