package de.krishna.development.simpledb.service;

import de.krishna.development.simpledb.domain.Department;
import de.krishna.development.simpledb.repository.DepartmentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Service Implementation for managing Department.
 */
@Service
@Transactional
public class DepartmentService {

    private final Logger log = LoggerFactory.getLogger(DepartmentService.class);

    private final DepartmentRepository departmentRepository;

    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    /**
     * Save a department.
     *
     * @param department the entity to save
     * @return the persisted entity
     */
    public Department save(Department department) {
        log.debug("Request to save Department : {}", department);
        return departmentRepository.save(department);
    }

    /**
     * Get all the departments.
     *
     * @return the list of entities
     */
    @Transactional(readOnly = true)
    public List<Department> findAll() {
        log.debug("Request to get all Departments");
        return departmentRepository.findAll();
    }

    /**
     * Get one department by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Transactional(readOnly = true)
    public Department findOne(Long id) {
        log.debug("Request to get Department : {}", id);
        return departmentRepository.findOne(id);
    }

    /**
     * Delete the department by id.
     *
     * @param id the id of the entity
     */
    public void delete(Long id) {
        log.debug("Request to delete Department : {}", id);
        departmentRepository.delete(id);
    }
}
