package Eventos;
import Enumeracion.*;
import Eventos.*;
import Principal.Login;
import java.util.*;
import javax.swing.JOptionPane;
import Usuarios.*;

public class ManejoEventos {

    private static ArrayList<Eventos> eventos = new ArrayList<>();
    private Calendar cal = Calendar.getInstance();

    public Eventos buscar(int code) {
        for (Eventos us : eventos) {
            if (us != null && us.getCodigoUnico() == code) {
                return us;
            }
        }
        return null;
    }

    public boolean borrarEvento(int code) {
        Eventos evento = buscar(code);

        if (evento != null && !evento.Cancelado()) {
            Calendar calendarActual = Calendar.getInstance();
            Calendar fechaEvento = Calendar.getInstance();
            fechaEvento.setTime(evento.getFecha());
            Administrador userAdmin = null;
            Contenidos Uscontenido = null;

            int tipoUsuario = Login.FUNCIONES.buscar(ManejoUsuarios.USERACTUAL).getTipoUsuario();

            if (tipoUsuario == 1) {
                userAdmin = (Administrador) Login.FUNCIONES.buscar(ManejoUsuarios.USERACTUAL);
            } else if (tipoUsuario == 2) {
                Uscontenido = (Contenidos) Login.FUNCIONES.buscar(ManejoUsuarios.USERACTUAL);
            }
           
            if (Login.FUNCIONES.buscar(ManejoUsuarios.USERACTUAL).getTipoUsuario() == 1 && userAdmin.revisar(code) || Login.FUNCIONES.buscar(ManejoUsuarios.USERACTUAL).getTipoUsuario() == 2 && Uscontenido.revisar(code)) {
                if (calendarActual.before(fechaEvento)) {
                     long diferenciaDias = ((fechaEvento.getTimeInMillis() - calendarActual.getTimeInMillis()) / (24 * 60 * 60 * 1000));
                    if (diferenciaDias <= 1 && buscar(code).getTipoEvento() != 3) {
                        double montoIndemnizacion = buscar(code).getMontoRenta() * 0.5;
                        buscar(code).setMulta(buscar(code).getMulta() + montoIndemnizacion);
                        JOptionPane.showMessageDialog(null, "La multa es de: $" + montoIndemnizacion);
                    }
                    buscar(code).setBorrado(true);
                    JOptionPane.showMessageDialog(null, "Evento borrado correctamente");
                    return true;
                } else {
                    JOptionPane.showMessageDialog(null, "No puede borrar un evento cuya fecha ya ha pasado");
                    return false;
                }
            } else {
                JOptionPane.showMessageDialog(null, "Solo el creador del evento puedo borrar eL evento");
                return false;
            }

        } else {
            JOptionPane.showMessageDialog(null, "El evento con código " + code + " no existe o ya fue borrado.");
            return false;
        }
    }

    public void AddEvent(Eventos eve, int id) {
        if (buscar(id) == null) {
            eventos.add(eve);
        }

    }

    public void editar_religioso(int id, int PersonasConvertidas, String titulo, String descripcion, Date fecha, double montoRenta, int cantidad_personas) {
            Eventos evento = buscar(id);
            EventoReligioso eve= (EventoReligioso) evento;
            eve.setPersonasConvertidas(PersonasConvertidas);
            buscar(id).setCantidadPersonas(cantidad_personas);
            buscar(id).setDescripcion(descripcion);
            buscar(id).setFecha(fecha);
            buscar(id).setMontoRenta(montoRenta);
            buscar(id).setTitulo(titulo);
        
    }

    
    public void editar_deportivo(int id, String equipo1, String equipo2, TipoDeporte deporte, ArrayList integrante_1, ArrayList integrante2, String titulo, String descripcion, Date fecha, double montoRenta, int cantidad_personas) {
        Eventos evento = buscar(id);
            EventoDeportivo eve= (EventoDeportivo) evento;
            eve.setNombreEquipo1(equipo1);
            eve.setNombreEquipo2(equipo2);
            eve.setTipoDeporte(deporte);
            eve.AgregarNombre1(integrante_1);
            eve.AgregarNombre2(integrante2);
            evento.setCantidadPersonas(cantidad_personas);
            evento.setDescripcion(descripcion);
            evento.setFecha(fecha);
            evento.setMontoRenta(montoRenta);
            evento.setTitulo(titulo);
        
    }

    public void editar_musical(int id, ArrayList integrantes, TipoMusica musica, String titulo, String descripcion, Date fecha, double montoRenta, int cantidad_personas) {
            Eventos evento = buscar(id);
            EventoMusical eve= (EventoMusical) evento;
            eve.AgregarNombre1(integrantes);
            eve.setTipoMusica(musica);
            buscar(id).setCantidadPersonas(cantidad_personas);
            buscar(id).setDescripcion(descripcion);
            buscar(id).setFecha(fecha);
            buscar(id).setMontoRenta(montoRenta);
            buscar(id).setTitulo(titulo);
            
    }

    
    public String datos(int code) {
        if (buscar(code) != null) {
            String texto_principal="";
            switch (buscar(code).getTipoEvento()) {
                case 1:
                    EventoDeportivo eve = (EventoDeportivo) buscar(code);
                    texto_principal=eve.toString();
                    break;

                case 2:
                    EventoMusical evm = (EventoMusical) buscar(code);
                    texto_principal = evm.toString();
                    break;

                case 3:
                    EventoReligioso evr = (EventoReligioso) buscar(code);
                    texto_principal = evr.toString();
                    break;
            }
            return texto_principal;
        }
        return null;
    }

    private String listarEventoscancelados(int i, String Detalles, int contador_deportivo, int contador_musical, int contador_religioso, double multa, String ListaGeneral) {
    if (eventos != null) {
    if (i < eventos.size()) {
        Eventos eventoActual = buscar(i);

        if (eventoActual.Cancelado()) {
            multa += eventoActual.getMulta();
            String tipo = "";
            switch (eventoActual.getTipoEvento()) {
                case 1:
                    tipo = "Deportivo";
                    contador_deportivo++;
                    break;
                case 2:
                    tipo = "Musical";
                    contador_musical++;
                    break;
                case 3:
                    tipo = "Religioso";
                    contador_religioso++;
                    break;
            }

            Detalles += "---------------\nCodigo: " + eventoActual.getCodigoUnico() +
                    "\nTipo de evento: " + tipo +
                    "\nTitulo: " + eventoActual.getTitulo() +
                    "\nfecha: " + eventoActual.getFecha().toString() +
                    "\nMulta: " + eventoActual.getMulta() + "\n";
        }

        return listarEventoscancelados(i + 1, Detalles, contador_deportivo, contador_musical, contador_religioso, multa, ListaGeneral);
    }
    ListaGeneral = "Eventos deportivos cancelados: " + contador_deportivo +
            "\nEventos Musicales cancelados: " + contador_musical +
            "\nEventos religiosos cancelados: " + contador_religioso +
            "\nMulta Total: " + multa + "\n";

    return ListaGeneral + Detalles;
    }else{
    return "No hay eventos cancelados";
    }
    }

    public String listarEventoscancelados() {
        return listarEventoscancelados(0, "", 0, 0, 0, 0, "");
    }

    private String listarEventosfuturos(int i, String acumulador, int contador_deportivo, int contador_musical, int contador_religioso, double monto_dep,double monto_mus,double monto_rel, String stats) {
        if (eventos != null) {
            if (i < eventos.size()) {
                if (buscar(i).getFecha().after(cal.getTime())&&!buscar(i).Cancelado()) {
                    String tipo = "";
                    if (buscar(i).getTipoEvento() == 1) {
                        tipo = "Deportivo";
                        contador_deportivo++;
                        monto_dep+=buscar(i).getMontoRenta();
                    }
                    if (buscar(i).getTipoEvento() == 2) {
                        tipo = "Musical";
                        contador_musical++;
                        monto_mus+=buscar(i).getMontoRenta();
                    }
                    if (buscar(i).getTipoEvento() == 3) {
                        tipo = "Religioso";
                        contador_religioso++;
                        monto_rel+=buscar(i).getMontoRenta();
                    }

                    return listarEventosfuturos(i + 1, acumulador + "---------------\nCodigo: " + buscar(i).getCodigoUnico() + "\n" + "Tipo de evento: " + tipo + "\n" + "Titulo: " + buscar(i).getTitulo() + "\n" + "fecha: " + buscar(i).getFecha().toString() + "\nmonto: " + buscar(i).getMontoRenta()+ "\n", contador_deportivo, contador_musical, contador_religioso, monto_dep,monto_mus,monto_rel, "Eventos deportivos Futuros: " + contador_deportivo + "\nEventos Musicales Futuros: " + contador_musical + "\nEventos religiosos Futuros: " + contador_religioso + "\nmonto de eventos deportivos: " + monto_dep + "\nmonto de eventos Musicales: " + monto_mus + "\nmonto de eventos religiosos: " + monto_rel+"\n" );
                } else {
                    return listarEventosfuturos(i + 1, acumulador, contador_deportivo, contador_musical, contador_religioso, monto_dep, monto_mus, monto_rel, stats);
                }
            }
            return stats + acumulador;
        } else {
            return "No hay eventos a futuro";
        }
    }
    public String listarEventosfuturos() {
        return listarEventosfuturos(0, "", 0, 0, 0, 0,0,0, "");
    }
private String listarEventosPasados(int i, String Detalles, int contador_deportivo, int contador_musical, int contador_religioso, double monto_dep,double monto_mus,double monto_rel, String ListaGeneral, List<Eventos> eventosPasados) {
    if (eventos != null) {
        if (i < eventos.size()) {
            if (buscar(i).getFecha().before(cal.getTime())&&!buscar(i).Cancelado()) {
                 String tipo = "";
                    if (buscar(i).getTipoEvento() == 1) {
                        tipo = "Deportivo";
                        contador_deportivo++;
                        monto_dep+=buscar(i).getMontoRenta();
                    }
                    if (buscar(i).getTipoEvento() == 2) {
                        tipo = "Musical";
                        contador_musical++;
                        monto_mus+=buscar(i).getMontoRenta();
                    }
                    if (buscar(i).getTipoEvento() == 3) {
                        tipo = "Religioso";
                        contador_religioso++;
                        monto_rel+=buscar(i).getMontoRenta();
                    }
                return listarEventosPasados(i + 1, Detalles + "---------------\nCodigo: " 
                        + eventosPasados.get(i).getCodigoUnico() + "\n" + "Tipo de evento: " 
                        + tipo + "\n" + "Titulo: " + eventosPasados.get(i).getTitulo() 
                        + "\n" + "Fecha: " + eventosPasados.get(i).getFecha().toString() 
                        + "\nMonto: " + eventosPasados.get(i).getMontoRenta() 
                        + "\n", contador_deportivo, contador_musical, contador_religioso, monto_dep,monto_mus,monto_rel, "Eventos Deportivos Futuros: " 
                                + contador_deportivo + "\nEventos Musicales Futuros: " 
                                + contador_musical + "\nEventos Religiosos Futuros: " 
                                + contador_religioso + "\nMonto de eventos deportivos: " 
                                + monto_dep + "\nMonto de eventos musicales: " + monto_mus 
                                + "\nMonto de eventos religiosos: " + monto_rel+"\n", eventosPasados);
            } else {
                return listarEventosPasados(i + 1, Detalles, contador_deportivo, contador_musical, contador_religioso, monto_dep, monto_mus, monto_rel, ListaGeneral, eventosPasados);
            }
        }
        return ListaGeneral + Detalles;
    } else {
        return "No hay eventos";
    }
}
    public String listarEventosPasados() {
        List<Eventos> eventosPasados=new ArrayList<>();
        for(int i=0; i<eventos.size();i++){
            eventosPasados.add(buscar(i));
            eventosPasados.sort(Comparator.comparing(Eventos::getFecha).reversed());
        }
        return listarEventosPasados(0, "", 0, 0, 0, 0,0,0, "",eventosPasados);
    }
        private String RangoDeEventos(int i, String Detalles, int contador_deportivo, int contador_musical, int contador_religioso, double monto_dep,double monto_mus,double monto_rel, String ListaGeneral,Date inicio,Date fin,double multa_dep,double multa_mus,double multa_rel,double total) {
        if (eventos != null) {
            if (i < eventos.size()) {
                if (buscar(i).getFecha().after(inicio)&&buscar(i).getFecha().before(fin)) {
                    String tipo = "";
                    if (buscar(i).getTipoEvento() == 1) {
                        tipo = "Deportivo";
                        contador_deportivo++;
                        monto_dep+=buscar(i).getMontoRenta();
                        multa_dep+=buscar(i).getMulta();
                    }
                    if (buscar(i).getTipoEvento() == 2) {
                        tipo = "Musical";
                        contador_musical++;
                        monto_mus+=buscar(i).getMontoRenta();
                        multa_mus+=buscar(i).getMulta();
                    }
                    if (buscar(i).getTipoEvento() == 3) {
                        tipo = "Religioso";
                        contador_religioso++;
                        monto_rel+=buscar(i).getMontoRenta();
                        multa_rel+=buscar(i).getMulta();
                    
                    }
                    total=monto_dep+multa_dep+monto_mus+multa_mus+monto_rel+multa_rel;

                    return RangoDeEventos(i + 1, Detalles + "---------------\nCodigo: " 
                            + buscar(i).getCodigoUnico() + "\n" + "Tipo de evento: " + tipo + "\n" 
                                    + "Titulo: " + buscar(i).getTitulo() + "\n" + "Fecha: " 
                            + buscar(i).getFecha().toString() + "\nMonto: " 
                            + buscar(i).getMontoRenta()+ "\n", contador_deportivo, contador_musical, contador_religioso, monto_dep,monto_mus,monto_rel, "Eventos deportivos: " 
                                    + contador_deportivo + "\nEventos Musicales: " + contador_musical + "\nEventos religiosos: " 
                                    + contador_religioso + "\nMonto de eventos deportivos: " + monto_dep+"\nMulta de eventos deportivos: " 
                                    + multa_dep+ "\nMonto de eventos musicales: " + monto_mus +"\nMulta de eventos musicales: " 
                                    + multa_mus+"\nMonto de eventos religiosos: " + monto_rel+"\nMulta de eventos religiosos: " 
                                    + multa_dep+"\nIngreso generado desde el "+inicio.toString()+" Hasta el "+fin.toString()+"\nes de: " 
                                    +total+"\n",inicio, fin,
                            multa_dep, multa_mus, multa_rel,total);
                } else {
                    return RangoDeEventos(i + 1, Detalles, contador_deportivo, contador_musical, contador_religioso, monto_dep, monto_mus, monto_rel, ListaGeneral,inicio, fin,multa_dep, multa_mus, multa_rel,total);
                }
            }
            System.out.println(Detalles);
            return ListaGeneral + Detalles;
        } else {
            return "No hay eventos -__-";
        }
    }

        public String RangoDeEventos(Date inicio,Date fin) {
        return RangoDeEventos(0, "", 0, 0, 0, 0,0,0, "",inicio, fin,0, 0, 0,0);
    }
}
