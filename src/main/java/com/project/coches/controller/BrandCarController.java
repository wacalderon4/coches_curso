package com.project.coches.controller;

import com.project.coches.domain.pojo.BrandCarPojo;
import com.project.coches.domain.service.BrandCarService;
import com.project.coches.domain.service.IBrandCarService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/**
 * Controlador REST de marca coche
 */
@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/marcas-coches")
public class BrandCarController {

    /**
     * Servicio de marca coche
     */
    private final IBrandCarService iBrandCarService;

    /**
     * Devuelve lista de macas coche
     * @return HttpCode OK con lista de marcas coche
     */
    @GetMapping()
    public ResponseEntity<List<BrandCarPojo>> getAll() {
        return ResponseEntity.ok(iBrandCarService.getAll());
        // return ResponseEntity.status(HttpStatus.OK)
        //         .body(iBrandCarService.getAll()); Alternativa para crear Response Entity
        // return new ResponseEntity<>(iBrandCarService.getAll(), HttpStatus.OK); Alternativa para crear Response Entity
    }

    /**
     * Devuelve una marca coche dado su id
     * @param id Id de la marca coche a buscar
     * @return HttpCode OK si la encuentra, HttpCode BadRequest de lo contrario
     */

    @GetMapping(path = "/{id}")
    public ResponseEntity<BrandCarPojo> getBrandCar(@PathVariable Integer id){
        return ResponseEntity.of(iBrandCarService.getBrandCar(id));
    }

    /**
     * Crea una nueva marca coche
     * @param brandCarPojoNew Marca coche a crear
     * @return HttpCode Created si la guarda correctamente
     */
    @PostMapping
    public ResponseEntity<BrandCarPojo> save(@RequestBody BrandCarPojo brandCarPojoNew){
        try{
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(iBrandCarService.save(brandCarPojoNew));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

    }

    /**
     * Actualiza una marca coche
     * @param brandCarPojoUpdate Marca coche a actualizar
     * @return HttpCode Ok si actualiza correctamente
     */

    @PatchMapping
    public ResponseEntity<BrandCarPojo> update(@RequestBody BrandCarPojo brandCarPojoUpdate){
        return ResponseEntity.of(iBrandCarService.update(brandCarPojoUpdate));
    }

    /**
     * Elimina una marca coche dado su id
     * @param id Id de la marca coche a eliminar
     * @return HttpCode Ok si la elimina, HttpCode NotFound si no existe
     */
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Integer id){
        return new ResponseEntity<>(this.iBrandCarService.delete(id) ? HttpStatus.OK : HttpStatus.NOT_FOUND);

    }

}
