package Usuarios;
import java.util.ArrayList;

public class Contenidos extends Usuarios{
    
ArrayList<Integer>IDs=new ArrayList<>();

    public Contenidos(String nombreUsuario, String contraseña, int tipoUsuario, int edad, String nombreCompleto) {
        super(nombreUsuario, contraseña, tipoUsuario, edad, nombreCompleto);
    }

    public void AgregarID(int ID) {
        this.IDs.add(ID);
        for (Integer ID1 : IDs) {
            System.out.println(IDs);
        }
    }
    
    public boolean revisar(int code){
        for (int i = 0; i < IDs.size(); i++) {
             if(IDs.get(i)!=null&&IDs.get(i)==code){
                 return true;
             }
        }
       return false;
    }
    
    public ArrayList getIDs(){
        return IDs;
    }
}
