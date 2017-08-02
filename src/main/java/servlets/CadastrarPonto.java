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
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Reginaldo
 */
public class CadastrarPonto extends HttpServlet {

    private GerenciadorDeCaronas caronaGer = new GerenciadorDeCaronas();
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   
        try {

            int idCarona = Integer.parseInt(request.getParameter("idCarona"));
            String ponto = request.getParameter("ponto");
            
            caronaGer.adicionarPonto(idCarona, ponto);


        } catch (SQLException ex) {
            Logger.getLogger(CadastrarUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        request.getRequestDispatcher("p.jsp").forward(request, response);
    }


}
