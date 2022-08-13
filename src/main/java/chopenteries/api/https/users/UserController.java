package chopenteries.api.https.users;

import chopenteries.api.core.users.UserService;
import chopenteries.api.https.users.dto.UserRequest;
import chopenteries.api.response.ResponseTemplate;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("user")
@RequiredArgsConstructor
// TODO: to call user url and user-detail need authorization token.
public class UserController {

    private final UserService userService;

    private final ResponseTemplate responseTemplate;

    @PostMapping("register")
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public Object registerUser(@RequestBody UserRequest request) {
        return responseTemplate.createResponse(userService.createOne(request));
    }

    @PostMapping("/{id}")
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    // TODO: need to validate token.
    public Object UpdateUser(@RequestBody UserRequest request, @PathVariable("id") int id) {
        return responseTemplate.createResponse(userService.updateOne(id, request));
    }

    @GetMapping("detail")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public Object userDetail(int id) {
        return responseTemplate.createResponse(userService.findUserById(id));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    // TODO: Need auth and token
    Object deleteUserById(@PathVariable("id") int id) {
        return responseTemplate.createResponse(userService.deleteUser(id));
    }

}
