package wirtualny.swiat.organizm.zwierze;

import wirtualny.swiat.WirtualnySwiat;

final public class Dzik extends Zwierze
{
    public Dzik(int x, int y, WirtualnySwiat swiat)
    {
        znak = 'D';
        sila = 8;
        inicjatywa = 6;
        polozenieX = x;
        polozenieY = y;
        aktualnySwiat = swiat;
    }

    public String getNazwa(){return ("Dzik");}
}
