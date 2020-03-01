import java.util.Scanner;

public class Cajero {
    Conexion c = new Conexion();
    Usuario usuario = new Usuario();
    Scanner te = new Scanner(System.in);
    
    int num;
    
    public boolean validacionTarjeta(int numT, int nip){
        usuario.setNumTarjeta(numT);					//Aqui ingresarmos el numero de tarjeta 
        usuario = c.seleccionarUsuario(usuario);			
        if(nip==usuario.getNIP()){						//Sentencia para verificar si coiciden los NIP 
            System.out.println(usuario.toString());		//con el numero de tarjeta anterior
            num = numT;
            return true;            
        }        
        return false;
    }
    
    public boolean validacionFondos(int cantidad){							
        Usuario usuarioA = new Usuario();
        usuarioA.setNumTarjeta(num);
        usuarioA = c.seleccionarUsuario(usuarioA);
        if(cantidad<=usuarioA.getFondosIni()){									//Sentencia para actualizar nuestro saldo ya depositado		
            c.actualizacionFondos(usuarioA.getId(), (0-cantidad));
            return true;            
        }        
        return false;
    }
    
    public void deposito(int numt){										//Funcion la cual nos ayudara a depositar
        System.out.println("Ingrese la cantidad a depositar ");
        int cantidad = te.nextInt();
        c.actualizacionFondos(usuario.getId(), cantidad);
        System.out.println("\nDeposito realizado con exito");
    }
    public void retiro(){												//Esta funcion nos servira para hacer un retiro
        System.out.println("Ingrese la cantidad a retirar");			//Mensaje que aparecera en la pantalla
        int cantidad = te.nextInt();
        if(validacionFondos(cantidad)==true){							//Sentencia la cual verificara si tiene saldo suficiente
            System.out.println("\nRetiro realizado con exito\n");
        }else{
            System.out.println("SALDO INSUFICIENTE");					//Si no tiene saldo suficiente aparecera este mensaje
            System.out.println("Desea intentarlo de nuevo?\nSI=1 NO=Cualquier Numero");
            int v =te.nextInt();
            if (v==1) {
                retiro();
            }
        }
    }
    
    public void verFondos(int numT){							//Para hacer una consulta de nuestro saldo
        Usuario usuarioA = new Usuario();
        usuarioA.setNumTarjeta(numT);
        usuarioA = c.seleccionarUsuario(usuarioA);        
        System.out.println("\nFondos Actuales: " + usuarioA.getFondosIni());
    }
}
