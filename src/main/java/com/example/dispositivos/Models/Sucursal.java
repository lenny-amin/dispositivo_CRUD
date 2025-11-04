package com.example.dispositivos.Models;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.*;

@Entity
@Table(name = "sucursales")
public class Sucursal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String ubicacion;
    private String telefono;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Dispositivo> dispositivos = new ArrayList<>();


    // Constructores
    public Sucursal() {}

    public Sucursal(String nombre, String ubicacion, String telefono, List<Dispositivo> dispositivos) {
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.telefono = telefono;
        this.dispositivos = dispositivos;
    }

    // Getters y setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getubicacion() { return ubicacion; }
    public void setubicacion(String ubicacion) { this.ubicacion = ubicacion; }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }

    public List<Dispositivo> getDispositivos() { return dispositivos; }
    public void setDispositivos(List<Dispositivo> dispositivos) { this.dispositivos = dispositivos; }
    
}
