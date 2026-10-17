package co.edu.udistrital.builder.modelo;

import java.io.IOException;
import java.io.Reader;

/**
 *
 * @author Manuel Salazar
 * @version 1
 */
public class MyBufferedReader extends Reader {

    private Reader dataSource;

    private char[] buffer;
    private int poss;
    private int validLim;

    public MyBufferedReader() {
    }

    // ==========================================
    // SETTERS PARA EL PATRÓN BUILDER
    // ==========================================
    public void setDataSource(Reader dataSource) {
        this.dataSource = dataSource;
    }

    public void allocateBuffer(int size) {
        this.buffer = new char[size];
        this.poss = 0;
        this.validLim = 0;
    }

    // ==========================================
    // EL CORAZÓN DEL BUFFER (Sobrescribiendo métodos de Reader)
    // ==========================================
    // Método que lee UNA sola letra
    @Override
    public int read() throws IOException {

        if (poss >= validLim) {
            validLim = dataSource.read(buffer, 0, buffer.length);
            poss = 0;

            if (validLim == -1) {
                return -1;
            }
        }
        char letra = buffer[poss];
        poss++;

        return letra;
    }

    @Override
    public int read(char[] cbuf, int off, int len) throws IOException {
        return -1;
    }

    @Override
    public void close() throws IOException {
        if (dataSource != null) {
            dataSource.close();
        }
        buffer = null;
    }

    public String nextLine() throws IOException {
        StringBuilder sb = new StringBuilder();
        int inicioTramo = this.poss;
        int longTramo = 0;

        while (true) {
            if (poss >= validLim) {

                if (longTramo > 0) {
                    sb.append(buffer, inicioTramo, longTramo);
                }

                validLim = dataSource.read(buffer, 0, buffer.length);
                this.poss = 0;
                longTramo = 0;
                inicioTramo = 0;

                if (validLim == -1) {
                    if (sb.length() == 0) {
                        return null;
                    }
                    break;
                }
            }

            char letra = buffer[poss];
            poss++;

            if (letra == '\n') {
                if (longTramo > 0) {
                    sb.append(buffer, inicioTramo, longTramo);
                }
                break;
            }

            longTramo++;
        }
        return sb.toString().replace("\r", "");
    }

    /*Ready() - Verifica si hay algo por leer ene le archivo o en el bufer - 
        Pensar como hacer la lectura del archivo, si esto implica traer datos del 
        arhcivo hacia el buffer
    
    skip(long n) - salta n caracteres del archivo - debe haber validacion de si 
        el archivo tiene esa cantidad de caracteres, corroborar si  es necesario 
        traer mas caracteres al bufer en caso de que n supere el tamaño del buffer 
        o los restantes en este.
    
    mark(int lim) y reset() - Crea un punto de restauracion para el puntero del 
        archivo y una forma de volver a el, corroborar si hace falta devolverse 
        a puntos del archvio si el punto de guardado queda atras del bufer o en 
        estados previos del bufer.
    
    
    */
}
