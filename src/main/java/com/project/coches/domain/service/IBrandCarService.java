package com.project.coches.domain.service;

import com.project.coches.domain.pojo.BrandCarPojo;

import java.util.List;
import java.util.Optional;

public interface IBrandCarService {
    /**
     * Devuelve una lista con todas las marcas de coches
     * @return Lista con marcas de coches
     */
    List<BrandCarPojo> getAll();

    /**
     * Devuelve una marca de coche dada su id
     * @param id Id de marca de coche
     * @return Optional del marca coche encontrado
     */
    Optional<BrandCarPojo> getBrandCar(Integer id);

    /**
     * Guarda una nueva marca coche
     * @param newBrandCar Marca coche a guardaR
     * @return Marca coche guardada
     */
    BrandCarPojo save(BrandCarPojo newBrandCar);

    /**
     * Actualiza una marca coche
     * @param newBrandCar Marca coche a actualizar
     * @return Marca coche actualizado
     */
    Optional<BrandCarPojo> update(BrandCarPojo newBrandCar);


    /**
     * Elimina una marca coche dado su id
     * @param idBrandCar Id del marca coche a eliminar
     * @return True si se eliminó, false de lo contrario
     */
    boolean delete(Integer idBrandCar);
}

