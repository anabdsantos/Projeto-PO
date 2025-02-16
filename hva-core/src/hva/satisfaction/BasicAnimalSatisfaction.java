package hva.satisfaction;

import hva.animal.Animal;
import hva.habitat.Habitat;

public class BasicAnimalSatisfaction implements SatisfactionAnimal {
    private Animal _animal;

    public BasicAnimalSatisfaction(Animal animal) {
        _animal = animal;
    }

    @Override
    public double calculateAnimalSatisfaction() {
        Habitat habitat = _animal.getAnimalHabitat();

        int sameSpecies = habitat.animalsOfTheSameSpecies(
            _animal.getIdSpecies())-1; 
        int differentSpecies = habitat.animalsOfDifferentSpecies(
            _animal.getIdSpecies());

        int area = habitat.getArea();
        int nAnimals = habitat.getAnimals().size(); 
        int adequacy = habitat.getInfluence(_animal.getIdSpecies());
        
        double satisfaction = 20 + 3 * sameSpecies 
        - 2 * differentSpecies + area / nAnimals + adequacy;

        return satisfaction;
    }
}
