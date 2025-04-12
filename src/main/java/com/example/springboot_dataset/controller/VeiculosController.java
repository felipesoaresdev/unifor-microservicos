package com.example.springboot_dataset.controller;


import com.example.springboot_dataset.model.Veiculos;
import com.example.springboot_dataset.service.VeiculosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/veiculos")
public class VeiculosController {
    @Autowired
    private VeiculosService veiculosService;

    @GetMapping
    public List<Veiculos> getAllItems(){
        return veiculosService.getAllItems();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Veiculos> getItemById(@PathVariable String id){
        return veiculosService.getItemById(id);
    }
    @GetMapping("/by-marca")
    public ResponseEntity<List<Veiculos>> getItemByMarca(@RequestParam String marca){
        return veiculosService.getItemByMarca(marca);
    }
    @GetMapping("/by-tipo")
    public ResponseEntity<List<Veiculos>> getItemByTipo(@RequestParam String tipo){
        return veiculosService.getItemByTipo(tipo);
    }
    @GetMapping("/by-preco")
    public ResponseEntity<List<Veiculos>> getItemByPreco(
            @RequestParam double min,
            @RequestParam double max){
        return veiculosService.getItemByPrecoBetween(min,max);
    }
}
