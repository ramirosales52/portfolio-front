
package com.portfolio.rr.Interface;

import com.portfolio.rr.Entity.Persona;
import java.util.List;


public interface IPersonaService {
    // Traer lista de personas
    public List<Persona> getPersona();
    // Guardar persona
    public void savePersona(Persona persona);
    // Eliminar persona por id
    public void deletePersona(Long id);
    // Buscar persona por id
    public Persona findPersona(Long id);
    
}
