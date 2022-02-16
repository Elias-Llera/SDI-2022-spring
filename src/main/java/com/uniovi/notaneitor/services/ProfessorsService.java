package com.uniovi.notaneitor.services;

import com.uniovi.notaneitor.entities.Professor;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProfessorsService {

    List<Professor> professors;

    @PostConstruct
    public void init(){
        professors = new ArrayList<>();
        professors.add(new Professor("123", "profName1", "profSur1", "cat1" ));
        professors.add(new Professor("456", "profName2", "profSur2", "cat2" ));
        professors.add(new Professor("789", "profName3", "profSur3", "cat3" ));
    }

    public List<Professor> getProfessors() {
        return professors;
    }

    public void addProfessor(Professor professor) {
        professors.add(professor);
    }

    public void deleteProfessor(String dni) {
        professors.removeIf(professor -> professor.getDni().equals(dni));
    }

    public Professor getProfessor(String dni) {
        for (Professor p: professors
             ) {
            if(p.getDni().equals(dni)){
                return p;
            }
        }
        return null;
    }

    public void updateProfessor(String dni, Professor professor) {
        for(Professor p : professors){
            if(p.getDni().equals(dni)){
                p.setName(professor.getName());
                p.setSurname(professor.getSurname());
                p.setCategory(professor.getCategory());
            }
        }
    }
}
