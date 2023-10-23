package tn.esprit.gestionzoo.main;
import tn.esprit.gestionzoo.entities.*;

public class zoomanagement {
    public static void main(String[] args) {
        zoo myZoo = new zoo("Mon zoo", "Ma ville");
        animal lion = new animal("new", "Lion", 5, true);

       // myZoo.addAnimal(lion);
        myZoo.listAnimals();

        animal lion2 = new animal("new", "Lion", 5, true);
        //myZoo.addAnimal(lion2);
        myZoo.listAnimals();

        myZoo.removeAnimal(lion);
        myZoo.listAnimals();

        zoo anotherZoo = new zoo("Zoo2", "Ville2");
        animal elephant = new animal("Mammifère", "Éléphant", 10, true);
        //anotherZoo.addAnimal(elephant);
        anotherZoo.listAnimals();

        zoo biggerZoo = zoo.comparerZoo(myZoo, anotherZoo);
        if (biggerZoo != null) {
            System.out.println("Le zoo avec le plus d'animaux est " + biggerZoo.getName());
        }


        Terrestrial terrestrialAnimal = new Terrestrial("terrestre", "chat", 4, false, 4);
        Dolphin dolphin = new Dolphin("Océan", "dolphin", 4, true, "mer", 15.0f);
        Penguin penguin = new Penguin("Antarctique", "penguin", 3, true, "mer", 30.0f);
        System.out.println(terrestrialAnimal);
        System.out.println(dolphin);
        System.out.println(penguin);


        dolphin.swim();
        penguin.swim();

        zoo myZoo1 = new zoo("Mon zoo", "Ma ville");

        Dolphin dolphin1 = new Dolphin("Océan 1", "dolphin1", 4, true, "mer", 15.0f);
        Dolphin dolphin2 = new Dolphin("Océan 2", "dolphin2", 5, false, "mer", 17.0f);
        Penguin penguin1 = new Penguin("Antarctique 1", "penguin1", 4, true, "mer", 30.0f);
        Penguin penguin2 = new Penguin("Antarctique 2", "penguin2", 4, false, "mer", 35.0f);

        myZoo1.addAquaticAnimal(dolphin1);
        myZoo1.addAquaticAnimal(dolphin2);
        myZoo1.addAquaticAnimal(penguin1);
        myZoo1.addAquaticAnimal(penguin2);
        myZoo1.swim();

        float maxPenguinDepth = myZoo1.maxPenguinSwimmingDepth();
        System.out.println("La profondeur maximale de nage des pingouins dans le zoo est : " + maxPenguinDepth + " mètres.");

        Dolphin dol3 = new Dolphin("Océan 2", "dodo", 5, false, "mer", 17.0f);
        Penguin peng3 = new Penguin("Océan 2", "dodo", 5, false, "mer", 17.0f);
        System.out.println(dol3.equals(peng3));


        zoo myZoo5 = new zoo("Mon zoo",  "ville");

        try {
            myZoo5.addAnimal(new animal("Lion", "lion", 5,true));
            System.out.println("Nombre d'animaux dans le zoo : " + myZoo5.getAnimalCount());

            myZoo5.addAnimal(new animal("Girafe", "girafe", -4,true));
            System.out.println("Nombre d'animaux dans le zoo : " + myZoo5.getAnimalCount());

            myZoo5.addAnimal(new animal("Tigre", "tigre", 4,true));
            System.out.println("Nombre d'animaux dans le zoo : " + myZoo5.getAnimalCount());

            myZoo5.addAnimal(new animal("Éléphant", "elephant", 4,false));
            System.out.println("Nombre d'animaux dans le zoo : " + myZoo5.getAnimalCount());
        } catch (ZooFullException | InvalidAgeException e) {
            System.out.println("Erreur : " + e.getMessage());
        }


    }
}

