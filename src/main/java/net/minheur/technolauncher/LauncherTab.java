package net.minheur.technolauncher;

import javax.swing.*;
import java.awt.*;

public abstract class LauncherTab {
    protected final JPanel PANEL = new JPanel();

    public LauncherTab() {
        // PANEL.setBackground(Color.DARK_GRAY);
        setPanel();
    }

    protected abstract void setPanel();

    public JPanel getPanel() {
        return PANEL;
    }

}
