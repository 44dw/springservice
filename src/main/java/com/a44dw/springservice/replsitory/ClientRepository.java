package com.a44dw.springservice.replsitory;

import com.a44dw.springservice.model.Client;
import org.springframework.data.repository.CrudRepository;

public interface ClientRepository extends CrudRepository<Client, Integer> {}
