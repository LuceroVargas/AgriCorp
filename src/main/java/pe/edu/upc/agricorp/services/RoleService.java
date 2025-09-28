package pe.edu.upc.agricorp.services;

import pe.edu.upc.agricorp.entities.Role;

import java.util.List;

public interface RoleService {
    public Role add(Role role);

    public Role edit(Role role);

    public void delete(Long id);

    public Role findById(Long id);

    public List<Role> listAll();
}
