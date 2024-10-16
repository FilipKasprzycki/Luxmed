package filip.kasprzycki.luxmed.db.repository;

import filip.kasprzycki.luxmed.db.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
