package com.a44dw.springservice.controller;

import com.a44dw.springservice.model.Client;
import com.a44dw.springservice.replsitory.ClientRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;
import java.util.Map;
import java.util.Optional;

@Controller
@RequestMapping("/clients")
public class ClientController {

    private final ClientRepository clientRepository;

    public ClientController(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @GetMapping
    public String showClients(Model model) {

        addClientsToModel(model);

        return "clientsList";
    }

    private void addClientsToModel(Model model) {
        Collection<Client> results = (Collection<Client>) clientRepository.findAll();

        model.addAttribute("clients", results);
    }

    @GetMapping("/new")
    public String initNewClientForm(Map<String, Object> model) {
        Client client = new Client();
        model.put("client", client);
        return "editClient";
    }

    @PostMapping({"/new", "/update/{id}"})
    public String processClientForm(@Valid Client client, BindingResult result, @PathVariable(value = "id", required = false) Integer id) {
        if(result.hasErrors()) {
            return "editClient";
        }
        if(id != null)
            client.setId(id);
        clientRepository.save(client);
        return "redirect:/clients";
    }

    @GetMapping("/update/{id}")
    public String initUpdateClientForm(@PathVariable("id") int id, Model model) {
        Optional<Client> optionalClient = clientRepository.findById(id);
        if(optionalClient.isPresent()) {
            model.addAttribute(optionalClient.get());
            return "editClient";
        }
        return "redirect:/clients";
    }

    //@DeleteMapping почему-то возвращает 405 ошибку
    @GetMapping("/delete/{id}")
    public String processDelete(@PathVariable("id") int id) {
        try {
            clientRepository.deleteById(id);
        } catch (Exception e) {
            return "deleteError";
        }
        return "redirect:/clients";
    }

    @GetMapping("/deleteError")
    public String showErrorMessage() {
        return "deleteError";
    }
}
