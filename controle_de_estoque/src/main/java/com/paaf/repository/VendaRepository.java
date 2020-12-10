package com.paaf.repository;

import org.bson.types.ObjectId;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.paaf.model.Produto;

@Repository
public interface VendaRepository extends CrudRepository<Produto, ObjectId> {

}