package filip.kasprzycki.luxmed.api.entity;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.extern.jackson.Jacksonized;

@Getter
@Builder
@ToString
@Jacksonized
@EqualsAndHashCode
public class CompanyUpdateReq {

    @NotBlank
    @Size(min = 1, max = 10_000)
    private String name;
}
