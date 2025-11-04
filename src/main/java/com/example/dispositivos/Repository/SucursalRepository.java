package com.example.dispositivos.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.dispositivos.Models.Sucursal;

public interface SucursalRepository extends JpaRepository<Sucursal, Long> {
}
