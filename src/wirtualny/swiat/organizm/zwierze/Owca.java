package wirtualny.swiat.organizm.zwierze;

import wirtualny.swiat.WirtualnySwiat;

import java.awt.*;

final public class Owca extends Zwierze
{
    public Owca(int x, int y, WirtualnySwiat swiat)
    {
        znak = 'O';
        id = 3;
        kolor = Color.BLACK;
        sila = 4;
        inicjatywa = 4;
        polozenieX = x;
        polozenieY = y;
        aktualnySwiat = swiat;

    }

    @Override
    public Color getColor() {
        return kolor;
    }

    public String getNazwa(){return ("Owca");}
}
