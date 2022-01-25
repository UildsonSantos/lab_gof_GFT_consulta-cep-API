package com.uildsonsantos.consultacep.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.uildsonsantos.consultacep.model.Cliente;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Long> {

}