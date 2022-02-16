package com.uniovi.notaneitor.controllers;

import com.uniovi.notaneitor.entities.Mark;
import com.uniovi.notaneitor.entities.Professor;
import com.uniovi.notaneitor.services.MarksService;
import com.uniovi.notaneitor.services.ProfessorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

        @RequestMapping("/professor/details/{dni}")
        public String getDetail(@PathVariable String dni) {
            return professorsService.getProfessor(dni).toString();
        }

        @RequestMapping("/professor/delete/{dni}")
        public String deleteMark(@PathVariable String dni){
            professorsService.deleteProfessor(dni);
            return professorsService.getProfessors().toString();
        }

        @RequestMapping(value="/professor/edit/{dni}", method=RequestMethod.POST)
        public String setEdit(@PathVariable String dni,@ModelAttribute Professor professor) {
            professorsService.updateProfessor(dni, professor);
            return professorsService.getProfessor(dni).toString();
        }

}
