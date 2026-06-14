public class HiloCorredor extends Thread {
    private String corredor;
    private static String ganadorCarrera = null;

    public HiloCorredor(String corredor) {
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

        if (ganadorCarrera == null) {
                ganadorCarrera = corredor;
                System.out.println("\n" + corredor + " llegó primero a la meta.\n");
        }
        
        System.out.println(corredor + " llegó a la meta.");
    }
}
