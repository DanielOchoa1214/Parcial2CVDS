/*
 * Copyright (C) 2015 hcadavid
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package edu.eci.pdsw.samples.entities;

import java.sql.Date;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author hcadavid
 */
public class Paciente {
    
    private int id;
    private TipoIdentificacion tipo_id;
    private String nombre;
    private Date fechaNacimiento;
    List<Consulta> consultas;
    

    public Paciente(int id, TipoIdentificacion tipo_id, String nombre, Date fechaNacimiento) {
        this.id = id;
        this.tipo_id = tipo_id;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        consultas=new ArrayList<>();
    }

    public Paciente(int id, TipoIdentificacion tipo_id, String nombre, Date fechaNacimiento, List<Consulta> consultas) {
        this.id = id;
        this.tipo_id = tipo_id;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.consultas= consultas;
    }

    public Paciente() {
        consultas=new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TipoIdentificacion getTipo_id() {
        return tipo_id;
    }

    public void setTipo_id(TipoIdentificacion tipo_id) {
        this.tipo_id = tipo_id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public List<Consulta> getConsultas() {
        return consultas;
    }

    public void setConsultas(List<Consulta> consultas) {
        this.consultas = consultas;
    }

    @Override
    public String toString() {
        StringBuffer rep = new StringBuffer("Paciente: { id:"+id+", tipo_id:"+tipo_id+", nombre: "+nombre+", fechaNacimiento: "+fechaNacimiento+", consultas : [\n");
        for (Consulta c:consultas){
            rep.append(c+"\n");
        }
        rep.append("]");
        return rep.toString();
    }
    
    
    
}
