package filip.kasprzycki.luxmed.api.entity;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
@EqualsAndHashCode
public class TeamReq {

    private String name;
    private ProjectReq project;
}
