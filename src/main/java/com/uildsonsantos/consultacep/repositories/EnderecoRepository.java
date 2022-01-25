package com.uildsonsantos.consultacep.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.uildsonsantos.consultacep.model.Endereco;

@Repository
public interface EnderecoRepository extends CrudRepository<Endereco, String> {

}