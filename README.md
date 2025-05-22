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

# Execução
Para rodar o projeto:

Configure um banco PostgreSQL local com o arquivo SQQL forncecido (Spotifei_Completo.SQL).

Importe o projeto no NetBeans.

Compile e execute via IDE ou utilize o arquivo .jar gerado na pasta dist/.

# Conclusão
O projeto Spotifei foi desenvolvido com o foco na organização em camadas, uso efetivo do banco de dados relacional, e uma interface amigável que cobre todas as funcionalidades requeridas pelo escopo da disciplina. Ele atende tanto ao usuário comum quanto ao administrador, promovendo uma experiência completa de gerenciamento de dados musicais.

# Notas
- Esse porjeto foi um pesadelo para realizar sozinho e me arrependo de nao ter feito em dupla. O trabalho extra qre teria com as funcoes do administrador nao sao nada comparados ao que sofri fazendo este projeto.
- Devido a alguma besteira que eu fiz acabei por perder meu projeto poucos dias antes da entrega. (Se eu tivesse feitu um backup no github....) Este projeto que esta sendo entregue esta um pouco diferente do que tinha feito originalmente devido a minha preca na horaa de finalizalo a tempo. Tenho somente a mim e minha idiotice para culpar.
