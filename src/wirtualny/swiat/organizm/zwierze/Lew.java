package wirtualny.swiat.organizm.zwierze;

import wirtualny.swiat.WirtualnySwiat;

import java.awt.*;

final public class Lew extends Zwierze
{
    public Lew(int x, int y, WirtualnySwiat swiat)
    {
        znak = 'L';
        kolor = Color.YELLOW;
        sila = 11;
        inicjatywa = 7;
        polozenieX = x;
        polozenieY = y;
        aktualnySwiat = swiat;

    }

    @Override
    public Color getColor() {
        return kolor;
    }

    public String getNazwa(){return ("Lew");}

}
