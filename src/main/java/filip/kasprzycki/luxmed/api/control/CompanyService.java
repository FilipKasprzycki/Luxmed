package filip.kasprzycki.luxmed.api.control;

import filip.kasprzycki.luxmed.api.entity.CompanyReq;
import filip.kasprzycki.luxmed.api.entity.CompanyResp;
import filip.kasprzycki.luxmed.api.entity.CompanyUpdateReq;
import filip.kasprzycki.luxmed.db.entity.Company;
import filip.kasprzycki.luxmed.db.repository.CompanyRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class CompanyService {

    private final CompanyRepository companyRepository;
    private final CompanyMapper companyMapper;

    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    public Optional<Company> getCompanyById(Long id) {
        return companyRepository.findById(id);
    }

    public CompanyResp createCompany(CompanyReq request) {
        log.info("Creating company from request: {}", request);
        Company company = companyMapper.mapFromRequest(request);
        companyRepository.save(company);
        return companyMapper.mapToResponse(company);
    }

    public void deleteCompany(Long id) {
        companyRepository.deleteById(id);
    }

    public Optional<Company> updateCompany(Long id, CompanyUpdateReq request) {
        return companyRepository.findById(id)
                .map(c -> {
                    c.setName(request.getName());
                    return companyRepository.save(c);
                });
    }
}
