package com.project.coches.domain.service;

import com.project.coches.domain.pojo.BrandCarPojo;
import com.project.coches.domain.repository.IBrandCarRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
/*
Servicio de coche
 */
@RequiredArgsConstructor
@Service
public class BrandCarService implements IBrandCarService{
    /**
     * Repositorio de marca coche
     */
    private final IBrandCarRepository iBrandCarRepository;

    /**
     * Devuelve una lista con todas las marcas de coches
     * @return Lista con marcas de coches
     */
    @Override
    public List<BrandCarPojo> getAll() {
        return iBrandCarRepository.getAll();
    }

    /**
     * Devuelve una marca de coche dada su id
     * @param id Id de marca de coche
     * @return Optional del marca coche encontrado
     */
    @Override
    public Optional<BrandCarPojo> getBrandCar(Integer id) {
        return iBrandCarRepository.getBrandCar(id);
    }

    /**
     * Guarda una nueva marca coche
     * @param newBrandCar Marca coche a guardaR
     * @return Marca coche guardada
     */
    @Override
    public BrandCarPojo save(BrandCarPojo newBrandCar) {
        return iBrandCarRepository.save(newBrandCar);
    }

    /**
     * Actualiza una nueva marca coche
     * @param newBrandCar Marca coche a guardaR
     * @return Optional con Marca coche actualizada
     */
    @Override
    public Optional<BrandCarPojo> update(BrandCarPojo newBrandCar) {
        if(iBrandCarRepository.getBrandCar(newBrandCar.getId()).isEmpty()) {
            return Optional.empty();
        }
        return Optional.of(iBrandCarRepository.save(newBrandCar)) ;
    }

    /**
     * Elimina una marca coche dado su id
     * @param idBrandCar Id del marca coche a eliminar
     * @return true si se eliminó, false de lo contrario
     */
    @Override
    public boolean delete(Integer idBrandCar) {

        if(iBrandCarRepository.getBrandCar(idBrandCar).isEmpty()) {
            return false;
        }

        iBrandCarRepository.delete(idBrandCar);
        return true;
    }
}
