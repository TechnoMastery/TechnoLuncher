package net.minheur.technolauncher.tabs;

import javax.swing.*;

public abstract class LauncherTab {
    protected final JPanel PANEL = new JPanel();

    public LauncherTab() {
        PANEL.setLayout(new BoxLayout(PANEL, BoxLayout.Y_AXIS));
        setPanel();
    }

    protected abstract void setPanel();

    public JPanel getPanel() {
        return PANEL;
    }

}
