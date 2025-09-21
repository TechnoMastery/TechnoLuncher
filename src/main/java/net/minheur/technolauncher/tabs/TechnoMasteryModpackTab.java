package net.minheur.technolauncher.tabs;

import net.minheur.technolauncher.LauncherTab;

import javax.swing.*;

public class TechnoMasteryModpackTab extends LauncherTab {
    @Override
    protected void setPanel() {
        PANEL.add(new JLabel("Download TechnoMastery on curseforge"));
    }
}
