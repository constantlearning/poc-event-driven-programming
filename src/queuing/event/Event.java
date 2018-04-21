package queuing.event;

public class Event {

    private String type;
    private Object payload;
    private Callback onSucess;
    private Callback onFailure;

    public Event(String type, Object payload, Callback onSucess, Callback onFailure) {
        this.type = type;
        this.payload = payload;
        this.onSucess = onSucess;
        this.onFailure = onFailure;
    }

    public String getType() {
        return type;
    }

    public Object getPayload() {
        return payload;
    }

    public Callback getOnSucess() {
        return onSucess;
    }

    public Callback getOnFailure() {
        return onFailure;
    }
}
