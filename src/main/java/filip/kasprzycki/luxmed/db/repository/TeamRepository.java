package filip.kasprzycki.luxmed.db.repository;

import filip.kasprzycki.luxmed.db.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team, Long> {
}
