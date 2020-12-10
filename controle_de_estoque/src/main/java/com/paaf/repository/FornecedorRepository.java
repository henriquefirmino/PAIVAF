package com.paaf.repository;

import org.bson.types.ObjectId;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.paaf.model.Produto;

@Repository
public interface FornecedorRepository extends CrudRepository<Produto, ObjectId> {

}