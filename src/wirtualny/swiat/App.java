/**
 *  Symulator wirtualnego swiata, LAB OTWARTE JPO
 *  Zwierzeta: wilk, owca, lew, zmija, dzik
 *  Rosliny: trawa, guarana, ciern
 *
 *
 * @author  Robert Latoszewski
 * @version 1.0
 * @since   2020-01-24
 */

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
