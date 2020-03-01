public class Usuario {
	
    private int id;					//Aqui comienza todas las declaraciones de varibles
    private String nombre;
    private String apellidoP;
    private String apellidoM;
    private int NIP;				//Estos son los datos del usuario que nosotors vamos a almacenar 
    private int numTarjeta;			// al momento de registrar un usuario nuevo
    private int fondosIni;
    private String Historial;
    private int edad;
	private String tutor;			
									//Aqui termina las declaraciones de las variables a utilizar
	

    public String getHistorial() {  //Inicia los setters and getters
        return Historial;
    }

    public void setHistorial(String Historial) {
        this.Historial = Historial;
    }

    public int getId() {
            return id;
    }
    public void setId(int id) {
            this.id = id;
    }
    public String getNombre() {
            return nombre;
    }
    public void setNombre(String nombre) {
            this.nombre = nombre;
    }
    public String getApellidoP() {
            return apellidoP;
    }
    public void setApellidoP(String apellidoP) {	//Los setter and getter los utilizamos para poder acceder
            this.apellidoP = apellidoP;				// y mandodificar los datos que nosotros ya tenemos
    }
    public String getApellidoM() {
            return apellidoM;
    }
    public void setApellidoM(String apellidoM) {
            this.apellidoM = apellidoM;
    }
    public int getNIP() {
        return NIP;
    }
    public void setNIP(int NIP) {
        this.NIP = NIP;
    }
    public int getNumTarjeta() {
        return numTarjeta;
    }
    public void setNumTarjeta(int numTarjeta) {
        this.numTarjeta = numTarjeta;
    }
    public int getFondosIni() {
        return fondosIni;
    }
    public void setFondosIni(int fondosIni) {
        this.fondosIni = fondosIni;
    }

    public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	public String getTutor() {
		return tutor;
	}

	public void setTutor(String tutor) {
		this.tutor = tutor;
	}
									//Aqui termina los setters and getters

	@Override
    public String toString() {
        return "Usuario: \n" + 
                "id= " + id + 
                "\nNombre Completo= " + nombre + " " + apellidoP + " " + apellidoM + 
                "\nNIP= " + NIP +  														//El toString nos servira para convertir los datos insertados en String
                "\nnumTarjeta= " + numTarjeta + 
                "\nFondos= " + fondosIni+
                "\nEdad= "+edad+
        		"\nTutor= "+tutor;
    }
}
