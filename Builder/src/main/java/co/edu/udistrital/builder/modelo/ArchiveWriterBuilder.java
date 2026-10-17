package co.edu.udistrital.builder.modelo;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

public class ArchiveWriterBuilder implements WriterBuilder {

    private MyBufferedWriter writer;
    private String path;
    private boolean append; // ¿Sobrescribir o añadir?

    public ArchiveWriterBuilder(String path, boolean append) {
        this.path = path;
        this.append = append;
    }

    @Override
    public void reset() {
        this.writer = new MyBufferedWriter();
    }

    @Override
    public void buildBufferSize(int size) {
        this.writer.allocateBuffer(size);
    }

    @Override
    public void buildDataSource() throws Exception {
        // Le pasamos el modoAñadir al FileOutputStream
        FileOutputStream fos = new FileOutputStream(this.path, this.append);
        OutputStreamWriter osw = new OutputStreamWriter(fos, StandardCharsets.UTF_8);
        this.writer.setDataSource(osw);
    }

    @Override
    public MyBufferedWriter getResult() {
        return this.writer;
    }
}
