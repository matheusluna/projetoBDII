<%@page contentType="text/html" pageEncoding="UTF-8"%>

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
    <div class="navbar-fixed">
      <nav>
        <div class="nav-wrapper indigo darken-4">
          <a href="index.html" data-activates="slide-out" class="button-collapse show-on-large"><i class="material-icons">keyboard_backspace</i></a>
          <a href="index.html" class="brand-logo">Cadastro</a>
        </div>
      </nav>
    </div>
    <div class="container">
      <div class="row">
        <form class="col s12" action="CadastrarUsuario" method="post">
          <div class="row">
            <div class="input-field col s6">
              <input id="email" type="email" class="validate" name="email" required>
              <label for="email">Email</label>
            </div>
            <div class="input-field col s6">
              <input id="password" type="password" class="validate" name="senha" required>
              <label for="password">Password</label>
            </div>

          </div>
          <div class="row">
            <div class="input-field col s12">
              <input id="name" type="text" class="validate" name="nome" required>
              <label for="name">Nome</label>
            </div>
          </div>
          <div class="row">
            <div class="input-field col s6">
              <select name="sexo">
                <option value="masculino">Masculino</option>
                <option value="feminino">Feminino</option>
              </select>
              <label>Sexo</label>
            </div>
            <div class="input-field col s6">
              <input type="date" class="datepicker" name="data">
              <label for="birthdate">Data de nascimento</label>
            </div>
          </div>
          <div class="row">
            <div class="input-field col s6">
              <input id="icon_telephone" type="tel" class="validate" name="telefone">
              <label for="icon_telephone">Telephone</label>
            </div>
          </div>
		  <div class="fixed-action-btn">
        <input type="submit" value="Register" />
		</div>
        </form>
      </div>
      
    </div>
    <script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
    <script type="text/javascript">
      $(document).ready(function() {
        $('select').material_select();
        $('.datepicker').pickadate({
          selectMonths: true, // Creates a dropdown to control month
          selectYears: 15, // Creates a dropdown of 15 years to control year
          monthsFull: ['01', '02', '03', '04', '05', '06', '07', '08', '09', '10', '11', '12'],
          monthsShort: ['Jan', 'Fev', 'Mar', 'Abr', 'Mai', 'Jun', 'Jul', 'Ago', 'Set', 'Out', 'Nov', 'Dez'],
          weekdaysFull: ['Domingo', 'Segunda', 'Terça', 'Quarta', 'Quinta', 'Sexta', 'Sabádo'],
          weekdaysShort: ['Dom', 'Seg', 'Ter', 'Qua', 'Qui', 'Sex', 'Sab'],
          today: 'Hoje',
          clear: 'Limpar',
          close: 'Pronto',
          labelMonthNext: 'Próximo mês',
          labelMonthPrev: 'Mês anterior',
          labelMonthSelect: 'Selecione um mês',
          labelYearSelect: 'Selecione um ano',
          format: 'dd/mm/yyyy'
        });
      });
    </script>
    <script type="text/javascript" src="materialize/js/materialize.min.js"></script>
  </body>
</html>


