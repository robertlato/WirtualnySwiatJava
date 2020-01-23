package wirtualny.swiat.organizm.roslina;

import wirtualny.swiat.WirtualnySwiat;

final public class Trawa extends Roslina
{
    public Trawa(int x, int y, WirtualnySwiat swiat)
    {
        znak = 'T';
        sila = 0;
        inicjatywa = 0;
        polozenieX = x;
        polozenieY = y;
        aktualnySwiat = swiat;
    }

    public String getNazwa(){return ("Trawa");}

}
