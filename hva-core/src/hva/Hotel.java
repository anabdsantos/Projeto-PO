package hva;

import hva.animal.Animal;
import hva.animal.Species;
import hva.employee.Employee;
import hva.employee.Trt;
import hva.employee.Vet;
import hva.exceptions.AnimalAlreadyExistsException;
import hva.exceptions.AnimalNotFoundException;
import hva.exceptions.EmployeeAlreadyExistsException;
import hva.exceptions.EmployeeNotFoundException;
import hva.exceptions.HabitatAlreadyExistsException;
import hva.exceptions.HabitatNotFoundException;
import hva.exceptions.ImportFileException;
import hva.exceptions.NoSuchResponsibilityException;
import hva.exceptions.SpeciesAlreadyExistsException;
import hva.exceptions.SpeciesNotFoundException;
import hva.exceptions.TreeAlreadyExistsException;
import hva.exceptions.TreeNotFoundException;
import hva.exceptions.UnauthorizedVetException;
import hva.exceptions.UnrecognizedEntryException;
import hva.exceptions.VaccineAlreadyExistsException;
import hva.exceptions.VaccineNotFoundException;
import hva.exceptions.VetNotFoundException;
import hva.habitat.Habitat;
import hva.habitat.tree.Cad;
import hva.habitat.tree.CadFallState;
import hva.habitat.tree.CadSpringState;
import hva.habitat.tree.CadSummerState;
import hva.habitat.tree.CadWinterState;
import hva.habitat.tree.Per;
import hva.habitat.tree.PerFallState;
import hva.habitat.tree.PerSpringState;
import hva.habitat.tree.PerSummerState;
import hva.habitat.tree.PerWinterState;
import hva.habitat.tree.Season;
import hva.habitat.tree.Tree;
import hva.vaccine.MedicalActs;
import hva.vaccine.Vaccine;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Hotel implements Serializable {

    @Serial
    private static final long serialVersionUID = 202407081733L;

    /** Boolean that indicates if the hotel has changed */
    private boolean _changed;

    /** Int that indicates the season of the hotel */
    private Season _season;

    /** Map that stores the species registered in the hotel.*/
    private Map<String,Species> _species = new TreeMap<>(
        String.CASE_INSENSITIVE_ORDER);

    /** Map that stores the trees registered in the hotel.*/ 
    private Map<String,Tree> _trees = new TreeMap<>(
        String.CASE_INSENSITIVE_ORDER);

    /** Map that stores the habitats registered in the hotel.*/
    private Map<String,Habitat> _habitats = new TreeMap<>(
        String.CASE_INSENSITIVE_ORDER);

    /** Map that stores the animals registered in the hotel.*/
    private Map<String,Animal> _animals = new TreeMap<>(
        String.CASE_INSENSITIVE_ORDER);

    /** Map that stores the employees registered in the hotel.*/
    private Map<String,Employee> _employees = new TreeMap<>(
        String.CASE_INSENSITIVE_ORDER);

    /** Map that stores the vaccines registered in the hotel.*/
    private Map<String,Vaccine> _vaccines = new TreeMap<>(
        String.CASE_INSENSITIVE_ORDER);
    
    /** Map that stores the vaccinations registered in the hotel.*/
    private List<MedicalActs> _vaccinations = new ArrayList<>();

    /** Map that stores the wrong vaccinations registered in the hotel.*/
    private List<MedicalActs> _wrongVaccinations = new ArrayList<>();

    /** 
     * Creates a hotel and initializes the change state to false.
    */
    public Hotel() {
        setChanged(false);
        setSeason(Season.PRIMAVERA);
    }

    /**
     * It changes the state of the hotel.
     * 
     * @param set boolean that indicates the new state of the hotel.
     */
    public void setChanged(boolean set) {
        _changed = set;
    }

    /**
     * returns the boolean of the attribute _changed of the hotel
     * 
     * @return True if hotel has been changed and false if not
     */
    public boolean getChanged() {
        return _changed;
    }

    /**
     * Changes the value of the state of the hotel to true.
     */
    public void changed() {
        setChanged(true);
    }

    /**
     * It changes the season of the hotel.
     * 
     * @param season
     */
    public void setSeason(Season season) {
        _season = season;
    }

    /**
     * returns the Habitat with the id
     * 
     * @param id
     * @return Habitat of the id
     */
    public Habitat getHabitat(String id) {
        return _habitats.get(id);
    }

    /**
     * returns the Tree with the id
     * 
     * @param id
     * @return Tree of the id
     */
    public Tree getTree(String id) {
        return _trees.get(id);
    }

    /**
     * returns the Animal with the id
     * 
     * @param id
     * @return Animal of the id
     */
    public Animal getAnimal(String id) {
        return _animals.get(id);
    }

    /**
     * returns the Employee with the id
     * 
     * @param id
     * @return Employee of the id
     */
    public Employee getEmployee(String id) {
        return _employees.get(id);
    }

    /**
     * returns the Vaccine with the id
     * 
     * @param id
     * @return Vaccine of the id
     */
    public Vaccine getVaccine(String id) {
        return _vaccines.get(id);
    }

    /**
     * returns the Species with the id
     * 
     * @param id
     * @return Species of the id
     */
    public Species getSpecies(String id) {
        return _species.get(id);
    }

    /**
     * verifies if the employee with the given ID is of type "Vet"
     * 
     * @param id
     * @return True if the id is of a Employee of the type Vet and 
     * false if not
     */
    public boolean isVet(String id) {
        Employee employee = getEmployee(id);
        return employee != null && employee.getType().equals(
            "VET");
    }

    /**
     * verifies if the employee with the given ID is of type "Trt"
     * 
     * @param id
     * @return True if the id is of a Employee of the type Trt and 
     * false if not
     */
    public boolean isTrt(String id) {
        Employee employee = getEmployee(id);
        return employee.getType().equals("TRT");
    }

    /**
     * Verifies if the species exists.
     * 
     * @param id the id of the species to be verified.
     * @return true if the species exists, false otherwise.
     */
    public boolean existSpecies(String id) {
        return getSpecies(id) != null;
    }

    /**
     * Verifies if the species name exists in the species list.
     * 
     * @param speciesName the name of the species to be verified.
     * @return true if the species name exists, false otherwise.
     */
    public boolean existSpeciesName(String speciesName) {
        for (Species species : _species.values()) {
            String name = species.getSpeciesName();
            if (name.equals(speciesName)) {
                return true;
            }
        } return false;
    }

    /**
     * Verifies if the habitat exists.
     * 
     * @param id the id of the habitat to be verified.
     * @return true if the habitat exists, false otherwise.
     */
    public boolean existHabitat(String id) {
        return getHabitat(id) != null;
    }

    /**
     * Verifies if the animal exists.
     * 
     * @param id the id of the animal to be verified.
     * @return true if the animal exists, false otherwise.
     */
    public boolean existAnimal(String id) {
        return getAnimal(id) != null;
    }

    /**
     * Verifies if the vaccine exists.
     * 
     * @param id the id of the vaccine to be verified.
     * @return true if the vaccine exists, false otherwise.
     */
    public boolean existVaccine(String id) {
        return getVaccine(id) != null;
    }

    /**
     * Verifies if the employee exists.
     * 
     * @param id the id of the employee to be verified.
     * @return true if the employee exists, false otherwise.
     */
    public boolean existEmployee(String id) {
        return getEmployee(id) != null;
    }

    /**
     * Verifies if the trees exists.
     * 
     * @param id the id of the trees to be verified.
     * @return true if the trees exists, false otherwise.
     */
    public boolean existTrees(String id) {
        return getTree(id) != null;
    }

    /**
     * checks if the responsibility and the employee are compatible.
     * 
     * @param idEmployee
     * @param idResponsibility
     * @return True if the employee is compatible with the 
     * responsability, and false if not
     */
    public boolean checksResponsibility(String idEmployee, String 
    idResponsibility) {
        return ((isTrt(idEmployee) && existHabitat(idResponsibility)) 
        || (isVet(idEmployee) && existSpecies(idResponsibility)));
    }

    /**
     * Checks if the vaccine is good for the animal species.
     * 
     * @param idVaccine
     * @param idAnimal
     * @return true if it is good for the animal, and false if not
     */
    public boolean vaccineIsGoodToAnimal(String idVaccine, String 
    idAnimal) {
        Vaccine vaccine = getVaccine(idVaccine);
        Animal animal = getAnimal(idAnimal);

        return vaccine.animalCanBeVaccinated(animal.getIdSpecies());      
    }

    /**
     * Read text input file and create domain entities.
     *
     * @param filename name of the text input file
     * @throws ImportFileException 
     */
    void importFile(String filename) throws ImportFileException {
        try (BufferedReader reader = new BufferedReader(
            new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split("\\|");
                try {
                    registerEntry(fields);
                } 
                catch (UnrecognizedEntryException | 
                TreeAlreadyExistsException | 
                HabitatAlreadyExistsException | 
                AnimalAlreadyExistsException | 
                EmployeeAlreadyExistsException | 
                VaccineAlreadyExistsException | 
                HabitatNotFoundException | 
                TreeNotFoundException | SpeciesNotFoundException|
                SpeciesAlreadyExistsException e) {
                    e.printStackTrace();
                }
            }
        } 
        catch (IOException e1) {
            throw new ImportFileException(filename, e1);
        }
    }

    /**
     * Registers a new entry in the system from the first 
     * vector element.
     * 
     * @param fields A variable-length argument array that contains
     * the diferent options to register the entry.
     * @throws UnrecognizedEntryException if the entry is invalid.
     * @throws TreeAlreadyExistsException if the tree already exists.
     * @throws HabitatAlreadyExistsException if the habitat already exists.
     * @throws AnimalAlreadyExistsException if the animal already exists.
     * @throws EmployeeAlreadyExistsException if the employee already exists.
     * @throws VaccineAlreadyExistsException if the vaccine already exists.
     * @throws SpeciesNotFoundException if the species doesn't exists.
     * @throws HabitatNotFoundException if the habitat doesn't exists.
     * @throws TreeNotFoundException if the tree doesn't exists.
     */
    public void registerEntry(String... fields) throws 
    UnrecognizedEntryException, TreeAlreadyExistsException, 
    HabitatAlreadyExistsException, AnimalAlreadyExistsException,
    EmployeeAlreadyExistsException, VaccineAlreadyExistsException, 
    SpeciesNotFoundException, HabitatNotFoundException,
    TreeNotFoundException, SpeciesAlreadyExistsException, 
    SpeciesNotFoundException {
        switch (fields[0]) {
            case "ESPÉCIE" -> registerSpecies(fields);
            case "ÁRVORE" -> registerTree(fields);
            case "HABITAT" -> registerHabitat(fields);
            case "ANIMAL" -> registerAnimal(fields);
            case "TRATADOR", "VETERINÁRIO" -> registerEmployee(
                fields);
            case "VACINA" -> registerVaccine(fields);
            default -> throw new UnrecognizedEntryException(
                fields[0]);
            }
    }

    /**
     * Registers a new species in the system and changes the state of
     * the hotel.
     * 
     * @param fields A variable-length argument array that contains
     * the diferent options to register the species.
     */
    public void registerSpecies(String... fields) throws SpeciesAlreadyExistsException {
        if (existSpeciesName(fields[2])) {
            throw new SpeciesAlreadyExistsException();
        }
        Species s = new Species(fields[1], fields[2]);
        _species.put(fields[1], s);
        changed();
    }

    /**
     * Registers a new tree in the system and changes the state of
     * the hotel.
     * Registers two types of trees depending on field 5.
     * 
     * @param fields A variable-length argument array that contains
     * the diferent options to register the trees.
     * @throws UnrecognizedEntryException if the entry is invalid.
     * @throws TreeAlreadyExistsException if the tree already exists.
     */
    public void registerTree(String... fields) throws 
    UnrecognizedEntryException, TreeAlreadyExistsException, 
    HabitatNotFoundException{
        if (existTrees(fields[1])) {
            throw new TreeAlreadyExistsException(fields[1]);
        }
        int age = Integer.parseInt(fields[3]);
        int cD = Integer.parseInt(fields[4]);
        switch (fields[5]) {
            case "PERENE" -> {
                Per tPer = new Per(fields[1], fields[2], age, cD);
                _trees.put(fields[1], tPer);
                switch (_season) {
                    case PRIMAVERA -> {tPer.setState(new 
                        PerSpringState(tPer));}
                    case VERAO -> {tPer.setState(new 
                        PerSummerState(tPer));}
                    case OUTONO -> {tPer.setState(new 
                        PerFallState(tPer));}
                    case INVERNO -> {tPer.setState(new 
                        PerWinterState(tPer));}
                }
                tPer.setInicialSeason(_season);
            }
            case "CADUCA" -> {
                Cad tCad = new Cad(fields[1], fields[2], age, cD);
                _trees.put(fields[1], tCad);
                switch (_season) {
                    case PRIMAVERA -> {tCad.setState(new 
                        CadSpringState(tCad));}
                    case VERAO -> {tCad.setState(new 
                        CadSummerState(tCad));}
                    case OUTONO -> {tCad.setState(new 
                        CadFallState(tCad));}
                    case INVERNO -> {tCad.setState(new 
                        CadWinterState(tCad));}
                }
                tCad.setInicialSeason(_season);
            }
            default -> throw new UnrecognizedEntryException(
                fields[5]);
        }
        changed();
    }

    /**
     * Registers a new habitat in the system and changes the state of 
     * the hotel.
     * 
     * @param fields A variable-length argument array that contains
     * the diferent options to register the habitat.
     * @throws HabitatAlreadyExistsException if the habitat already exists.
     * @throws TreeNotFoundException if the tree already exists.
     */
    public void registerHabitat(String... fields) throws 
    HabitatAlreadyExistsException, TreeNotFoundException{
        if (existHabitat(fields[1])) {
            throw new HabitatAlreadyExistsException(fields[1]);
        }
        int area = Integer.parseInt(fields[3]);
        Habitat h = new Habitat(fields[1], fields[2], area);
        if (fields.length>=5 && !fields[4].isEmpty()) {
            String[] idTrees = fields[4].split(",");
            for (String id : idTrees) {
                if (!existTrees(id)) {
                    throw new TreeNotFoundException(id);
                }
                h.addTree(id, _trees.get(id));
            }
        }
        _habitats.put(fields[1], h);
        changed();
    }

    /**
     * Registers a new animal in the system and and changes the state 
     * of the hotel.
     * 
     * @param fields A variable-length argument array that contains
     * the diferent options to register the animal.
     * @throws AnimalAlreadyExistsException if the animal already exists.
     * @throws HabitatNotFoundException if the habitat doesn't exists.
     */
    public void registerAnimal(String... fields) throws 
    AnimalAlreadyExistsException, HabitatNotFoundException, 
    SpeciesNotFoundException {
        if (existAnimal(fields[1])) {
            throw new AnimalAlreadyExistsException(fields[1]);
        }
        if (!existHabitat(fields[4])) {
            throw new HabitatNotFoundException(fields[4]);
        }
        if (!existSpecies(fields[3])) {
            throw new SpeciesNotFoundException(fields[3]);
        }
        String sName = getSpecies(fields[3]).getSpeciesName();
        Habitat habitat = getHabitat(fields[4]);
        Animal a = new Animal(fields[1], fields[2], sName, fields[3], 
        habitat);
        habitat.addAnimal(fields[1], a);
        if (!habitat.hasInfluence(fields[3])) {
            habitat.setInfluence(fields[3],0);
        }
        Species species = getSpecies(fields[3]); 
        species.addAnimals(fields[1],a);
        _animals.put(fields[1], a);
        changed();
    }

    /**
     * Registers a new employee in the system and changes the state 
     * of the hotel.
     * Registers two types of employess depending on field 0.
     * Because it has optional fields it has two options for each type
     * of employee. With or without the last field.
     * 
     * @param fields A variable-length argument array that contains
     * the diferent options to register the employee.
     * @throws EmployeeAlreadyExistsException is the employee already exists.
     * @throws HabitatNotFoundException if the habitat doesn't exists.
     * @throws SpeciesNotFoundException if the species doesn't exists.
     *
     */
    public void registerEmployee(String... fields) throws 
    EmployeeAlreadyExistsException, HabitatNotFoundException, 
    SpeciesNotFoundException {
        if (existEmployee(fields[1])) {
            throw new EmployeeAlreadyExistsException(fields[1]);
        }
        switch (fields[0]) {
            case "TRATADOR"-> {
                Trt e = new Trt(fields[1], fields[2]);
                if (fields.length>=4 && !fields[3].isEmpty()) {
                    String[] idResponsibilities = fields[3].split(
                    ",");
                    for (String id : idResponsibilities) {
                        if (!existHabitat(id)) {
                            throw new HabitatNotFoundException(id);
                        }
                        Habitat habitat = getHabitat(id);
                        e.addResponsibilities(id, habitat);
                        habitat.increaseNTrts();
                    }
                }
                _employees.put(fields[1], e);
            }
            case "VETERINÁRIO"-> {
                Vet e = new Vet(fields[1], fields[2]);
                if (fields.length>=4 && !fields[3].isEmpty()) {
                    String[] idResponsibilities = fields[3].split(
                    ",");
                    for (String id : idResponsibilities) {
                        if (!existSpecies(id)) {
                            throw new SpeciesNotFoundException(id);
                        }
                        Species species = getSpecies(id);
                        e.addResponsibilities(id, species);
                        species.increaseNVets();
                    }
                }
                _employees.put(fields[1], e);
            }
        }
        changed();
    }

    /**
     * Registers a new vaccine in the system and changes the state of 
     * the hotel.
     * Because it has optional fields it has two option to register a
     * vaccine. With or without the last field.
     * 
     * @param fields A variable-length argument array that contains
     * the diferent options to register the vaccine.
     * @throws VaccineAlreadyExistsException if the vaccine already exists.
     * @throws SpeciesNotFoundException if the species doesn't exists.
     */
    public void registerVaccine(String... fields) throws 
    VaccineAlreadyExistsException, SpeciesNotFoundException {
        if (existVaccine(fields[1])) {
            throw new VaccineAlreadyExistsException(fields[1]);
        }
        Vaccine v = new Vaccine(fields[1], fields[2]);
        if (fields.length>=4 && !fields[3].isEmpty()) {
            String cleanedList = fields[3].replace(" ", "");
            String[] idSpecies = cleanedList.split(",");
            for (String id : idSpecies) {
                if (!existSpecies(id)) {
                    throw new SpeciesNotFoundException(id);
                }
                v.addSpecies(id, getSpecies(id));
            }
        }
        _vaccines.put(fields[1], v);
        changed();
    }

    /**
     * Advances the season of the hotel and of each tree.
     * 
     * @return value of the season
     */
    public int advanceSeason() {
        _season = _season.next();
        setSeason(_season);
        for(Tree t: _trees.values()) {
            t.advance(_season);
        }
        changed();
        return _season.getValue();
    }

    /**
     * register tree and add it to the Habitat.
     * @param idHabitat
     * @param idTree
     * @param nameTree
     * @param ageTree
     * @param difficultyType
     * @param type
     * @return a strings of the planted tree.
     * @throws UnrecognizedEntryException
     * @throws TreeAlreadyExistsException
     * @throws HabitatNotFoundException
     */
    public String addTreeToHabitat(String idHabitat, String idTree, 
    String nameTree, String ageTree, String difficultyType, String 
    type) throws UnrecognizedEntryException, 
    TreeAlreadyExistsException, HabitatNotFoundException {
        if (!existHabitat(idHabitat)) {
            throw new HabitatNotFoundException(idHabitat);
        }
        if (existTrees(idTree)) {
            throw new TreeAlreadyExistsException(idTree);
        } 
        registerTree(new String[] { 
            "ÁRVORE", idTree, nameTree, ageTree, difficultyType, 
            type
        });
        Tree t = getTree(idTree);
        getHabitat(idHabitat).addTree(idTree, t);
        changed();
        return t.toString();
    }

    /**
     * transfer the animal to the new Habitat and removes from the 
     * old.
     * 
     * @param idAnimal
     * @param idHabitat
     * @throws AnimalNotFoundException
     * @throws HabitatNotFoundException
     */
    public void transferToHabitat(String idAnimal, String idHabitat) 
    throws AnimalNotFoundException, HabitatNotFoundException{
        if (!existAnimal(idAnimal)) {
            throw new AnimalNotFoundException(idAnimal);
        }
        if (!existHabitat(idHabitat)) {
            throw new HabitatNotFoundException(idHabitat);
        }
        Animal animal = getAnimal(idAnimal);
        Habitat oldHabitat = animal.getAnimalHabitat();
        oldHabitat.removeAnimal(idAnimal);
        Habitat next = getHabitat(idHabitat);
        next.addAnimal(idAnimal, animal);
        animal.setHabitat(next);
        String idSpecies = animal.getIdSpecies();
        if (!next.hasInfluence(idSpecies)) {
            next.setInfluence(idSpecies,0);
        }
        changed();
    }

    /**
     * change the area of the Habitat.
     * 
     * @param id
     * @param area
     * @throws HabitatNotFoundException
     */
    public void changeHabitatArea(String id, int area) throws 
    HabitatNotFoundException {
        if (!existHabitat(id)) {
            throw new HabitatNotFoundException(id);
        }
        Habitat habitat = getHabitat(id);
        if (habitat.getArea() != area) {
            habitat.setArea(area);
            changed();
        }
    }

    /**
     * change the influence of the habitat in the species.
     * 
     * @param idHabitat
     * @param idSpecies
     * @param influence
     * @throws HabitatNotFoundException
     * @throws SpeciesNotFoundException
     */
    public void changeHabitatInfluence(String idHabitat, 
    String idSpecies, String influence) throws 
    HabitatNotFoundException, SpeciesNotFoundException {
        int nInfluence = 0;
        if (!existHabitat(idHabitat)) {
            throw new HabitatNotFoundException(idHabitat);
        }
        if (!existSpecies(idSpecies)) {
            throw new SpeciesNotFoundException(idSpecies);
        }
        switch (influence) {
            case "POS" -> {nInfluence = 20;}
            case "NEG" -> {nInfluence = -20;}
        }
        Habitat habitat = getHabitat(idHabitat);
        if (!habitat.hasInfluence(idSpecies) || 
        nInfluence != habitat.getInfluence(idSpecies)) {
            habitat.setInfluence(idSpecies, nInfluence);
            changed();
        }
    }

    /**
     * add responsibility to the employee
     * 
     * @param idEmployee
     * @param idResponsibility
     * @throws EmployeeNotFoundException
     * @throws NoSuchResponsibilityException
     */
    public void addResponsibilityToEmployee(String idEmployee, String 
    idResponsibility) throws EmployeeNotFoundException, 
    NoSuchResponsibilityException {
        if (!existEmployee(idEmployee)) {
            throw new EmployeeNotFoundException(idEmployee);
        }
        if (!checksResponsibility(idEmployee,idResponsibility)) {
            throw new NoSuchResponsibilityException(idEmployee, 
            idResponsibility);
        }
        Employee employee = getEmployee(idEmployee);
        if (isTrt(idEmployee)) {
            Trt trt = (Trt) employee;
            if (trt.getResponsibility(idResponsibility) == null) {
                Habitat habitat = getHabitat(idResponsibility);
                trt.addResponsibilities(idResponsibility, habitat);
                habitat.increaseNTrts();
            }
        } else if (isVet(idEmployee)) {
            Vet vet = (Vet) employee;
            if (vet.getResponsibility(idResponsibility) == null) {
                Species species = getSpecies(idResponsibility);
                vet.addResponsibilities(idResponsibility, species);
                species.increaseNVets();
            }
        }
        changed();
    }

    /**
     * remove the responsibility of the employee
     * 
     * @param idEmployee
     * @param idResponsibility
     * @throws EmployeeNotFoundException
     * @throws NoSuchResponsibilityException
     */
    public void removeResponsibilitiesFromEmployee(String idEmployee, 
    String idResponsibility) throws EmployeeNotFoundException, 
    NoSuchResponsibilityException {
        if (!existEmployee(idEmployee)) {
            throw new EmployeeNotFoundException(idEmployee);
        }
        if (!checksResponsibility(idEmployee,idResponsibility)) {
            throw new NoSuchResponsibilityException(idEmployee, 
            idResponsibility);
        }
        Employee employee = getEmployee(idEmployee);
        if (isTrt(idEmployee)) {
            Trt trt = (Trt) employee;
            if (trt.getResponsibility(idResponsibility) == null) {
                throw new NoSuchResponsibilityException(idEmployee,
                idResponsibility);
            }
            trt.removeResponsibilities(idResponsibility);
        } else if (isVet(idEmployee)) {
            Vet vet = (Vet) employee;
            if (vet.getResponsibility(idResponsibility) == null) {
                throw new NoSuchResponsibilityException(idEmployee,
                idResponsibility);
            }
            vet.removeResponsibilities(idResponsibility);
        }
        changed();
        
    }

    /**
     * vaccinate the animal and update all the vaccinations and 
     * medical acts lists.
     * 
     * @param idVaccine
     * @param idEmployee
     * @param idAnimal
     * @throws EmployeeNotFoundException
     * @throws UnauthorizedVetException
     * @throws VaccineNotFoundException
     * @throws AnimalNotFoundException
     */
    public void vaccinateAnimal(String idVaccine, String idEmployee, 
    String idAnimal) throws VetNotFoundException, 
    UnauthorizedVetException, VaccineNotFoundException,
    AnimalNotFoundException {
        if(!existVaccine(idVaccine)) {
            throw new VaccineNotFoundException(idVaccine);
        }

        if (!existAnimal(idAnimal)) {
            throw new AnimalNotFoundException(idAnimal);
        }

        if (!isVet(idEmployee) || !existEmployee(idEmployee) ) {
            throw new VetNotFoundException(idEmployee);
        }

        Employee employee = getEmployee(idEmployee);
        Vet vet = (Vet) employee;
        Animal animal = getAnimal(idAnimal);
        Vaccine vaccine = getVaccine(idVaccine);
        MedicalActs medicalAct = new MedicalActs(idVaccine,
        idEmployee,animal.getIdSpecies());

        if (!vet.hasSpecies(animal.getIdSpecies())) {
            throw new UnauthorizedVetException(idEmployee, animal.
            getIdSpecies());
        }

        animal.addAnimalMedicalAct(medicalAct);
        vet.addVetMedicalAct(medicalAct);
        _vaccinations.add(medicalAct);
        vaccine.increaseNApllications();

        if (!vaccineIsGoodToAnimal(idVaccine, idAnimal)) {
            _wrongVaccinations.add(medicalAct);
            int damage = vaccine.calculateDamage(animal.
            getSpeciesName());
            animal.addHealthHistorial(damage);
        } else {
            animal.updateHeatlhHistorial("NORMAL");
        }
    }

        /**
     * A collection of strings that represents all animals.
     * It uses each animal's toString().
     * 
     * @return a collection of strings.
     */
    public Collection<String> showAnimals() {
        List<String> animalStrings = new ArrayList<>();
        for (Animal animal : _animals.values()) {
            animalStrings.add(animal.toString());
        }
        return Collections.unmodifiableCollection(animalStrings);
    }

    /**
     * A collection of strings that represents all habitats.
     * It uses each habitat's toString().
     * 
     * @return a collection of strings.
     */
    public Collection<String> showHabitats() {
        List<String> habitatStrings = new ArrayList<>();
        for (Habitat habitat : _habitats.values()) {
            habitatStrings.add(habitat.toString());
            for (Tree tree : habitat.getTrees().values()) {
                habitatStrings.add(tree.toString());
            }
        }
        return Collections.unmodifiableCollection((habitatStrings));
    }

    /**
     * A collection of strings that represents all vaccines.
     * It uses each vaccine's toString().
     * 
     * @return a collection of strings.
     */
    public Collection<String> showVaccines() {
        List<String> vaccineStrings = new ArrayList<>();
        for (Vaccine vaccine : _vaccines.values()) {
            vaccineStrings.add(vaccine.toString());
        }
        return Collections.unmodifiableCollection((vaccineStrings));
    }

    /**
     * A collection of strings that represents all employees.
     * It uses each employees's toString().
     * 
     * @return a collection of strings.
     */
    public Collection<String> showEmployees() {
        List<String> employeeStrings = new ArrayList<>();
        for (Employee employee : _employees.values()) {
            employeeStrings.add(employee.toString()); 
        }
        return Collections.unmodifiableCollection(employeeStrings);
    }

    /**
     * A collection of strings that represents all trees in the 
     * Habitat with id.
     * 
     * @param id
     * @return a collection of strings.
     * @throws HabitatNotFoundException
     */
    public Collection<String> showAllTreesInHabitat(String id) throws
    HabitatNotFoundException {
        if (!existHabitat(id)) {
            throw new HabitatNotFoundException(id);
        }
        Habitat habitat = getHabitat(id);
        return habitat.showTrees();
    }

    /**
     * A collection of strings that represents all animals in the 
     * Habitat with id.
     * 
     * @param idHabitat
     * @return a collection of strings.
     * @throws HabitatNotFoundException
     */
    public Collection<String> showAnimalsInHabitat(String idHabitat) 
    throws HabitatNotFoundException {
        if (!existHabitat(idHabitat)) {
            throw new HabitatNotFoundException(idHabitat);
        }
        Habitat habitat = getHabitat(idHabitat);
        return habitat.showAnimals();
    }

    /**
     * A collection of strings that represents all medical acts by 
     * the Veterinarian with id.
     * 
     * @param idVet
     * @return a collection of strings.
     * @throws VetNotFoundException
     */
    public Collection<String> showMedicalActsByVeterinarian(
        String idVet) throws VetNotFoundException {
        if (!isVet(idVet) || !existEmployee(idVet)) {
            throw new VetNotFoundException(idVet);
        }
        Employee employee = getEmployee(idVet);
        Vet vet = (Vet) employee;
        return vet.showMedicalActs();
    }

    /**
     * A collection of strings that represents all medical acts on 
     * the animal with id.
     * 
     * @param idAnimal
     * @return a collection of strings.
     * @throws AnimalNotFoundException
     */
    public Collection<String> showMedicalActsOnAnimal(
        String idAnimal) throws AnimalNotFoundException {
        if (!existAnimal(idAnimal)) {
            throw new AnimalNotFoundException(idAnimal);
        }
        Animal animal = getAnimal(idAnimal);
        return animal.showMedicalActs();
    }

    /**
     * A collection of strings that represents all medical acts of 
     * wrong vaccinations.
     * 
     * @return a collection of strings.
     */
    public Collection<String> showWrongVaccinations() {
        List<String> wrongVaccinationsStrings = new ArrayList<>();
        for (MedicalActs medicalActs : _wrongVaccinations) {
            wrongVaccinationsStrings.add(medicalActs.toString()); 
        }
        return Collections.unmodifiableCollection(
            wrongVaccinationsStrings);
    }

    /**
     * A collection of strings that represents all vaccinations.
     * 
     * @return a collection of strings.
     */
    public Collection<String> showVaccinations() {
        List<String> vaccinationsStrings = new ArrayList<>();
        for (MedicalActs medicalActs : _vaccinations) {
            vaccinationsStrings.add(medicalActs.toString()); 
        }
        return Collections.unmodifiableCollection(
            vaccinationsStrings);
    }

    /**
     * calculate and returns the value of Satisfaction of Animal
     * @param idAnimal
     * @throws AnimalNotFoundException
     * @return value of satisfaction rounded to int
     */
    public int showSatisfactionOfAnimal(String idAnimal) throws 
    AnimalNotFoundException {
        if (!existAnimal(idAnimal)) {
            throw new AnimalNotFoundException(idAnimal);
        }
        Animal animal = getAnimal(idAnimal);
        
        return (int) Math.round(animal.getAnimalSatisfaction().
        calculateAnimalSatisfaction());
    }

    /**
     * calculate and returns the value of Satisfaction of Employee
     * @param idEmployee
     * @throws EmployeeNotFoundException
     * @return value of satisfaction rounded to int
     */
    public int showSatisfactionOfEmployee(String idEmployee) throws 
    EmployeeNotFoundException {
        if (!existEmployee(idEmployee)) {
            throw new EmployeeNotFoundException(idEmployee);
        }
        Employee employee = getEmployee(idEmployee);
        
        return (int) Math.round(employee.getSatisfaction().
        calculateEmployeeSatisfaction());
    }

    /**
     * calculate and returns the sum of Satisfaction for all 
     * employees and animals.
     * 
     * @return value of satisfaction rounded to int
     */
    public int showGlobalSatisfaction() {
        double satisfaction = 0;
        for (Animal a: _animals.values()) {
            satisfaction += a.getAnimalSatisfaction().
            calculateAnimalSatisfaction();
        }
        for (Employee e: _employees.values()) {
            satisfaction += e.getSatisfaction().
            calculateEmployeeSatisfaction();
        }
        return (int) Math.round(satisfaction);
    }

}