-- Criação do banco de dados (execute isso fora de um banco específico)
CREATE DATABASE spotifei;

-- Conecte-se ao banco (se estiver usando psql)
-- \c spotifei

-- Tabela de usuários
CREATE TABLE usuarios (
    userid VARCHAR(50) PRIMARY KEY,
    usernome VARCHAR(100) NOT NULL,
    usersenha VARCHAR(100) NOT NULL
);

-- Tabela de artistas
CREATE TABLE artistas (
    artistid SERIAL PRIMARY KEY,
    artistnome VARCHAR(100) NOT NULL
);

-- Tabela de músicas
CREATE TABLE musicas (
    musicid SERIAL PRIMARY KEY,
    musictitulo VARCHAR(100) NOT NULL,
    musicgenero VARCHAR(50),
    artistid INTEGER REFERENCES artistas(artistid)
);

-- Tabela de playlists (sem ligação com usuário)
CREATE TABLE playlists (
    playlistid SERIAL PRIMARY KEY,
    playlistnome VARCHAR(100) NOT NULL
);

-- Relação entre músicas e playlists
CREATE TABLE playlist_musicas (
    playlistid INTEGER REFERENCES playlists(playlistid),
    musicid INTEGER REFERENCES musicas(musicid),
    PRIMARY KEY (playlistid, musicid)
);

-- Tabela de curtidas globais
CREATE TABLE curtidas (
    musicid INTEGER PRIMARY KEY REFERENCES musicas(musicid),
);

-- Tabela de descurtidas globais
CREATE TABLE descurtidas (
    musicid INTEGER PRIMARY KEY REFERENCES musicas(musicid),
);

-- Histórico global das últimas músicas buscadas
CREATE TABLE historico (
    id SERIAL PRIMARY KEY,
    musicid INTEGER REFERENCES musicas(musicid),
);


-- Inserir usuários
INSERT INTO usuarios (userid, usernome, usersenha) VALUES 
('userfei', 'userfei', '123123'),
('userfei01', 'feiano', '123456'),
('userfei005', 'fulano de tal', '000111');

-- Inserir artistas
INSERT INTO artistas (artistnome) VALUES
('Imagine Dragons'),
('Linkin Park'),
('Bon Jovi'),
('Taylor Swift');

-- Inserir músicas
INSERT INTO musicas (musictitulo, musicgenero, artistid) VALUES 
-- Imagine Dragons
('Radioactive', NULL, 1),
('Believer', NULL, 1),
('Demons', NULL, 1),
('Thunder', NULL, 1),
('Whatever It Takes', NULL, 1),
-- Linkin Park
('Numb', NULL, 2),
('In the End', NULL, 2),
('Crawling', NULL, 2),
('One Step Closer', NULL, 2),
-- Bon Jovi
('Livin'' on a Prayer', NULL, 3),
('It''s My Life', NULL, 3),
('You Give Love a Bad Name', NULL, 3),
-- Taylor Swift
('Shake It Off', NULL, 4),
('Blank Space', NULL, 4),
('Love Story', NULL, 4),
('Anti-Hero', NULL, 4);

-- Inserir playlists (agora globais, sem id_usuario)
INSERT INTO playlists (playlistnome) VALUES 
('Motivacao Total'),
('Treino Power'),
('Favoritas'),
('Relaxamento'),
('Rock das Antigas'),
('Pop Atual');

-- Associar músicas às playlists
INSERT INTO playlist_musicas (playlistid, musicid) VALUES 
-- Playlist 1 - Motivação Total
(1, 2), (1, 4), (1, 5), (1, 10),
-- Playlist 2 - Treino Power
(2, 6), (2, 7), (2, 12),
-- Playlist 3 - Favoritas
(3, 1), (3, 2), (3, 11), (3, 14), (3, 16),
-- Playlist 4 - Relaxamento
(4, 3), (4, 13), (4, 15),
-- Playlist 5 - Rock das Antigas
(5, 6), (5, 9), (5, 11), (5, 13),
-- Playlist 6 - Pop Atual
(6, 14), (6, 15), (6, 16);
