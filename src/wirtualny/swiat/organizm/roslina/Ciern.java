package wirtualny.swiat.organizm.roslina;

import wirtualny.swiat.WirtualnySwiat;

final public class Ciern extends Roslina
{

    public Ciern(int x, int y, WirtualnySwiat swiat)
    {
        znak = 'C';
        sila = 2;
        inicjatywa = 0;
        polozenieX = x;
        polozenieY = y;
        aktualnySwiat = swiat;
    }

    public String getNazwa(){return ("Ciern");}

}
