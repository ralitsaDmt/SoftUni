package P09_TrafficLight;

import java.util.Iterator;

public class TrafficLight {
    private Signal signal;
    private SignalIterator signalIterator;

    public TrafficLight(String signal){
        this.signal = Enum.valueOf(Signal.class, signal);
        this.signalIterator = new SignalIterator();
    }

    public void changeSignal(){
        this.signal = this.signalIterator.next();
    }

    public String getSignal(){
        return this.signal.name();
    }

    @Override
    public String toString() {
        return this.signal.name();
    }

    private final class SignalIterator implements Iterator<Signal> {

        @Override
        public boolean hasNext() {
            return true;
        }

        @Override
        public Signal next() {

            if (signal.equals(Signal.RED)){
                return Signal.GREEN;
            } else if (signal.equals(Signal.GREEN)) {
                return Signal.YELLOW;
            } else {
                return Signal.RED;
            }

        }
    }
}
