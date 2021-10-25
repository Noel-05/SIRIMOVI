
package com.app.cliente.domain;

/**
 *
 * @author cg11017
 */

import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="informacionorganizacional")
public class InformacionOrganizacionalList {
    private List<InformacionOrganizacional> data;

    public List<InformacionOrganizacional> getData() {
        return data;
    }

    public void setData(List<InformacionOrganizacional> data) {
        this.data = data;
    }
    
    
}
