package pe.edu.upc.agricorp.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.agricorp.entities.Gardener;
import pe.edu.upc.agricorp.repositories.GardenerRepo;
import pe.edu.upc.agricorp.services.GardenerService;

import java.util.List;


@Service
public class GardenerImple implements GardenerService {
    @Autowired
    private GardenerRepo gardenerRepo;


    @Override
    public Gardener addG(Gardener gardener) {
        if (gardener.getName() == null || gardener.getName().isBlank()) {return null;}
        return gardenerRepo.save(gardener);
    }

    @Override
    public Gardener editG(Gardener gardener) {
        Gardener gardenerfound = findGById(gardener.getId());
        if (gardenerfound.getName() == null || gardenerfound.getName().isBlank()) {return null;}

        return gardenerRepo.save(gardenerfound);
    }

    @Override
    public void deleteG(Long id) {
        Gardener gardenerfound = findGById(id);
        if( gardenerfound == null){
            return;
        }
        gardenerRepo.delete(gardenerfound);
    }

    @Override
    public List<Gardener> findAll() {
        return  gardenerRepo.findAll();
    }

    @Override
    public Gardener findGById(Long id) {
        return  gardenerRepo.findById(id).orElse(null);
    }

}
