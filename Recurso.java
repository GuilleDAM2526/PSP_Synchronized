public class Recurso {
    private int saldo = 30;
    
    public synchronized void consultarSaldo(){
        System.out.println("El saldo en la cuenta es de: " + saldo);
    }
    public synchronized void sacarDinero(String nombre, int saca) throws InterruptedException{
        while (saldo < saca){
            System.out.println("No quedan fondos suficientes, por favor, espere.");
            wait();
        }
        saldo -= saca;
        System.out.println(nombre + " ha sacado " + saca + " Euros. El saldo actual es de " + saldo + " Euros");
    }
    
    public synchronized void ingresarDinero(String nombre, int ingresa){
        saldo += ingresa;
        System.out.println(nombre + " ha ingresado " + ingresa + " Euros. El saldo actual es de " + saldo + " Euros");
        notifyAll();
    }
}
