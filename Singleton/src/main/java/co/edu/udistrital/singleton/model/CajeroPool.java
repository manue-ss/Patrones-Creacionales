package co.edu.udistrital.singleton.model;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Implementación del Object Pool (que a su vez es Singleton).
 * @author Manuel Salazar
 */
public class CajeroPool {
    private static CajeroPool instancia;
    private final Queue<CajeroAutomatico> disponibles;
    private final int CAPACIDAD_MAXIMA = 4; // Sucursal pequeña de 2 cajeros
    private int cajerosCreados = 0;

    private CajeroPool() {
        this.disponibles = new LinkedList<>();
    }

    public static CajeroPool getInstance() {
        if (instancia == null) {
            instancia = new CajeroPool();
        }
        return instancia;
    }

    public CajeroAutomatico acquire() {
        CajeroAutomatico cajero = disponibles.poll();

        if (cajero == null) {
            if (cajerosCreados < CAPACIDAD_MAXIMA) {
                cajero = new CajeroAutomatico();
                cajerosCreados++;
            } else {
                return null;
            }
        }
        return cajero;
    }

    public void release(CajeroAutomatico cajero) {
        if (cajero != null) {
            disponibles.offer(cajero);
        }
    }
}