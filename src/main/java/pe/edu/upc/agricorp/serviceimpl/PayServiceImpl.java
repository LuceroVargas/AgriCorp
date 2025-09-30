package pe.edu.upc.agricorp.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.agricorp.entities.Pay;
import pe.edu.upc.agricorp.repositories.PayRepository;
import pe.edu.upc.agricorp.services.PayService;

import java.util.List;


@Service
public class PayServiceImpl implements PayService {
    @Autowired
    PayRepository payRepository;

    @Override
    public Pay add(Pay pay) {
        if (pay.getName()==null || pay.getName().isBlank()) {
            return null;
        }
        if (pay.getType()==null || pay.getType().isBlank()) {
            return null;
        }

        if (pay.getAmount()==null || pay.getAmount() <0) {
            return null;
        }
        return payRepository.save(pay);
    }
    @Override
    public Pay edit(Pay pay) {
        Pay payFound = findById(pay.getId());
        if (payFound==null){
            return null;
        }
        if (pay.getName()!=null) {
            payFound.setName(pay.getName());
        }
        if (pay.getType()!=null) {
            payFound.setType(pay.getType());
        }
        if (pay.getAmount()!=null) {
            payFound.setAmount(pay.getAmount());
        }
        return payRepository.save(payFound);
    }

    @Override
    public void delete(Long id) {

        Pay payFound = findById(id);
        if (payFound==null){
            return;
        }

        payRepository.deleteById(id);
    }

    @Override
    public Pay findById(Long id) {
        return payRepository.findById(id).orElse(null);
    }

    @Override
    public List<Pay> listAll() {
        return payRepository.findAll();
    }
}
