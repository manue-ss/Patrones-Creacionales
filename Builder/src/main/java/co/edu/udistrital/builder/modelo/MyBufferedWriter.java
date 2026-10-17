package co.edu.udistrital.builder.modelo;

import java.io.IOException;
import java.io.Writer;

/**
 *
 * @author Manuel Salazar
 * @version 1
 */
public class MyBufferedWriter extends Writer {

    private Writer dataSource;

    private char[] buffer;
    private int poss;

    public MyBufferedWriter() {
    }

    // ==========================================
    // SETTERS PARA EL PATRÓN BUILDER
    // ==========================================
    public void setDataSource(Writer dataSource) {
        this.dataSource = dataSource;
    }

    public void allocateBuffer(int size) {
        this.buffer = new char[size];
        this.poss = 0;
    }

    // ==========================================
    // MÉTODO PRIVADO: EL NÚCLEO DEL BUFFER
    // ==========================================
    private void emptyToDisk() throws IOException {
        // Solo viajamos al disco si realmente hay algo en la carretilla
        if (poss > 0) {
            dataSource.write(buffer, 0, poss);
            poss = 0; // Reiniciamos el cursor de la carretilla
        }
    }

    // ==========================================
    // EL CORAZÓN DEL BUFFER (Sobrescribiendo métodos de Writer)
    // ==========================================
    
    // Método que escribe UNA sola letra (en memoria RAM)
    @Override
    public void write(int c) throws IOException {
        // Si el arreglo está lleno, hacemos el viaje pesado al disco
        if (poss >= buffer.length) {
            emptyToDisk();
        }
        
        // Asignamos en RAM de forma instantánea
        buffer[poss] = (char) c;
        poss++;
    }

    // El contrato de Writer nos obliga a implementar este método
    @Override
    public void write(char[] cbuf, int off, int len) throws IOException {
        // Reutilizamos nuestra lógica segura enviando carácter por carácter a la RAM
        for (int i = 0; i < len; i++) {
            this.write(cbuf[off + i]);
        }
    }

    @Override
    public void flush() throws IOException {
        // 1. Vaciamos nuestra carretilla de RAM al obrero físico
        emptyToDisk();
        // 2. Obligamos al obrero físico a soltar los datos hacia el Sistema Operativo
        if (dataSource != null) {
            dataSource.flush();
        }
    }

    @Override
    public void close() throws IOException {
        // ¡REGLA DE ORO DEL WRITER! Jamás cerrar sin antes vaciar la carretilla
        this.flush();
        
        if (dataSource != null) {
            dataSource.close();
        }
        buffer = null; // Liberamos memoria
    }

    // ==========================================
    // EL SUPERPODER Y MÉTODOS DE COMODIDAD
    // ==========================================
    
    public void newLine() throws IOException {
        // System.lineSeparator() detecta automáticamente si estás en Windows (\r\n) 
        // o en Linux/Mac (\n) y devuelve el salto correcto.
        String salto = System.lineSeparator();
        for (int i = 0; i < salto.length(); i++) {
            this.write(salto.charAt(i));
        }
    }

    // Sobrecargamos write para aceptar Strings directamente (como hace el original)
    public void write(String str) throws IOException {
        for (int i = 0; i < str.length(); i++) {
            this.write(str.charAt(i));
        }
    }
}