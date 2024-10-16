package filip.kasprzycki.luxmed.api.control;

import filip.kasprzycki.luxmed.api.entity.CompanyReq;
import filip.kasprzycki.luxmed.api.entity.CompanyResp;
import filip.kasprzycki.luxmed.db.entity.Company;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CompanyMapper {

    Company mapFromRequest(CompanyReq request);

    CompanyResp mapToResponse(Company company);
}
