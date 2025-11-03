package com.example.dispositivos.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.dispositivos.Models.Dispositivo;

public interface DispositivoRepository extends JpaRepository<Dispositivo, Long> {
}
