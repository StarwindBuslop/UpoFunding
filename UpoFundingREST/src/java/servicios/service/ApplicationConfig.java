/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios.service;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author frank
 */
@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(servicios.service.DonacionFacadeREST.class);
        resources.add(servicios.service.EventoFacadeREST.class);
        resources.add(servicios.service.InversionFacadeREST.class);
        resources.add(servicios.service.ProyectoFacadeREST.class);
        resources.add(servicios.service.SolidariaFacadeREST.class);
        resources.add(servicios.service.TipoFacadeREST.class);
        resources.add(servicios.service.UsuarioFacadeREST.class);
    }
    
}
