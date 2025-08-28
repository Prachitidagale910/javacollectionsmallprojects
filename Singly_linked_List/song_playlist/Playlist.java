public class Playlist {
    
    private Song Head;
    private Song Tail;
    private int size;

    public Playlist() {
        this.size = 0;
        Head = null;
        Tail = null;
    }

    public void addSong(String name, String artist, double duration) {
        Song song = new Song(name, artist, duration);

        if (Head == null) { 
            Head = song;
            Tail = song;
        } else {
            Tail.next = song;
            Tail = song;
        }
        size++;
        System.out.println("Song \"" + name + "\" added successfully!");
    }

    public void deleteSong(String name) {
        if (Head == null) {
            System.out.println("Playlist is empty! No song to delete.");
            return;
        }

        if (Head.name.equalsIgnoreCase(name)) {
            System.out.println("Deleting first song: " + Head.name);
            Head = Head.next;
            if (Head == null) {
                Tail = null;
            }
            size--;
            return;
        }

        Song prev = Head;
        Song current = Head.next;

        while (current != null && !current.name.equalsIgnoreCase(name)) {
            prev = current;
            current = current.next;
        }

        if (current == null) {
            System.out.println("Song \"" + name + "\" not found in playlist.");
            return;
        }

        if (current == Tail) {
            Tail = prev;
        }

        prev.next = current.next;
        current.next = null;
        size--;
        System.out.println("Song \"" + name + "\" deleted successfully!");
    }

    public Song searchSong(String name) {
        Song temp = Head;
        while (temp != null) {
            if (temp.name.equalsIgnoreCase(name)) {
                System.out.println(".......Song found........");
                System.out.println(temp);
                return temp;
            }
            temp = temp.next;
        }
        System.out.println("Song \"" + name + "\" not found!");
        return null;
    }

    public void displayPlaylist() {
        if (Head == null) {
            System.out.println("Empty Playlist!!!");
            return;
        }

        Song temp = Head;
        int count = 1;

        while (temp != null) {
            System.out.println(count + ": " + temp);
            temp = temp.next;
            count++;
        }
    }

    public void countSongs() {
        if (size > 0) {
            System.out.println("There are total " + size + " songs in the playlist.");
        } else {
            System.out.println("Oops! This playlist is empty.");
        }
    }

    // 1. Reverse the Playlist
    public void reversePlaylist() {
        if (Head == null || Head.next == null) {
            System.out.println("Playlist is too small to reverse!");
            return;
        }

        Song prev = null;
        Song current = Head;
        Song next = null;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        Tail = Head;
        Head = prev;

        System.out.println("Playlist reversed successfully!");
    }

    // 2. Play Next Song (remove from front)
    public void playNextSong() {
        if (Head == null) {
            System.out.println("Playlist is empty! No song to play.");
            return;
        }

        System.out.println("Now playing: " + Head.name);
        Head = Head.next;
        if (Head == null) {
            Tail = null;
        }
        size--;
    }

    // 3. Clear Playlist
    public void clearPlaylist() {
        Head = null;
        Tail = null;
        size = 0;
        System.out.println("Playlist cleared successfully!");
    }

    // Inner class: Song as node
    private class Song {

        private String name;
        private String artist;
        private double duration;
        private Song next;

        public Song(String name, String artist, double duration) {
            this.name = name;
            this.artist = artist;
            this.duration = duration;
            this.next = null;
        }

        @Override
        public String toString() {
            return "\n🎵 Song: " + name +
                   "\n   Artist : " + artist +
                   "\n   Duration: " + duration + " min\n";
        }
    }
}
