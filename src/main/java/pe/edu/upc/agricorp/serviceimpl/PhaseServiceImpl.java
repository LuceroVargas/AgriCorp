package pe.edu.upc.agricorp.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.agricorp.entities.Phase;
import pe.edu.upc.agricorp.repositories.PhaseRepository;
import pe.edu.upc.agricorp.services.PhaseService;

import java.util.List;

@Service
public class PhaseServiceImpl implements PhaseService {
    @Autowired
    PhaseRepository phaseRepository;


    @Override
    public Phase add(Phase phase) {

        if (phase.getName()==null || phase.getName().isBlank()) {
            return null;
        }
        if (phase.getDescription()==null || phase.getDescription().isBlank()) {
            return null;
        }
        if (phase.getPhaseOrder()==null || phase.getPhaseOrder() < 0){
            return null;
        }
        if (phase.getMinDay()==null || phase.getMinDay() < 0) {
            return null;
        }
        if (phase.getMaxDay()==null || phase.getMaxDay() < 0) {
            return null;
        }

        return phaseRepository.save(phase);
    }

    @Override
    public Phase edit(Phase phase) {
        Phase phaseFound = findById(phase.getId());
        if (phaseFound==null){
            return null;
        }
        if (phase.getName()!=null) {
            phaseFound.setName(phase.getName());
        }
        if (phase.getDescription()!=null) {
            phaseFound.setDescription(phase.getDescription());
        }
        if (phase.getPhaseOrder()!=null) {
            phaseFound.setPhaseOrder(phase.getPhaseOrder());
        }
        if (phase.getMinDay()!=null) {
            phaseFound.setMinDay(phase.getMinDay());
        }
        if (phase.getMaxDay()!=null) {
            phaseFound.setMaxDay(phase.getMaxDay());
        }


        return phaseRepository.save(phaseFound);
    }

    @Override
    public void delete(Long id) {

        Phase phaseFound = findById(id);
        if (phaseFound==null){
            return;
        }

        phaseRepository.deleteById(id);
    }

    @Override
    public Phase findById(Long id) {
        return phaseRepository.findById(id).orElse(null);
    }

    @Override
    public List<Phase> listAll() {
        return phaseRepository.findAll();
    }



}

