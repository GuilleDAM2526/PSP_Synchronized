/* Crear un programa que simule un cajero automático.
 * La familia González ( Eduardo, María, Luis, Marta) disponen de 
 * una cuenta bancaria común. Cada persona tiene una tarjeta de crédito,
 * de la misma cuenta.
 * Cada persona podrá sacar dinero, ingresar dinero y consultar el saldo.
 * Hasta que una persona no haya terminado de sacar dinero o ingresar,
 * otra persona no podrá realizar ninguna acción.
 * La cuenta tiene un saldo inicial de 30 euros.
 * Ejecutar las siguientes acciones de manera simultánea.
 * 
 * Eduardo saca 60 euros.
 * María consulta el saldo
 * Marta ingresa 80 euros.
 * Luis saca 20
 * Marta saca 20.
 * Eduardo ingresa 30.
 */

public class Cajero {

    public static void main(String[] args) throws InterruptedException{
        Recurso cuenta = new Recurso();

        Gonzalez edu = new Gonzalez("Eduardo", cuenta);
        Gonzalez maria = new Gonzalez("Maria", cuenta);
        Gonzalez marta = new Gonzalez("Marta", cuenta);
        Gonzalez luis = new Gonzalez("Luis", cuenta);

        edu.start();
        maria.start();
        marta.start();
        luis.start();

        edu.join();
        maria.join();
        marta.join();
        luis.join();
    }
}