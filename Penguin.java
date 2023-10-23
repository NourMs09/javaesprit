package tn.esprit.gestionzoo.entities;

public class Penguin extends Aquatic {
    public float getSwimmingDepth() {
        return swimmingDepth;
    }

    public void setSwimmingDepth(float swimmingDepth) {
        this.swimmingDepth = swimmingDepth;
    }

    private float swimmingDepth;

    public Penguin(String family, String name, int age, boolean isMammal, String habitat, float swimmingDepth) {
        super(family,name,age,isMammal,habitat);
        this.swimmingDepth = swimmingDepth;
    }
    public String toString() {
        return super.toString() + ", Habitat: " + habitat + ", Swimming Depth: " + swimmingDepth;
    }

    public void swim() {
        System.out.println("This penguin is swimming at a depth of " + swimmingDepth );
    }


}



