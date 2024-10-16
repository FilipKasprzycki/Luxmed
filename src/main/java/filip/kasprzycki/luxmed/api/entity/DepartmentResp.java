package filip.kasprzycki.luxmed.api.entity;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@Builder
@ToString
@EqualsAndHashCode
public class DepartmentResp {

    private Long id;
    private String name;
    private List<TeamResp> teams;
}
