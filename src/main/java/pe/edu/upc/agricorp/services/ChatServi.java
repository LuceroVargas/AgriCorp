package pe.edu.upc.agricorp.services;

import pe.edu.upc.agricorp.entities.Chat;

import java.util.List;

public interface ChatServi {
    public Chat addC(Chat chat);
    public Chat editC(Chat chat);
    public void deleteC(Long id);
    public List<Chat> findAll();
    public Chat findById(Long id);

}
