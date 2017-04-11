package P02_FileStream;

public abstract class BaseStream implements Streamable {
    private int bitesSent;
    private int length;


    protected BaseStream(int bitesSent, int length) {
        this.bitesSent = bitesSent;
        this.length = length;
    }

    @Override
    public int getBytesSent(){
        return this.bitesSent;
    }

    @Override
    public int getLength(){
        return this.length;
    }
}
