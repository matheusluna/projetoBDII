package servlets;

import converterInformacao.ConverterData;
import gerenciadores.GerenciadorDeUsuario;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;




/**
 *
 * @author Reginaldo
 */
    
public class CadastrarUsuario extends HttpServlet {

    private GerenciadorDeUsuario usuarioGer = new GerenciadorDeUsuario();
    ConverterData converter = new ConverterData();
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
            FileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload upload = new ServletFileUpload(factory);

            try {
  
                String nome = request.getParameter("nome");
                String email = request.getParameter("email");
                String senha = request.getParameter("senha");
                String sexo = request.getParameter("sexo");
                String telefone = request.getParameter("telefone");
                String dataNascimento = request.getParameter("data");               
//                Usuario user = new Usuario();
//                user = usuarioGer.pesquisarUsuarioEmail(email);
//                if(user.getEmail() != null){
//                    request.setAttribute("mensagem", "Email já cadastrado!");
//                    request.getRequestDispatcher("cadastrarUsuario.jsp").forward(request, response);
//                }else{
                    usuarioGer.adicionarUsuario(nome, email, converter.stringParaDate(dataNascimento), senha, sexo, telefone);
//                }
                

            } catch (SQLException ex) {
            Logger.getLogger(CadastrarUsuario.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(CadastrarUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }

}
