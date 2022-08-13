package chopenteries.api.https.users.dto;

import chopenteries.api.entities.UserDetail;
import chopenteries.api.response.converter.DtoConverter;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDetailRequest implements DtoConverter<UserDetail> {

    private String firstName;

    private String lastName;

    private String email;


    @Override
    public UserDetail convertToEntity() {
        return null;
    }

    @Override
    public UserDetail updateEntity(UserDetail userDetail) {
        return null;
    }
}
