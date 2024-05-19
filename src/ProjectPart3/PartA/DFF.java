package ProjectPart3.PartA;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


public class DFF {
    byte In;
    byte Out;
    private final ScheduledExecutorService scheduler;

    public DFF(byte In) {
        this.In = In;
        this.Out = this.In;
        this.scheduler = Executors.newScheduledThreadPool(1);
        startUpdateTask();
    }
    public DFF(int In) {
        this((byte) In);
    }

    public byte getOut(){
        return this.Out;
    }

    public void update(byte Clock){
        if (Clock == (byte) 1){
            this.Out = this.In;
        }
    }

    public void setIn(byte In){
        this.In = In;
    }

    private void startUpdateTask(){
        final Runnable updater = new Runnable() {
            public void run() {
                update((byte) 1);
            }
        };
        this.scheduler.scheduleAtFixedRate(updater, 0, 1, TimeUnit.SECONDS);
    }
}
