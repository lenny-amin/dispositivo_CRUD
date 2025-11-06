package com.example.dispositivos.Controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.dispositivos.Models.Dispositivo;
import com.example.dispositivos.Services.DispositivoService;
import org.springframework.http.MediaType;
import org.springframework.http.HttpStatus;

import java.util.List;

@RestController
@RequestMapping("/api/dispositivos")
@CrossOrigin(origins = "${app.cors.allowed-origins}", methods = { RequestMethod.GET, RequestMethod.POST,
        RequestMethod.PUT, RequestMethod.DELETE })
public class DispositivoController {

    private final DispositivoService dispositivoService;

    public DispositivoController(DispositivoService dispositivoService) {
        this.dispositivoService = dispositivoService;
    }

    @GetMapping
    public List<Dispositivo> getAll() {
        return dispositivoService.findAll();
    }

    @GetMapping("/state/alert")
    public List<Dispositivo> getAlert() {
        return dispositivoService.findAlerted();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Dispositivo> getById(@PathVariable Long id) {
        return dispositivoService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Dispositivo> create(@RequestBody Dispositivo dispositivo) {
        try {
            Dispositivo newDispositivo = dispositivoService.save(dispositivo);
            return ResponseEntity.status(HttpStatus.CREATED).body(newDispositivo);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Dispositivo> update(@PathVariable Long id, @RequestBody Dispositivo dispositivo) {
        try {
            return ResponseEntity.ok(dispositivoService.update(id, dispositivo));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        return dispositivoService.findById(id)
                .map(dispositivo -> {
                    dispositivoService.delete(id);
                    return ResponseEntity.noContent().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
