package com.senai.devinadoption.service;

import com.senai.devinadoption.enums.Animal;
import com.senai.devinadoption.model.Armazem;
import com.senai.devinadoption.repository.ArmazemRepository;
import org.springframework.stereotype.Service;


@Service
public class ArmazemServiceImpl implements ArmazemService {
    private final ArmazemRepository armazemRepository;

    public ArmazemServiceImpl(ArmazemRepository armazemRepository) {
        this.armazemRepository = armazemRepository;
    }


    @Override
    public Armazem cadastrarArmazem(String nome, Animal animal) {
        Armazem armazem = new Armazem();
        armazem.setNome(nome);
        armazem.setAnimal(animal);
        return armazemRepository.save(armazem);
    }
}


