/**
 * Created by forte on 14/09/16.
 */
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

@ManagedBean
@SessionScoped
public class ContactBean implements Serializable {

    private int id;
    private String name;
    private String apellido;
    private String direccion;
    private String telefono;
    private String correo;
    private Contacto contactoSeleccionado;
    private static final HashMap<Integer,Contacto> contactos = new HashMap<>();

    public ContactBean() {
        id = -1;
    }

    public String agregarRapido() {
        Contacto newContact = new Contacto();
        newContact.setNombre(name);
        newContact.setApellido(apellido);
        contactos.put(newContact.getId(),newContact);
        name = apellido = direccion = telefono = correo = "";

        return null;
    }

    public String borrar(Contacto cont) {
        contactos.remove(cont.getId());

        return null;
    }

    public String guardar() {
        //si entro al form desde afuera o desde datatable con ref al contacto seleccionado
        if(id == -1) {
            Contacto newContacto = new Contacto();
            newContacto.setNombre(name);
            newContacto.setApellido(apellido);
            newContacto.setDireccion(direccion);
            newContacto.setTelefono(telefono);
            newContacto.setCorreo(correo);

            contactos.put(newContacto.getId(),newContacto);
        }
        else {
            Contacto target = contactos.get(id);
            target.setNombre(name);
            target.setApellido(apellido);
            target.setDireccion(direccion);
            target.setTelefono(telefono);
            target.setCorreo(correo);
        }

        limpiarDatos();

        return "index";
    }

    public String volver() {
        limpiarDatos();

        return "index";
    }

    public String verDetalle() {
        if(contactoSeleccionado != null) {
            id = contactoSeleccionado.getId();
            name = contactoSeleccionado.getNombre();
            apellido = contactoSeleccionado.getApellido();
            direccion = contactoSeleccionado.getDireccion();
            telefono = contactoSeleccionado.getTelefono();
            correo = contactoSeleccionado.getCorreo();
            contactoSeleccionado = null;

            return "form";
        }
        else {
            id = -1;
        }

        return null;
    }

    public void limpiarDatos() {

        id = -1;
        name = apellido = direccion = telefono = correo = "";
        contactoSeleccionado = null;
    }

    public static ArrayList<Contacto> getContactos() {
        return new ArrayList<>(contactos.values());
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public Contacto getContactoSeleccionado() {
        return contactoSeleccionado;
    }
    public void setContactoSeleccionado(Contacto contactoSeleccionado) {
        this.contactoSeleccionado = contactoSeleccionado;
    }
    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public String getTelefono() {
        return telefono;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public String getCorreo() {
        return correo;
    }
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
}