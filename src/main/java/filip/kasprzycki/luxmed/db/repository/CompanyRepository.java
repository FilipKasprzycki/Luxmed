package filip.kasprzycki.luxmed.db.repository;

import filip.kasprzycki.luxmed.db.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Long> {
}
