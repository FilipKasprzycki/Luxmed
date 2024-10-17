package filip.kasprzycki.luxmed.api.control;

import filip.kasprzycki.luxmed.api.entity.CompanyReq;
import filip.kasprzycki.luxmed.api.entity.CompanyResp;
import filip.kasprzycki.luxmed.api.entity.CompanyUpdateReq;
import filip.kasprzycki.luxmed.db.entity.Company;
import filip.kasprzycki.luxmed.db.repository.CompanyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CompanyService {

    private final CompanyRepository companyRepository;
    private final CompanyMapper companyMapper;

    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    public Optional<Company> getCompanyById(long id) {
        return companyRepository.findById(id);
    }

    public CompanyResp createCompany(CompanyReq request) {
        Company company = companyMapper.mapFromRequest(request);
        companyRepository.save(company);
        return companyMapper.mapToResponse(company);
    }

    public void deleteCompany(long id) {
        companyRepository.deleteById(id);
    }

    public Optional<Company> updateCompany(long id, CompanyUpdateReq request) {
        return companyRepository.findById(id)
                .map(c -> {
                    c.setName(request.getName());
                    return companyRepository.save(c);
                });
    }
}
