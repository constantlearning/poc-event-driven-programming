import event.Callback;
import event.Event;
import event.EventEngine;
import event.RegisterClientListener;
import repository.Client;

import java.util.UUID;

public class Main {

    static {
        EventEngine.start();
        EventEngine.subscribeListener("CLIENT_REGISTRATION", new RegisterClientListener());
    }

    public static void main(String[] args) {

        for (int i = 0; i < 1000000; i++) {

            Client client = new Client(i, UUID.randomUUID());

            Event event = new Event("CLIENT_REGISTRATION", client,
                    new Callback() {
                        @Override
                        public void callback(Object payload) {
                            String value = (String) payload;
                            System.out.println("Success callback: " + value);
                        }
                    },

                    new Callback() {
                        @Override
                        public void callback(Object payload) {
                            RuntimeException exception = (RuntimeException) payload;
                            System.out.println("Failure callback: " + exception.getMessage());
                        }
                    });

            EventEngine.publish(event);
        }
    }
}
