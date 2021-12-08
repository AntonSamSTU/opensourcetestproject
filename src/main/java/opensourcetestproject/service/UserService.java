package opensourcetestproject.service;

import opensourcetestproject.model.Role;
import opensourcetestproject.model.User;
import opensourcetestproject.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Set;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User doesnt Exist!");
        } else {
            return user;
        }
    }

    public boolean saveUser(String username, String password, Role role) {
        User userFromDB = userRepository.findByUsername(username);
        if (userFromDB == null) {
            User newUser = new User();
            newUser.setUsername(username);
            newUser.setPassword(bCryptPasswordEncoder.encode(password));
            newUser.setRoles(Collections.singleton(role));
            userRepository.save(newUser);
            return true;
        } else {
            return false;
        }
    }

}
