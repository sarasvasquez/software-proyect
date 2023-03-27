import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class ExcelWriter {
    public static void main(String[] args) throws IOException {
        // Crea un nuevo archivo de Excel
        File file = new File("datos.xlsx");

        // Crea una hoja en el archivo
        String[] header = { "Nombre", "Edad" };
        String[][] data = new String[3][2];

        // Agrega datos a la hoja
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                System.out.printf("Ingrese %s para el usuario %d: ", header[j], i+1);
                data[i][j] = scanner.nextLine();
            }
        }
        scanner.close();

        // Guarda el archivo de Excel en el disco
        FileOutputStream outputStream = new FileOutputStream(file);
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < header.length; i++) {
            stringBuilder.append(header[i]).append("\t");
        }
        stringBuilder.append("\n");
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                stringBuilder.append(data[i][j]).append("\t");
            }
            stringBuilder.append("\n");
        }
        outputStream.write(stringBuilder.toString().getBytes());
        outputStream.close();
    }
}
