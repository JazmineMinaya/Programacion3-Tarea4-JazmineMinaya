public class HiloCorredores extends Thread {
    private String corredor;

    public HiloCorredores(String corredor) {
        this.corredor = corredor;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            System.out.println(corredor + " avanzó al metro " + i);
            try {
                Thread.sleep(1000);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println(corredor + "llegó a la meta.");
    }
    
}
