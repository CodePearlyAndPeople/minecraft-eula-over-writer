import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;

public class CreateEULAFile {
    public static void main(String[] args) {
        // The content to write to the file
        String content = "# By changing the setting below to TRUE you are indicating your agreement to our EULA (https://aka.ms/MinecraftEULA).\n"
                       + "# Date: " + LocalDate.now() + "\n"
                       + "eula=true";

        // File path
        String fileName = "eula.txt";

        // Create or overwrite the file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write(content);
            System.out.println("File " + fileName + " has been created/overwritten successfully.");
            System.out.println("By doing this action you are indicating your agreement to mojang's EULA (https://aka.ms/MinecraftEULA).");
        } catch (IOException e) {
            System.err.println("An error occurred while creating or writing to the file: " + e.getMessage());
        }
    }
}
