package repository;

import java.util.ArrayList;
import java.util.List;

public class Repository {

    private List<Client> clientsRepository;

    private static Repository instance = null;

    public static Repository getInstance() {
        if (instance == null) {
            instance = new Repository();
        }
        return instance;
    }

    private Repository() {
        this.clientsRepository = new ArrayList<>();
    }

    public void insertClient(Client client) {

        if (client.getId() % 2 != 0) {
            throw new RuntimeException("Invalid repository.Client!");
        }

        this.clientsRepository.add(client);
    }
}
