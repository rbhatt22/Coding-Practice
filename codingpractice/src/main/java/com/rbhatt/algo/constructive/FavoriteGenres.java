package com.rbhatt.algo.constructive;

import java.util.*;

/**
 * Created by rbhatt22 on 1/2/20.
 * Given a map Map<String, List<String>> userSongs with user names as keys and a list of all the songs that the user has listened to as values.

 Also given a map Map<String, List<String>> songGenres, with song genre as keys and a list of all the songs within that genre as values. The song can only belong to only one genre.

 The task is to return a map Map<String, List<String>>, where the key is a user name and the value is a list of the user's favorite genre(s). Favorite genre is the most listened to genre. A user can have more than one favorite genre if he/she has listened to the same number of songs per each of the genres.

 userSongs = {
 "David": ["song1", "song2", "song3", "song4", "song8"],
 "Emma":  ["song5", "song6", "song7"]
 },
 songGenres = {
 "Rock":    ["song1", "song3"],
 "Dubstep": ["song7"],
 "Techno":  ["song2", "song4"],
 "Pop":     ["song5", "song6"],
 "Jazz":    ["song8", "song9"]
 }

 Output: {
 "David": ["Rock", "Techno"],
 "Emma":  ["Pop"]
 }

 */
public class FavoriteGenres {

    public  Map<String, List<String>> findFavoriteGenres(Map<String, List<String>> userSongs, Map<String, List<String>> songGenres) {
        Map<String, List<String>> favGenres = new HashMap<>();

        for (Map.Entry<String, List<String>> entry : userSongs.entrySet()) {
            String user = entry.getKey();
            List<String> songs = entry.getValue();
            Map<String, Integer> userGenres = new HashMap<>();

            for (String song : songs) {
                String genres = getGenres(song, songGenres);
                if (userGenres.containsKey(genres)) {
                    int genresCount = userGenres.get(genres);
                    userGenres.put(genres, genresCount + 1);
                } else {
                    userGenres.put(genres, 1);
                }
            }

            List<String> genresList = getFavGenres(userGenres);

            favGenres.put(user, genresList);
        }

        return favGenres;
    }

    public String getGenres(String song, Map<String, List<String>> songGenres) {
        String genres = null;

        for (Map.Entry<String, List<String>> entry : songGenres.entrySet()) {
            if (entry.getValue().contains(song)) {
                genres = entry.getKey();
            }
        }

        return genres;
    }

    public List<String> getFavGenres(Map<String, Integer> userGenres) {
        List<String> favGenres = new ArrayList<>();

        int maxCount = Collections.max(userGenres.values());

        for (Map.Entry<String, Integer> entry : userGenres.entrySet()) {
            if (entry.getValue() == maxCount) {
                favGenres.add(entry.getKey());
            }
        }

        return favGenres;
    }

    public static void main(String[] args) {

        FavoriteGenres ob = new FavoriteGenres();

        Map<String, List<String>> userSongs = new HashMap<>();
        List<String> davidSongs = new ArrayList<>();
        davidSongs.add("song1");
        davidSongs.add("song2");
        davidSongs.add("song3");
        davidSongs.add("song4");
        davidSongs.add("song8");
        userSongs.put("David", davidSongs);
        List<String> emmaSongs = new ArrayList<>();
        emmaSongs.add("song5");
        emmaSongs.add("song6");
        emmaSongs.add("song7");
        userSongs.put("Emma", emmaSongs);

        Map<String, List<String>> songGenres = new HashMap<>();
        List<String> rockSongs = new ArrayList<>();
        rockSongs.add("song1");
        rockSongs.add("song3");
        List<String> dubstep = new ArrayList<>();
        dubstep.add("song7");
        List<String> techno = new ArrayList<>();
        techno.add("song2");
        techno.add("song4");
        List<String> pop = new ArrayList<>();
        pop.add("song5");
        pop.add("song6");
        List<String> jazz = new ArrayList<>();
        jazz.add("song8");
        jazz.add("song9");
        songGenres.put("rock",rockSongs);
        songGenres.put("dubstep",dubstep);
        songGenres.put("techno",techno);
        songGenres.put("pop",pop);
        songGenres.put("jazz",jazz);

        System.out.println(ob.findFavoriteGenres(userSongs, songGenres));

        Map<String, List<String>> userSongs2 = new HashMap<>();
        List<String> davidSongs2 = new ArrayList<>();
        davidSongs.add("song1");
        davidSongs.add("song2");
        userSongs.put("David", davidSongs2);
        List<String> emmaSongs2 = new ArrayList<>();
        emmaSongs.add("song3");
        emmaSongs.add("song4");
        userSongs2.put("Emma", emmaSongs2);
        Map<String, List<String>> songGenres2 = new HashMap<>();

        System.out.println(ob.findFavoriteGenres(userSongs2, songGenres2));
    }

}
