package wirtualny.swiat.organizm;

import wirtualny.swiat.WirtualnySwiat;

import java.awt.*;

abstract public class Organizm implements Comparable<Organizm>
{
    abstract public void akcja();

    abstract public void kolizja(int nowyX, int nowyY);

    abstract public Color getColor();

    @Override
    public int compareTo(Organizm drugi)
    {
        return (drugi.getPierwszenstwo() - this.getPierwszenstwo());
    }


    // GETTERS
    abstract public String getNazwa();
    public int getPierwszenstwo(){return (wiek+inicjatywa);}
    public int getWiek(){return wiek;}
    public char getZnak(){return this.znak;}
    public int getInicjatywa(){return this.inicjatywa;}
    public int getSila(){return sila;}
    public int getPolozenieX(){return polozenieX;}
    public int getPolozenieY(){return polozenieY;}
    public boolean getDoUsuniecia(){return doUsuniecia;}
    public int getId(){return id;}

    // SETTERS
    public void increaseSila(int x){sila += x;}
    public void increaseWiek(){wiek++;}
    public void setPolozenieX(int x) {polozenieX = x;}
    public void setPolozenieY(int y) {polozenieY = y;}
    public void setDoUsuniecia(){doUsuniecia = true;}
    public void setSila(int nowaSila){sila = nowaSila;}
    public void setWiek(int nowyWiek){wiek = nowyWiek;}

    // VARIABLES
    protected char znak;
    protected int id;
    protected Color kolor;
    protected int wiek = 0;
    protected int sila = 0;
    protected int inicjatywa = 0;
    protected int polozenieX;
    protected int polozenieY;

    protected boolean doUsuniecia = false;
    protected WirtualnySwiat aktualnySwiat = null;

}
