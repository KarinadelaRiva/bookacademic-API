package com.bookademic.bookademic.services;

import com.bookademic.bookademic.domain.dto.degreeProgram.DegreeProgramCreateDTO;
import com.bookademic.bookademic.domain.dto.degreeProgram.DegreeProgramResponseAdminDTO;
import com.bookademic.bookademic.domain.dto.degreeProgram.DegreeProgramResponseUserDTO;
import com.bookademic.bookademic.domain.dto.degreeProgram.DegreeProgramUpdateDTO;
import com.bookademic.bookademic.domain.entities.DegreeProgram;
import com.bookademic.bookademic.domain.entities.Subject;
import com.bookademic.bookademic.exceptions.domainExceptions.resourceNotFound.DegreeProgramNotFoundException;
import com.bookademic.bookademic.exceptions.domainExceptions.resourseConflict.ResourceConflictException;
import com.bookademic.bookademic.mappers.DegreeProgramMapper;
import com.bookademic.bookademic.repositories.DegreeProgramRepository;
import com.bookademic.bookademic.services.interfaces.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class DegreeProgramService implements IService<DegreeProgram> {
    private final DegreeProgramRepository degreeProgramRepository;
    private final DegreeProgramMapper degreeProgramMapper;
    private final SubjectService subjectService;

    @Autowired
    public DegreeProgramService(DegreeProgramRepository degreeProgramRepository,
                                DegreeProgramMapper degreeProgramMapper,
                                SubjectService subjectService) {
        this.degreeProgramRepository = degreeProgramRepository;
        this.degreeProgramMapper = degreeProgramMapper;
        this.subjectService = subjectService;
    }

    @Transactional(rollbackFor = Exception.class)
    public DegreeProgram create(DegreeProgramCreateDTO degreeProgramCreateDTO) {
        Set<Long> seenIds = new HashSet<>();
        Set<String> seenCodes = new HashSet<>();
        Set<Subject> uniqueSubjects = new HashSet<>();

        validateCodeUniqueness(degreeProgramCreateDTO.getCode());

        if (degreeProgramCreateDTO.getSubjectsIds() != null) {
            for (Long subjectId : degreeProgramCreateDTO.getSubjectsIds()) {
                if (subjectId != null && seenIds.add(subjectId)) {
                    Subject subject = subjectService.findEntityById(subjectId);
                    uniqueSubjects.add(subject);
                }
            }
        }

        if (degreeProgramCreateDTO.getSubjectsCodes() != null) {
            for (String subjectCode : degreeProgramCreateDTO.getSubjectsCodes()) {
                if (subjectCode != null && seenCodes.add(subjectCode)) {
                    Subject subject = subjectService.findByCode(subjectCode);
                    uniqueSubjects.add(subject);
                }
            }
        }

        DegreeProgram degreeProgram = degreeProgramMapper.toEntity(degreeProgramCreateDTO, new ArrayList<>(uniqueSubjects));
        return degreeProgramRepository.save(degreeProgram);
    }

    @Transactional(readOnly = true)
    public DegreeProgram findEntityById(Long id) {
        return degreeProgramRepository.findById(id)
                .orElseThrow(() -> new DegreeProgramNotFoundException("Degree Program not found with ID: " + id));
    }

    @Transactional(readOnly = true)
    public DegreeProgramResponseAdminDTO findByIdAdminDTO(Long id) {
        DegreeProgram degreeProgram = findEntityById(id);
        return degreeProgramMapper.toResponseAdminDto(degreeProgram);
    }

    @Transactional(readOnly = true)
    public DegreeProgramResponseUserDTO findByIdUserDTO(Long id) {
        DegreeProgram degreeProgram = findEntityById(id);
        if (!degreeProgram.getActive()) {
            throw new DegreeProgramNotFoundException("Degree Program not found or inactive with ID: " + id);
        }
        return degreeProgramMapper.toResponseUserDto(degreeProgram);
    }

    @Transactional(readOnly = true)
    public DegreeProgram findByCode(String code) {
        return degreeProgramRepository.findByCode(code.toUpperCase())
                .orElseThrow(() -> new DegreeProgramNotFoundException("Degree Program not found with code: " + code.toUpperCase()));
    }

    @Transactional(readOnly = true)
    public DegreeProgramResponseAdminDTO findByCodeAdminDTO(String code) {
        DegreeProgram degreeProgram = findByCode(code);
        return degreeProgramMapper.toResponseAdminDto(degreeProgram);
    }

    @Transactional(readOnly = true)
    public DegreeProgramResponseUserDTO findByCodeUserDTO(String code) {
        DegreeProgram degreeProgram = findByCode(code);
        if (!degreeProgram.getActive()) {
            throw new DegreeProgramNotFoundException("Degree Program not found or inactive with code: " + code.toUpperCase());
        }
        return degreeProgramMapper.toResponseUserDto(degreeProgram);
    }

    @Transactional(readOnly = true)
    public List<DegreeProgram> findAll() {
        return degreeProgramRepository.findAll();
    }

    @Transactional(readOnly = true)
    public List<DegreeProgramResponseAdminDTO> findAllAdminDTO() {
        List<DegreeProgram> degreePrograms = findAll();
        return degreePrograms.stream()
                .map(degreeProgramMapper::toResponseAdminDto)
                .toList();
    }

    @Transactional(readOnly = true)
    public List<DegreeProgramResponseUserDTO> findAllUserDTO() {
        List<DegreeProgram> degreePrograms = findAll();
        return degreePrograms.stream()
                .filter(DegreeProgram::getActive)
                .map(degreeProgramMapper::toResponseUserDto)
                .toList();
    }

    @Transactional(readOnly = true)
    public List<DegreeProgram> searchByName(String partialName) {
        List<DegreeProgram> degreePrograms = degreeProgramRepository.findByNameContainingIgnoreCase(partialName.toUpperCase());

        if (degreePrograms.isEmpty()) {
            throw new DegreeProgramNotFoundException("No Degree Programs found with name containing: " + partialName);
        }

        return degreePrograms;
    }

    @Transactional(readOnly = true)
    public List<DegreeProgramResponseAdminDTO> searchByNameAdminDTO(String partialName) {
        return searchByName(partialName).stream()
                .map(degreeProgramMapper::toResponseAdminDto)
                .toList();
    }

    @Transactional(readOnly = true)
    public List<DegreeProgramResponseUserDTO> searchByNameUserDTO(String partialName) {
        return searchByName(partialName).stream()
                .filter(DegreeProgram::getActive)
                .map(degreeProgramMapper::toResponseUserDto)
                .toList();
    }

    @Transactional(rollbackFor = Exception.class)
    public DegreeProgram update(DegreeProgramUpdateDTO degreeProgramUpdateDTO) {

        DegreeProgram existingDegreeProgram;

        if(degreeProgramUpdateDTO.getId() != null && degreeProgramUpdateDTO.getExistingCode() != null) {
            existingDegreeProgram = findEntityById(degreeProgramUpdateDTO.getId());
        } else if(degreeProgramUpdateDTO.getId() != null) {
            existingDegreeProgram = findEntityById(degreeProgramUpdateDTO.getId());
        } else if(degreeProgramUpdateDTO.getExistingCode() != null) {
            existingDegreeProgram = findByCode(degreeProgramUpdateDTO.getExistingCode());
        } else {
            throw new ResourceConflictException("Either ID or Code must be provided for update.");
        }

        if(degreeProgramUpdateDTO.getNewCode() != null) {
            validateCodeUniqueness(degreeProgramUpdateDTO.getNewCode(), existingDegreeProgram.getId());
            existingDegreeProgram.setCode(degreeProgramUpdateDTO.getNewCode().toUpperCase());
        }

        if(degreeProgramUpdateDTO.getName() != null) {
            existingDegreeProgram.setName(degreeProgramUpdateDTO.getName().toUpperCase());
        }

        return degreeProgramRepository.save(existingDegreeProgram);
    }

    @Transactional(rollbackFor = Exception.class)
    public DegreeProgram deleteById(Long id) {

        DegreeProgram dp = findEntityById(id);

        if (!dp.getActive()) {
            throw new ResourceConflictException("Degree Program with ID: " + id + " is already inactive.");
        }

        List<Long> subjectIds = dp.getSubjects().stream()
                .map(Subject::getId)
                .toList();

        dp = removeSubjectsFromDegreeProgram(dp.getId(), subjectIds, null);
        dp.setActive(false);

        return degreeProgramRepository.save(dp);
    }

    @Transactional(rollbackFor = Exception.class)
    public DegreeProgram reactivateById(Long id) {
        DegreeProgram dp = findEntityById(id);

        if (dp.getActive()) {
            throw new ResourceConflictException("Degree Program with ID: " + id + " is already active.");
        }

        dp.setActive(true);
        return degreeProgramRepository.save(dp);
    }

    @Transactional(rollbackFor = Exception.class)
    public DegreeProgram assignSubjectsToDegreeProgram(Long degreeProgramId, List<Long> subjectIds, List<String> subjectsCodes) {
        DegreeProgram dp = findEntityById(degreeProgramId);
        List<Subject> currentSubjects = dp.getSubjects();

        Set<Subject> subjectsToAdd = new HashSet<>();

        if (subjectIds != null) {
            subjectIds.stream()
                    .map(subjectService::findEntityById)
                    .filter(s -> !currentSubjects.contains(s))
                    .forEach(subjectsToAdd::add);
        }

        if (subjectsCodes != null) {
            subjectsCodes.stream()
                    .map(subjectService::findByCode)
                    .filter(s -> !currentSubjects.contains(s))
                    .forEach(subjectsToAdd::add);
        }

        currentSubjects.addAll(subjectsToAdd);
        dp.setSubjects(currentSubjects);
        return degreeProgramRepository.save(dp);
    }

    @Transactional(rollbackFor = Exception.class)
    public DegreeProgram removeSubjectsFromDegreeProgram(Long degreeProgramId, List<Long> subjectIds, List<String> subjectsCodes) {
        DegreeProgram dp = findEntityById(degreeProgramId);
        Set<Subject> currentSubjects = new HashSet<>(dp.getSubjects());

        if (subjectIds != null) {
            for (Long subjectId : subjectIds) {
                Subject subject = subjectService.findEntityById(subjectId);
                currentSubjects.remove(subject);
            }
        }

        if (subjectsCodes != null) {
            for (String subjectCode : subjectsCodes) {
                Subject subject = subjectService.findByCode(subjectCode);
                currentSubjects.remove(subject);
            }
        }

        dp.setSubjects(new ArrayList<>(currentSubjects));
        return degreeProgramRepository.save(dp);
    }

    private void validateCodeUniqueness(String code) {
        if (code == null || code.isBlank()) {
            return; // Do nothing if code is null or blank
        }

        if (degreeProgramRepository.existsByCode(code.toUpperCase())) {
            throw new ResourceConflictException("A Degree Program with this code already exists.");
        }
    }

    private void validateCodeUniqueness(String code, Long currentId) {
        if (code == null || code.isBlank()) {
            return;
        }

        degreeProgramRepository.findByCode(code.toUpperCase()).ifPresent(existing -> {
            if (!existing.getId().equals(currentId)) {
                throw new ResourceConflictException("A Degree Program with this code already exists.");
            }
        });
    }

    @Transactional
    public void removeSubjectFromAllDegreePrograms(Subject subject) {
        List<DegreeProgram> degreePrograms = subject.getDegreePrograms();

        for (DegreeProgram degreeProgram : degreePrograms) {
            degreeProgram.getSubjects().remove(subject);
        }
        degreeProgramRepository.saveAll(degreePrograms);
    }


}


