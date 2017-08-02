/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import converterInformacao.ConverterData;
import gerenciadores.GerenciadorDeCaronas;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Time;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;


/**
 *
 * @author Reginaldo
 */
public class CadastrarCarona extends HttpServlet {

    private GerenciadorDeCaronas caronaGer = new GerenciadorDeCaronas();
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   
            FileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload upload = new ServletFileUpload(factory);
            ConverterData converter = new ConverterData();
            try {
                String id = request.getParameter("idUsuario");
                int idUsuario = Integer.parseInt(id);
                String origem = request.getParameter("origem");
                String destino = request.getParameter("destino");
                String h = request.getParameter("hora");
                Time hora = Time.valueOf(h);
                String data = request.getParameter("data"); 
                String ajuda = request.getParameter("ajudadecusto");
                float ajudaDeCusto = Float.parseFloat(ajuda);

                caronaGer.adicionarCarona(idUsuario, origem, destino, hora, converter.stringParaDate(data), ajudaDeCusto);
                

            } catch (SQLException ex) {
            Logger.getLogger(CadastrarUsuario.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(CadastrarUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }

   
}
