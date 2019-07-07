create table if not exists Artist(
	artistID 	int 		auto_increment primary key,
    name		varchar(64)	unique not null
);

create table if not exists Genre(
	genreID 		int 		auto_increment primary key,
    description		varchar(64)	unique not null
);

create table if not exists Album(
	albumID 		int 		auto_increment primary key,
    name	varchar(64)	unique not null
);

create table if not exists Song(
	songID 		int 			auto_increment primary key,
    track 		varchar(64),
    title 		varchar(64) 	not null,
    artist 		int 			not null,
    album 		int,
    genre 		int,
    year		varchar(8),
    pathToFile 	varchar(255)	not null
);

create table if not exists User(
	userID 			int 			auto_increment primary key,
    firstname 		varchar(64) 	not null,
    familyname 		varchar(64) 	not null,
    username 		varchar(64) 	unique not null,
    email 			varchar(64) 	unique not null,
    password 		varchar(1024) 	not null
);

create table if not exists Playlist(
	playlistID 			int 			auto_increment primary key,
    name 				varchar(128)	not null,
    creationdate		timestamp 		not null,
    owner 				int 			not null,
    visibility 			varchar(8) 		not null,
    constraint checkVisibility check(visibility in ('true', 'false'))
);

create table if not exists Playback(
	playlist	int,
	song 		int,
    primary key(playlist, song)
);

create table if not exists Subscription(
	subscriber 	int,
    playlist 	int,
    primary key(subscriber, playlist)
);

create table if not exists Favorite(
	user int,
    song int,
    primary key(user, song)
);