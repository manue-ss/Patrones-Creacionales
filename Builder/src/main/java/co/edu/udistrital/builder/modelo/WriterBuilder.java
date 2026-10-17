package co.edu.udistrital.builder.modelo;

public interface WriterBuilder {
    void reset();
    void buildBufferSize(int tamano);
    void buildDataSource() throws Exception;
    MyBufferedWriter getResult();
}