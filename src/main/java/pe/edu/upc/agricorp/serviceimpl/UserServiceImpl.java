package pe.edu.upc.agricorp.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.agricorp.entities.User;
import pe.edu.upc.agricorp.repositories.UserRepository;
import pe.edu.upc.agricorp.services.UserService;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public User add(User user) {

        if (user.getUsername()==null || user.getUsername().isBlank()) {
            return null;
        }

        return userRepository.save(user);
    }
    @Override
    public User edit(User user) {
        User userFound = findById(user.getId());
        if (userFound==null){
            return null;
        }
        if (user.getUsername()!=null) {
            userFound.setUsername(user.getUsername());
        }
        if (user.getPassword()!=null) {
            userFound.setPassword(user.getPassword());
        }

        return userRepository.save(userFound);
    }
    @Override
    public void delete(Long id) {

        User userFound = findById(id);
        if (userFound==null){
            return;
        }

        userRepository.deleteById(id);
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public List<User> listAll() {
        return userRepository.findAll();
    }
}
