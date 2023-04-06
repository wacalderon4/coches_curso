package com.project.coches.persistance.mapper;

import com.project.coches.domain.pojo.BrandCarPojo;
import com.project.coches.persistance.entity.BrandCarEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

/*
* Mapper que transforma objetos de Marca Coche a pojos o entidades
* */
@Mapper(componentModel = "spring")
public interface IBrandCarMapper {

    /**
     * Convierte una entidad a un pojo de marca coche
     * @param marcaEntity Entidad a convertir
     * @return Pojo convertido
     */

    @Mapping(source = "id", target = "id")
    @Mapping(source = "description", target = "description")
    BrandCarPojo toMarcaCochePojo(BrandCarEntity marcaEntity);

    /**
     * Convierte un pojo a una entidad de marca coche
     * @param marcaPojo Pojo a convertir
     * @return Entidad convertida
     */
    @InheritInverseConfiguration
    BrandCarEntity toMarcaCocheEntity(BrandCarPojo marcaPojo);

    /**
     * Retorna una lista de marcas coche transformada a Pojo de una lista de Entidades
     * @param marcasCocheEntity Entidad a transformar
     * @return Lista Transformada
     */
    List<BrandCarPojo> toMarcasCochePojo(List<BrandCarEntity> marcasCocheEntity);

}
