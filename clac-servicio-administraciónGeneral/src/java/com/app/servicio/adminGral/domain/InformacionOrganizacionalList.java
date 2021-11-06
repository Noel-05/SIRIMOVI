
package com.app.servicio.adminGral.domain;

import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="informationorganizationals")
public class InformacionOrganizacionalList {
    private List<InformacionOrganizacional> data;

    public List<InformacionOrganizacional> getData() {
        return data;
    }

    public void setData(List<InformacionOrganizacional> data) {
        this.data = data;
    }
}
