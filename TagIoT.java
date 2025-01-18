public class TagIoT {
    private String tagId;

    public TagIoT(String tagId) {
        this.tagId = tagId;
    }

    public String getTagId() {
        return tagId;
    }

    public void rastrear() {
        System.out.println("Rastreando mercadoria com Tag IoT: " + tagId);
    }
}
