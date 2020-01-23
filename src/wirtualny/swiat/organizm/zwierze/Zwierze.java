package wirtualny.swiat.organizm.zwierze;

import wirtualny.swiat.WirtualnySwiat;
import wirtualny.swiat.organizm.Organizm;

import javax.swing.*;
import java.util.Random;

abstract public class Zwierze extends Organizm
{

    //public String getNazwa(){return null;}
    public void akcja()
    {
        // WYBIERAM NOWE WSPOLRZEDNE
        Random generator = new Random();
        int rozmiarSwiata = aktualnySwiat.getRozmiar();
        int nowyX = rozmiarSwiata;
        int nowyY = rozmiarSwiata;

        while(!aktualnySwiat.czyWGranicy(nowyX, nowyY))
        {
            // wyrazenie daje nam 3 wartosci: n-1, n, n+1
            nowyX = generator.nextInt(3) + (polozenieX - 1);
            nowyY = generator.nextInt(3) + (polozenieY - 1);
        }

        // NOWE POLE JEST WOLNE
        if (aktualnySwiat.getOrganizm(nowyX, nowyY) == null)
        {
            aktualnySwiat.setOrganizm(polozenieX, polozenieY, nowyX, nowyY);
            polozenieX = nowyX;
            polozenieY = nowyY;
            //this->setPolozenie(nowyX, nowyY); // zapisuje zmiane polozenia w polach organizmu
        }

        // ORGANIZM NIE RUSZYL SIE W TEJ TURZE
        else if (nowyX == polozenieX && nowyY == polozenieY){}

        // NOWE POLE JEST ZAJETE
        else
            kolizja(nowyX, nowyY);


    }

    @Override
    public void kolizja(int nowyX, int nowyY)
    {
        Organizm przeciwnik = aktualnySwiat.getOrganizm(nowyX, nowyY);
        if (przeciwnik.getNazwa().equals("Lew") && getSila() < 5) {}
        else if (przeciwnik.getNazwa().equals("Guarana"))
        {
            przeciwnik.kolizja(polozenieX, polozenieY);
        }
        else
        {

            // ROZMNAZANIE
            if (getNazwa().equals(przeciwnik.getNazwa()))
            {
                // sprawdz po kolei zajetosc pol, nowy organizm przypisz do pierwszego wolnego pola
                boolean gotowe = false;
                for (int i = -1; i < 2; i++)
                {
                    for (int j = -1; j < 2; j++)
                    {
                        if (!aktualnySwiat.zajetoscPola(polozenieX + i, polozenieY + j))
                        {
                            aktualnySwiat.createOrganizm(polozenieX + i, polozenieY + j, getZnak());
                            gotowe = true;
                            break;
                        }
                        else if(!aktualnySwiat.zajetoscPola(przeciwnik.getPolozenieX() + i,
                            przeciwnik.getPolozenieY() + j))
                        {
                            aktualnySwiat.createOrganizm(przeciwnik.getPolozenieX() + i,
                                przeciwnik.getPolozenieY() + j, getZnak());
                            gotowe = true;
                            break;
                        }
                    }
                    if (gotowe) break;
                }
            }

            //ATAKUJACY WYGRYWA
            else if (sila >= przeciwnik.getSila())
            {
                aktualnySwiat.panelRaportow.add(new JLabel(getNazwa() + " [" + polozenieX + "]["
                        + polozenieY + "] wygrywa pojedynek z "
                        + przeciwnik.getNazwa()
                        + " [" + przeciwnik.getPolozenieX()
                        + "][" + przeciwnik.getPolozenieY()
                        +"]. Pole wygranego to: [" + nowyX + "][" + nowyY + "]\n"));

                aktualnySwiat.setOrganizm(polozenieX, polozenieY, nowyX, nowyY);
                polozenieX = nowyX;
                polozenieY = nowyY;

            }
            // ATAKUJACY PRZEGRYWA
        else
            {
                aktualnySwiat.panelRaportow.add(new JLabel(getNazwa() + " [" + polozenieX + "]["
                        + polozenieY + "] przegrywa pojedynek z "
                        + przeciwnik.getNazwa()
                        + " [" + przeciwnik.getPolozenieX() + "]["
                        + przeciwnik.getPolozenieY() + "],  i zwalnia swoje pole. " +
                        "Pole wygranego to: [" + przeciwnik.getPolozenieX() + "]["
                        + przeciwnik.getPolozenieY() + "]\n"));

                aktualnySwiat.usunOrganizm(polozenieX, polozenieY);
            }
        }

    }

}
