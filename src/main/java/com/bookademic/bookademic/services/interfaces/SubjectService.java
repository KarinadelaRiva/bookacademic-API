package com.bookademic.bookademic.services.interfaces;

import com.bookademic.bookademic.domain.entities.Subject;
import com.bookademic.bookademic.exceptions.domainExceptions.resourceNotFound.SubjectNotFoundException;
import com.bookademic.bookademic.repositories.SubjectRepository;

public class SubjectService  {

    private final SubjectRepository subjectRepository;

    public SubjectService(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }


    public Subject findEntityById(Long id) {
        return subjectRepository.findById(id)
                .orElseThrow(() -> new SubjectNotFoundException("Subject not found with ID: " + id));
    }


    public Subject findByCode(String code) {
        return subjectRepository.findByCode(code)
                .orElseThrow(() -> new SubjectNotFoundException("Subject not found with code: " + code));
    }
}
