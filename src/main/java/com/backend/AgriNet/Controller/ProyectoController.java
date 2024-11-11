package com.backend.AgriNet.Controller;

import com.backend.AgriNet.Model.proyectos.Proyecto;
import com.backend.AgriNet.Service.ProyectoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/proyectos")
public class ProyectoController {

    @Autowired
    private ProyectoService proyectoService;

    @GetMapping
    public List<Proyecto> getAllProyectos() {
        return proyectoService.getAllProyectos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Proyecto> getProyectoById(@PathVariable String id) {
        return proyectoService.getProyectoById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Proyecto createProyecto(@RequestBody Proyecto proyecto) {
        return proyectoService.createProyecto(proyecto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Proyecto> updateProyecto(@PathVariable String id, @RequestBody Proyecto proyectoDetails) {
        return ResponseEntity.ok(proyectoService.updateProyecto(id, proyectoDetails));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProyecto(@PathVariable String id) {
        proyectoService.deleteProyecto(id);
        return ResponseEntity.noContent().build();
    }
}
