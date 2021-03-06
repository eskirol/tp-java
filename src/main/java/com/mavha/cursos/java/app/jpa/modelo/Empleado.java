/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mavha.cursos.java.app.jpa.modelo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author mdominguez
 */
@Entity
public class Empleado {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;
    private Double salarioHora;    
    @Temporal(TemporalType.DATE) private Date fechaContratacion; //TODO 1.2 definir el tipo temporal         

    //TODO 1.3 mapear relacion bidireccional con departamento
    @ManyToOne 
    private Departamento trabajaEn;
  
    //TODO 1.4  mapear relacion con proyecto. Elegir un lado como dueño de la relacion        
    //@ManyToOne; 
    //private List<Proyecto> participaDe;
    //@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER, mappedBy="lider")
    //
    
    //TODO 1.5 mapear la relación con tarea.
    @OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER, mappedBy="responsable") 
    private List<Tarea> tareasAsignadas = new ArrayList<Tarea>();
    //
    
    public Empleado() {
    }
    
    

    public Empleado(String nombre, Double salario, Date fechaContratacion) {
        this.nombre = nombre;
        this.salarioHora = salario;
        this.fechaContratacion = fechaContratacion;
    }

    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getSalarioHora() {
        return salarioHora;
    }

    public void setSalarioHora(Double salarioHora) {
        this.salarioHora = salarioHora;
    }

    public Date getFechaContratacion() {
        return fechaContratacion;
    }

    public void setFechaContratacion(Date fechaContratacion) {
        this.fechaContratacion = fechaContratacion;
    }

    public Departamento getTrabajaEn() {
        return trabajaEn;
    }

    public void setTrabajaEn(Departamento trabajaEn) {
        this.trabajaEn = trabajaEn;
    }

    @Override
    public String toString() {
        return "Empleado{" + "id=" + id + ", nombre=" + nombre + ", salarioHora=" + salarioHora + '}';
    }

    
    
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Empleado other = (Empleado) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    
    

    
}
