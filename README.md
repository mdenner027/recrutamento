<h1>Task Manager</h1>
<h2>Sobre o Projeto</h2>
<p>O Task Manager trata-se de um sistema desenvolvido como forma de atividade avaliativa da Esig Group.</p>
<h2> O que foi feito no projeto</h2>
<p>Com base no que foi solicitado para a realização da atividade técnica, foram implementados os seguintes itens:</p>
<ul>
   <li> a) Desenvolver o backend utilizando Java 11 e Spring Boot</li>
   <li> b) Utilizar persistência em um banco de dados PostgreSQL e persistência JPA</li>
   <li> c) Os endpoints devem ser em REST</li>
   <li> d) A aplicação deverá ter um controle de login por usuário e senha e os endpoints devem autenticar através de token JWT.</li>
   <li> 
      e) Catalogar as chamadas dos endpoints no VS Code REST Client( https://marketplace.visualstudio.com/items?itemName=humao.rest-client )
      ou no Postman (ver em <a href="#testar">Como Testar o Projeto</a>)
   </li>
</ul>
<p>Além disso, de forma a complementar a atividade, no presente projeto também foi implementado os seguintes itens opcionais:</p>
<ul>
   <li> g) Publicar projeto no heroku ou outro ambiente cloud.</li>
   <li> i) Documentar a API usando o Swagger (https://swagger.io).</li>
   <li> j) outros diferenciais que julgar conveniente, como fazer um front-end em qualquer tecnologia (Angular seria um diferencial). </i>
</ul>
<h2>Versões do Projeto</h2>
<p>O projeto conta com duas versões independentes, sendo elas</p>
<ul>
   <li>
      Versão com autenticação por meio de JWT.
      <ul>
         <li>Essa é a versão padrão do projeto que foi requisitado na avaliação técnica e, por tal motivo, utiliza JWT para autenticação. </li>
         <li>Esta versão do projeto pode ser acessada no linke <a href="https://recrutamento-manager-com-jwt.herokuapp.com/" target="_blank">https://recrutamento-manager-com-jwt.herokuapp.com/</a>.
         </li>
         <li>Além disso, sua documentação pode ser encontrada em <a href="https://recrutamento-manager-com-jwt.herokuapp.com/swagger-ui.html" target="blank">Documentação com Swagger</a>. Na interface da documentação, também é possível testar os endpoints da aplicação.
         </li>
      </ul>
   </li>
   <li>
      Versão sem autenticação.
      <ul>
         <li>
            Nessa versão do projeto o processo de autenticação de autorização foi desabilitado, de forma a facilitar o acesso do site criado.
         </li>
         <li>
            O site que dá suporte a esta versão foi desenvolvido utilizando o Angular e pode ser acessado no link <a href="https://603edd851ecd1f0007a37a3d--optimistic-hermann-e8672e.netlify.app" target="new">Task Manager</a>.
         </li>
      </ul>
   </li>
</ul>
<h2 id="testar">Como Testar o Projeto</h2>
<p>Para acessar a aplicação e testá-la, algumas formas são:</p>
<ol>
   <li>
      Você pode testar a aplicação utilizando o Postman, usando como base a documentação disponibilizada (<a href="https://recrutamento-manager-com-jwt.herokuapp.com/swagger-ui.html" target="blank">Documentação com Swagger</a>).
      Na documentação, está presente os endpoints e o que é necessário para acessar cada um deles, como exemplo dos objetos requisitados, parâmetros e etc. <br/>
      OBS.: é necessário criar um novo usuário para realizar o login. Além disso, ao acessar o endpoint de login, caso suas credenciais forem validadas, você receberá o token JWT. Para autenticar o acesso aos demais endpoints, é necessário que você informe o token na aba de autorizações da requisição do Postman e informar que está sendo utilizado o tipo "Bearer Token".
   </li>
   <br/>
   <li>
      A segunda forma de teste é utilizar a própria interface do Swagger UI que é provida pela documentação (<a href="https://recrutamento-manager-com-jwt.herokuapp.com/swagger-ui.html" target="blank">Documentação com Swagger</a>) como forma de testar a aplicação. Na documentação, é possível testar todos os endpoints e visualizar detalhes dos objetos, parâmetros e os exemplos de possíveis respostas para cada uma das requisições.
      OBS.: é necessário criar um novo usuário para realizar o login. Além disso, após o processo de login, é necessário informar o token recebido na opção "Authorize" antecedido da palavra Bearer (ex.: Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJtYXgiLCJleHAiOjE2 ...).
   </li>
   <br/>
   <li>
      A última forma para realização dos testes é por meio do site criado <a href="https://603edd851ecd1f0007a37a3d--optimistic-hermann-e8672e.netlify.app" target="_blank">Task Manager</a>. No site, é possível realizar a maioria das operações, à exceção dos processo de autenticação e autorização.<br/>
      Assim, as operações que podem ser realizadas no site são:
      <ul>
         <li>
            Cadastrar, listar, remover e atualizar registros de responsáveis (CRUD da entidade "responsável");
         </li>
         <li>
            Cadastrar, listar, remover e atualizar registros de tarefas (CRUD da entidade "tarefa");
         </li>
         <li>
            Filtrar tarefas cadastradas com base em parâmetros;
         </li>
         <li>
            Marcar tarefas como concluídas.
         </li>
      </ul>
   </li>
</ol>
