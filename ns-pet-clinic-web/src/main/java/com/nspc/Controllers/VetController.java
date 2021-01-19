package com.nspc.Controllers;

import com.nspc.model.Vet;
import com.nspc.services.VetService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Set;

@Controller
public class VetController {
    private VetService vetServiceMap;

    public VetController(VetService vetServiceMap) {
        this.vetServiceMap = vetServiceMap;
    }

    @RequestMapping({"/vets","vets.html"})
    public String vets(Model model){
        Set<Vet> vets  = vetServiceMap.findAll();
        System.out.println("Vets from controller " + vets.size());
        model.addAttribute("vets",vets);
        return "vet/vets";
    }
}
