package GUI;

import APIConnetions.RefreshAuth;
import Models.Artist;
import Services.CompareArtist;
import Services.Searcher;
import spotify.api.spotify.SpotifyApi;
import spotify.models.artists.ArtistFull;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class HomePage{
    private JPanel homePageView;
    private JTextField title;
    private JTextField secondArtist;
    private JTextField firstArtist;
    private JComboBox<String> firstArtistList;
    private JComboBox<String> secondArtistList;
    private JPanel firstArtistInfo;
    private JLabel secondArtistPic;
    private JPanel secondArtistInfo;
    private JLabel firstArtistPic;
    private JLabel firstFollowers;
    private JPanel secondStats;
    private JPanel firstStats;
    private JLabel secondFollowers;
    private JLabel firstPopularity;
    private JLabel secondPopularity;
    private JLabel firstName;
    private JLabel secondName;
    private JLabel secondGenres;
    private JLabel firstGenres;
    private JPanel firstTop3;
    private JLabel first1Song;
    private JLabel first2Song;
    private JLabel first3Song;
    private JLabel first1Stats;
    private JLabel first2Stats;
    private JLabel first3Stats;
    private JLabel firstTopSongs;
    private JLabel firstAlbum;
    private JLabel secondAlbum;
    private JLabel secondTopSongs;
    private JLabel second1Song;
    private JLabel second2Song;
    private JLabel second3Song;
    private JLabel second1Stats;
    private JLabel second2Stats;
    private JLabel second3Stats;
    private JButton compareButton;
    private JButton searchButton1;
    private JButton searchButton2;
    public static SpotifyApi api = RefreshAuth.refreshAuth();
    Searcher searcher = new Searcher(api);
    CompareArtist compareArtist = new CompareArtist(api);
    List<ArtistFull>firstCombo = new ArrayList<>();
    List<ArtistFull>secondCombo = new ArrayList<>();

    public JPanel getHomePageView() {
        return homePageView;
    }

    public HomePage() {
        searchButton1.addActionListener(new SearchButton1Clicked());
        searchButton2.addActionListener(new SearchButton2Clicked());
        compareButton.addActionListener(new CompareButtonClicked());
    }
    private class SearchButton1Clicked implements ActionListener{


        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("First Search Button Pressed");
            firstArtistList.removeAllItems();
            firstCombo = searcher.searchForArtist(firstArtist.getText());
            for (ArtistFull artist : firstCombo) {
                firstArtistList.addItem(artist.getName());
            }
        }
    }
    private class SearchButton2Clicked implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Second Search Button Pressed");
            secondArtistList.removeAllItems();
            secondCombo = searcher.searchForArtist(secondArtist.getText());
            for (ArtistFull artist : secondCombo) {
                secondArtistList.addItem(artist.getName());
            }
        }
    }
    private class CompareButtonClicked implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            wipeForm();
            Artist first = new Artist();
            Artist second = new Artist();
            for (ArtistFull artist: firstCombo){
                if (artist.getName().equals(firstArtistList.getSelectedItem())) {
                    first = compareArtist.getArtistInfo(artist.getId());
                    break;
                }

            }
            for (ArtistFull artist : secondCombo){
                if (artist.getName().equals(secondArtistList.getSelectedItem())) {
                    second = compareArtist.getArtistInfo(artist.getId());
                    break;
                }
            }
            displayArtistPictures(first, second);
            displayArtistStats(first, second);
        }
    }

    private ImageIcon getPicture(String imageUrl) throws IOException {
        URL url = new URL(imageUrl);
        BufferedImage image = ImageIO.read(url);
        System.out.println("Load image into frame...");
        if (image.getHeight() > 640 || image.getWidth() > 640)
            return new ImageIcon("GUI/test.png");
        return new ImageIcon(image);
    }

    private void displayArtistPictures(Artist first, Artist second){
        try {
            firstArtistPic.setIcon(getPicture(first.getImageURL().getUrl()));
            secondArtistPic.setIcon(getPicture(second.getImageURL().getUrl()));
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    private void displayArtistStats(Artist first, Artist second){
        firstName.setText(firstName.getText() + first.getName());
        firstFollowers.setText(firstFollowers.getText() + first.getFollowers());
        firstPopularity.setText(firstPopularity.getText() + first.getPopularity());
        firstGenres.setText(firstGenres.getText() + first.getGenres());
        firstAlbum.setText(firstAlbum.getText() + first.getTopAlbum().getName() + ", POPULARITY: " + first.getTopAlbum().getPopularity());
        first1Stats.setText("<html><body> Name: " + first.getTopSongs().get(0).getName() + "<br> Album: " + first.getTopSongs().get(0).getAlbum() + "<br> Popularity: " + first.getTopSongs().get(0).getPopularity() + "<body><html>");
        first2Stats.setText("<html><body> Name: " + first.getTopSongs().get(1).getName() + "<br> Album: " + first.getTopSongs().get(1).getAlbum() + "<br> Popularity: " + first.getTopSongs().get(1).getPopularity() + "<body><html>");
        first3Stats.setText("<html><body> Name: " + first.getTopSongs().get(2).getName() + "<br> Album: " + first.getTopSongs().get(2).getAlbum() + "<br> Popularity: " + first.getTopSongs().get(2).getPopularity() + "<body><html>");

        secondName.setText(secondName.getText() + second.getName());
        secondFollowers.setText(secondFollowers.getText() + second.getFollowers());
        secondPopularity.setText(secondPopularity.getText() + second.getPopularity());
        secondGenres.setText(secondGenres.getText() + second.getGenres());
        secondAlbum.setText(secondAlbum.getText() + second.getTopAlbum().getName() + ", POPULARITY: " + second.getTopAlbum().getPopularity());
        second1Stats.setText("<html><body> Name: " + second.getTopSongs().get(0).getName() + "<br> Album: " + second.getTopSongs().get(0).getAlbum() + "<br> Popularity: " + second.getTopSongs().get(0).getPopularity() + "<body><html>");
        second2Stats.setText("<html><body> Name: " + second.getTopSongs().get(1).getName() + "<br> Album: " + second.getTopSongs().get(1).getAlbum() + "<br> Popularity: " + second.getTopSongs().get(1).getPopularity() + "<body><html>");
        second3Stats.setText("<html><body> Name: " + second.getTopSongs().get(2).getName() + "<br> Album: " + second.getTopSongs().get(2).getAlbum() + "<br> Popularity: " + second.getTopSongs().get(2).getPopularity() + "<body><html>");
    }

    private void wipeForm(){
        firstArtistPic.setIcon(null);
        firstName.setText("Name: ");
        firstFollowers.setText("Followers: ");
        firstPopularity.setText("Popularity: ");
        firstGenres.setText("Genres: ");
        firstAlbum.setText("Top Album: ");
        firstArtistPic.setIcon(null);
        secondName.setText("Name: ");
        secondFollowers.setText("Followers: ");
        secondPopularity.setText("Popularity: ");
        secondGenres.setText("Genres: ");
        secondAlbum.setText("Top Album: ");
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("HomePage");
        frame.setContentPane(new HomePage().homePageView);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

}
