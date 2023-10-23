package tn.esprit.gestionzoo.entities;

import javax.swing.plaf.synth.SynthOptionPaneUI;

public class zoo {
    private Aquatic[] aquaticAnimals;
    public static final int MAX_CAGES = 20;

    private animal[] animals;
    private String name;
    private String city;
    private int nbrCages;
    private int animalCount;

    public zoo(String name, String city) {
        this.name = name;
        this.city = city;
        this.nbrCages = MAX_CAGES;
        this.animals = new animal[MAX_CAGES];
        this.animalCount = 0;
        this.aquaticAnimals = new Aquatic[10];
    }
    public Aquatic[] getAquaticAnimals() {
        return aquaticAnimals;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public int getNbrCages() {
        return nbrCages;
    }

    public int getAnimalCount() {
        return animalCount;
    }

    public boolean isZooFull() {
        return animalCount >= nbrCages;
    }

    public void addAnimal(animal animal) throws ZooFullException, InvalidAgeException {
        if (animalCount < nbrCages) {
            if (animal.getAge() < 0) {
                throw new InvalidAgeException("L'âge de l'animal ne peut pas être négatif.");
            }
            animals[animalCount] = animal;
            animalCount++;
        } else {
            throw new ZooFullException("Le zoo est plein, impossible d'ajouter plus d'animaux.");
        }
    }


    public void listAnimals() {
        for (int i = 0; i < animalCount; i++) {
            System.out.println("Animal " + (i + 1) + ": " + animals[i].getName());
        }
    }

    public int searchAnimal(animal animal) {
        for (int i = 0; i < animalCount; i++) {
            if (animals[i].equals(animal)) {
                return i;
            }
        }
        return -1;
    }

    public boolean removeAnimal(animal animal) {
        int index = searchAnimal(animal);
        if (index != -1) {
            animals[index] = animals[animalCount - 1];
            animals[animalCount - 1] = null;
            animalCount--;
            System.out.println("Animal " + animal.getName() + " a été supprimé du zoo.");
            return true;
        } else {
            System.out.println("Animal " + animal.getName() + " n'a pas été trouvé dans le zoo.");
            return false;
        }
    }

    public static zoo comparerZoo(zoo z1, zoo z2) {
        if (z1.getAnimalCount() > z2.getAnimalCount()) {
            return z1;
        } else if (z2.getAnimalCount() > z1.getAnimalCount()) {
            return z2;
        } else {
            System.out.println("Les zoos ont le même nombre d'animaux.");
            return null;
        }
    }

    public String toString() {
        return "Nom du zoo: " + name + ", Ville du zoo: " + city + ", Nombre de cages: " + nbrCages;
    }

    public void addAquaticAnimal(Aquatic aquatic) {
        for (int i = 0; i < aquaticAnimals.length; i++) {
            if (aquaticAnimals[i] == null) {
                aquaticAnimals[i] = aquatic;
                break;
            }
        }
    }

    public void swim() {
        for (Aquatic aquatic : aquaticAnimals) {
            if (aquatic != null) {
                aquatic.swim();
            }
        }
    }
    public float maxPenguinSwimmingDepth() {
            float maxDepth = 0.0f;
            for (Aquatic aquatic : aquaticAnimals) {
                if (aquatic instanceof Penguin) {
                    Penguin penguin = (Penguin) aquatic;
                    if (penguin.getSwimmingDepth() > maxDepth) {
                        maxDepth = penguin.getSwimmingDepth();
                    }
                }
            }
            return maxDepth;
        }

        public void displayNumberOfAquaticsByType(){
            int dolphinCount = 0;
            int penguinCount = 0;
            for (Aquatic aquatic : aquaticAnimals) {
                if (aquatic instanceof Dolphin) {
                    dolphinCount++;
                } else if (aquatic instanceof Penguin) {
                    penguinCount++;
                }
            }
            System.out.println("Number of dolphins: " + dolphinCount);
            System.out.println("Number of penguins: " + penguinCount);
        }


    }


