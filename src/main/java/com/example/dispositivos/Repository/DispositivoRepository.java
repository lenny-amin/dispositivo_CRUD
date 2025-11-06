package com.example.dispositivos.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.dispositivos.Models.Dispositivo;

public interface DispositivoRepository extends JpaRepository<Dispositivo, Long> {
    List<Dispositivo> findByState(String state);
}
