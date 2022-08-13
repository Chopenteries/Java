//package chopenteries.api.configuration.service;
//
//import chopenteries.api.core.users.UserRepository;
//import chopenteries.api.core.users.UserService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.security.authentication.BadCredentialsException;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Component;
//
//import java.util.ArrayList;
//
//@Component
//@RequiredArgsConstructor
//public class JwtDetailService implements UserDetailsService {
//
//    private final UserRepository userRepository;
//    @Override
//    public UserDetails loadUserByUsername(String mobileNumber) throws UsernameNotFoundException {
//        chopenteries.api.entities.User myUser = userRepository.findByMobileNumber(mobileNumber).orElseThrow(() -> {
//            throw new BadCredentialsException("Bad Credential");
//        });
//
//        return new User(myUser.getMobileNumber(), myUser.getPassword(), new ArrayList<>(){{
//            add(new SimpleGrantedAuthority("ROLE_"+myUser.getDetail().getRole().getname()));
//        }});
//    }
//}
