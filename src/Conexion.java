
import java.util.ArrayList;
import java.util.List;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;

public class Conexion {
    private ObjectContainer db = null;						//Comienzan las declaraciones de la funciones 

    private void abrirRegistro() {							//Abre el registro para que nosotros podamos insertar un dato nuevo
        db = Db4oEmbedded.openFile("RegistroUsuario");
    }

    private void cerrarConexion() {							
        db.close();
    }

    public void insertarRegistro(Usuario u) {				//Con esta funcion podemos insertar nuevos datos
        abrirRegistro();
        db.store(u);
        cerrarConexion();
    }
    
    public Usuario seleccionarUsuario(Usuario u) {			//Con esta podemos hacer una consulta de un datos ya registrado
        abrirRegistro();
        ObjectSet resultado = db.queryByExample(u);
        Usuario usuario = (Usuario) resultado.next();
        cerrarConexion();
        return usuario;
    }
    
    public void actualizacionFondos(int id, int cantidad ){		//En esta nos ayudara para actualizar los datos del usuario
        abrirRegistro();
        Usuario u = new Usuario();
        u.setId(id);
        ObjectSet resultado = db.queryByExample(u);
        
        Usuario preresultado = (Usuario) resultado.next();
        preresultado.setFondosIni(preresultado.getFondosIni() + cantidad);
        
        db.store(preresultado);
        cerrarConexion();
    }
}
