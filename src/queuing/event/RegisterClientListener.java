package queuing.event;

import queuing.repository.Client;
import queuing.repository.Repository;

public class RegisterClientListener implements EventListener {

    @Override
    public void onRecieve(Event event) {

        Repository repository = Repository.getInstance();

        Client client = (Client) event.getPayload();
        System.out.println("Initializing client registration: " + client);

        Callback callback;

        try {
            repository.insertClient(client);
            callback = event.getOnSucess();
            callback.callback("Success on registration;");

        } catch (RuntimeException e) {
            callback = event.getOnFailure();
            callback.callback(e);
        }
    }
}
