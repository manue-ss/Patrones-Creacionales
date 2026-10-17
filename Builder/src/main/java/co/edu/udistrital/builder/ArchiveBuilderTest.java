package co.edu.udistrital.builder;

import co.edu.udistrital.builder.controller.Client;
import co.edu.udistrital.builder.modelo.DirectorIO;
import co.edu.udistrital.builder.modelo.ArchiveReaderBuilder;
import co.edu.udistrital.builder.modelo.ArchiveWriterBuilder;
import co.edu.udistrital.builder.view.ConsoleViewFactory;

import javax.swing.JFileChooser;
import javax.swing.UIManager;
import java.io.File;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Manuel Salazar
 * @version 1
 */
public class ArchiveBuilderTest {

    static {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch (Exception e) {
            System.err.print(e.getMessage());
        }
    }

    public static void main(String[] args) {
        Client cliente = new Client(new DirectorIO(), new ConsoleViewFactory());

        cliente.printLn("Abriendo explorador para seleccionar el origen...");
        String pathEntrada = getPath("Seleccione el archivo a Copiar", false);

        if (pathEntrada == null) {
            cliente.printErr(">> Operación cancelada por el usuario o fallida.");
            cliente.printLn("Saliendo...");

            return;
        }

        cliente.printLn("Abriendo explorador para seleccionar el destino...");
        String pathSalida = getPath("Seleccione dónde Guardar la copia", true);

        if (pathSalida == null) {
            cliente.printErr(">> Operación cancelada por el usuario o fallida.");
            cliente.printLn("Saliendo...");

            return;
        }

        cliente.configureReader(new ArchiveReaderBuilder(pathEntrada));
        cliente.configureWriter(new ArchiveWriterBuilder(pathSalida, false));

        cliente.printLn("Iniciando copiado...");

        String linea;
        while ((linea = cliente.nextLine()) != null) {
            cliente.writeLine(linea);
        }

        cliente.closeStreams();
        cliente.printLn("Copiado finalizado con éxito.");
    }

    /**
     * Método auxiliar para abrir la ventana del explorador de archivos.
     *
     * @param titulo    El texto que aparecerá en la parte superior de la
     *                  ventana.
     * @param esGuardar true si queremos la ventana de "Guardar como", false
     *                  para "Abrir".
     *
     * @return El String con la ruta absoluta del archivo, o null si se canceló.
     */
    private static String getPath(String titulo, boolean esGuardar) {
        JFileChooser explorador = new JFileChooser();
        explorador.setDialogTitle(titulo);

        explorador.setFileSelectionMode(JFileChooser.FILES_ONLY);

        FileNameExtensionFilter filtroTxt = new FileNameExtensionFilter("Archivos de Texto (*.txt)", "txt");
        explorador.setFileFilter(filtroTxt);

        explorador.setAcceptAllFileFilterUsed(false);

        int seleccion;
        if (esGuardar) {
            seleccion = explorador.showSaveDialog(null);
        } else {
            seleccion = explorador.showOpenDialog(null);
        }

        if (seleccion == JFileChooser.APPROVE_OPTION) {
            File archivoElegido = explorador.getSelectedFile();
            String rutaAbsoluta = archivoElegido.getAbsolutePath();
            
            if (esGuardar && !rutaAbsoluta.toLowerCase().endsWith(".txt")) {
                rutaAbsoluta += ".txt";
            }

            return rutaAbsoluta;
        }

        return null;
    }
}
