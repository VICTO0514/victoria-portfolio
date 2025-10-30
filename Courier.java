package model;

public class Courier {
    private int id;
    private String senderName;
    private String receiverName;
    private String source;
    private String destination;
    private String status;

    public Courier(int id, String senderName, String receiverName, String source, String destination, String status) {
        this.id = id;
        this.senderName = senderName;
        this.receiverName = receiverName;
        this.source = source;
        this.destination = destination;
        this.status = status;
    }

    public Courier(String senderName, String receiverName, String source, String destination, String status) {
        this.senderName = senderName;
        this.receiverName = receiverName;
        this.source = source;
        this.destination = destination;
        this.status = status;
    }

    public int getId() { return id; }
    public String getSenderName() { return senderName; }
    public String getReceiverName() { return receiverName; }
    public String getSource() { return source; }
    public String getDestination() { return destination; }
    public String getStatus() { return status; }

    public void setStatus(String status) { this.status = status; }

    @Override
    public String toString() {
        return id + " | " + senderName + " → " + receiverName + " | " + source + " → " + destination + " | " + status;
    }
}
