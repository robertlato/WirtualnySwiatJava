package wirtualny.swiat.organizm.roslina;

import wirtualny.swiat.organizm.Organizm;

import java.util.Random;

abstract public class Roslina extends Organizm
{
    public void akcja()
    {
        Random generator = new Random();
        int szansa = generator.nextInt(100);

        if(getNazwa().equals("Ciern")) szansa = 100;

        if (szansa > 80)
        {
            boolean gotowe = false;
            for (int i = -1; i < 2; i++)
            {
                for (int j = -1; j < 2; j++)
                {
                    // jezeli pole jest wolne i jest w granicy swiata to stworz nowy organizm
                    if (!aktualnySwiat.zajetoscPola(polozenieX + i,polozenieY + j))
                    {
                        aktualnySwiat.createOrganizm(polozenieX + i,polozenieY + j, getZnak());
                        gotowe = true;
                        break;
                    }
                }
                if (gotowe) break;
            }
        }
    }

    public void kolizja(int nowyX, int nowyY){}


}
