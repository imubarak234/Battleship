import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Graphics;
import javax.imageio.ImageIO;
import java.util.*;
import java.io.*;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
//import java.applet.Applet;
/**
 * Write a description of class GameGUI here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameGUI 
{
    private SWAT game = new Admiral("Ibrahim");
    private JFrame myFrame = new JFrame("Star-Ship"); 

    Container contentPane = myFrame.getContentPane();
    
    

    JLabel westPanel = new JLabel(new ImageIcon("images.jpeg"));
    JPanel southPanel = new JPanel();

    private JTextArea list = new JTextArea();
    private JScrollPane pane = new JScrollPane(list);

    private JButton fightButton = new JButton("Fight");
    private JButton viewButton = new JButton("View state of game");
    private JButton quitButton = new JButton("quit");
    private JButton clearButton = new JButton("Clear");
    private JButton newGame = new JButton("New Game");
    private JButton loadGame = new JButton("Load game");
    private JButton hardButton = new JButton("Hard");
    private JButton mediumButton = new JButton("Medium");
    private JButton easyButton = new JButton("Easy");
    public GameGUI()
    {
        //back = getImage(getCodeBase(), "850_6498.jpg");
        myFrame.setSize(1000, 1000);
        //myFrame.setIconImage(back);
        makeMenuBar();
        //sound();
        contentPane.setLayout(new BorderLayout());
        
        
        contentPane.add(westPanel, BorderLayout.WEST);
        contentPane.add(pane, BorderLayout.CENTER);
        contentPane.add(southPanel, BorderLayout.SOUTH);
        southPanel.setLayout(new BorderLayout());
        southPanel.add(clearButton, BorderLayout.CENTER);
             
        //JLabel background = new JLabel(new ImageIcon("850_6498.jpg"));
        //contentPane.add(background);
        //background.setLayout(new FlowLayout());
        pane.setVisible(false);
        clearButton.setVisible(false);

        westPanel.setLayout(new FlowLayout());
        westPanel.add(fightButton);
        westPanel.add(viewButton);
        westPanel.add(newGame);
        westPanel.add(loadGame);
        westPanel.add(quitButton);
        westPanel.add(hardButton);
        westPanel.add(mediumButton);
        westPanel.add(easyButton);
        fightButton.setVisible(false);
        viewButton.setVisible(false);
        westPanel.setVisible(true);
        hardButton.setVisible(false);
        mediumButton.setVisible(false);
        easyButton.setVisible(false);
        newGame.setVisible(true);
        loadGame.setVisible(true);

        myFrame.pack();
        myFrame.setVisible(true);
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        clearButton.addActionListener(new clearHandler());
        fightButton.addActionListener(new fightHandler());
        viewButton.addActionListener(new viewHandler());
        quitButton.addActionListener(new quitHandler());
        newGame.addActionListener(new newHandler());
        hardButton.addActionListener(new hardHandler());
        mediumButton.addActionListener(new mediumHandler());
        easyButton.addActionListener(new easyHandler());
        loadGame.addActionListener(new loadHandler());
        // try 
        // {
            // contentPane.add(new JLabel(new ImageIcon(ImageIO.read(new File("850_6498.jpg")))), BorderLayout.EAST);
        // } catch (IOException e) {e.printStackTrace();}

    }

    private void makeMenuBar()
    {
        JMenuBar menubar = new JMenuBar();
        //JMenuBar nextbar = new JMenuBar();
        myFrame.setJMenuBar(menubar);
       // myFrame.setJMenuBar(nextbar);

        JMenu forceMenu = new JMenu("Forces");
        menubar.add(forceMenu);
        JMenu fightMenu = new JMenu("Fights");
        menubar.add(fightMenu);
        JMenu instMenu = new JMenu("Instructions");
        menubar.add(instMenu);


        JMenuItem ASFItem = new JMenuItem("List ASFleet");
        forceMenu.add(ASFItem);
        ASFItem.addActionListener(new ASFHandler());

        JMenuItem listItem = new JMenuItem("List Admirals Forces");
        forceMenu.add(listItem);
        listItem.addActionListener(new admiralHandler());

        JMenuItem activeItem = new JMenuItem("Activate Force");
        forceMenu.add(activeItem);
        activeItem.addActionListener(new activateHandler());

        JMenuItem recallItem = new JMenuItem("Recall Force");
        forceMenu.add(recallItem);
        recallItem.addActionListener(new recallHandler());
        
        JMenuItem listFight = new JMenuItem("List Fights");
        fightMenu.add(listFight);
        listFight.addActionListener(new listFightHandler());
        
        JMenuItem highs = new JMenuItem("HighScores");
        fightMenu.add(highs);
        highs.addActionListener(new highScoreHandler());
        
        JMenuItem resting = new JMenuItem("Resting Fleet");
        fightMenu.add(resting);
        resting.addActionListener(new restingFleetHandler());
        
        JMenuItem instrc = new JMenuItem("Instruction");
        instMenu.add(instrc);
        instrc.addActionListener(new instructionHandler());


    }
    
    private void sound()
    {
        try 
        {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(this.getClass().getResource("audio/spacemusic.au"));
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
            clip.loop(Clip.LOOP_CONTINUOUSLY);
            
        } catch (Exception ex) {ex.printStackTrace();}
    }
    private class ASFHandler implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            pane.setVisible(true);
            clearButton.setVisible(true);
            list.setText(game.getASFleet());
        }
    }

    private class admiralHandler implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            pane.setVisible(true);
            clearButton.setVisible(true);
            list.setText(game.getFightingFleet());
        }
    }

    private class activateHandler implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            String fRef = JOptionPane.showInputDialog(null, "Enter reference Number : ");
            JOptionPane.showMessageDialog(null, game.activateForce(fRef));
        }
    }

    private class recallHandler implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            String st = JOptionPane.showInputDialog(null, "Enter reference Number : ");
            game.recallForce(st);
        }
    }

    private class clearHandler implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            list.setText("");
        }
    }

    private class fightHandler implements ActionListener
    {
        public void actionPerformed(ActionEvent e) 
        {
            pane.setVisible(true);
            clearButton.setVisible(true);
            String mmg= JOptionPane.showInputDialog(null, "Enter Fight Number : ");
            int number = Integer.parseInt(mmg);
            list.setText(game.canFight(number));
            String what = JOptionPane.showInputDialog(null,"Enter the reference of the force u want to fight with: ");
            list.setText(game.fight(number,what));

        }

    }
    
    private class listFightHandler implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            pane.setVisible(true);
            clearButton.setVisible(true);

            list.setText(game.getAllFights());
        }
    }
    
    private class viewHandler implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            list.setText(game.toString());
        }
    }
    
    private class quitHandler implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            System.exit(0);
        }
    }
    
    private class newHandler implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            String mmg= JOptionPane.showInputDialog(null, "Enter your name : ");
            game.setName(mmg);
            newGame.setVisible(false);
            loadGame.setVisible(false);
            quitButton.setVisible(false);
            hardButton.setVisible(true);
            mediumButton.setVisible(true);
            easyButton.setVisible(true);
            // if(e.getSource() == mediumButton)
            // {
                
            // }
            // else if(e.getSource() == easyButton)
            // {
                
            // }
            // else if(e.getSource() == hardButton)
            // {
                
            // }
            // hardButton.setVisible(false);
            // mediumButton.setVisible(false);
            // easyButton.setVisible(false);
   
            // quitButton.setVisible(true);
            // fightButton.setVisible(true);
            // viewButton.setVisible(true);
        
        }
    }
    
    private class loadHandler implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            String files = JOptionPane.showInputDialog(null, "Enter File name : ");
            game.loadGamess(files);
            // hardButton.setVisible(false);
            // mediumButton.setVisible(false);
            // easyButton.setVisible(false);
   
            quitButton.setVisible(true);
            fightButton.setVisible(true);
            viewButton.setVisible(true);
        
        }
    }
    
    private class easyHandler implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            quitButton.setVisible(true);
            hardButton.setVisible(false);
            mediumButton.setVisible(false);
            easyButton.setVisible(false);
            quitButton.setVisible(true);
            fightButton.setVisible(true);
            viewButton.setVisible(true);
            game.removeFight(10);
            game.removeFight(7);
            game.removeFight(8);
            game.removeFight(9);
            game.removeFight(6);

        }
    }
    
    private class mediumHandler implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            hardButton.setVisible(false);
            mediumButton.setVisible(false);
            easyButton.setVisible(false);
            quitButton.setVisible(true);
            fightButton.setVisible(true);
            viewButton.setVisible(true);
            game.removeFight(7);
            game.removeFight(8);
            game.removeFight(9);
            game.removeFight(9);
            game.removeFight(10);

        }
    }
    
    private class hardHandler implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            hardButton.setVisible(false);
            mediumButton.setVisible(false);
            easyButton.setVisible(false);
            quitButton.setVisible(true);
            fightButton.setVisible(true);
            viewButton.setVisible(true);
            
        }
    }
    
    private class highScoreHandler implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            pane.setVisible(true);
            clearButton.setVisible(true);

            list.setText(game.displayLeaderboard());
        }
    }
    
    private class restingFleetHandler implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            pane.setVisible(true);
            clearButton.setVisible(true);

            list.setText(game.restingFleet());
        }
    }
    
    private class instructionHandler implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            pane.setVisible(true);
            clearButton.setVisible(true);

            list.setText(game.instructions());
        }
    }
    
    // private class 
    
    // private Image getMyImage()
    // {
        
    // }
}
