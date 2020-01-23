package wirtualny.swiat.organizm.roslina;

import wirtualny.swiat.WirtualnySwiat;

import java.awt.*;

final public class Trawa extends Roslina
{
    public Trawa(int x, int y, WirtualnySwiat swiat)
    {
        znak = 'T';
        kolor = Color.GREEN;
        sila = 0;
        inicjatywa = 0;
        polozenieX = x;
        polozenieY = y;
        aktualnySwiat = swiat;
    }

    @Override
    public Color getColor() {
        return kolor;
    }

    public String getNazwa(){return ("Trawa");}

}
