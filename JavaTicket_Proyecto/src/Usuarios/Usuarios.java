package Usuarios;

public class Usuarios {
    private String contraseña;
    private int tipoUsuario; 
    private String nombreCompleto;
    private String nombreUsuario;
    private int edad;
        
    public Usuarios(String nombreUsuario, String contraseña, int tipoUsuario, int edad, String nombreCompleto) {
        this.tipoUsuario = tipoUsuario;
        this.contraseña = contraseña;
        this.nombreCompleto = nombreCompleto;
        this.nombreUsuario = nombreUsuario;
        this.edad = edad;
    }

   public String getContraseña() {
        return contraseña;
    }
   public void setNombre_real(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }
    public void setTipo_usuario(int tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }
    
    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

     public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombre_usuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }
    public int getTipoUsuario() {
        return tipoUsuario;
    }
    
    public int getEdad() {
        return edad;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

 
}
