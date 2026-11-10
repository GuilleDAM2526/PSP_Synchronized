public class Gonzalez extends Thread {
    private String nombre;
    private Recurso recurso;

    public Gonzalez(String nombre, Recurso recurso) {
        this.nombre = nombre;
        this.recurso = recurso;
    }

    @Override
    public void run() {
        System.out.println(nombre + " empieza.");

        try {
            switch (nombre) {
                case "Eduardo":
                    recurso.sacarDinero("Eduardo", 60);
                    recurso.ingresarDinero("Eduardo", 30);
                    break;
                case "Maria":
                    recurso.consultarSaldo();
                    break;
                case "Marta":
                    recurso.ingresarDinero("Marta", 80);
                    recurso.sacarDinero("Marta", 20);
                    break;
                case "Luis":
                    recurso.sacarDinero("Luis", 20);
                    break;
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println(nombre + " fue interrumpido mientras esperaba.");
        }

        System.out.println(nombre + " termina.");
    }
}
