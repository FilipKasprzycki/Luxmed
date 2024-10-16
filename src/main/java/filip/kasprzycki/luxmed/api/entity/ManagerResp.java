package filip.kasprzycki.luxmed.api.entity;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
@EqualsAndHashCode
public class ManagerResp {

    private Long id;
    private String name;
    private String email;
    private String phone;
    private String additionalContactInformation;
}
