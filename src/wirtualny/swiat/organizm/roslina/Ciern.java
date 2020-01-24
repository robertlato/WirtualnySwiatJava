package wirtualny.swiat.organizm.roslina;

import wirtualny.swiat.WirtualnySwiat;

import java.awt.*;

final public class Ciern extends Roslina
{

    public Ciern(int x, int y, WirtualnySwiat swiat)
    {
        znak = 'C';
        id = 8;
        kolor = Color.PINK;
        sila = 2;
        inicjatywa = 0;
        polozenieX = x;
        polozenieY = y;
        aktualnySwiat = swiat;
    }

    @Override
    public Color getColor() {
        return kolor;
    }

    public String getNazwa(){return ("Ciern");}

}
