alter table Song
	add constraint Song_Artist foreign key(artist) references Artist(artistID),
    add constraint Song_Album foreign key(album) references Album(albumID),
    add constraint Song_Genre foreign key(genre) references Genre(genreID);

alter table Playlist
	add constraint Playlist_User foreign key(owner) references User(userID);

alter table Playback
	add constraint Playback_Playlist foreign key(playlist) references Playlist(playlistID),
    add constraint Playback_Song foreign key(song) references Song(songID);
    
alter table Subscription
	add constraint Subscription_Subscriber foreign key(subscriber) references User(userID),
    add constraint Subscription_Playlist foreign key(playlist) references Playlist(playlistID);
    
alter table Favorite
	add constraint Favorite_User foreign key(user) references User(userID),
    add constraint Favorite_Song foreign key(song) references Song(songID);