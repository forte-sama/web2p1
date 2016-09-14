/**
 * Created by forte on 14/09/16.
 */
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;

@ManagedBean(name = "klkBean")
@SessionScoped
public class HelloBean implements Serializable {

    private String name;
    private int edad;

    public HelloBean() {}

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
}