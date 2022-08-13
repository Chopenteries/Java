package chopenteries.api.response;

import chopenteries.api.response.model.ExceptionResponseModel;
import chopenteries.api.response.model.ResponseModel;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
public class ResponseTemplate {
    public Object createResponse(Object data){
        return createResponse(data, "success");
    }

    public Object createResponse(Object data, String message){
        return ResponseModel.builder()
                .status(200)
                .message(message)
                .data(data)
                .build();
    }

    public Object createExceptionResponse(HttpStatus status, String message){
        return ExceptionResponseModel.builder()
                .status(status.value())
                .message(message)
                .build();
    }

    public Object createExceptionResponse(Integer status, String message){
        return ExceptionResponseModel.builder()
                .status(status)
                .message(message)
                .build();
    }

    public ResponseModel getResponseModel() {
        return new ResponseModel();
    }

}
