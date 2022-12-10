package com.example.demo.service.spravka;

import com.example.demo.entity.People;
import com.example.demo.entity.Reference;

import java.util.List;

public interface ReferenceService {
    public List<Reference> findAllByStudent(String login);

    public List<Reference> getAllReference();

    public void saveReference(Reference reference);

    public Reference getReference(int id);

    public void deleteReference(int id);
}