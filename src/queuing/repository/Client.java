package queuing.repository;

import java.util.UUID;

public class Client {

    private Integer id;
    private UUID name;

    public Client(Integer id, UUID name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    @Override
    public String toString() {
        return "queuing.repository.Client{" +
                "id=" + id +
                ", name=" + name +
                '}';
    }
}
