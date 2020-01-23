package wirtualny.swiat.organizm.zwierze;

import wirtualny.swiat.WirtualnySwiat;
import wirtualny.swiat.organizm.Organizm;

import javax.swing.*;
import java.awt.*;

final public class Zmija extends Zwierze
{
    public Zmija(int x, int y, WirtualnySwiat swiat)
    {
        znak = 'Z';
        kolor = Color.CYAN;
        sila = 2;
        inicjatywa = 3;
        polozenieX = x;
        polozenieY = y;
        aktualnySwiat = swiat;
    }

    @Override
    public void kolizja(int nowyX, int nowyY)
{
    Organizm przeciwnik = aktualnySwiat.getOrganizm(nowyX, nowyY);
    super.kolizja(nowyX, nowyY);
    if (getDoUsuniecia()) // zmija przegrala pojedynek z przeciwnikiem
    {
        aktualnySwiat.usunOrganizm(nowyX, nowyY);
        aktualnySwiat.panelRaportow.add(new JLabel(przeciwnik.getNazwa() + " [" + przeciwnik.getPolozenieX()
                + "][" + przeciwnik.getPolozenieY() + "] umiera w wyniku zatrucia przez zmije ["
                + polozenieX + "][" + polozenieY + "]\n"));
    }
}

    @Override
    public Color getColor()
    {
        return kolor;
    }


    public String getNazwa(){return ("Zmija");}

}
