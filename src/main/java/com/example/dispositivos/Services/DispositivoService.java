package com.example.dispositivos.Services;

import org.springframework.stereotype.Service;

import com.example.dispositivos.Models.Dispositivo;
import com.example.dispositivos.Repository.DispositivoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class DispositivoService {

    private final DispositivoRepository dispositivoRepository;

    public DispositivoService(DispositivoRepository dispositivoRepository) {
        this.dispositivoRepository = dispositivoRepository;
    }

    public List<Dispositivo> findAll() {
        return dispositivoRepository.findAll();
    }

    public List<Dispositivo> findAlerted() {
        return dispositivoRepository.findByState("alert");
    }

    public Optional<Dispositivo> findById(Long id) {
        return dispositivoRepository.findById(id);
    }

    public Dispositivo save(Dispositivo dispositivo) {
        return dispositivoRepository.save(dispositivo);
    }

    public Dispositivo update(Long id, Dispositivo updatedDispositivo) {
        return dispositivoRepository.findById(id)
                .map(existing -> {
                    existing.setName(updatedDispositivo.getName());
                    existing.setDescripcion(updatedDispositivo.getDescripcion());
                    existing.setState(updatedDispositivo.getState());
                    existing.setType(updatedDispositivo.getType());
                    existing.setSchemaJson(updatedDispositivo.getSchemaJson());
                    return dispositivoRepository.save(existing);
                })
                .orElseThrow(() -> new RuntimeException("Dispositivo no encontrado"));
    }

    public void delete(Long id) {
        dispositivoRepository.deleteById(id);
    }
}

