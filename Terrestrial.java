package tn.esprit.gestionzoo.entities;

public class Terrestrial extends animal {
    private int nbrLegs;

    public Terrestrial(String family, String name, int age, boolean isMammal, int nbrLegs) {
        super(family,name,age,isMammal);
        this.nbrLegs = nbrLegs;
    }

    public int getNbrLegs() {
        return nbrLegs;
    }

    public void setNbrLegs(int nbrLegs) {
            this.nbrLegs = nbrLegs;

    }
    public String toString() {
        return super.toString()+"Nbr de pattes: " + getNbrLegs();
    }
}
