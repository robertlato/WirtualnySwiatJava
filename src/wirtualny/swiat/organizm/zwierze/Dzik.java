package wirtualny.swiat.organizm.zwierze;

import wirtualny.swiat.WirtualnySwiat;

import java.awt.*;

final public class Dzik extends Zwierze
{
    public Dzik(int x, int y, WirtualnySwiat swiat)
    {
        znak = 'D';
        id = 5;
        kolor = Color.ORANGE;
        sila = 8;
        inicjatywa = 6;
        polozenieX = x;
        polozenieY = y;
        aktualnySwiat = swiat;
    }

    @Override
    public Color getColor() {
        return kolor;
    }

    public String getNazwa(){return ("Dzik");}
}
