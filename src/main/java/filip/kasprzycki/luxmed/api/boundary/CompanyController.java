package filip.kasprzycki.luxmed.api.boundary;

import filip.kasprzycki.luxmed.api.control.CompanyService;
import filip.kasprzycki.luxmed.api.entity.CompanyReq;
import filip.kasprzycki.luxmed.api.entity.CompanyResp;
import filip.kasprzycki.luxmed.api.entity.CompanyUpdateReq;
import filip.kasprzycki.luxmed.db.entity.Company;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/company")
public class CompanyController {

    private final CompanyService companyService;

    @GetMapping
    public List<CompanyResp> getAllCompanies() {
        log.info("[GET] /api/company");

        List<CompanyResp> response = companyService.getAllCompanies();

        log.info("Response: {}", response);
        return response;
    }

    @GetMapping("/{id}")
    public ResponseEntity<CompanyResp> getCompanyById(@PathVariable long id) {
        log.info("[GET] /api/company/{}", id);

        Optional<CompanyResp> response = companyService.getCompanyById(id);

        log.info("Response: {}", response.isPresent() ? response.get() : "not found");
        return response.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public CompanyResp createCompany(@RequestBody @Valid CompanyReq company) {
        log.info("[POST] /api/company with request body: {}", company);

        CompanyResp response = companyService.createCompany(company);

        log.info("Response: {}", response);
        return response;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCompany(@PathVariable long id) {
        log.info("[DELETE] /api/company/{}", id);

        companyService.deleteCompany(id);

        log.info("Company #{} is deleted", id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<CompanyResp> updateCompany(@PathVariable long id, @RequestBody @Valid CompanyUpdateReq company) {
        log.info("[PUT] api/company/{} with request body {}", id, company);

        Optional<CompanyResp> response = companyService.updateCompany(id, company);

        log.info("Response: {}", response.isPresent() ? response.get() : "not found");
        return response.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
