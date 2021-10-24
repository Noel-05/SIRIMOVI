
package com.app.cliente.domain;

import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="pruebapersons")
public class PruebaPersonaList {
    private List<PruebaPersona> data;

    public List<PruebaPersona> getData() {
        return data;
    }

    public void setData(List<PruebaPersona> data) {
        this.data = data;
    }
    
}
