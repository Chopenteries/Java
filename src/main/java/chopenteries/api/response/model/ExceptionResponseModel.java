package chopenteries.api.response.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ExceptionResponseModel {

    private Integer status;
    private String message;
}
