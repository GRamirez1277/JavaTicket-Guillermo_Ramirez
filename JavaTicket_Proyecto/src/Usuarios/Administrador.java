package Usuarios;
import java.util.ArrayList;

public class Administrador extends Usuarios{
    
    private ArrayList<Integer>IDs=new ArrayList<>();

    public Administrador(String nombreUsuario, String contraseña, int tipoUsuario, int edad, String nombreCompleto) {
        super(nombreUsuario, contraseña, tipoUsuario, edad, nombreCompleto);
    }

    public void AgregarID(int ID) {
        IDs.add(ID);
        for (Integer sas : IDs) {
            System.out.println(sas);
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