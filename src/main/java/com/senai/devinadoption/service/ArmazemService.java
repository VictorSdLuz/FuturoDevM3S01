package com.senai.devinadoption.service;

import com.senai.devinadoption.enums.Animal;
import com.senai.devinadoption.model.Armazem;

public interface ArmazemService {


    Armazem cadastrarArmazem(String nome, Animal tipoAnimal);
}
