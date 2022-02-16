package com.uniovi.notaneitor.controllers;

import com.uniovi.notaneitor.entities.Professor;
import com.uniovi.notaneitor.services.ProfessorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProfessorsController {

        @Autowired
        private ProfessorsService professorsService;

        @RequestMapping("/professor/list")
        public String getList(){
            return professorsService.getProfessors().toString();
        }

        @RequestMapping(value= "/professor/add", method = RequestMethod.POST)
        public String setProfessor(@ModelAttribute Professor professor) {
            professorsService.addProfessor(professor);
            return professorsService.getProfessors().toString();
        }

        @RequestMapping("/professor/details/{id}")
        public String getDetail(@PathVariable Long id) {
            return professorsService.getProfessor(id).toString();
        }

        @RequestMapping("/professor/delete/{id}")
        public String deleteMark(@PathVariable Long id){
            professorsService.deleteProfessor(id);
            return professorsService.getProfessors().toString();
        }

        @RequestMapping(value="/professor/edit/{id}", method=RequestMethod.POST)
        public String setEdit(@PathVariable Long id,@ModelAttribute Professor professor) {
            professor.setId(id);
            professorsService.addProfessor(professor);
            return professorsService.getProfessor(id).toString();
        }

}
