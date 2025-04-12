package com.example.springboot_dataset.repository;

import com.example.springboot_dataset.model.Veiculos;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VeiculosRepository extends MongoRepository<Veiculos, String> {

    List<Veiculos> findByMarcaContainingIgnoreCase(String marca);
    List<Veiculos> findByTipoContainingIgnoreCase(String tipo);
    List<Veiculos> findByPrecoBetween(double min, double max);


}
