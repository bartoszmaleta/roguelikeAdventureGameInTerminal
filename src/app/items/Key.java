package app.items;

public class Key extends Item {
    private String keyId;

    public Key(String name, int value, String keyId) {
        super(name, value, "\uD83D\uDD11");
        this.keyId = keyId;
    }

    public String getKeyId() {
        return keyId;
    }

    public void setKeyId(String keyId) {
        this.keyId = keyId;
    }
    
    
}