
package com.app.cliente.domain;

import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="persons")
public class PersonaList {
    
    private List<Persona> data;

    public List<Persona> getData() {
        return data;
    }

    public void setData(List<Persona> data) {
        this.data = data;
    }
    
}
