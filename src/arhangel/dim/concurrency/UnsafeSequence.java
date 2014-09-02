package arhangel.dim.concurrency;


public class UnsafeSequence {
    private int val;

    public int nextVal() {
        return val++;
    }


    public static void main(String[] args) throws Exception {
        UnsafeSequence seq = new UnsafeSequence();
        Thread t1 = new Sequencer(seq);
        Thread t2 = new Sequencer(seq);

        t1.start();
        t2.start();

        // waiting for both
        t1.join();
        t2.join();

        // Should be 200_000
        System.out.println("Next Val: " + seq.nextVal());


    }

    static class Sequencer extends Thread {
        private UnsafeSequence seq;
        public Sequencer(UnsafeSequence seq) {
            this.seq = seq;
        }
        @Override
        public void run() {
            for (int i = 0; i < 100_000; i++) {
                seq.nextVal();
            }
        }

    }


}
