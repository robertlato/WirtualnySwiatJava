package wirtualny.swiat.organizm.roslina;

import wirtualny.swiat.WirtualnySwiat;
import wirtualny.swiat.organizm.Organizm;

final public class Guarana extends Roslina
{
    public Guarana(int x, int y, WirtualnySwiat swiat)
    {
        znak = 'G';
        sila = 0;
        inicjatywa = 0;
        polozenieX = x;
        polozenieY = y;
        aktualnySwiat = swiat;
    }

    @Override
    public void kolizja(int nowyX, int nowyY)
{
    Organizm przeciwnik = aktualnySwiat.getOrganizm(nowyX, nowyY);
    System.out.print( przeciwnik.getNazwa() + " [" + przeciwnik.getPolozenieX()
            + "][" + przeciwnik.getPolozenieY() + "] zjada Guarane ["
            + polozenieX + "][" + polozenieY + "], zajmuje jej pole i otrzymuje +3 do sily.\n");
    przeciwnik.increaseSila(3);
    aktualnySwiat.setOrganizm(przeciwnik.getPolozenieX(), przeciwnik.getPolozenieY(), nowyX, nowyY);
    przeciwnik.setPolozenieX(nowyX);
    przeciwnik.setPolozenieY(nowyY);
}


    public String getNazwa(){return ("Guarana");}
}
