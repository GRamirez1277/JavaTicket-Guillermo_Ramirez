package Usuarios;
import Principal.Login;
import java.util.ArrayList;

public class ManejoUsuarios {

    public static String USERACTUAL = "";
    public static ArrayList<Usuarios> Users;
    public static String usuario_Edit = "";

    public ManejoUsuarios() {
        Users = new ArrayList<>();
        añadirAdmin();
    }

    public void añadir(String nombreUsuario, Usuarios us) {
        if (verificar(nombreUsuario)) {
            Users.add(us);
        }
    }

    public boolean verificarBorrado(String Username) {
        if (buscar(Username) != null && buscar(Username).getTipoUsuario() != 0) {
            return true;
        }
        return false;
    }

    public void borrar(String Username) {
        if (verificarBorrado(Username)) {
            Users.remove(buscar(Username));
        }

    }

    public final void añadirAdmin() {
        Administrador us = new Administrador("admin", "supersecreto", 0, 0, "");
        Users.add(0, us);
    }

    public void editar(String name, String user, String password, int edad, int tipo) {
        if (buscar(usuario_Edit) != null) {
            buscar(usuario_Edit).setEdad(edad);
            buscar(usuario_Edit).setTipo_usuario(tipo);
            buscar(usuario_Edit).setNombre_real(name);
            buscar(usuario_Edit).setContraseña(password);
            buscar(usuario_Edit).setNombre_usuario(user);
        }
    }

    public Usuarios buscar(String nombreUsuario) {
        for (Usuarios us : Users) {
            if (us != null && us.getNombreUsuario().equals(nombreUsuario)) {
                return us;
            }
        }
        return null;
    }

    public String datos() {
        String Texto = "nombre: " + buscar(USERACTUAL).getNombreCompleto()
                + "\nNombre de usuario: " + buscar(USERACTUAL).getNombreUsuario()
                + "\nContraseña: " + buscar(USERACTUAL).getContraseña()
                + "\nEdad: " + buscar(USERACTUAL).getEdad();
        switch (buscar(USERACTUAL).getTipoUsuario()) {
            case 1:
                Texto += "\nTipo de usuario: Administrador\n";
                break;
            case 2:
                Texto += "\nTipo de usuario: Contenido\n";
                break;
            case 3:
                Texto += "\nTipo de usuario: Limitado\n";
                break;
        }

        if (buscar(USERACTUAL) instanceof Contenidos) {
            Contenidos us = (Contenidos) buscar(USERACTUAL);
            Texto += verEventos(USERACTUAL, us.getIDs());
        }

        if (buscar(USERACTUAL) instanceof Administrador) {
            Administrador us = (Administrador) buscar(USERACTUAL);
            Texto += verEventos(USERACTUAL, us.getIDs());
        }
        if(buscar(USERACTUAL) instanceof Limitado){
            Limitado us = (Limitado) buscar(USERACTUAL);
            Texto += verEventos(USERACTUAL, us.getIDs());
        }

        return Texto;
    }

    private String verEventos(int i, ArrayList array, String acumulador) {

        if (i < array.size()) {
            if (Login.MANEJOEVENTOS.buscar((int) array.get(i)) != null) {
                String tipo = "";
                String Estado;
                if (Login.MANEJOEVENTOS.buscar((int) array.get(i)).getTipoEvento() == 1) {
                    tipo = "Deportivo";
                }
                if (Login.MANEJOEVENTOS.buscar((int) array.get(i)).getTipoEvento() == 2) {
                    tipo = "Musical";
                }
                if (Login.MANEJOEVENTOS.buscar((int) array.get(i)).getTipoEvento() == 3) {
                    tipo = "Religioso";
                }
                if (Login.MANEJOEVENTOS.buscar((int) array.get(i)).Cancelado()) {
                    Estado = "Cancelado";
                } else {
                    Estado = "Activo";
                }
                return verEventos(i + 1, array, acumulador + "---------------\nCodigo: " + Login.MANEJOEVENTOS.buscar((int) array.get(i)).getCodigoUnico() + "\n" + "Tipo de evento: " + tipo + "\n" + "Titulo: " + Login.MANEJOEVENTOS.buscar((int) array.get(i)).getTitulo() + "\n" + "Estado: " + Estado + "\nMonto: " + Login.MANEJOEVENTOS.buscar((int) array.get(i)).getMontoRenta() + "\n");
            } else {
                return "";
            }
        }
        System.out.println(acumulador);
        return acumulador;
    }

    public String verEventos(String name, ArrayList array) {
        return verEventos(0, array, "");
    }

    public boolean verificar(String nombre_usuario) {
        if (buscar(nombre_usuario) != null) {
            return false;
        }

        return true;
    }
}
