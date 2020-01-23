package wirtualny.swiat;

import wirtualny.swiat.organizm.Organizm;
import wirtualny.swiat.organizm.roslina.*;
import wirtualny.swiat.organizm.zwierze.*;

import java.util.*;

public class WirtualnySwiat {
    // zmien na private!
    public Organizm[][] organizmy;
    private List<Organizm> kolejnoscOrganizmow = new ArrayList<Organizm>();
    private List<Organizm> organizmyDoUsuniecia = new ArrayList<Organizm>();
    private int rozmiar;
    int iloscOrganizmow;
    private int tura;

    public WirtualnySwiat(int rozmiar, int iloscOrganizmow) {
        this.rozmiar = rozmiar;
        this.iloscOrganizmow = iloscOrganizmow;

        organizmy = new Organizm[rozmiar][rozmiar];

        // tworze randomowe organizmy w randomowych polach

        int i = iloscOrganizmow;
        Random generator = new Random();
        while (i > 0) {
            int x = generator.nextInt(rozmiar);
            int y = generator.nextInt(rozmiar);
            if (organizmy[x][y] == null) {
                int wylosowanyOrganizm = generator.nextInt(8) + 1;
                switch (wylosowanyOrganizm) {
                    case 1:
                        organizmy[x][y] = new Ciern(x, y, this);
                        // dalszy kod
                        break;

                    case 2:
                        organizmy[x][y] = new Dzik(x, y, this);
                        // dalszy kod
                        break;

                    case 3:
                        organizmy[x][y] = new Guarana(x, y, this);
                        // dalszy kod
                        break;

                    case 4:
                        organizmy[x][y] = new Lew(x, y, this);
                        // dalszy kod
                        break;

                    case 5:
                        organizmy[x][y] = new Owca(x, y, this);
                        // dalszy kod
                        break;

                    case 6:
                        organizmy[x][y] = new Trawa(x, y, this);
                        // dalszy kod
                        break;

                    case 7:
                        organizmy[x][y] = new Wilk(x, y, this);
                        // dalszy kod
                        break;

                    case 8:
                        organizmy[x][y] = new Zmija(x, y, this);
                        // dalszy kod
                        break;

                    default:
                        break;
                }
            }
            i -= 1;
        }
        ustalKolejnosc();
    }

    public void wykonajTure()
    {
        tura++;
        int tabSize = kolejnoscOrganizmow.size() - 1;
        for (int i = 0; i < tabSize; i++) {
            if (!kolejnoscOrganizmow.get(i).getDoUsuniecia()) kolejnoscOrganizmow.get(i).akcja();
            kolejnoscOrganizmow.get(i).increaseWiek();
        }

        // usun organizmy jezeli sa jakies do usuniecia
        if (!organizmyDoUsuniecia.isEmpty())
            for (Organizm i : organizmyDoUsuniecia)
            {
                kolejnoscOrganizmow.remove(i);
            }
        organizmyDoUsuniecia.clear();
        kolejnoscOrganizmow.sort(Organizm::compareTo);
    }

    public void rysujSwiat()
    {
        {
            System.out.println();
            for (int i = rozmiar - 1; i >= 0; i--)
            {
                for (int j = 0; j < rozmiar; j++)
                {
                    if (organizmy[j][i] == null) System.out.print('0');//cout << '0';
                    else
                    {
                        System.out.print(organizmy[j][i].getZnak());
//                        cout << organizmy[j][i]->getZnak();
                    }
                }
                System.out.println();
            }
            System.out.println();
        }

    }
    public void usunOrganizm(int x, int y)
    {
        organizmyDoUsuniecia.add(organizmy[x][y]);
        organizmy[x][y].setDoUsuniecia();
        organizmy[x][y] = null;
    }


    public void ustalKolejnosc()
    {
        for (int i = 0; i < rozmiar; i++)
        {
            for (int j = 0; j < rozmiar; j++)
            {
                if (organizmy[i][j] != null)
                {
                    kolejnoscOrganizmow.add(organizmy[i][j]);
                }
            }
        }
        kolejnoscOrganizmow.sort(Organizm::compareTo);
    }

    public boolean zajetoscPola(int x, int y)
    {
        if(czyWGranicy(x, y)) return organizmy[x][y] != null;
        return true;
    } // true jezeli pole zajete lub pole wybiega poza tablice swiata

    public boolean czyWGranicy(int x, int y)
    {
        return !(x >= rozmiar || x < 0 ||
                y >= rozmiar || y < 0);
    }

    public void createOrganizm(int x, int y, char znak)
    {
        switch (znak)
        {
            case 'C':
                organizmy[x][y] = new Ciern(x, y, this);
                // dalszy kod
                break;

            case 'D':
                organizmy[x][y] = new Dzik(x, y, this);
                // dalszy kod
                break;

            case 'G':
                organizmy[x][y] = new Guarana(x, y, this);
                // dalszy kod
                break;

            case 'L':
                organizmy[x][y] = new Lew(x, y, this);
                // dalszy kod
                break;

            case 'O':
                organizmy[x][y] = new Owca(x, y, this);
                // dalszy kod
                break;

            case 'T':
                organizmy[x][y] = new Trawa(x, y, this);
                // dalszy kod
                break;

            case 'W':
                organizmy[x][y] = new Wilk(x, y, this);
                // dalszy kod
                break;

            case 'Z':
                organizmy[x][y] = new Zmija(x, y, this);
                // dalszy kod
                break;

            default:
                break;
        }

        kolejnoscOrganizmow.add(organizmy[x][y]);
        System.out.print("Utworzono nowy organizm: " + organizmy[x][y].getNazwa() +
                ". Jego pole to: [" + x + "][" + y + "].\n");
    }

    // GETTERS

    public Organizm getOrganizm(int x, int y){return organizmy[x][y];}
    public int getRozmiar(){return rozmiar;}
    public int getTura(){return tura;}

    // SETTERS

    public void setOrganizm(int x, int y, int nowyX, int nowyY)
    {
        if(organizmy[nowyX][nowyY] != null)
        {
            usunOrganizm(nowyX, nowyY); // organizmy[nowyX][nowyY] = null
        }
        organizmy[nowyX][nowyY] = organizmy[x][y];
        organizmy[x][y] = null;
    }


//    public
}


