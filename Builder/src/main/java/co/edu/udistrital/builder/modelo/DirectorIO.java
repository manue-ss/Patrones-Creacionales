package co.edu.udistrital.builder.modelo;

/**
 *
 * @author Manuel Salazar
 * @version 1
 */
public class DirectorIO {

    public void buildStandardReader(ReaderBuilder builder) throws Exception {
        builder.reset();
        builder.buildBufferSize(8192);
        builder.buildDataSource();
    }

    public void buildMassiveReader(ReaderBuilder builder) throws Exception {
        builder.reset();
        builder.buildBufferSize(1024 * 128);
        builder.buildDataSource();
    }

    public void buildStandardWriter(WriterBuilder builder) throws Exception {
        builder.reset();
        builder.buildBufferSize(8192);
        builder.buildDataSource();
    }
    
    
}
