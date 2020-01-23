package wirtualny.swiat.organizm.zwierze;

import wirtualny.swiat.WirtualnySwiat;

final public class Wilk extends Zwierze
{
    public Wilk(int x, int y, WirtualnySwiat swiat)
    {
        znak = 'W';
        sila = 9;
        inicjatywa = 5;
        polozenieX = x;
        polozenieY = y;
        aktualnySwiat = swiat;
    }

    public String getNazwa(){return ("Wilk");}

}
