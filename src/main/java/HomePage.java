import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomePage{
    private JPanel homePageView;
    private JTextField Title;
    private JTextField SecondArtist;
    private JTextField FirstArtist;
    private JComboBox FirstArtistList;
    private JComboBox SecondArtistList;
    private JPanel FirstArtistInfo;
    private JLabel SecondArtistPic;
    private JPanel SecondArtistInfo;
    private JLabel FirstArtistPic;
    private JLabel FirstFollowers;
    private JPanel SecondStats;
    private JPanel FirstStats;
    private JLabel SecondFollowers;
    private JLabel FirstPopularity;
    private JLabel SecondPopularity;
    private JLabel FirstName;
    private JLabel SecondName;
    private JLabel SecondGenres;
    private JLabel FirstGenres;
    private JPanel FirstTop3;
    private JLabel First1Song;
    private JLabel First2Song;
    private JLabel First3Song;
    private JLabel First1Stats;
    private JLabel First2Stats;
    private JLabel First3Stats;
    private JLabel FirstTopSongs;
    private JLabel FirstAlbum;
    private JLabel SecondAlbum;
    private JLabel SecondTopSongs;
    private JLabel Second1Song;
    private JLabel Second2Song;
    private JLabel Second3Song;
    private JLabel Second1Stats;
    private JLabel Second2Stats;
    private JLabel Second3Stats;
    private JButton compareButton;
    private JButton searchButton1;
    private JButton searchButton2;

    private class CompareButtonClicked implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("HomePage");
        frame.setContentPane(new HomePage().homePageView);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

}
