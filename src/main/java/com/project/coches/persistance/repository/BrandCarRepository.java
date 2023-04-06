package com.project.coches.persistance.repository;

import com.project.coches.domain.pojo.BrandCarPojo;
import com.project.coches.domain.repository.IBrandCarRepository;
import com.project.coches.persistance.entity.BrandCarEntity;
import com.project.coches.persistance.mapper.IBrandCarMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Repositorio de marca coche
 */
@RequiredArgsConstructor // Crea constructor con los atributos final
@Repository
public class BrandCarRepository implements IBrandCarRepository {

    /**
     * Crud de marca coche
     */
    private final IBrandCarCrudRepository iBrandCarCrudRepository;

    /**
     * Mapper de marca coche
     */
    private final IBrandCarMapper iBrandCarMapper;

    /**
     * Devuelve una lista con todas las marcas coche
     * @return
     */
    @Override
    public List<BrandCarPojo> getAll() {
        return iBrandCarMapper.toMarcasCochePojo(iBrandCarCrudRepository.findAll());
    }

    /**
     * Devuelve una marca de coche dado su id
     * @param id Id de marca de coche
     * @return Optional del marca coche encontrado
     */
    @Override
    public Optional<BrandCarPojo> getBrandCar(Integer id) {
        return iBrandCarCrudRepository.findById(id)
                .map(iBrandCarMapper::toMarcaCochePojo);
        // brandCarEntity -> iBrandCarMapper.toMarcaCochePojo(brandCarEntity) LAMBDA
        // iBrandCarMapper::toMarcaCochePojo Metodo por REFERENCIA
    }

    /**
     * Guarda una nueva marca coche
     * @param newBrandCar Marca coche a guardaR
     * @return Marca coche guardada
     */
    @Override
    public BrandCarPojo save(BrandCarPojo newBrandCar) {
        BrandCarEntity brandCarEntity = iBrandCarMapper.toMarcaCocheEntity(newBrandCar);
        return iBrandCarMapper.toMarcaCochePojo(iBrandCarCrudRepository.save(brandCarEntity));
    }

    /**
     * Elimina una marca coche dado su id
     * @param idBrandCar Id del marca coche a eliminar
     */
    @Override
    public void delete(Integer idBrandCar) {
        iBrandCarCrudRepository.deleteById(idBrandCar);

    }
}
