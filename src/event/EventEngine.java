package event;

import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class EventEngine {

    private static Queue<Event> eventQueue = new LinkedBlockingQueue<>();
    private static Map<String, EventListener> eventListener = new HashMap<>();

    public static void subscribeListener(String type, EventListener listener) {
        eventListener.put(type, listener);
    }

    public static void publish(Event event) {
        eventQueue.add(event);
    }

    public static void start() {

        new Thread(() -> {

            while (true) {

                Event event = eventQueue.poll();

                if (event != null) {

                    EventListener listener = eventListener.get(event.getType());

                    if (listener != null) {

                        listener.onRecieve(event);
                    }
                }

                try {
                    Thread.sleep(10);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                System.out.println("Pool Size: " + eventQueue.size());
            }

        }).start();
    }
}