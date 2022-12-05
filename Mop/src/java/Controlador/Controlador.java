package Controlador;

import Modelo.PerfilUsuario;
import Modelo.PerfilUsuarioDAO;
import Modelo.Usuario;
import Modelo.UsuarioDAO;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Controlador extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response); 
        UsuarioDAO usuariodao = new UsuarioDAO();
        String accion;
        RequestDispatcher dispatcher = null;
        accion = request.getParameter("accion");
        if(accion == null || accion.isEmpty()){
            dispatcher = request.getRequestDispatcher("inicio.jsp");
            List<Usuario> listausuario = usuariodao.listaUsuario();
            request.setAttribute("lista", listausuario);
        }else if(accion.equals("login")){
            dispatcher = request.getRequestDispatcher("Login/login.jsp");
        }else if(accion.equals("atras")){
            dispatcher = request.getRequestDispatcher("inicio.jsp");
            List<Usuario> listausuario = usuariodao.listaUsuario();
            request.setAttribute("lista", listausuario);
        }else if("registrar".equals(accion)){
            dispatcher = request.getRequestDispatcher("Login/registrar.jsp");
        }else if("guardar".equals(accion)){
            String cargo;
            int id = usuariodao.AutoID();
            int perfilid = Integer.parseInt(request.getParameter("perfilU"));
            String nombre_usuario = request.getParameter("txtusuario");
            String contrasenha1 = request.getParameter("txtcontra");
            String contrasenha2 = request.getParameter("txtcontra2");
            if(contrasenha1.equals(contrasenha2)){
                if (perfilid == 1){
                    cargo = "Administrador";
                }else if (perfilid == 2){
                    cargo = "Bienes";
                }else{
                    cargo = "Prevención de Riesgo";
                }
                Usuario usuario = new Usuario(id, perfilid, nombre_usuario, contrasenha1, perfilid,cargo);
                usuariodao.insertarUsuario(usuario);
                dispatcher = request.getRequestDispatcher("Login/login.jsp"); 
            }else{
                dispatcher = request.getRequestDispatcher("Login/login.jsp");
            }
                
        }
        dispatcher.forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        doGet(request, response);
    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
