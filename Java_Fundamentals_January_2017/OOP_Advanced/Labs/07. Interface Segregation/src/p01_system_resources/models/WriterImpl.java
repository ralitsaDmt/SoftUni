package p01_system_resources.models;

import p01_system_resources.contracts.Writer;

public class WriterImpl implements Writer {

    @Override
    public void println(String output) {
        System.out.println(output);
    }
}
