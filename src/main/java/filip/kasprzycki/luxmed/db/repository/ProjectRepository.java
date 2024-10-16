package filip.kasprzycki.luxmed.db.repository;

import filip.kasprzycki.luxmed.db.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {
}
