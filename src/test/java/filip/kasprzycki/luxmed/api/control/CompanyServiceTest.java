package filip.kasprzycki.luxmed.api.control;

import filip.kasprzycki.luxmed.api.entity.CompanyReq;
import filip.kasprzycki.luxmed.api.entity.CompanyResp;
import filip.kasprzycki.luxmed.api.entity.CompanyUpdateReq;
import filip.kasprzycki.luxmed.db.entity.*;
import filip.kasprzycki.luxmed.db.repository.CompanyRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CompanyServiceTest {

    @Mock
    private CompanyRepository companyRepository;

    @Mock
    private CompanyMapper companyMapper;

    @InjectMocks
    private CompanyService sut;

    @Test
    void getAllCompanies() {
        // setup
        List<Company> companies = List.of(new Company(), new Company());
        List<CompanyResp> expected = List.of(CompanyResp.builder().build(), CompanyResp.builder().build());

        when(companyRepository.findAll()).thenReturn(companies);
        when(companyMapper.mapToResponseList(companies)).thenReturn(expected);

        // when
        List<CompanyResp> actual = sut.getAllCompanies();

        // then
        assertEquals(actual, expected);

        verify(companyRepository).findAll();
        verify(companyMapper).mapToResponseList(companies);
        verifyNoMoreInteractions(companyRepository, companyMapper);
    }

    @Test
    void getCompanyById() {
        // setup
        long id = 101;
        Company company = new Company();
        CompanyResp expected = CompanyResp.builder().build();

        when(companyRepository.findById(id)).thenReturn(Optional.of(company));
        when(companyMapper.mapToResponse(company)).thenReturn(expected);

        // when
        Optional<CompanyResp> actual = sut.getCompanyById(id);

        // then
        assertTrue(actual.isPresent());
        assertEquals(actual.get(), expected);

        verify(companyRepository).findById(id);
        verify(companyMapper).mapToResponse(company);
        verifyNoMoreInteractions(companyRepository, companyMapper);
    }

    @Test
    void getCompanyById_notFound() {
        // setup
        long id = 101;

        when(companyRepository.findById(id)).thenReturn(Optional.empty());

        // when
        Optional<CompanyResp> actual = sut.getCompanyById(id);

        // then
        assertTrue(actual.isEmpty());

        verify(companyRepository).findById(id);
        verifyNoMoreInteractions(companyRepository);
        verifyNoInteractions(companyMapper);
    }

    @Test
    void deleteCompany() {
        // setup
        long id = 101;

        // when
        Executable actual = () -> sut.deleteCompany(id);

        // then
        assertDoesNotThrow(actual);

        verify(companyRepository).deleteById(id);
        verifyNoMoreInteractions(companyRepository);
        verifyNoInteractions(companyMapper);
    }

    @Test
    void createCompany() {
        // setup
        CompanyReq request = CompanyReq.builder().build();
        CompanyResp expected = CompanyResp.builder().build();
        Company company = new Company();

        when(companyMapper.mapFromRequest(request)).thenReturn(company);
        when(companyMapper.mapToResponse(company)).thenReturn(expected);

        // when
        CompanyResp actual = sut.createCompany(request);

        // then
        assertEquals(actual, expected);

        verify(companyMapper).mapFromRequest(request);
        verify(companyMapper).mapToResponse(company);
        verify(companyRepository).save(company);
        verifyNoMoreInteractions(companyRepository, companyMapper);
    }

    @Test
    void updateCompany() {
        // setup
        long id = 101;
        CompanyUpdateReq request = CompanyUpdateReq.builder().build();
        CompanyResp expected = CompanyResp.builder().build();
        Company company = new Company();

        when(companyMapper.mapToResponse(company)).thenReturn(expected);
        when(companyRepository.findById(id)).thenReturn(Optional.of(company));
        when(companyRepository.save(company)).thenReturn(company);

        // when
        Optional<CompanyResp> actual = sut.updateCompany(id, request);

        // then
        assertTrue(actual.isPresent());
        assertEquals(actual.get(), expected);

        verify(companyMapper).mapToResponse(company);
        verify(companyRepository).findById(id);
        verify(companyRepository).save(company);
        verifyNoMoreInteractions(companyRepository, companyMapper);
    }

    @Test
    void updateCompany_notFound() {
        // setup
        long id = 101;
        CompanyUpdateReq request = CompanyUpdateReq.builder().build();

        when(companyRepository.findById(id)).thenReturn(Optional.empty());

        // when
        Optional<CompanyResp> actual = sut.updateCompany(id, request);

        // then
        assertTrue(actual.isEmpty());

        verify(companyRepository).findById(id);
        verifyNoMoreInteractions(companyRepository);
        verifyNoInteractions(companyMapper);
    }
}