package hva.vaccine;

import java.io.Serializable;

public class MedicalActs implements Serializable{
    private String _idVaccine;

    private String _idVet;

    private String _idSpecies;

    public MedicalActs(String idVaccine, String idVet, 
    String idSpecies) {
        _idVaccine = idVaccine;
        _idVet = idVet;
        _idSpecies = idSpecies;
    }

    public String getIdVaccine(){
        return _idVaccine;
    }

    public String getIdVet() {
        return _idVet;
    }

    public String getIdSpecies() {
        return _idSpecies;
    }

    @Override
    public String toString() {
        return String.format(
            "REGISTO-VACINA|%s|%s|%s", _idVaccine, _idVet,
            _idSpecies);   
    }
}
