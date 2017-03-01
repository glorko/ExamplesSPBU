package net.punklan.glorfindeil.study.lesson2;

import java.io.*;
import java.net.URL;
import java.nio.charset.Charset;

/**
 * Created by Aleksandr_Kichev on 28-Feb-17.
 */
public class InputOutputExample {
    public static void main(String[] args) throws IOException {
        URL url = Thread.currentThread().getContextClassLoader().getResource("test_data.txt");
        File file = new File(url.getPath());
        File out = new File("Output.txt");
        if (out.exists()) out.delete();
        out.createNewFile();
        OutputStream outputStream = new FileOutputStream(out);
        String line;
        try (
                InputStream fis = new FileInputStream(file);
                InputStreamReader isr = new InputStreamReader(fis, Charset.forName("UTF-8"));
                BufferedReader br = new BufferedReader(isr);
        ) {
            while ((line = br.readLine()) != null) {
                String[] splitted = line.split(" ");
                for (String sp : splitted) {
                    outputStream.write((sp + "\n").getBytes());
                }
                outputStream.write("-----\n".getBytes());
            }
        }
        outputStream.flush();
        outputStream.close();
    }
}
