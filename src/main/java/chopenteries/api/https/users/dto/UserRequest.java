package chopenteries.api.https.users.dto;

import chopenteries.api.entities.User;
import chopenteries.api.entities.UserDetail;
import chopenteries.api.response.converter.DtoConverter;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Size;

@Getter
@Setter
public class UserRequest implements DtoConverter<User> {

    private String userName;

    private String mobileNumber;

    @Size(min = 8, max = 16)
    private String password;

    private String firstName;

    private String lastName;

    private String email;

    @Override
    public User convertToEntity() {

        User newUser = new User();
        newUser.setUserName(this.userName);
        newUser.setMobileNumber(this.mobileNumber);
        newUser.setPassword(this.password);

        newUser.setDetail(new UserDetail());
        newUser.getDetail().setFirstName(this.firstName);
        newUser.getDetail().setLastName(this.lastName);
        newUser.getDetail().setEmail(this.email);
        newUser.getDetail().setUpdatedBy(newUser.getDetail().getCreatedBy());
        return newUser;
    }

    @Override
    public User updateEntity(User user) {

        user.setUserName(userName == null ? user.getUserName() : this.userName);
        // TODO: to update mobile-number needs validate otp-code or email.
        user.setMobileNumber(mobileNumber == null ? user.getMobileNumber() : this.mobileNumber);
        // TODO: to update password needs validate token or code by email.
        user.setPassword(password == null ? user.getPassword() : this.password);

        UserDetail detail = user.getDetail();
        // check first if blank then replace by request
        if (this.firstName != null && !this.firstName.isBlank()){
            detail.setFirstName(this.getFirstName());
        }
        // check last name if blank then replace by request
        if (this.lastName != null && !this.lastName.isBlank()){
            detail.setLastName(this.getLastName());
        }
        // check last name if blank then replace by request
        if (this.email != null && !this.email.isBlank()){
            detail.setEmail(this.getEmail());
        }
        user.setDetail(detail);
        return user;
    }


}
