package co.edu.udistrital.builder.modelo;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class ArchiveReaderBuilder implements ReaderBuilder {

    private MyBufferedReader reader;
    private String path;

    // El especialista pide lo que necesita al instanciarse
    public ArchiveReaderBuilder(String path) {
        this.path = path;
    }

    @Override
    public void reset() {
        this.reader = new MyBufferedReader();
    }

    @Override
    public void buildBufferSize(int size) {
        this.reader.allocateBuffer(size);
    }

    @Override
    public void buildDataSource() throws Exception {
        // El Builder asume la responsabilidad de crear la conexión física
        FileInputStream fis = new FileInputStream(this.path);
        InputStreamReader isr = new InputStreamReader(fis, StandardCharsets.UTF_8);
        this.reader.setDataSource(isr); // Inyectamos el hermano menor
    }

    @Override
    public MyBufferedReader getResult() {
        return this.reader;
    }
}
