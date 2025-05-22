# Projeto_SpotiFei
Projeto da Disciplina CCM310

# Desenvolvedor
Nome: Rodrigo INoue Castanho

# Objetivo do Projeto
O projeto Spotifei visa desenvolver uma aplicação desktop com interface gráfica inspirada na plataforma Spotify, voltada para o compartilhamento de informações sobre músicas e podcasts, sem a necessidade de reprodução de áudio. O foco está em funcionalidades como cadastro de usuários, playlists e estatísticas.

# Tecnologias Utilizadas
Java (Swing) – para construção da interface gráfica (GUI)

JDBC com PostgreSQL – para persistência e gerenciamento de dados

Padrão de Projeto MVC – separação das camadas da aplicação

IDE utilizada: NetBeans

# Estrutura do Projeto
 - controller: Lógica de controle das ações do usuário (ex: ControllerCadastro, ControllerLogin)

- model: Contém as classes que representam as entidades principais como Usuarios, Musicas, Playlists

- DAO: Camada de acesso ao banco de dados (ex: UsuariosDAO, MusicasDAO)

- view: Interfaces gráficas em Swing para interação com o usuário

- main: Classe Spotiifei.java que inicia o sistema

# Funcionalidades Implementadas – Usuário
- Cadastro de novos usuários

- Login seguro por ID e senha

- Busca de músicas por nome, artista ou gênero

- Visualização de detalhes das músicas

- Curtir ou descurtir músicas

- Gerenciamento de playlists (criação, edição, exclusão)

- Histórico de interações:

- Últimas 10 músicas buscadas

- Músicas curtidas e descurtidas

# Funcionalidades Implementadas – Administrador
- Nenhuma

#  Banco de Dados
O sistema utiliza PostgreSQL para garantir persistência total dos dados. Todos os dados inseridos são armazenados em tabelas normalizadas, acessadas via DAOs específicos. O sistema se conecta através da classe Conexao.

# Interface Gráfica (GUI)
A interface é construída em Java Swing, com janelas específicas para cada funcionalidade, como login, cadastro, busca de músicas, gerenciamento de playlists e painel administrativo.
