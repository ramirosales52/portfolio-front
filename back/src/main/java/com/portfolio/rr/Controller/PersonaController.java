
package com.portfolio.rr.Controller;

import com.portfolio.rr.Entity.Persona;
import com.portfolio.rr.Interface.IPersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class PersonaController {
    @Autowired IPersonaService ipersonaService;
    
    @GetMapping("personas/get")
    public List<Persona> getPersona() {
        return ipersonaService.getPersona();
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("personas/create")
    public String createPersona(@RequestBody Persona persona) {
        ipersonaService.savePersona(persona);
        return "La persona fue creada correctamente";
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("personas/delete/{id}")
    public String deletePersona(@PathVariable Long id) {
        ipersonaService.deletePersona(id);
        return("La persona fue eliminada correctamente");
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("personas/edit/{id}")
    public Persona editPersona(@PathVariable Long id, 
                               @RequestParam("nombre") String newName,
                               @RequestParam("apellido") String newSurname,
                               @RequestParam("img") String newImg) {
        Persona persona = ipersonaService.findPersona(id);
        
        persona.setNombre(newName);
        persona.setApellido(newSurname);
        persona.setImg(newImg);
        
        ipersonaService.savePersona(persona);
        return persona;
    }
    
    @GetMapping("personas/get/perfil")
    public Persona findPersona() {
        return ipersonaService.findPersona((long)1);
    }
}
