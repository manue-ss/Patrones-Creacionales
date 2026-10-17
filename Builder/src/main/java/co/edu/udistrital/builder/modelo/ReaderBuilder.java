package co.edu.udistrital.builder.modelo;

public interface ReaderBuilder {
    void reset();
    void buildBufferSize(int tamano);
    void buildDataSource() throws Exception;    MyBufferedReader getResult();
}