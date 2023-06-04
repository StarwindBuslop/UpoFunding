/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import servicios.Dao;

/**
 *
 * @author aleja
 */
public class Servlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();

        
        String ruta = "/index.jsp";
        String accion = request.getParameter("accion");
        
        Dao dao = new Dao();
        
        if (accion != null) {

            // AQUI ESTAN LAS DIFERENTES OPCIONES, DEPENDIENDO DEL INPUT SUBMIT PULSADO
            if (accion.equals("Add")) {
                if (request.getParameter("dni") == null) {
                    ruta = "/addCliente.jsp";

                } else {
                    // RECOGO LOS ATRIBUTOS DEL FORMULARIO DE AÑADIR
                    String nombre = request.getParameter("nombre");
                    int edad = Integer.parseInt(request.getParameter("edad"));
                    String direccion = request.getParameter("direccion");
                    int hijos = Integer.parseInt(request.getParameter("hijos"));
                    String telefono = request.getParameter("telefono");
                    // AQUI NO SE PIERDE EL DATO DNI PORQUE AQUI LO ESTAS CREANDO, EN EDITAR LO NECESITAMOS DE  OTRO LADO.
                    String dni = request.getParameter("dni");

                    String fecha = request.getParameter("nacimiento");

                    //Creo un cliente en la base de datos.
                    // Tienes dni, nombre, edad, direccion, hijos, telefono, fecha
                    // Es decir los atributos para hacer un cliente
                    // Pon la llamada al servicio RESTful para crear un cliente
                    //********************************************************
                }

                //OJO!! debe empezar con '/' para indicar que es relativo al contexto actual
            } else if (accion.equals("Eliminar")) {
                if (request.getParameter("operacion") == null && session.getAttribute("dni") == null) {
                    ruta = "/index.jsp";
                } else if (request.getParameter("seguro") == null) {
                    ruta = "/deleteCliente.jsp";
                    session.setAttribute("dni", request.getParameter("operacion"));
                } else if (request.getParameter("seguro").equals("si")) {

                    String dni = (String) session.getAttribute("dni");

                    // Tengo el dni, que es la clave de cliente y lo que permite eliminarlo
                    // Pon la llamada al servicio RESTful para eliminar cliente
                    //***********************************************************************
                    // UNA VEZ ELIMINADO EL CLIENTE LIMPIO LA VARIBALE DE SESSION
                    session.removeAttribute("dni");

                } else if (request.getParameter("seguro").equals("no")) {
                    session.removeAttribute("dni");

                }

            } // SI ELIJO LA OPCION EDITAR
            else if (accion.equals("Actualizar")) {

                // HAY QUE TENER EN CUENTA QUE PARA PODER EDITAR NECESITO HABER SELECCIONADO ALGUN CLIENTE
                // SI NO ME LLEVA DE VUELTA A LA MISMA PAGINA
                if (request.getParameter("operacion") == null && session.getAttribute("dni") == null) {
                    ruta = "/index.jsp";
                } else if (request.getParameter("seguro") == null) {
                    String dni = (String) request.getParameter("operacion");
                    session.setAttribute("dni", dni);
                    Object c = null;

                    // Consulta un cliente para guardarlo en una varible de session
                    // En un objeto que guarda la variable de session se llama c
                    // Pon la llamada al servicio RESTful para consultar un cliente y guardarlo en c como Cliente
                    //***********************************************************************
                    session.setAttribute("cliente", c);
                    ruta = "/updateCliente.jsp";

                } else if (request.getParameter("seguro").equals("si")) {

                    // RECOGO LOS ATRIBUTOS DEL FORMULARIO DE EDITAR
                    String nombre = request.getParameter("nombre");
                    int edad = Integer.parseInt(request.getParameter("edad"));
                    String direccion = request.getParameter("direccion");
                    int hijos = Integer.parseInt(request.getParameter("hijos"));
                    String telefono = request.getParameter("telefono");

                    // ESTA VARIABLE LA COJO POR SESIÓN PORQUE DE UNA PAGINA A OTRA SE PIERDE.
                    String dni = (String) session.getAttribute("dni");

                    // RECOJO LA FECHA
                    String fecha = request.getParameter("nacimiento");

                    //Actualizo un cliente en la base de datos.
                    // Tienes nombre, edad, direccion, hijos, telefono, fecha
                    // Es decir los atributos que podemos editar de un cliente
                    // Pon la llamada al servicio RESTful para editar un cliente
                    //********************************************************
                    // ELIMINO LA VARIBLE DE SESION AL TERMINAR
                    session.removeAttribute("dni");
                    session.removeAttribute("cliente");
                } else if (request.getParameter("seguro").equals("no")) {
                    // ELIMINO LA VARIBLE DE SESION AL TERMINAR
                    session.removeAttribute("dni");
                    session.removeAttribute("cliente");
                }

            }

        }

        // Consulta todos los clientes para guardarlo en una varible de session
        // En un objeto que guarda la variable de session se llama c
        // Pon la llamada al servicio RESTful para consultar todos los clientes 
        // y guardarlo en listas como lista de clientes 
        List lista = new ArrayList();
        //*************************************************
        session.setAttribute("lista", lista);
        // IMPORTANTE, CONEXION ENTRE LA VISTA Y LA CONTROLADORA
        getServletContext().getRequestDispatcher(ruta).forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
