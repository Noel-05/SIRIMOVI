/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.cliente.domain;

import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author rafae
 */

@XmlRootElement(name="commercial information")
public class InformacionComercialList {
    
    private List<InformacionComercial> data;

    public List<InformacionComercial> getData() {
        return data;
    }

    public void setData(List<InformacionComercial> data) {
        this.data = data;
    }
}
