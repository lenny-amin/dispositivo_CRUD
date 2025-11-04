package com.example.dispositivos.Services;

import com.example.dispositivos.Models.Sucursal;
import com.example.dispositivos.Repository.SucursalRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class SucursalService {
    private final SucursalRepository sucursalRepository;

    public SucursalService(SucursalRepository sucursalRepository) {
        this.sucursalRepository = sucursalRepository;
    }

    public List<Sucursal> findAll() {
        return sucursalRepository.findAll();
    }

    public Optional<Sucursal> findById(Long id) {
        return sucursalRepository.findById(id);
    }

    public Sucursal save(Sucursal sucursal) {
        return sucursalRepository.save(sucursal);
    }

    public Sucursal update(Long id, Sucursal updatedSucursal) {
        return sucursalRepository.findById(id)
                .map(existing -> {
                    existing.setNombre(updatedSucursal.getNombre());
                    existing.setubicacion(updatedSucursal.getubicacion());
                    existing.setTelefono(updatedSucursal.getTelefono());
                    existing.setDispositivos(updatedSucursal.getDispositivos());
                    return sucursalRepository.save(existing);
                })
                .orElseThrow(() -> new RuntimeException("Sucursal no encontrada"));
    }

    public void delete(Long id) {
        sucursalRepository.deleteById(id);
    }

}
