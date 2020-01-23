package wirtualny.swiat.organizm.zwierze;

import wirtualny.swiat.WirtualnySwiat;

final public class Owca extends Zwierze
{
    public Owca(int x, int y, WirtualnySwiat swiat)
    {
        znak = 'O';
        sila = 4;
        inicjatywa = 4;
        polozenieX = x;
        polozenieY = y;
        aktualnySwiat = swiat;

    }

    public String getNazwa(){return ("Owca");}
}
