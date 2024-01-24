package org.acme.resteasy.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import org.acme.resteasy.dto.Department;
import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class DepartmentRepo implements PanacheRepository<Department> {

}
