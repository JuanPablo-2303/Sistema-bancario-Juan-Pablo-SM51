import java.util.Scanner;

public class Banco {
    static int nummm;
    public static void main(String[] args) {
        int validar=0, numT, nip, menu;
        Scanner te = new Scanner(System.in);		//Para qur podamos escribir o insertar datos desde la pantalla
        
        Usuario usuario = new Usuario();			//Declaraciones para poder accerder a una funcion de una clase
        Conexion c = new Conexion();				
        Cajero caja = new Cajero();
        Registro r = new Registro();				//Termian las declaraciones
        System.out.println("Menu");
        System.out.println("Nuevo Usuario: 1");		//Mensaje para decidir que queremos hacer
        System.out.println("Iniciar sesion: 2");
        validar = te.nextInt();
        while(validar==1){
            r.crearCuenta();
            System.out.println("Desea agregar otro usuario?");
            System.out.println("Ingrese 1=SI o 2=NO");
            validar = te.nextInt();
        }
        
        System.out.println("******************************");
        System.out.println("INICIAR SESION");
        System.out.println("******************************");
        System.out.println("Ingrese el numero de tarjeta:");
        numT = te.nextInt();
        
        System.out.println("Ingrese su nip:");
        nip = te.nextInt();
        
        if(caja.validacionTarjeta(numT, nip)==true){
            do{
                nummm=numT;
                System.out.println("******************************");
                System.out.println("MENU");
                System.out.println("******************************");
                
                System.out.println("Elija un numero:");
                System.out.println("0) Fondos Actuales");
                System.out.println("1) Depositar");
                System.out.println("2) Retirar");
                System.out.println("3) Cerrar Sesion");
                menu = te.nextInt();
                
                switch(menu){						//Sentencia para que tome un tiempo en hacer la funcion que elegimos
                    case 0:
                        caja.verFondos(nummm);
                        break;
                    case 1:
                        caja.deposito(nummm);
                        break;
                    case 2:
                        caja.retiro();
                        break;
                    case 3:
                        System.exit(0);
                        break;
                }
            }while(1==1);            
        }else{
            System.out.println("NIP erroneo");
        } 
    }
}
