package P02_FileStream;

public class File extends BaseStream {

    private String name;


    protected File(int bitesSent, int length, String name) {
        super(bitesSent, length);
        this.name = name;
    }
}
