package filip.kasprzycki.luxmed.db.repository;

import filip.kasprzycki.luxmed.db.entity.Manager;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManagerRepository extends JpaRepository<Manager, Long> {
}
