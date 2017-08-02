/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import gerenciadores.GerenciadorDeCaronas;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Reginaldo
 */
public class ListarCaronas extends HttpServlet {

   private GerenciadorDeCaronas caronasGer = new GerenciadorDeCaronas();

    public void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
//        UsuarioDao dao = new UsuarioDao();
       request.setCharacterEncoding("UTF-8");
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("/listarUsuarios.jsp");
        List lista = new ArrayList();
         try {
             lista = caronasGer.listarCaronas();
         } catch (SQLException ex) {
             Logger.getLogger(ListarCaronas.class.getName()).log(Level.SEVERE, null, ex);
         }
        request.setAttribute("usuarios", lista);

        dispatcher.forward(request, response);

    }
}
