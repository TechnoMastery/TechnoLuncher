package net.minheur.technolauncher.tabs;

import javax.swing.*;

public enum Tabs {
    POTO_FLUX("PotoFlux", PotoFluxTab.class),
    TECHNO_MASTERY_MODPACK("TechnoMastery", TechnoMasteryModpackTab.class);

    private final String name;
    private final Class<? extends LauncherTab> associatedClass;

    Tabs(String name, Class<? extends LauncherTab> associatedClass) {
        this.name = name;
        this.associatedClass = associatedClass;
    }

    public String getName() {
        return name;
    }

    public Class<? extends LauncherTab> getAssociatedClass() {
        return associatedClass;
    }

    public LauncherTab createInstance() {
        try {
            return associatedClass.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erreur lors de la création de l'onglet " + name + " : " + e.getMessage());
            return null;
        }
    }
}
