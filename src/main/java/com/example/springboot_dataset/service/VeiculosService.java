package com.example.springboot_dataset.service;

import com.example.springboot_dataset.model.Veiculos;
import com.example.springboot_dataset.repository.VeiculosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VeiculosService {

    @Autowired
    private VeiculosRepository veiculosRepository;

    public List<Veiculos> getAllItems(){
        return veiculosRepository.findAll();
    }


    public ResponseEntity<Veiculos> getItemById(String id){

        return veiculosRepository.findById(id)
                .map(ResponseEntity :: ok)
                .orElse(ResponseEntity.notFound().build());

    }
    public ResponseEntity<List<Veiculos>> getItemByMarca(String marca){
        List<Veiculos> veiculos = veiculosRepository.findByMarcaContainingIgnoreCase(marca);
        return ResponseEntity.ok(veiculos);
    }
    public ResponseEntity<List<Veiculos>> getItemByTipo(String tipo){
        List<Veiculos> veiculos = veiculosRepository.findByTipoContainingIgnoreCase(tipo);
        return ResponseEntity.ok(veiculos);
    }
    public ResponseEntity<List<Veiculos>> getItemByPrecoBetween(double min, double max){
        List<Veiculos> veiculos = veiculosRepository.findByPrecoBetween(min, max);
        return ResponseEntity.ok(veiculos);
    }

}
