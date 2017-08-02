<%-- 
    Document   : principal
    Created on : 19/07/2017, 06:08:32
    Author     : Reginaldo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib tagdir="/WEB-INF/tags/" prefix="tag"%>

<!DOCTYPE html>
<html>
  <head>
    <!--Import Google Icon Font-->
      <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
      <!--Import materialize.css-->
      <link type="text/css" rel="stylesheet" href="materialize/css/materialize.min.css"  media="screen,projection"/>

      <!--Let browser know website is optimized for mobile-->
      <meta name="viewport" content="width=device-width, initial-scale=1.0"/><!--Import Google Icon Font-->
      <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
      <!--Import materialize.css-->
      <link type="text/css" rel="stylesheet" href="materialize/css/materialize.min.css"  media="screen,projection"/>

      <!--Let browser know website is optimized for mobile-->
      <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <meta charset="utf-8">
    <title>Vai pra onde?</title>
    <style>
      html, body {
        height: 100%;
        margin: 0;
        padding: 0;
      }
      #map {
        height: 90%;
        width: 100%;
      }

    </style>
  </head>
  <body>


    <div id="modal1" class="modal">
      <form class="" action="CadastrarCarona" method="post" onsubmit="return valida_form(this)">
        <div class="modal-content">
          <h4>Rota</h4>
          <div class="row">
                
                   <input name="idUsuario" value= ${sessaoId}>
                  
            <p><b>Origem:</b></p>
            <input id="origem" name="origem" value="">
          </div>
          <div class="row">
            <p><b>Pontos Intermediários:</b></p>
            <div id="pontos"></div>
          </div>
          <div class="row">
            <p><b>Destino:</b></p>
            <input id="destino" name="destino">
          </div>
          <div class="row">
            <p><b>Distância:</b></p>
            <input id="distancia" name="distancia"></p>
          </div>
          <div class="row">
            <p><b>Hora de saída:</b></p>
            <input id="horasaida" name="hora">
          </div>
          <div class="row">
            <p><b>Tempo de viagem:</b></p>
            <p id="tempo" name="tempo"></p>
          </div>
          <div class="row">
            <p><b>Data de saída:</b></p>
            <input id="datasaida" name="data">
          </div>
          <div class="row">
            <p><b>Ajuda de custo:</b></p>
            <input id="custo" name="custo">
          </div>
        </div>
        <div class="modal-footer">
          <input class="modal-action modal-close waves-effect waves-green btn-flat" type="submit" name="" value="Salvar">
        </div>
      </form>
    </div>











    <ul id="slide-out" class="side-nav">
      <li><a href="#" data-activates="slide-out2" class="button-collapse2 show-on-large">Cadastrar carona</a></li>
      <li><a href="#" data-activates="slide-out3" class="button-collapse3 show-on-large">Pedir carona</a></li>
    </ul>


    <ul id="slide-out2" class="side-nav">
      <div class="col s12">
        <div class="row">
          <div class="input-field col s12">
            <input id="start" type="text" name="origem">
            <label for="start">Origem</label>
          </div>
          <div class="input-field col s12">
            <input id="waypoints" type="text" name="alternativo">
            <label for="waypoints">Ponto Alternativos</label>
            <input class="btn" type="button" id="btEnvio" value="Salvar">
          </div>
          <div class="input-field col s12">
            <input id="end" type="text" name="destino">
            <label for="end">Destino</label>
          </div>
          <div class="input-field col s6">
             <input id="calendario" type="text" class="datepicker" name="calendario">
             <label for="calendario">Data da viagem</label>
          </div>
          <div class="input-field col s6">
            <input id="hora" type="text" class="timepicker" name="hora">
            <label for="hora">Horário de partida</label>
          </div>
          <div class="input-field col s12">
            <input id="ajuda" type="text" name="ajuda">
            <label for="ajuda">Ajuda de custo</label>
          </div>
          <div class="input-field col s12">
            <input data-target="modal1" class="btn" type="submit" id="submit" name="submit" value="Visualizar">
          </div>

        </div>

      </div>
    </ul>

    <ul id="slide-out3" class="side-nav">
      <div class="row">
        <form class="" action="index.html" method="post">
          <div class="row">
            <div class="input-field col s12">
              <input id="origem" type="text" name="origem" value="">
              <label for="origem">Origem</label>
            </div>
          </div>
          <div class="row">
            <div class="input-field col s12">
              <input id="destino" type="text" name="destino" value="">
              <label for="destino">Destino</label>
            </div>
          </div>
          <div class="row">
            <div class="input-field col s12">
              <input class="btn" type="submit" name="" value="Pesquisar">
            </div>
          </div>
        </form>
      </div>
    </ul>


    <nav>
      <div class="nav-wrapper indigo darken-4">
        <a href="#" data-activates="slide-out" class="button-collapse show-on-large"><i class="material-icons">menu</i></a>
        <a href="#" class="brand-logo">Vai pra onde? <tag:usuarioLogado/></a>
      </div>
    </nav>
    <div id="map"></div>

    <script src="js/map.js"></script>
    <script async defer
    src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAuSd81wSdpuOefFfjLlmb8bKZULEd1OwY&callback=initMap">
    </script>
    <!--Import jQuery before materialize.js-->
    <script type="text/javascript" src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
    <script type="text/javascript" src="materialize/js/materialize.min.js"></script>
    <script type="text/javascript" src="materialize/js/plugin.js"></script>
  </body>
</html>
