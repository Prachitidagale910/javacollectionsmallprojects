import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Playlist playlist = new Playlist();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n==== Song Playlist Menu ====");
            System.out.println("1. Add Song");
            System.out.println("2. Delete Song by Name");
            System.out.println("3. Display Playlist");
            System.out.println("4. Search Song");
            System.out.println("5. Count Songs");
            System.out.println("6. Reverse Playlist");
            System.out.println("7. Play Next Song (Remove from front)");
            System.out.println("8. Clear Playlist");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter song name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter artist name: ");
                    String artist = sc.nextLine();
                    System.out.print("Enter duration (in mins): ");
                    double duration = sc.nextDouble();
                    playlist.addSong(name, artist, duration);
                    System.out.println("Song added!");
                    break;

                case 2:
                    System.out.print("Enter song name to delete: ");
                    String deleteName = sc.nextLine();
                    playlist.deleteSong(deleteName);
                    break;

                case 3:
                    playlist.displayPlaylist();
                    break;

                case 4:
                    System.out.print("Enter song name to search: ");
                    String searchName = sc.nextLine();
                    playlist.searchSong(searchName);
                    break;

                case 5:
                    playlist.countSongs();
                    break;

                case 6:
                    playlist.reversePlaylist();
                    System.out.println("Playlist reversed!");
                    break;

                case 7:
                    playlist.playNextSong();
                    break;

                case 8:
                    playlist.clearPlaylist();
                    System.out.println("Playlist cleared!");
                    break;

                case 0:
                    System.out.println("Exiting... Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }

        } while (choice != 0);

        sc.close();
    }
}
