public class HiloDescarga extends Thread {
    private String archivo;

    public HiloDescarga(String archivo) {
        this.archivo = archivo;
    }

    @Override
    public void run() {
        System.out.println("\nDescargando " + archivo);

        for (int i = 0; i <= 100; i++) {
            System.out.println(archivo + " " + i + "%");
            try {
                Thread.sleep(500);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("\n" + archivo + " completado.");
    }
}
