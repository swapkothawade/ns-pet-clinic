package com.nspc.Controllers;

import com.nspc.model.Owner;
import com.nspc.services.OwnerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Set;

@Controller
public class OwnerController {
    private OwnerService ownerService;

    public OwnerController(OwnerService ownerServiceMap) {
        this.ownerService = ownerServiceMap;
    }

    @RequestMapping("/owners")
    public String owners(Model model){

        Set<Owner> owners = ownerService.findAll();
        System.out.println("Owneres from controller " + owners.size());
        model.addAttribute("owners",owners);
        return "owner/owner";
    }
}
