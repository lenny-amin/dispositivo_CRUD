package com.example.dispositivos.Controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.dispositivos.Models.Sucursal;
import com.example.dispositivos.Services.SucursalService;
import org.springframework.http.MediaType;
import org.springframework.http.HttpStatus;

import java.util.*;

@RestController
@RequestMapping("/api/sucursales")
@CrossOrigin(origins = "${app.cors.allowed-origins}", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class SucursalController {
    private final SucursalService sucursalService;

    public SucursalController(SucursalService sucursalService) {
        this.sucursalService = sucursalService;
    }

    @GetMapping
    public List<Sucursal> getAll() {
        return sucursalService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Sucursal> getById(@PathVariable Long id) {
        return sucursalService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Sucursal> create(@RequestBody Sucursal sucursal) {
        try {
            Sucursal newSucursal = sucursalService.save(sucursal);
            return ResponseEntity.status(HttpStatus.CREATED).body(newSucursal);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Sucursal> update(@PathVariable Long id, @RequestBody Sucursal sucursal) {
        try {
            return ResponseEntity.ok(sucursalService.update(id, sucursal));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        return sucursalService.findById(id)
            .map(sucursal -> {
                sucursalService.delete(id);
                return ResponseEntity.noContent().<Void>build();
            })
            .orElse(ResponseEntity.notFound().build());
    }
}
