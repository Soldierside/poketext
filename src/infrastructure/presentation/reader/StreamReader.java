package infrastructure.presentation.reader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StreamReader {

    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    public static String read() {
        String readed = null;

        try {
            System.out.print("Introdueix una opció: ");
            readed = (in.readLine().trim()).replaceAll("\\s+", " ");
        } catch (IOException e) {
            e.printStackTrace();
        }

        return readed;
    }
}
