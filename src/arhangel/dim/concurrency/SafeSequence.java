package arhangel.dim.concurrency;


public class SafeSequence {

    private int val;

    public synchronized int nextVal() {
        return val++;
    }

    public int nextValUnsafe() {
        return val++;
    }


    public static void main(String[] args) throws Exception {
        SafeSequence seq = new SafeSequence();
        Thread t1 = new Sequencer(seq);
        Thread t2 = new Sequencer(seq);
        Thread t3 = new UnsafeSequencer(seq);

        t1.start();
        t2.start();

        //t3.start();

        // waiting for both
        t1.join();
        t2.join();

        //t3.join();

        // Should be 200_000
        System.out.println("Next Val: " + seq.nextVal());


    }

    static class Sequencer extends Thread {
        private SafeSequence seq;

        public Sequencer(SafeSequence seq) {
            this.seq = seq;
        }

        @Override
        public void run() {
            for (int i = 0; i < 100_000; i++) {
                seq.nextVal();
            }
        }

    }
    static class UnsafeSequencer extends Thread {
        private SafeSequence seq;

        public UnsafeSequencer(SafeSequence seq) {
            this.seq = seq;
        }

        @Override
        public void run() {
            for (int i = 0; i < 100_000; i++) {
                seq.nextValUnsafe();
            }
        }

    }
}
