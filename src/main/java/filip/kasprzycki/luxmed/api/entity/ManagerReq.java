package filip.kasprzycki.luxmed.api.entity;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
@EqualsAndHashCode
public class ManagerReq {

    @NotBlank
    @Size(min = 1, max = 10_000)
    private String name;

    @Email
    @Size(max = 1_000)
    private String email;

    @Size(max = 100)
    private String phone;

    @Size(max = 10_000)
    private String additionalContactInformation;
}
