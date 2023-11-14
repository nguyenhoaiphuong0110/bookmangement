package model;

public class Reader {
    private static int id = 10000000;
    private int readerID;
    private String fullName;
    private String address;
    private String phoneName;

    public Reader() {
    }

    public Reader(int readerID, String fullName, String address, String phoneName) {
        if(readerID == 0){
            this.readerID = id++;
        }else {
            this.readerID = readerID;
        }
        this.readerID = readerID;
        this.fullName = fullName;
        this.address = address;
        this.phoneName = phoneName;
    }

    public Reader(int i) {
    }

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        Reader.id = id;
    }

    public int getReaderID() {
        return readerID;
    }

    public void setReaderID(int readerID) {
        this.readerID = readerID;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneName() {
        return phoneName;
    }

    public void setPhoneName(String phoneName) {
        this.phoneName = phoneName;
    }

    @Override
    public String toString() {
        return "Reader{" +
                "readerID=" + readerID +
                ", fullName='" + fullName + '\'' +
                ", address='" + address + '\'' +
                ", phoneName='" + phoneName + '\'' +
                '}';
    }
}
