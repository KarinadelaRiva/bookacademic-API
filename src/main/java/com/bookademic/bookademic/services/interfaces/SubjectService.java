package com.bookademic.bookademic.services.interfaces;

import com.bookademic.bookademic.domain.dto.subject.SubjectCreateDTO;
import com.bookademic.bookademic.domain.dto.subject.SubjectResponseAdminDTO;
import com.bookademic.bookademic.domain.dto.subject.SubjectResponseUserDTO;
import com.bookademic.bookademic.domain.dto.subject.SubjectUpdateDTO;
import com.bookademic.bookademic.domain.entities.DegreeProgram;
import com.bookademic.bookademic.domain.entities.Subject;
import com.bookademic.bookademic.exceptions.domainExceptions.resourceNotFound.SubjectNotFoundException;
import com.bookademic.bookademic.exceptions.domainExceptions.resourseConflict.ResourceConflictException;
import com.bookademic.bookademic.mappers.SubjectMapper;
import com.bookademic.bookademic.repositories.SubjectRepository;
import com.bookademic.bookademic.services.DegreeProgramService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class SubjectService implements IService<Subject> {

    private final SubjectRepository subjectRepository;
    private final SubjectMapper subjectMapper;
    private final DegreeProgramService degreeProgramService;

    public SubjectService(SubjectRepository subjectRepository,
                          SubjectMapper subjectMapper,
                          @Lazy DegreeProgramService degreeProgramService) {
        this.subjectRepository = subjectRepository;
        this.subjectMapper = subjectMapper;
        this.degreeProgramService = degreeProgramService;
    }

    @Transactional
    public Subject create(SubjectCreateDTO subjectCreateDTO) {
        Set<Long> seenIds = new HashSet<>();
        Set<String> seenCodes = new HashSet<>();
        Set<DegreeProgram> uniqueDegreePrograms = new HashSet<>();

        validateCodeUniqueness(subjectCreateDTO.getCode());

        if(subjectCreateDTO.getDegreeProgramIds() != null) {
            for(Long degreeProgramId : subjectCreateDTO.getDegreeProgramIds()) {
                if (degreeProgramId != null && seenIds.add(degreeProgramId)) {
                    DegreeProgram degreeProgram = degreeProgramService.findEntityById(degreeProgramId);
                    uniqueDegreePrograms.add(degreeProgram);
                }
            }
        }

        if(subjectCreateDTO.getDegreeProgramCodes() != null) {
            for(String degreeProgramCode : subjectCreateDTO.getDegreeProgramCodes()) {
                if (degreeProgramCode != null && seenCodes.add(degreeProgramCode)) {
                    DegreeProgram degreeProgram = degreeProgramService.findByCode(degreeProgramCode);
                    uniqueDegreePrograms.add(degreeProgram);
                }
            }
        }

        Subject subject = subjectMapper.toEntity(subjectCreateDTO, new ArrayList<>(uniqueDegreePrograms));
        return subjectRepository.save(subject);
    }

    @Transactional(readOnly = true)
    public Subject findEntityById(Long id) {
        return subjectRepository.findById(id)
                .orElseThrow(() -> new SubjectNotFoundException("Subject not found with ID: " + id));
    }

    @Transactional(readOnly = true)
    public SubjectResponseAdminDTO findByIdAdminDTO(Long id) {
        Subject subject = findEntityById(id);
        return subjectMapper.toResponseAdminDTO(subject);
    }

    @Transactional(readOnly = true)
    public SubjectResponseUserDTO findByIdUserDTO(Long id) {
        Subject subject = findEntityById(id);
        if (!subject.getActive()) {
            throw new SubjectNotFoundException("Subject not found with ID: " + id + " or it is inactive.");
        }
        return subjectMapper.toResponseUserDTO(subject);
    }

    @Transactional(readOnly = true)
    public Subject findByCode(String code) {
        return subjectRepository.findByCode(code)
                .orElseThrow(() -> new SubjectNotFoundException("Subject not found with code: " + code));
    }

    @Transactional(readOnly = true)
    public SubjectResponseAdminDTO findByCodeAdminDTO(String code) {
        Subject subject = findByCode(code);
        return subjectMapper.toResponseAdminDTO(subject);
    }

    @Transactional(readOnly = true)
    public SubjectResponseUserDTO findByCodeUserDTO(String code) {
        Subject subject = findByCode(code);
        if (!subject.getActive()) {
            throw new SubjectNotFoundException("Subject not found with code: " + code + " or it is inactive.");
        }
        return subjectMapper.toResponseUserDTO(subject);
    }

    @Transactional(readOnly = true)
    public List<Subject> findAll() {
        return subjectRepository.findAll();
    }

    @Transactional(readOnly = true)
    public List<SubjectResponseAdminDTO> findAllAdminDTO() {
        List<Subject> subjects = findAll();
        return subjects.stream()
                .map(subjectMapper::toResponseAdminDTO)
                .toList();
    }

    @Transactional(readOnly = true)
    public List<SubjectResponseUserDTO> findAllUserDTO() {
        List<Subject> subjects = findAll();
        return subjects.stream()
                .filter(Subject::getActive) // Filter only active subjects
                .map(subjectMapper::toResponseUserDTO)
                .toList();
    }

    @Transactional(readOnly = true)
    public List<Subject> searchByName(String partialName) {
        List<Subject> subjects = subjectRepository.findByNameContainingIgnoreCase(partialName);

        if (subjects.isEmpty()) {
            throw new SubjectNotFoundException("No subjects found with name containing: " + partialName);
        }

        return subjects;
    }

    @Transactional(readOnly = true)
    public List<SubjectResponseAdminDTO> searchByNameAdminDTO(String partialName) {
        List<Subject> subjects = searchByName(partialName);
        return subjects.stream()
                .map(subjectMapper::toResponseAdminDTO)
                .toList();
    }

    @Transactional(readOnly = true)
    public List<SubjectResponseUserDTO> searchByNameUserDTO(String partialName) {
        List<Subject> subjects = searchByName(partialName);
        return subjects.stream()
                .filter(Subject::getActive) // Filter only active subjects
                .map(subjectMapper::toResponseUserDTO)
                .toList();
    }

    @Transactional(readOnly = true)
    public List<Subject> searchByDegreeProgramId(Long degreeProgramId) {
        return subjectRepository.findByDegreeProgramId(degreeProgramId);
    }

    @Transactional(readOnly = true)
    public List<SubjectResponseAdminDTO> searchByDegreeProgramIdAdminDTO(Long degreeProgramId) {
        List<Subject> subjects = searchByDegreeProgramId(degreeProgramId);
        return subjects.stream()
                .map(subjectMapper::toResponseAdminDTO)
                .toList();
    }

    @Transactional(readOnly = true)
    public List<SubjectResponseUserDTO> searchByDegreeProgramIdUserDTO(Long degreeProgramId) {
        List<Subject> subjects = searchByDegreeProgramId(degreeProgramId);
        return subjects.stream()
                .filter(Subject::getActive) // Filter only active subjects
                .map(subjectMapper::toResponseUserDTO)
                .toList();
    }

    @Transactional(rollbackFor = Exception.class)
    public Subject update(SubjectUpdateDTO subjectUpdateDTO){
        Subject existingSubject;

        if(subjectUpdateDTO.getId() != null && subjectUpdateDTO.getCode() != null) {
            existingSubject = findEntityById(subjectUpdateDTO.getId());
        } else if (subjectUpdateDTO.getId() != null) {
            existingSubject = findEntityById(subjectUpdateDTO.getId());
        } else if (subjectUpdateDTO.getCode() != null) {
            existingSubject = findByCode(subjectUpdateDTO.getCode());
        } else {
            throw new IllegalArgumentException("Either ID or code must be provided for update.");
        }

        validateCodeUniqueness(subjectUpdateDTO.getCode(), existingSubject.getId());

        if(existingSubject.getCode() == null){
            existingSubject.setCode(subjectUpdateDTO.getCode());
        }
        if(subjectUpdateDTO.getName() != null){
            existingSubject.setName(subjectUpdateDTO.getName());
        }
        if(subjectUpdateDTO.getRequiresLab() != null){
            existingSubject.setRequiresLab(subjectUpdateDTO.getRequiresLab());
        }
        if(subjectUpdateDTO.getRequiresWorkshop() != null){
            existingSubject.setRequiresWorkshop(subjectUpdateDTO.getRequiresWorkshop());
        }

        return subjectRepository.save(existingSubject);
    }

    @Transactional(rollbackFor = Exception.class)
    public Subject deleteById(Long id) {
        Subject subject = findEntityById(id);

        if (!subject.getActive()) {
            throw new ResourceConflictException("Subject with ID: " + id + " is already inactive.");
        }

        removeSubjectFromDegreePrograms(id);

        subject.setActive(false);
        return subjectRepository.save(subject);
    }

    @Transactional(rollbackFor = Exception.class)
    public Subject reactivateById(Long id) {
        Subject subject = findEntityById(id);

        if (subject.getActive()) {
            throw new ResourceConflictException("Subject with ID: " + id + " is already active.");
        }

        subject.setActive(true);
        return subjectRepository.save(subject);
    }

    @Transactional(rollbackFor = Exception.class)
    private void removeSubjectFromDegreePrograms(Long subjectId) {
        Subject subject = findEntityById(subjectId);

        if (subject.getDegreePrograms() != null && !subject.getDegreePrograms().isEmpty()) {
            degreeProgramService.removeSubjectFromAllDegreePrograms(subject);
            subject.setDegreePrograms(new ArrayList<>());
        }
    }

    private void validateCodeUniqueness(String code){
        if (code == null || code.isBlank()){
            return; // Do nothing if code is null or blank
        }

        if(subjectRepository.existsByCode(code)) {
            throw new ResourceConflictException("A subject with code " + code + " already exists.");
        }
    }

    private void validateCodeUniqueness(String code, Long currentId) {
        if (code == null || code.isBlank()) {
            return; // Do nothing if code is null or blank
        }

        subjectRepository.findByCode(code)
                .ifPresent(subject -> {
                    if (!subject.getId().equals(currentId)) {
                        throw new ResourceConflictException("A subject with code " + code + " already exists.");
                    }
                });
    }
}
