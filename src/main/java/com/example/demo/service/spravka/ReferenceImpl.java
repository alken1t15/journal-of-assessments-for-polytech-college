package com.example.demo.service.spravka;

import com.example.demo.dao.PeopleRepository;
import com.example.demo.dao.ReferenceRepository;
import com.example.demo.entity.People;
import com.example.demo.entity.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReferenceImpl implements ReferenceService {
    @Autowired
    private ReferenceRepository referenceRepository;

    @Override
    public List<Reference> findAllByStudent(String login) {
        List<Reference> people = referenceRepository.findAllByStudent(login);
        return people;
    }

    @Override
    public List<Reference> getAllReference() {
        return null;
    }

    @Override
    public void saveReference(Reference reference) {
        referenceRepository.save(reference);
    }

    @Override
    public Reference getReference(int id) {
        return null;
    }

    @Override
    public void deleteReference(int id) {

    }
}