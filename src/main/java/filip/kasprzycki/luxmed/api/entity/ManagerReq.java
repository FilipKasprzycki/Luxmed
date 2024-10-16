package filip.kasprzycki.luxmed.api.entity;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
@EqualsAndHashCode
public class ManagerReq {

    private String name;
    private String email;
    private String phone;
    private String additionalContactInformation;
}
