package local.my.temp.controller;

import local.my.temp.dto.ClientDTO;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author Vitaly Moskalik
 * created on 24.10.2017
 */
@RestController
@RequestMapping(value = "/clients")
public class ClientController {

    @PostMapping
    public void save(@Valid @RequestBody ClientDTO clientDTO, BindingResult bindingResult) {
        System.out.println(bindingResult);
    }

    @GetMapping
    public String hello() {
        return "Hello, World!";
    }
}
