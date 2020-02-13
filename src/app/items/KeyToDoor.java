package app.items;

public class KeyToDoor extends Item {
    private String keyId;

    public KeyToDoor(String name, int value, String keyId) {
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