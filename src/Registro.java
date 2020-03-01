
import java.util.Scanner;

public class Registro {
    Usuario usuario = new Usuario();				//Declaracion de una varible por la cual nosotros vamos a poder accerder a los datos
    Conexion c = new Conexion();					//de otras clase
    
    public  void crearCuenta(){
        Scanner te = new Scanner(System.in);			//Se crea un public void para que en la clase principal solo lo llamemos
        String cadena="";
        int cont=0;
        int cal=0;
        int a_a;
        int a_n;
        // INSERT nuevo usuario
        int numero = (int)(Math.random()*(755-25+1)+25);		//El math.random es para que nos cree numero aleatorios
        int numt = (int)(Math.random()*1000000000);				
        usuario.setId(numero);									//la declaración (numero)nos enviara un id aleatorio

        System.out.println("=====================");
        System.out.println("====Nuevo Usuario====" );			//mensajes que queremos que aparezca en la pantalla
        System.out.println("===================== \n");

        System.out.println("Ingrese su nombre:");
        usuario.setNombre(te.next());							//Lo que nosotros ingresemos se ira registrado en la clase Usuario
        System.out.println("Ingrese su apellido paterno:");
        usuario.setApellidoP(te.next());
        System.out.println("Ingrese su apellido materno:");
        usuario.setApellidoM(te.next());
        System.out.println("Ingrese su año de naciemiento: ");
        a_n = te.nextInt();
        System.out.println("Ingrese el año actual");
        a_a = te.nextInt();										//En este solo haremos el calculo de la edad del usuario a registrar
        cal = a_a - a_n;
        System.out.println("Su edad es de: "+cal+" Años");
        if(cal < 18) {											//Aqui hacemos una condicional
        	System.out.println("Ingrese nombre de su tutor: ");	//La cual si el resultado de la edad es menos a 18 años  
        	usuario.setTutor(te.next());						//pedira el nombre del tutor
        }else {
        	System.out.println("Eres mayor de edad :)");
        	usuario.setEdad(cal);
        }													//Termina la condicional
        System.out.println("Ingrese su nuevo NIP:");
        usuario.setNIP(te.nextInt());
        usuario.setNumTarjeta(numt);
        System.out.println("Numero de Tarjeta: "+usuario.getNumTarjeta());
        System.out.println("Ingrese un fondo inicial:");
        usuario.setFondosIni(te.nextInt());

        c.insertarRegistro(usuario);							//Accedemos a la funcion de la clase Registro para que los datos
        System.out.println("===========================");		//anteriores se guarden 
        System.out.println("====Registro completado====");
        System.out.println("=========================== \n");
    }
}
