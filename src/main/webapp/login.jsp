<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib tagdir="/WEB-INF/tags/" prefix="tag"%>

<!DOCTYPE html>
<html>
  <head>
    <!--Import Google Icon Font-->
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <!--Import materialize.css-->
    <link type="text/css" rel="stylesheet" href="css/materialize.min.css"  media="screen,projection"/>

    <!--Let browser know website is optimized for mobile-->
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
  </head>

  <body class="indigo lighten-5">
    <!--Import jQuery before materialize.js-->
    <br>
    <div class="container">
      <div class="container">
        <div class="container">
          <div class="container">
            <div class="row center-align">
                <img src="img/logo1.png" alt="" height="150px">
                <h4 class="indigo-text text-lighten-2"><tag:statusUsuarioSenha/></h4>
            </div>
            <div class="row">
              <form class="col s12" action="Login" method="post">
                <div class="row">
                  <div class="input-field col s12">
                    <input name="email" id="email" type="email" class="validate">
                    <label for="email">Email</label>
                  </div>
                </div>
                <div class="row">
                  <div class="input-field col s12">
                    <input name="password" id="password" type="password" class="validate">
                    <label for="password">Password</label>
                  </div>
                </div>
                <p>Não possui conta? <a href="register.jsp">clique aqui!</a></p>
                <div class="row center-align">
                    <input class="waves-effect waves-light btn indigo darken-4" type="submit" value="Login" />

                </div>
              </form>
            </div>
          </div>
        </div>
      </div>
    </div>
    <script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
    <script type="text/javascript" src="materialize/js/materialize.min.js"></script>
  </body>
</html>
<!--
<html lang="pt-br">
    <body>
        <div class="wrapper">
            <h1><center>Caronas</center></h1>
            <h2><center>Ofereça ou encontre caronas pra qualquer lugar</center></h2>
            <div class="content">
                <div id="form_wrapper" class="form_wrapper">
                    <form class="register" class="form_wrapper" role="form" action="CadastrarUsuario" method="post">
                        <h3>Cadastrar</h3>
                        <div class="column">
                            <div>
                                    <label>Email:</label>
                                    <input type="text" name="email" class="form_wrapper" id="nome" placeholder = "e-mail" required/>
                            </div>
                            <div>
                                    <label>Nascimento:</label>
                                    <input type="text" name="data" class="form_wrapper" id="nome" placeholder = "data de nascimento" required/>
                            </div>
                            <div>
                                    <label>Sexo</label>
                                    <input type="text" name="sexo" class="form_wrapper" id="nome" placeholder = "sexo" required />
                            </div>
                            <br>
                        </div>
                        
                        <div class="column">
                            <div>
                                <label>Nome:</label>
                                <input type="text" name="nome" class="form_wrapper" id="nome" placeholder = "nome" required/>
                            </div>

                            <div>
                                <label>Password:</label>
                                <input type="password" name="senha" class="form_wrapper" id="nome" placeholder = "senha" required/>
                            </div>
                            <div>
                                <label>Telefone:</label>
                                <input type="text" name="telefone" class="form_wrapper" id="nome" placeholder = "telefone" required/>
                            </div>
                        </div>
                        <div class="bottom">
                                <a href="login.jsp" rel="login" class="linkform">Você já tem uma conta? Entre aqui</a>
                                <input type="submit" value="Registrar" />
                                <div class="clear"></div>
                        </div>
                    </form>
            <div class="clear"></div>
                </div>
                <div id="form_wrapper" class="form_wrapper">
                <form class="login active" class="form_wrapper" role="form" action="Login" method="post">
                    <h3>Login</h3>
                    <div>
                        <label>Username:</label>
                        <input type="text" name="nome" type = "text"  class="form_wrapper" id="nome" placeholder = "nome" required/>
                    </div>
                    <div>
                        <label>Password: <a href="register.jsp" rel="forgot_password" class="forgot linkform">Cadastrar</a></label>
                        <input type="password" name="senha" type = "text"  class="form-control" id="senha" placeholder = "senha" required/>
                    </div>
                    <div class="bottom">
                        <input type="submit" value="Login" />
                            <div class="clear"></div>
                    </div>
                </form>
                                
                        <div class="clear"></div>
            </div>
            </div>
        </div>
		
    </body>
-->
</html>
