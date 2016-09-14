/**
 * Created by forte on 14/09/16.
 */
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;

@ManagedBean
@SessionScoped
public class ContactBean implements Serializable {

    private String name;
    private String apellido;
    private static final ArrayList<Contacto> contactos = new ArrayList<>();

    public ContactBean() {}

    public static ArrayList<Contacto> getContactos() {
        return contactos;
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

    public String agregar() {
        Contacto newContact = new Contacto();
        newContact.setNombre(name);
        newContact.setApellido(apellido);
        contactos.add(newContact);
        return "welcome?faces-redirect=true";
    }
}