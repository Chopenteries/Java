package chopenteries.api.response.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class ResponseModel {

    public ResponseModel(){}

    private Integer status;
    private String message;
    private Object data;
}
