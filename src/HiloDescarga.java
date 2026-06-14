public class HiloDescarga extends Thread {
    private String archivo;

    public HiloDescarga(String archivo) {
        this.archivo = archivo;
    }

    @Override
    public void run() {
        System.out.println("Descargando " + archivo + "...");


        for (int i = 0; i <= 100; i+=20) {
            System.out.println(archivo + " " + i + "%");
            try {
                Thread.sleep(1000);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println(archivo + " completado.");
    }
}
