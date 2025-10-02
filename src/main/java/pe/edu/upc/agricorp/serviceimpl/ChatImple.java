package pe.edu.upc.agricorp.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.agricorp.entities.Chat;
import pe.edu.upc.agricorp.repositories.ChatRepo;
import pe.edu.upc.agricorp.services.ChatServi;

import java.util.List;

@Service
public class ChatImple implements ChatServi {
    @Autowired
    private ChatRepo chatRepo;

    @Override
    public Chat addC(Chat chat) {
        if (chat.getMessage() == null || chat.getMessage().isBlank()) {
            return null;
        }
        if (chat.getDate() == null) {
            return null;
        }
        return  chatRepo.save(chat);
    }

    @Override
    public Chat editC(Chat chat) {
        Chat chat1 = findById(chat.getId());
        if  (chat1 == null) {
            return null;
        }
        if (chat.getMessage() == null) {
            return null;
        }
        if (chat.getDate() == null) {
            return null;
        }
        return  chatRepo.save(chat);
    }

    @Override
    public void deleteC(Long id) {
        Chat chat = findById(id);
        if (chat == null) {
            return;
        }
        chatRepo.delete(chat);
    }

    @Override
    public List<Chat> findAll() {
        return chatRepo.findAll();
    }

    @Override
    public Chat findById(Long id) {
        return chatRepo.findById(id).orElse(null);
    }
}
