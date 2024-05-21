package com.example.locationvoiture1.web;

import com.example.locationvoiture1.dao.entities.Voiture;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import com.example.locationvoiture1.dao.entities.Client;
import com.example.locationvoiture1.service.ClientManagerService;
@Controller
@AllArgsConstructor
public class ClientController {
    private ClientManagerService clientManagerService;
    /*@PostMapping("/addClient")
    public String addClient(@RequestParam String nom, @RequestParam String prenom,
                            @RequestParam String email, @RequestParam String numtel, Model model) {
        Client newClient = new Client(id,nom, prenom, email, numtel);
        clientManagerService.save(newClient);
        return "redirect:/clients"; // Redirect to the list of clients after adding
    }*/
    @RequestMapping("/createClient")
    public String createClient(){
        return "CreateClient";
    }
    @RequestMapping("/saveClient")
    public String saveVoiture(@ModelAttribute("clientVue") Client clientController){
        Client saveClient= clientManagerService.saveClient(clientController);
        return "CreateClient";
    }
    @GetMapping("/ClientList")
    public String ClientList(Model model, @RequestParam(name = "page", defaultValue = "0" ) int page,
                                  @RequestParam(name = "taille", defaultValue = "6" ) int taille,
                                  @RequestParam(name = "search", defaultValue = "") String keyword
    ) {
        Page<Client> clients = clientManagerService.getAllClients(page, taille, keyword);
        model.addAttribute("clientsVue", clients);
        int[] pages = new int[clients.getTotalPages()];
        for (int i = 0; i < pages.length; i++) {
            pages[i] = i;
        }
        model.addAttribute("pages", pages);
        model.addAttribute("currentPage", page);
        model.addAttribute("keyword", keyword);
        return "ClientList";
    }
    @RequestMapping("/ClientList")
    public String clientList(ModelMap modelMap,
                               @RequestParam(name ="page",defaultValue = "0")int page,
                               @RequestParam(name ="size",defaultValue = "2")int size) {
        Page<Client> clientController = clientManagerService.getAllClientByPage(page, size);
        modelMap.addAttribute("clientsVue", clientController);
        modelMap.addAttribute("pages",new int[clientController.getTotalPages()]);
        modelMap.addAttribute("currentPage",page);
        return "ClientList";
    }
    @RequestMapping("/editClient")
    public String editClient(@RequestParam("id") Long id, ModelMap modelMap) {
        Client client = clientManagerService.getClientById(id);
        modelMap.addAttribute("clientVue", client);
        return "EditClient"; // Assurez-vous que "EditeShoes" est le nom de votre vue JSP pour l'édition de chaussures
    }
    @RequestMapping("updateClient")

    public String updateClient(

            @ModelAttribute("clientVue") Client clientController){

        clientManagerService.updateClient(clientController);
        return "redirect:ClientList";

    }
    @RequestMapping("/deleteClient")

    public String deleteClient(@RequestParam("id") Integer id, ModelMap modelMap,
                                 @RequestParam(name ="page",defaultValue = "0")int page,
                                 @RequestParam(name ="size",defaultValue = "2")int size) {
        clientManagerService.deleteClientById(id);
        Page<Client> clientController = clientManagerService.getAllClientByPage(page, size);
        modelMap.addAttribute("clientVue", clientController);
        modelMap.addAttribute("pages",new int[clientController.getTotalPages()]);
        modelMap.addAttribute("currentPage",page);
        return "ClientList";}
}
