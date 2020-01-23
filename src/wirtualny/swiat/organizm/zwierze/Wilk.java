package wirtualny.swiat.organizm.zwierze;

import wirtualny.swiat.WirtualnySwiat;

import java.awt.*;

final public class Wilk extends Zwierze
{
    public Wilk(int x, int y, WirtualnySwiat swiat)
    {
        znak = 'W';
        kolor = Color.GRAY;
        sila = 9;
        inicjatywa = 5;
        polozenieX = x;
        polozenieY = y;
        aktualnySwiat = swiat;
    }

    @Override
    public Color getColor() {
        return kolor;
    }

    public String getNazwa(){return ("Wilk");}

}
