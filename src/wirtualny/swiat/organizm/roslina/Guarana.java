package wirtualny.swiat.organizm.roslina;

import wirtualny.swiat.WirtualnySwiat;
import wirtualny.swiat.organizm.Organizm;

import javax.swing.*;
import java.awt.*;

final public class Guarana extends Roslina
{
    public Guarana(int x, int y, WirtualnySwiat swiat)
    {
        znak = 'G';
        kolor = Color.RED;
        sila = 0;
        inicjatywa = 0;
        polozenieX = x;
        polozenieY = y;
        aktualnySwiat = swiat;
    }

    @Override
    public void kolizja(int nowyX, int nowyY)
{
    Organizm przeciwnik = aktualnySwiat.getOrganizm(nowyX, nowyY);
    aktualnySwiat.panelRaportow.add(new JLabel(przeciwnik.getNazwa() + " [" + przeciwnik.getPolozenieX()
            + "][" + przeciwnik.getPolozenieY() + "] zjada Guarane ["
            + polozenieX + "][" + polozenieY + "], zajmuje jej pole i otrzymuje +3 do sily.\n"));
    przeciwnik.increaseSila(3);
    aktualnySwiat.setOrganizm(przeciwnik.getPolozenieX(), przeciwnik.getPolozenieY(), nowyX, nowyY);
    przeciwnik.setPolozenieX(nowyX);
    przeciwnik.setPolozenieY(nowyY);
}

    @Override
    public Color getColor() {
        return kolor;
    }


    public String getNazwa(){return ("Guarana");}
}
