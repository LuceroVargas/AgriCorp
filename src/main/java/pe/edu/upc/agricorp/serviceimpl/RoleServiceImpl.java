package pe.edu.upc.agricorp.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.agricorp.entities.Role;
import pe.edu.upc.agricorp.repositories.RoleRepository;
import pe.edu.upc.agricorp.services.RoleService;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleRepository roleRepository;


    @Override
    public Role add(Role role) {

        if (role.getType()==null || role.getType().isBlank()) {
            return null;
        }

        return roleRepository.save(role);
    }

    @Override
    public Role edit(Role role) {
        Role roleFound = findById(role.getId());
        if (roleFound==null){
            return null;
        }
        if (role.getType()!=null) {
            roleFound.setType(role.getType());
        }

        return roleRepository.save(roleFound);
    }

    @Override
    public void delete(Long id) {

        Role roleFound = findById(id);
        if (roleFound==null){
            return;
        }

        roleRepository.deleteById(id);
    }

    @Override
    public Role findById(Long id) {
        return roleRepository.findById(id).orElse(null);
    }

    @Override
    public List<Role> listAll() {
        return roleRepository.findAll();
    }

}
