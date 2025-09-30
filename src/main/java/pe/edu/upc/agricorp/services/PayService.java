package pe.edu.upc.agricorp.services;

import pe.edu.upc.agricorp.entities.Pay;

import java.util.List;

public interface PayService {
    public Pay add(Pay pay);

    public Pay edit(Pay pay);

    public void delete(Long id);

    public Pay findById(Long id);

    public List<Pay> listAll();

}
