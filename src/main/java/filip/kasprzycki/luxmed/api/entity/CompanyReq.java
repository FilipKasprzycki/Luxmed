package filip.kasprzycki.luxmed.api.entity;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@Builder
@ToString
@EqualsAndHashCode
public class CompanyReq {

    @NotBlank
    @Size(min = 1, max = 10_000)
    private String name;

    private List<DepartmentReq> departments;
}
