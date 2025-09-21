package net.minheur.technolauncher;

import javax.swing.*;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesGetter {
    public final String version;

    public PropertiesGetter() {
        Properties props = new Properties();
        try (InputStream in = getClass().getClassLoader().getResourceAsStream("version.properties")) {
            props.load(in);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erreur lors du chargement du fichier properties !");
        }
        version = props.getProperty("version");
    }
}
