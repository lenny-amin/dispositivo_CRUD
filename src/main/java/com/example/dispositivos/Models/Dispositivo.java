package com.example.dispositivos.Models;

import jakarta.persistence.*;
import org.hibernate.type.SqlTypes;
import org.hibernate.annotations.JdbcTypeCode;
import com.fasterxml.jackson.databind.JsonNode;

@Entity
@Table(name = "dispositivos")
public class Dispositivo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String descripcion;
    private String state;
    private String type;

    // Campo JSONB en PostgreSQL
    @Column(columnDefinition = "jsonb")
    @JdbcTypeCode(SqlTypes.JSON)
    private JsonNode schemaJson;

    // Constructores
    public Dispositivo() {}

    public Dispositivo(String name, String descripcion, String state, String type, JsonNode schemaJson) {
        this.name = name;
        this.descripcion = descripcion;
        this.state = state;
        this.type = type;
        this.schemaJson = schemaJson;
    }

    // Getters y setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public String getState() { return state; }
    public void setState(String state) { this.state = state; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public JsonNode getSchemaJson() { return schemaJson; }
    public void setSchemaJson(JsonNode schemaJson) { this.schemaJson = schemaJson; }
}
