package pe.edu.upc.agricorp.services;

import pe.edu.upc.agricorp.entities.User;

import java.util.List;

public interface UserService {
    public User add(User user);

    public User edit(User user);

    public void delete(Long id);

    public User findById(Long id);

    public List<User> listAll();
}
