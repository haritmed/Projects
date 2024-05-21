package com.example.locationvoiture1.web;

import com.example.locationvoiture1.dao.entities.Voiture;
import com.example.locationvoiture1.service.VoitureManagerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;

@Controller
@AllArgsConstructor
public class VoitureController {
    private VoitureManagerService voitureManagerService;
    @RequestMapping("/createVoiture")
    public String createVoiture(){
        return "CreateVoiture";
    }

    @RequestMapping("/saveVoiture")
    public String saveVoiture(@ModelAttribute("voitureVue") Voiture voitureController){
        Voiture saveVoiture= voitureManagerService.saveVoiture(voitureController);
        return "CreateVoiture";
    }
    @GetMapping("/CarList")
    public String carList(Model model, @RequestParam(name = "page", defaultValue = "0" ) int page,
                                @RequestParam(name = "taille", defaultValue = "6" ) int taille,
                                @RequestParam(name = "search", defaultValue = "") String keyword
    ) {
        Page<Voiture> voitures = voitureManagerService.getAllVoitures(page, taille, keyword);
        model.addAttribute("voituresVue", voitures);
        int[] pages = new int[voitures.getTotalPages()];
        for (int i = 0; i < pages.length; i++) {
            pages[i] = i;
        }
        model.addAttribute("pages", pages);
        model.addAttribute("currentPage", page);
        model.addAttribute("keyword", keyword);
        return "CarList";
    }
    @RequestMapping("/CarList")
    public String carList(ModelMap modelMap,
                               @RequestParam(name ="page",defaultValue = "0")int page,
                               @RequestParam(name ="size",defaultValue = "2")int size) {
        Page<Voiture> voitureController = voitureManagerService.getAllVoitureByPage(page, size);
        modelMap.addAttribute("voituresVue", voitureController);
        modelMap.addAttribute("pages",new int[voitureController.getTotalPages()]);
        modelMap.addAttribute("currentPage",page);
        return "CarList";
    }
    @RequestMapping("/editVoiture")
    public String editVoiture(@RequestParam("id") Long id, ModelMap modelMap) {
        Voiture voiture = voitureManagerService.getVoitureById(id);
        modelMap.addAttribute("voituresVue", voiture);
        return "EditVoiture";
    }
    @RequestMapping("updateVoiture")
    public String updateVoiture(

            @ModelAttribute("voituresVue") Voiture voitureController){

        voitureManagerService.updateVoiture(voitureController);
        return "redirect:CarList";

    }
    @GetMapping("/")
    public String homePage(ModelMap model) {

        model.addAttribute("voituresVue", voitureManagerService.getAllVoitures());
        return "HomePage";
    }
   /* @RequestMapping("/voituresList")
    public String voituressList(ModelMap modelMap){
        List<Voiture> patientsController= voitureManagerService.getAllVoitures();
        ModelMap.addAttribute("patientsVue",patientsController);
        return "VoituresList";
    }
   @GetMapping("/indexpage")
   public String listProduitsAction(Model model,

                                    @RequestParam(name = "page", defaultValue = "0" ) int page,
                                    @RequestParam(name = "taille", defaultValue = "6" ) int taille
   ) {

       Page<Voiture> voitures = voitureManagerService.getAllVoitures(page, taille);
       model.addAttribute("listProduits", voitures.getContent());
       int[] pages = new int[voitures.getTotalPages()];
       model.addAttribute("pages" , pages);
       model.addAttribute(“currentPage", page);
       return "index";
   }*/

}
