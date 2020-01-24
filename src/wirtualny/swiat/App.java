package wirtualny.swiat;

import javax.swing.*;

public class App {

    public static void main(String[] args)
    {
        try
        {
            // Set cross-platform Java Look&Feel (also called "Metal")
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        }
        catch (UnsupportedLookAndFeelException | ClassNotFoundException | InstantiationException | IllegalAccessException e)
        {
            // handle exception
        }

        MyFrame Frame = new MyFrame();
        WirtualnySwiat pierwszySwiat = new WirtualnySwiat(20, 20, Frame);
        pierwszySwiat.rysujSwiat();
    }
}
