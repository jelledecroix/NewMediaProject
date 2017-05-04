package newmediaproject.nmct.howest.be.newmediaproject;

import java.io.Serializable;

/**
 * Created by Jelle on 18/04/2017.
 */

public class Producten implements Serializable {
    private int mId;
    private String mName;
    private int mPrijs;
    private String mCategorie;
    private int inVooraad;
    private int IsChecked;
public Producten(int id, String naam, int prijs,String categorie,int inVooraad,int ischecked){
    this.setmId(id);
    this.setmName(naam);
    this.setmPrijs(prijs);
    this.setmCategorie(categorie);
    this.setInVooraad(inVooraad);
    this.setIsChecked(ischecked);
}

    public Producten() {

    }

    public int getmId() {
        return mId;
    }

    public void setmId(int mId) {
        this.mId = mId;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public int getmPrijs() {
        return mPrijs;
    }

    public void setmPrijs(int mPrijs) {
        this.mPrijs = mPrijs;
    }

    public String getmCategorie() {
        return mCategorie;
    }

    public void setmCategorie(String mCategorie) {
        this.mCategorie = mCategorie;
    }

    public int getInVooraad() {
        return inVooraad;
    }

    public void setInVooraad(int inVooraad) {
        this.inVooraad = inVooraad;
    }

    public int getIsChecked() {
        return IsChecked;
    }

    public void setIsChecked(int isChecked) {
        IsChecked = isChecked;
    }
}
