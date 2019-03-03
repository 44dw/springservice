package com.a44dw.springservice;

import com.a44dw.springservice.model.Client;
import com.a44dw.springservice.replsitory.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.Locale;

@Service
public class ClientFormatter implements Formatter<Client> {

    @Autowired
    ClientRepository repository;

    @Override
    public String print(Client client, Locale locale) {
        return client != null ? client.getId().toString() : "";
    }

    @Override
    public Client parse(String s, Locale locale) throws ParseException {
        Integer id = Integer.valueOf(s);
        return this.repository.findById(id).get();
    }
}
