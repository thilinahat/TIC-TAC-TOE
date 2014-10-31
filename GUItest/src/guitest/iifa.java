/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package guitest;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *
 * @author thilina
 */
public class iifa extends JFrame {
    
    PlayersDatabaseAccessor databaseAccessor=new PlayersDatabaseAccessor();
    JList l=new JList();
    Icon icn1=new ImageIcon(getClass().getResource("btn.JPG"));
    Icon icn2=new ImageIcon(getClass().getResource("hhoverX.JPG"));
    Icon icn3=new ImageIcon(getClass().getResource("hhoverO.JPG"));
    Icon icn4=new ImageIcon(getClass().getResource("gameOver.JPG"));
    Icon icn5=new ImageIcon(getClass().getResource("pplayer1Wins.JPG"));
    Icon icn6=new ImageIcon(getClass().getResource("pplayer2Wins.JPG"));
    Icon icn7=new ImageIcon(getClass().getResource("oneWins.JPG"));
    Icon icn8=new ImageIcon(getClass().getResource("twoWins.JPG"));   
   
    JLabel oneWins=new JLabel();
    JLabel twoWins=new JLabel();
    JLabel gameOver=new JLabel();
    JLabel round1=new JLabel("ROUND I");
    JLabel round2=new JLabel("ROUND II");
    JLabel round3=new JLabel("ROUND III");
    JButton btn1=new JButton(icn1);
   JButton btn2=new JButton(icn1);
   JButton btn3=new JButton(icn1);
   JButton btn4=new JButton(icn1);
   JButton btn5=new JButton(icn1);
   JButton btn6=new JButton(icn1);
   JButton btn7=new JButton(icn1);
   JButton btn8=new JButton(icn1);
   JButton btn9=new JButton(icn1);
   JButton newGame=new JButton("New Game");
   JButton highscores=new JButton("Highscores");
   JButton exit=new JButton("Exit");
   JButton easy=new JButton("Easy");
   JButton medium=new JButton("Medium");
   JButton hard=new JButton("Hard");
   JButton startGame=new JButton("Start Game");
   Random generate=new Random();
   boolean player1[]=new boolean[9];
   boolean player2[]=new boolean[9];
   int count=0;
   int round=0;
   boolean WIN=false;
   boolean SINGLE=true;
   boolean COM_PLAYER1=false;
   boolean COM_PLAYER2=true;
   boolean EASY=false;
   boolean MEDIUM=false;
   boolean HARD=false;
   String playerName;
   
   //adding components to frame.setting eventListeners.positioning components
  public iifa(String profileName)   {
      
            super("TIC-TAC-TOE");
             this.playerName=profileName;
            setLayout(null);
            add(btn1);
            add(btn2);
            add(btn3);
            add(btn4);
            add(btn5);
            add(btn6);
            add(btn7);
            add(btn8);
            add(btn9);  
            add(newGame); 
            add(exit);
            add(highscores); 
            add(gameOver);
            add(oneWins);
            add(twoWins);
            add(easy);
            add(medium);
            add(hard);
            add(startGame);
            add(round1);
            add(round2);
            add(round3 );            
            
            eHandler handler=new eHandler();
            btn1.addActionListener(handler);
            btn2.addActionListener(handler);
            btn3.addActionListener(handler);
            btn4.addActionListener(handler);
            btn5.addActionListener(handler);
            btn6.addActionListener(handler);
            btn7.addActionListener(handler);
            btn8.addActionListener(handler);
            btn9.addActionListener(handler);
            newGame.addActionListener(handler);
            exit.addActionListener(handler);
            highscores.addActionListener(handler);
            easy.addActionListener(handler);
            medium.addActionListener(handler);
            hard.addActionListener(handler);
            startGame.addActionListener(handler);
            
            btn1.setBounds(50, 50, 75, 75);
            btn2.setBounds(130, 50, 75, 75);
            btn3.setBounds(210, 50, 75, 75);
            btn4.setBounds(50, 130, 75, 75);
            btn5.setBounds(130, 130, 75, 75);
            btn6.setBounds(210, 130, 75, 75);
            btn7.setBounds(50, 210, 75, 75);
            btn8.setBounds(130, 210, 75, 75);
            btn9.setBounds(210, 210, 75, 75);
            newGame.setBounds(50, 300, 100,25 );  
            exit.setBounds(160, 300, 75,25 );
            highscores.setBounds(245, 300, 100, 25);
            gameOver.setBounds(30, 350, 360, 80);
            oneWins.setBounds(30, 350, 410, 80);
            twoWins.setBounds(30, 350, 410, 80);
            easy.setBounds(200, 130, 100, 50);
            medium.setBounds(200, 210, 100, 50);
            hard.setBounds(200, 290, 100, 50);
            startGame.setBounds(200, 400, 150, 50);
            round1.setBounds(200, 130, 100, 100);
            round2.setBounds(200, 130, 100, 100);
            round3.setBounds(200, 130, 100, 100);
            
            btn1.setVisible(false);
            btn2.setVisible(false); 
            btn3.setVisible(false);
            btn4.setVisible(false);
            btn5.setVisible(false);
            btn6.setVisible(false);
            btn7.setVisible(false);
            btn8.setVisible(false);
            btn9.setVisible(false);
            newGame.setVisible(false);
            exit.setVisible(false);
            highscores.setVisible(false);
            gameOver.setVisible(false);
            oneWins.setVisible(false);
            twoWins.setVisible(false);
            easy.setVisible(true);
            medium.setVisible(true);
            hard.setVisible(true);
            startGame.setVisible(false);
            round1.setVisible(false);
            round2.setVisible(false);
            round3.setVisible(false);
            
            oneWins.setIcon(icn7);
            twoWins.setIcon(icn8);
            gameOver.setIcon(icn4);
            
     
            
            
       
   } // end of constructor
  
  public final void startGame() throws SQLException {   //starting a new game 
            btn1.setVisible(false);
            btn2.setVisible(false); 
            btn3.setVisible(false);
            btn4.setVisible(false);
            btn5.setVisible(false);
            btn6.setVisible(false);
            btn7.setVisible(false);
            btn8.setVisible(false);
            btn9.setVisible(false);
            newGame.setVisible(false);
            exit.setVisible(false);
            highscores.setVisible(false);
            gameOver.setVisible(false);
            oneWins.setVisible(false);
            twoWins.setVisible(false);
            
            btn1.setIcon(icn1);
            btn2.setIcon(icn1);
            btn3.setIcon(icn1);
            btn4.setIcon(icn1);
            btn5.setIcon(icn1);
            btn6.setIcon(icn1);
            btn7.setIcon(icn1);
            btn8.setIcon(icn1);
            btn9.setIcon(icn1);
            
            for(int k=0;k<9;k++)
                 player1[k]=false;
            for(int k=0;k<9;k++)
                 player2[k]=false;
           
            count=0;
            WIN=false;
            round++;
   
           if(round==2){
                round2.setVisible(true);
                startGame.setVisible(true);
                COM_PLAYER1=true;
                COM_PLAYER2=false;
                playComputer();
            }
           else if(round==3){
               round3.setVisible(true);
               startGame.setVisible(true);
               COM_PLAYER1=false;
               COM_PLAYER2=true;
            }
            
      
  }
  
  //cheks whether player1 wins
  public void verifyPlayer1() throws SQLException{
 
              if(player1[0]&& player1[1]&& player1[2]){ // 1way
                  oneWins.setVisible(true);
                  btn1.setIcon(icn5);
                  btn2.setIcon(icn5);
                  btn3.setIcon(icn5);
                  WIN=true;
                  //delay(100);
              }
              else if(player1[3]&&player1[4]&& player1[5]){ //2way
                  oneWins.setVisible(true);
                  btn4.setIcon(icn5);
                  btn5.setIcon(icn5);
                  btn6.setIcon(icn5);
                  WIN=true;
                  //delay(100);
              }
              else if(player1[6] && player1[7] && player1[8] ){ //3way
                  oneWins.setVisible(true);
                  btn7.setIcon(icn5);
                  btn8.setIcon(icn5);
                  btn9.setIcon(icn5);
                  WIN=true;
                  //delay(100);
              }
              else if(player1[0] && player1[3] && player1[6] ){//4way
                  oneWins.setVisible(true);
                  btn1.setIcon(icn5);
                  btn4.setIcon(icn5);
                  btn7.setIcon(icn5);
                  WIN=true;
                  //delay(100);
              }
              else if(player1[1] && player1[4] && player1[7] ){//5way
                  oneWins.setVisible(true);
                  btn2.setIcon(icn5);
                  btn5.setIcon(icn5);
                  btn8.setIcon(icn5);
                  WIN=true;
                  //delay(100);
              }
              else if(player1[2] && player1[5] && player1[8] ){//6way
                  oneWins.setVisible(true);
                  btn3.setIcon(icn5);
                  btn6.setIcon(icn5);
                  btn9.setIcon(icn5);
                  WIN=true;
                  //delay(100);
              }
                  else if(player1[0] && player1[4] && player1[8] ){//7way
                  oneWins.setVisible(true);
                  btn1.setIcon(icn5);
                  btn5.setIcon(icn5);
                  btn9.setIcon(icn5);
                  WIN=true;
                  //delay(100);
              }
              else if(player1[2] && player1[4] && player1[6] ){//8way
                  oneWins.setVisible(true);
                  btn3.setIcon(icn5);
                  btn5.setIcon(icn5);
                  btn7.setIcon(icn5);
                  WIN=true;
                  //delay(100);
              }
              else if(count==9){  //game over condition
              //    WIN=true;
                  gameOver.setVisible(true);
            }
             else if(SINGLE &&  count<9 &&   COM_PLAYER2)
                  playComputer(); 
             
             else if(WIN && COM_PLAYER2 ){  //human player play as player one and he has won
                 if(EASY)
                   databaseAccessor.updateScores(playerName,10);
                 else if(MEDIUM)
                   databaseAccessor.updateScores(playerName,20);
                 if(HARD)
                   databaseAccessor.updateScores(playerName,30);
             }
             
          //    if(WIN) //end of a round
      //          startGame();
 
      }     
  
  
  //cheks whether player2 wins 
  public void verifyPlayer2() throws SQLException{
    
              if(player2[0] && player2[1] && player2[2] ){ // 1way
                  twoWins.setVisible(true);
                  btn1.setIcon(icn6);
                  btn2.setIcon(icn6);
                  btn3.setIcon(icn6);
                  WIN=true;
                  //delay(100);
              }
              else if(player2[3] && player2[4] && player2[5] ){ //2way
                  twoWins.setVisible(true);
                  btn4.setIcon(icn6);
                  btn5.setIcon(icn6);
                  btn6.setIcon(icn6);
                  WIN=true;
                  //delay(100);
              }
              else if(player2[6] && player2[7] && player2[8] ){ //3way
                  twoWins.setVisible(true);
                  btn7.setIcon(icn6);
                  btn8.setIcon(icn6);
                  btn9.setIcon(icn6);
                  WIN=true;
                  //delay(100);
              }
              else if(player2[0] && player2[3] && player2[6] ){//4way
                  twoWins.setVisible(true);
                  btn1.setIcon(icn6);
                  btn4.setIcon(icn6);
                  btn7.setIcon(icn6);
                  WIN=true;
                  //delay(100);
              }
              else if(player2[1] && player2[4] && player2[7] ){//5way
                  twoWins.setVisible(true);
                  btn2.setIcon(icn6);
                  btn5.setIcon(icn6);
                  btn8.setIcon(icn6);
                  WIN=true;
                  //delay(100);
              }
              else if(player2[2] && player2[5] && player2[8] ){//6way
                  twoWins.setVisible(true);
                  btn3.setIcon(icn6);
                  btn6.setIcon(icn6);
                  btn9.setIcon(icn6);
                  WIN=true;
                  //delay(100);
              }
                  else if(player2[0] && player2[4] && player2[8] ){//7way
                  twoWins.setVisible(true);
                  btn1.setIcon(icn6);
                  btn5.setIcon(icn6);
                  btn9.setIcon(icn6);
                  WIN=true;
                  //delay(100);
              }
              else if(player2[2] && player2[4] && player2[6] ){//8way
                  twoWins.setVisible(true);
                  btn3.setIcon(icn6);
                  btn5.setIcon(icn6);
                  btn7.setIcon(icn6);
                  WIN=true;
                  //delay(100);
              }
              else if(count==9){
                  WIN=true;
                  gameOver.setVisible(true);
      }
              else if(SINGLE &&  count<9 &&COM_PLAYER1)
                  playComputer();
              
              else if(WIN && COM_PLAYER1 ){ //human player play as player two and he has won
                 if(EASY)
                   databaseAccessor.updateScores(playerName,10);
                 else if(MEDIUM)
                   databaseAccessor.updateScores(playerName,20);
                 if(HARD)
                   databaseAccessor.updateScores(playerName,30);
             }
  }
  
  public void playComputer() throws SQLException {    //make the computer play
      int randNum;
      count++;
      
      if(EASY) {  //game mode is easy
       
          if((count-1)%2==1) { //computer play as player 2 in Easy mode
             while(true){   
                 randNum=generate.nextInt(9);
                 if(player2[randNum]==false && player1[randNum]==false){
                       player2[randNum]=true;
                  //    delay();
                       switch(randNum) {
                           case 0 :  btn1.setIcon(icn3);
                                           break;
                           case 1 :  btn2.setIcon(icn3);
                                           break;    
                           case 2 :  btn3.setIcon(icn3);
                                           break;
                           case 3 :  btn4.setIcon(icn3);
                                           break;
                           case 4 :  btn5.setIcon(icn3);
                                           break;
                           case 5 :  btn6.setIcon(icn3);
                                           break;
                           case 6 :  btn7.setIcon(icn3);
                                           break;
                           case 7 :  btn8.setIcon(icn3);
                                           break;
                           case 8 :  btn9.setIcon(icn3);
                                           break;    
                       }
                        verifyPlayer2();
                       break;
                 }
              }
         }
      
        else{   //computer play as player 1 in Easy mode
             while(true){   
                 randNum=generate.nextInt(9);
                 if(player2[randNum]==false && player1[randNum]==false){
                       player1[randNum]=true;
                     //   delay();
                       switch(randNum) {
                           case 0 :  btn1.setIcon(icn2);
                                           break;
                           case 1 :  btn2.setIcon(icn2);
                                           break;    
                           case 2 :  btn3.setIcon(icn2);
                                           break;
                           case 3 :  btn4.setIcon(icn2);
                                           break;
                           case 4 :  btn5.setIcon(icn2);
                                           break;
                           case 5 :  btn6.setIcon(icn2);
                                           break;
                           case 6 :  btn7.setIcon(icn2);
                                           break;
                           case 7 :  btn8.setIcon(icn2);
                                           break;
                           case 8 :  btn9.setIcon(icn2);
                                           break;    
                       }
                        verifyPlayer1();
                       break;
                 }
              }
        }
      }
      
      else if(MEDIUM){   //game mode is medium
          
         if((count-1)%2==1) {  //computer play as player 2 in Medium Mode
           if(player1[0] && player1[1] && !player1[2] && !player2[2] ){   //horizontal method 1
               player2[2]=true;
               btn3.setIcon(icn3);
               verifyPlayer2();
           }
           else if(player1[0] && player1[2] && !player1[1] && !player2[1] ){
               player2[1]=true;
               btn2.setIcon(icn3);
               verifyPlayer2();
           }
           else if(player1[1] && player1[2] && !player1[0] && !player2[0] ){
               player2[0]=true;
               btn1.setIcon(icn3);
               verifyPlayer2();
           }
           else if(player1[3] && player1[4] && !player1[5] && !player2[5] ){  //horizontal method 2
               player2[5]=true;
               btn6.setIcon(icn3);
               verifyPlayer2();
           }
            else if(player1[3] && player1[5] && !player1[4] && !player2[4] ){
               player2[4]=true;
               btn5.setIcon(icn3);
               verifyPlayer2();
           }
            else if(player1[4] && player1[5] && !player1[3] && !player2[3] ){
               player2[3]=true;
               btn4.setIcon(icn3);
               verifyPlayer2();
           }
            else if(player1[6] && player1[7] && !player1[8] && !player2[8] ){  //horizontal method 3
               player2[8]=true;
               btn9.setIcon(icn3);
               verifyPlayer2();
           }
          else if(player1[6] && player1[8] && !player1[7] && !player2[7] ){
               player2[7]=true;
               btn8.setIcon(icn3);
               verifyPlayer2();
           }
           else if(player1[7] && player1[8] && !player1[6] && !player2[6] ){
               player2[6]=true;
               btn7.setIcon(icn3);
               verifyPlayer2();
           }
           else if(player1[0] && player1[3] && !player1[6] && !player2[6] ){ //vertical method 1
               player2[6]=true;
               btn7.setIcon(icn3);
               verifyPlayer2();
           }
           else if(player1[0] && player1[6] && !player1[3] && !player2[3] ){
               player2[3]=true;
               btn4.setIcon(icn3);
               verifyPlayer2();
           }
           else if(player1[3] && player1[6] && !player1[0] && !player2[0] ){
               player2[0]=true;
               btn1.setIcon(icn3);
               verifyPlayer2();
           }
           else if(player1[1] && player1[4] && !player1[7] && !player2[7] ){  //vertical method 2
               player2[7]=true;
               btn8.setIcon(icn3);
               verifyPlayer2();
           }
           else if(player1[1] && player1[7] && !player1[4] && !player2[4] ){
               player2[4]=true;
               btn5.setIcon(icn3);
               verifyPlayer2();
           }
           else if(player1[4] && player1[7] && !player1[1] && !player2[1] ){
               player2[1]=true;
               btn2.setIcon(icn3);
               verifyPlayer2();
           }
           else if(player1[2] && player1[5] && !player1[8] && !player2[8] ){ //vertical method 3
               player2[8]=true;
               btn9.setIcon(icn3);
               verifyPlayer2();
           }
           else if(player1[2] && player1[8] && !player1[5] && !player2[5] ){
               player2[5]=true;
               btn6.setIcon(icn3);
               verifyPlayer2();
           }
           else if(player1[5] && player1[8] && !player1[2] && !player2[2] ){
               player2[2]=true;
               btn3.setIcon(icn3);
               verifyPlayer2();
           }
           else if(player1[0] && player1[4] && !player1[8] && !player2[8] ){  //diagonal method 1
               player2[8]=true;
               btn9.setIcon(icn3);
               verifyPlayer2();
           }
           else if(player1[0] && player1[8] && !player1[4] && !player2[4] ){  
               player2[4]=true;
               btn5.setIcon(icn3);
               verifyPlayer2();
           }
           else if(player1[4] && player1[8] && !player1[0] && !player2[0] ){  
               player2[0]=true;
               btn1.setIcon(icn3);
               verifyPlayer2();
           }
           else if(player1[2] && player1[4] && !player1[6] && !player2[6] ){  //diagonal method 2
               player2[6]=true;
               btn7.setIcon(icn3);
               verifyPlayer2();
           }
           else if(player1[2] && player1[6] && !player1[4] && !player2[4] ){  
               player2[4]=true;
               btn5.setIcon(icn3);
               verifyPlayer2();
           }
           else if(player1[4] && player1[6] && !player1[2] && !player2[2] ){  
               player2[2]=true;
               btn3.setIcon(icn3);
               verifyPlayer2();
           }
           else{   //player one is not in a position to win
              while(true){   
                 randNum=generate.nextInt(9);
                 if(player2[randNum]==false && player1[randNum]==false){
                       player2[randNum]=true;
                  //    delay();
                       switch(randNum) {
                           case 0 :  btn1.setIcon(icn3);
                                           break;
                           case 1 :  btn2.setIcon(icn3);
                                           break;    
                           case 2 :  btn3.setIcon(icn3);
                                           break;
                           case 3 :  btn4.setIcon(icn3);
                                           break;
                           case 4 :  btn5.setIcon(icn3);
                                           break;
                           case 5 :  btn6.setIcon(icn3);
                                           break;
                           case 6 :  btn7.setIcon(icn3);
                                           break;
                           case 7 :  btn8.setIcon(icn3);
                                           break;
                           case 8 :  btn9.setIcon(icn3);
                                           break;    
                       }
                        verifyPlayer2();
                       break;
                 } 
              }
          }
       }
         else {    //computer play as player 1 in Medium mode
              if(player2[0] && player2[1] && !player2[2] && !player1[2] ){   //horizontal method 1
               player1[2]=true;
               btn3.setIcon(icn2);
               verifyPlayer1();
           }
           else if(player2[0] && player2[2] && !player2[1] && !player1[1] ){
               player1[1]=true;
               btn2.setIcon(icn2);
               verifyPlayer1();
           }
           else if(player2[1] && player2[2] && !player2[0] && !player1[0] ){
               player1[0]=true;
               btn1.setIcon(icn2);
               verifyPlayer1();
           }
           else if(player2[3] && player2[4] && !player2[5] && !player1[5] ){  //horizontal method 2
               player1[5]=true;
               btn6.setIcon(icn2);
               verifyPlayer1();
           }
            else if(player2[3] && player2[5] && !player2[4] && !player1[4] ){
               player1[4]=true;
               btn5.setIcon(icn2);
               verifyPlayer1();
           }
            else if(player2[4] && player2[5] && !player2[3] && !player1[3] ){
               player1[3]=true;
               btn4.setIcon(icn2);
               verifyPlayer1();
           }
            else if(player2[6] && player2[7] && !player2[8] && !player1[8] ){  //horizontal method 3
               player1[8]=true;
               btn9.setIcon(icn2);
               verifyPlayer1();
           }
          else if(player2[6] && player2[8] && !player2[7] && !player1[7] ){
               player1[7]=true;
               btn8.setIcon(icn2);
               verifyPlayer1();
           }
           else if(player2[7] && player2[8] && !player2[6] && !player2[6] ){
               player1[6]=true;
               btn7.setIcon(icn2);
               verifyPlayer1();
           }
           else if(player2[0] && player2[3] && !player2[6] && !player1[6] ){ //vertical method 1
               player1[6]=true;
               btn7.setIcon(icn2);
               verifyPlayer1();
           }
           else if(player2[0] && player2[6] && !player2[3] && !player1[3] ){
               player1[3]=true;
               btn4.setIcon(icn2);
               verifyPlayer1();
           }
           else if(player2[3] && player2[6] && !player2[0] && !player1[0] ){
               player1[0]=true;
               btn1.setIcon(icn2);
               verifyPlayer1();
           }
           else if(player2[1] && player2[4] && !player2[7] && !player1[7] ){  //vertical method 2
               player1[7]=true;
               btn8.setIcon(icn2);
               verifyPlayer1();
           }
           else if(player2[1] && player2[7] && !player2[4] && !player1[4] ){
               player1[4]=true;
               btn5.setIcon(icn2);
               verifyPlayer1();
           }
           else if(player2[4] && player2[7] && !player2[1] && !player1[1] ){
               player1[1]=true;
               btn2.setIcon(icn2);
               verifyPlayer1();
           }
           else if(player2[2] && player2[5] && !player2[8] && !player1[8] ){ //vertical method 3
               player1[8]=true;
               btn9.setIcon(icn2);
               verifyPlayer1();
           }
           else if(player2[2] && player2[8] && !player2[5] && !player1[5] ){
               player1[5]=true;
               btn6.setIcon(icn2);
               verifyPlayer1();
           }
           else if(player2[5] && player2[8] && !player2[2] && !player1[2] ){
               player1[2]=true;
               btn3.setIcon(icn2);
               verifyPlayer1();
           }
           else if(player2[0] && player2[4] && !player2[8] && !player1[8] ){  //diagonal method 1
               player1[8]=true;
               btn9.setIcon(icn2);
               verifyPlayer1();
           }
           else if(player2[0] && player2[8] && !player2[4] && !player1[4] ){  
               player1[4]=true;
               btn5.setIcon(icn2);
               verifyPlayer1();
           }
           else if(player2[4] && player2[8] && !player2[0] && !player1[0] ){  
               player1[0]=true;
               btn1.setIcon(icn2);
               verifyPlayer1();
           }
           else if(player2[2] && player2[4] && !player2[6] && !player1[6] ){  //diagonal method 2
               player1[6]=true;
               btn7.setIcon(icn2);
               verifyPlayer1();
           }
           else if(player2[2] && player2[6] && !player2[4] && !player1[4] ){  
               player1[4]=true;
               btn5.setIcon(icn2);
               verifyPlayer1();
           }
           else if(player2[4] && player2[6] && !player2[2] && !player1[2] ){  
               player1[2]=true;
               btn3.setIcon(icn2);
               verifyPlayer1();
           }
           else{   //player two is not in a position to win
              while(true){   
                 randNum=generate.nextInt(9);
                 if(player2[randNum]==false && player1[randNum]==false){
                       player1[randNum]=true;
                  //    delay();
                       switch(randNum) {
                           case 0 :  btn1.setIcon(icn2);
                                           break;
                           case 1 :  btn2.setIcon(icn2);
                                           break;    
                           case 2 :  btn3.setIcon(icn2);
                                           break;
                           case 3 :  btn4.setIcon(icn2);
                                           break;
                           case 4 :  btn5.setIcon(icn2);
                                           break;
                           case 5 :  btn6.setIcon(icn2);
                                           break;
                           case 6 :  btn7.setIcon(icn2);
                                           break;
                           case 7 :  btn8.setIcon(icn2);
                                           break;
                           case 8 :  btn9.setIcon(icn2);
                                           break;    
                       }
                        verifyPlayer1();
                       break;
                 }
              }   
           }
         }      
      }
      else if(HARD){   //game mode is hard
          
         if((count-1)%2==1) {  //computer play as player 2 in hard Mode
             
             //try to win now
         if(player2[0] && player2[1] && !player2[2] && !player1[2] ){   //horizontal method 1
               player2[2]=true;
               btn3.setIcon(icn3);
               verifyPlayer2();
           }
           else if(player2[0] && player2[2] && !player2[1] && !player1[1] ){
               player2[1]=true;
               btn2.setIcon(icn3);
               verifyPlayer2();
           }
           else if(player2[1] && player2[2] && !player2[0] && !player1[0] ){
               player2[0]=true;
               btn1.setIcon(icn3);
               verifyPlayer2();
           }
           else if(player2[3] && player2[4] && !player2[5] && !player1[5] ){  //horizontal method 2
               player2[5]=true;
               btn6.setIcon(icn3);
               verifyPlayer2();
           }
            else if(player2[3] && player2[5] && !player2[4] && !player1[4] ){
               player2[4]=true;
               btn5.setIcon(icn3);
               verifyPlayer2();
           }
            else if(player2[4] && player2[5] && !player2[3] && !player1[3] ){
               player2[3]=true;
               btn4.setIcon(icn3);
               verifyPlayer2();
           }
            else if(player2[6] && player2[7] && !player2[8] && !player1[8] ){  //horizontal method 3
               player2[8]=true;
               btn9.setIcon(icn3);
               verifyPlayer2();
           }
          else if(player2[6] && player2[8] && !player2[7] && !player1[7] ){
               player2[7]=true;
               btn8.setIcon(icn3);
               verifyPlayer2();
           }
           else if(player2[7] && player2[8] && !player2[6] && !player2[6] ){
               player2[6]=true;
               btn7.setIcon(icn3);
               verifyPlayer2();
           }
           else if(player2[0] && player2[3] && !player2[6] && !player1[6] ){ //vertical method 1
               player2[6]=true;
               btn7.setIcon(icn3);
               verifyPlayer2();
           }
           else if(player2[0] && player2[6] && !player2[3] && !player1[3] ){
               player2[3]=true;
               btn4.setIcon(icn3);
               verifyPlayer2();
           }
           else if(player2[3] && player2[6] && !player2[0] && !player1[0] ){
               player2[0]=true;
               btn1.setIcon(icn3);
               verifyPlayer2();
           }
           else if(player2[1] && player2[4] && !player2[7] && !player1[7] ){  //vertical method 2
               player2[7]=true;
               btn8.setIcon(icn3);
               verifyPlayer2();
           }
           else if(player2[1] && player2[7] && !player2[4] && !player1[4] ){
               player2[4]=true;
               btn5.setIcon(icn3);
               verifyPlayer2();
           }
           else if(player2[4] && player2[7] && !player2[1] && !player1[1] ){
               player2[1]=true;
               btn2.setIcon(icn3);
               verifyPlayer2();
           }
           else if(player2[2] && player2[5] && !player2[8] && !player1[8] ){ //vertical method 3
               player2[8]=true;
               btn9.setIcon(icn3);
               verifyPlayer2();
           }
           else if(player2[2] && player2[8] && !player2[5] && !player1[5] ){
               player2[5]=true;
               btn6.setIcon(icn3);
               verifyPlayer2();
           }
           else if(player2[5] && player2[8] && !player2[2] && !player1[2] ){
               player2[2]=true;
               btn3.setIcon(icn3);
               verifyPlayer2();
           }
           else if(player2[0] && player2[4] && !player2[8] && !player1[8] ){  //diagonal method 1
               player2[8]=true;
               btn9.setIcon(icn3);
               verifyPlayer2();
           }
           else if(player2[0] && player2[8] && !player2[4] && !player1[4] ){  
               player2[4]=true;
               btn5.setIcon(icn3);
               verifyPlayer2();
           }
           else if(player2[4] && player2[8] && !player2[0] && !player1[0] ){  
               player2[0]=true;
               btn1.setIcon(icn3);
               verifyPlayer2();
           }
           else if(player2[2] && player2[4] && !player2[6] && !player1[6] ){  //diagonal method 2
               player2[6]=true;
               btn7.setIcon(icn3);
               verifyPlayer2();
           }
           else if(player2[2] && player2[6] && !player2[4] && !player1[4] ){  
               player2[4]=true;
               btn5.setIcon(icn3);
               verifyPlayer2();
           }
           else if(player2[4] && player2[6] && !player2[2] && !player1[2] ){  
               player2[2]=true;
               btn3.setIcon(icn3);
               verifyPlayer2();
           }
             //you can't win so check whether player 1 is goin to win
           else  if(player1[0] && player1[1] && !player1[2] && !player2[2] ){   //horizontal method 1
               player2[2]=true;
               btn3.setIcon(icn3);
               verifyPlayer2();
           }
           else if(player1[0] && player1[2] && !player1[1] && !player2[1] ){
               player2[1]=true;
               btn2.setIcon(icn3);
               verifyPlayer2();
           }
           else if(player1[1] && player1[2] && !player1[0] && !player2[0] ){
               player2[0]=true;
               btn1.setIcon(icn3);
               verifyPlayer2();
           }
           else if(player1[3] && player1[4] && !player1[5] && !player2[5] ){  //horizontal method 2
               player2[5]=true;
               btn6.setIcon(icn3);
               verifyPlayer2();
           }
            else if(player1[3] && player1[5] && !player1[4] && !player2[4] ){
               player2[4]=true;
               btn5.setIcon(icn3);
               verifyPlayer2();
           }
            else if(player1[4] && player1[5] && !player1[3] && !player2[3] ){
               player2[3]=true;
               btn4.setIcon(icn3);
               verifyPlayer2();
           }
            else if(player1[6] && player1[7] && !player1[8] && !player2[8] ){  //horizontal method 3
               player2[8]=true;
               btn9.setIcon(icn3);
               verifyPlayer2();
           }
          else if(player1[6] && player1[8] && !player1[7] && !player2[7] ){
               player2[7]=true;
               btn8.setIcon(icn3);
               verifyPlayer2();
           }
           else if(player1[7] && player1[8] && !player1[6] && !player2[6] ){
               player2[6]=true;
               btn7.setIcon(icn3);
               verifyPlayer2();
           }
           else if(player1[0] && player1[3] && !player1[6] && !player2[6] ){ //vertical method 1
               player2[6]=true;
               btn7.setIcon(icn3);
               verifyPlayer2();
           }
           else if(player1[0] && player1[6] && !player1[3] && !player2[3] ){
               player2[3]=true;
               btn4.setIcon(icn3);
               verifyPlayer2();
           }
           else if(player1[3] && player1[6] && !player1[0] && !player2[0] ){
               player2[0]=true;
               btn1.setIcon(icn3);
               verifyPlayer2();
           }
           else if(player1[1] && player1[4] && !player1[7] && !player2[7] ){  //vertical method 2
               player2[7]=true;
               btn8.setIcon(icn3);
               verifyPlayer2();
           }
           else if(player1[1] && player1[7] && !player1[4] && !player2[4] ){
               player2[4]=true;
               btn5.setIcon(icn3);
               verifyPlayer2();
           }
           else if(player1[4] && player1[7] && !player1[1] && !player2[1] ){
               player2[1]=true;
               btn2.setIcon(icn3);
               verifyPlayer2();
           }
           else if(player1[2] && player1[5] && !player1[8] && !player2[8] ){ //vertical method 3
               player2[8]=true;
               btn9.setIcon(icn3);
               verifyPlayer2();
           }
           else if(player1[2] && player1[8] && !player1[5] && !player2[5] ){
               player2[5]=true;
               btn6.setIcon(icn3);
               verifyPlayer2();
           }
           else if(player1[5] && player1[8] && !player1[2] && !player2[2] ){
               player2[2]=true;
               btn3.setIcon(icn3);
               verifyPlayer2();
           }
           else if(player1[0] && player1[4] && !player1[8] && !player2[8] ){  //diagonal method 1
               player2[8]=true;
               btn9.setIcon(icn3);
               verifyPlayer2();
           }
           else if(player1[0] && player1[8] && !player1[4] && !player2[4] ){  
               player2[4]=true;
               btn5.setIcon(icn3);
               verifyPlayer2();
           }
           else if(player1[4] && player1[8] && !player1[0] && !player2[0] ){  
               player2[0]=true;
               btn1.setIcon(icn3);
               verifyPlayer2();
           }
           else if(player1[2] && player1[4] && !player1[6] && !player2[6] ){  //diagonal method 2
               player2[6]=true;
               btn7.setIcon(icn3);
               verifyPlayer2();
           }
           else if(player1[2] && player1[6] && !player1[4] && !player2[4] ){  
               player2[4]=true;
               btn5.setIcon(icn3);
               verifyPlayer2();
           }
           else if(player1[4] && player1[6] && !player1[2] && !player2[2] ){  
               player2[2]=true;
               btn3.setIcon(icn3);
               verifyPlayer2();
           }
        
         // computer not in a position to win,mark on the middle box and save the game
           else if(!player1[4] && !player2[4]){
               player2[4]=true;
               btn5.setIcon(icn3);
               verifyPlayer2();
           }
           else {
               while(true){   
                 randNum=generate.nextInt(9);
                 if(player2[randNum]==false && player1[randNum]==false && randNum!=0 && randNum!=2 && randNum!=6 && randNum!=8){
                       player2[randNum]=true;
                       switch(randNum) {
                           case 0 :  btn1.setIcon(icn3);
                                           break;
                           case 1 :  btn2.setIcon(icn3);
                                           break;    
                           case 2 :  btn3.setIcon(icn3);
                                           break;
                           case 3 :  btn4.setIcon(icn3);
                                           break;
                           case 4 :  btn5.setIcon(icn3);
                                           break;
                           case 5 :  btn6.setIcon(icn3);
                                           break;
                           case 6 :  btn7.setIcon(icn3);
                                           break;
                           case 7 :  btn8.setIcon(icn3);
                                           break;
                           case 8 :  btn9.setIcon(icn3);
                                           break;    
                       }
                        verifyPlayer2();
                       break;
                 } 
              }
           }
          
       }
         else {    //computer play as player 1 in Hard mode
             
             //try to win
           
           if(player1[0] && player1[1] && !player1[2] && !player2[2] ){   //horizontal method 1
               player1[2]=true;
               btn3.setIcon(icn2);
               verifyPlayer1();
           }
           else if(player1[0] && player1[2] && !player1[1] && !player2[1] ){
               player1[1]=true;
               btn2.setIcon(icn2);
               verifyPlayer1();
           }
           else if(player1[1] && player1[2] && !player1[0] && !player2[0] ){
               player1[0]=true;
               btn1.setIcon(icn2);
               verifyPlayer1();
           }
           else if(player1[3] && player1[4] && !player1[5] && !player2[5] ){  //horizontal method 2
               player1[5]=true;
               btn6.setIcon(icn2);
               verifyPlayer1();
           }
            else if(player1[3] && player1[5] && !player1[4] && !player2[4] ){
               player1[4]=true;
               btn5.setIcon(icn2);
               verifyPlayer1();
           }
            else if(player1[4] && player1[5] && !player1[3] && !player2[3] ){
               player1[3]=true;
               btn4.setIcon(icn2);
               verifyPlayer1();
           }
            else if(player1[6] && player1[7] && !player1[8] && !player2[8] ){  //horizontal method 3
               player1[8]=true;
               btn9.setIcon(icn2);
               verifyPlayer1();
           }
          else if(player1[6] && player1[8] && !player1[7] && !player2[7] ){
               player1[7]=true;
               btn8.setIcon(icn2);
               verifyPlayer1();
           }
           else if(player1[7] && player1[8] && !player1[6] && !player2[6] ){
               player1[6]=true;
               btn7.setIcon(icn2);
               verifyPlayer1();
           }
           else if(player1[0] && player1[3] && !player1[6] && !player2[6] ){ //vertical method 1
               player1[6]=true;
               btn7.setIcon(icn2);
               verifyPlayer1();
           }
           else if(player1[0] && player1[6] && !player1[3] && !player2[3] ){
               player1[3]=true;
               btn4.setIcon(icn2);
               verifyPlayer1();
           }
           else if(player1[3] && player1[6] && !player1[0] && !player2[0] ){
               player1[0]=true;
               btn1.setIcon(icn2);
               verifyPlayer1();
           }
           else if(player1[1] && player1[4] && !player1[7] && !player2[7] ){  //vertical method 2
               player1[7]=true;
               btn8.setIcon(icn2);
               verifyPlayer1();
           }
           else if(player1[1] && player1[7] && !player1[4] && !player2[4] ){
               player1[4]=true;
               btn5.setIcon(icn2);
               verifyPlayer1();
           }
           else if(player1[4] && player1[7] && !player1[1] && !player2[1] ){
               player1[1]=true;
               btn2.setIcon(icn2);
               verifyPlayer1();
           }
           else if(player1[2] && player1[5] && !player1[8] && !player2[8] ){ //vertical method 3
               player1[8]=true;
               btn9.setIcon(icn2);
               verifyPlayer1();
           }
           else if(player1[2] && player1[8] && !player1[5] && !player2[5] ){
               player1[5]=true;
               btn6.setIcon(icn2);
               verifyPlayer1();
           }
           else if(player1[5] && player1[8] && !player1[2] && !player2[2] ){
               player1[2]=true;
               btn3.setIcon(icn2);
               verifyPlayer1();
           }
           else if(player1[0] && player1[4] && !player1[8] && !player2[8] ){  //diagonal method 1
               player1[8]=true;
               btn9.setIcon(icn2);
               verifyPlayer1();
           }
           else if(player1[0] && player1[8] && !player1[4] && !player2[4] ){  
               player1[4]=true;
               btn5.setIcon(icn2);
               verifyPlayer1();
           }
           else if(player1[4] && player1[8] && !player1[0] && !player2[0] ){  
               player1[0]=true;
               btn1.setIcon(icn2);
               verifyPlayer1();
           }
           else if(player1[2] && player1[4] && !player1[6] && !player2[6] ){  //diagonal method 2
               player1[6]=true;
               btn7.setIcon(icn2);
               verifyPlayer1();
           }
           else if(player1[2] && player1[6] && !player1[4] && !player2[4] ){  
               player1[4]=true;
               btn5.setIcon(icn2);
               verifyPlayer1();
           }
           else if(player1[4] && player1[6] && !player1[2] && !player2[2] ){  
               player1[2]=true;
               btn3.setIcon(icn2);
               verifyPlayer1();
           }
             //you can't win so check whether player 2 is goin to win 
             else  if(player2[0] && player2[1] && !player2[2] && !player1[2] ){   //horizontal method 1
               player1[2]=true;
               btn3.setIcon(icn2);
               verifyPlayer1();
           }
           else if(player2[0] && player2[2] && !player2[1] && !player1[1] ){
               player1[1]=true;
               btn2.setIcon(icn2);
               verifyPlayer1();
           }
           else if(player2[1] && player2[2] && !player2[0] && !player1[0] ){
               player1[0]=true;
               btn1.setIcon(icn2);
               verifyPlayer1();
           }
           else if(player2[3] && player2[4] && !player2[5] && !player1[5] ){  //horizontal method 2
               player1[5]=true;
               btn6.setIcon(icn2);
               verifyPlayer1();
           }
            else if(player2[3] && player2[5] && !player2[4] && !player1[4] ){
               player1[4]=true;
               btn5.setIcon(icn2);
               verifyPlayer1();
           }
            else if(player2[4] && player2[5] && !player2[3] && !player1[3] ){
               player1[3]=true;
               btn4.setIcon(icn2);
               verifyPlayer1();
           }
            else if(player2[6] && player2[7] && !player2[8] && !player1[8] ){  //horizontal method 3
               player1[8]=true;
               btn9.setIcon(icn2);
               verifyPlayer1();
           }
          else if(player2[6] && player2[8] && !player2[7] && !player1[7] ){
               player1[7]=true;
               btn8.setIcon(icn2);
               verifyPlayer1();
           }
           else if(player2[7] && player2[8] && !player2[6] && !player2[6] ){
               player1[6]=true;
               btn7.setIcon(icn2);
               verifyPlayer1();
           }
           else if(player2[0] && player2[3] && !player2[6] && !player1[6] ){ //vertical method 1
               player1[6]=true;
               btn7.setIcon(icn2);
               verifyPlayer1();
           }
           else if(player2[0] && player2[6] && !player2[3] && !player1[3] ){
               player1[3]=true;
               btn4.setIcon(icn2);
               verifyPlayer1();
           }
           else if(player2[3] && player2[6] && !player2[0] && !player1[0] ){
               player1[0]=true;
               btn1.setIcon(icn2);
               verifyPlayer1();
           }
           else if(player2[1] && player2[4] && !player2[7] && !player1[7] ){  //vertical method 2
               player1[7]=true;
               btn8.setIcon(icn2);
               verifyPlayer1();
           }
           else if(player2[1] && player2[7] && !player2[4] && !player1[4] ){
               player1[4]=true;
               btn5.setIcon(icn2);
               verifyPlayer1();
           }
           else if(player2[4] && player2[7] && !player2[1] && !player1[1] ){
               player1[1]=true;
               btn2.setIcon(icn2);
               verifyPlayer1();
           }
           else if(player2[2] && player2[5] && !player2[8] && !player1[8] ){ //vertical method 3
               player1[8]=true;
               btn9.setIcon(icn2);
               verifyPlayer1();
           }
           else if(player2[2] && player2[8] && !player2[5] && !player1[5] ){
               player1[5]=true;
               btn6.setIcon(icn2);
               verifyPlayer1();
           }
           else if(player2[5] && player2[8] && !player2[2] && !player1[2] ){
               player1[2]=true;
               btn3.setIcon(icn2);
               verifyPlayer1();
           }
           else if(player2[0] && player2[4] && !player2[8] && !player1[8] ){  //diagonal method 1
               player1[8]=true;
               btn9.setIcon(icn2);
               verifyPlayer1();
           }
           else if(player2[0] && player2[8] && !player2[4] && !player1[4] ){  
               player1[4]=true;
               btn5.setIcon(icn2);
               verifyPlayer1();
           }
           else if(player2[4] && player2[8] && !player2[0] && !player1[0] ){  
               player1[0]=true;
               btn1.setIcon(icn2);
               verifyPlayer1();
           }
           else if(player2[2] && player2[4] && !player2[6] && !player1[6] ){  //diagonal method 2
               player1[6]=true;
               btn7.setIcon(icn2);
               verifyPlayer1();
           }
           else if(player2[2] && player2[6] && !player2[4] && !player1[4] ){  
               player1[4]=true;
               btn5.setIcon(icn2);
               verifyPlayer1();
           }
           else if(player2[4] && player2[6] && !player2[2] && !player1[2] ){  
               player1[2]=true;
               btn3.setIcon(icn2);
               verifyPlayer1();
           }
           
           //can't win try to save the game
           else if(!player1[4] && !player2[4]){
               player1[4]=true;
               btn5.setIcon(icn2);
               verifyPlayer1();
           }
           else{   
              while(true){   
                 randNum=generate.nextInt(9);
                 if(player2[randNum]==false && player1[randNum]==false && randNum!=0 && randNum!=2 && randNum!=6 && randNum!=8){
                       player1[randNum]=true;
                  //    delay();
                       switch(randNum) {
                           case 0 :  btn1.setIcon(icn2);
                                           break;
                           case 1 :  btn2.setIcon(icn2);
                                           break;    
                           case 2 :  btn3.setIcon(icn2);
                                           break;
                           case 3 :  btn4.setIcon(icn2);
                                           break;
                           case 4 :  btn5.setIcon(icn2);
                                           break;
                           case 5 :  btn6.setIcon(icn2);
                                           break;
                           case 6 :  btn7.setIcon(icn2);
                                           break;
                           case 7 :  btn8.setIcon(icn2);
                                           break;
                           case 8 :  btn9.setIcon(icn2);
                                           break;    
                       }
                        verifyPlayer1();
                       break;
                 }
              }   
           }
         }      
      }
  }    
  
  
  public void delay(){
      for(int i=0;i<100000;i++)
          for(int j=0;j<10000;j++){
              
          }
  }
    
    
    //event handling class
    public class eHandler implements ActionListener { 

        @Override
        public void actionPerformed(ActionEvent e) {
            
            try {
                JButton btn=(JButton) e.getSource();
                
                
                if(btn==exit) {    //closing the game
                    System.exit(0);
                }
                else if(btn==newGame)//cancelling n begining a new game or begining a new round
                    startGame();
                
                
                else if(btn==easy || btn==medium || btn==hard){  //selecting the game mode
                    if(btn==easy)
                        EASY=true;
                    else if(btn==medium)
                        MEDIUM=true;
                    else
                        HARD=true;
                    
                    easy.setVisible(false);
                    medium.setVisible(false);
                    hard.setVisible(false);
                    round1.setVisible(true);
                    startGame.setVisible(true);  
                    round++;   //changing round to one
                }
                
                else if(btn==startGame) {// starting the game
                    startGame.setVisible(false);
                    btn1.setVisible(true);
                    btn2.setVisible(true);
                    btn3.setVisible(true);
                    btn4.setVisible(true);
                    btn5.setVisible(true);
                    btn6.setVisible(true);
                    btn7.setVisible(true);
                    btn8.setVisible(true);
                    btn9.setVisible(true);
                    newGame.setVisible(true);
                    exit.setVisible(true);
                    highscores.setVisible(true);
                    round1.setVisible(false);
                    round2.setVisible(false);
                    round3.setVisible(false);
                }
                
                else if(btn!=highscores && count<9 && !WIN) { //checking for the selected button
                    count++;
                    if(btn==btn1){
                        if(count%2==1){
                            player1[0]=true;
                            btn1.setIcon(icn2);
                            verifyPlayer1();
                        }
                        else{
                            player2[0]=true;
                            btn1.setIcon(icn3);
                            verifyPlayer2();
                        }
                    }
                    
                    
                    else  if(btn==btn2){
                        if(count%2==1){
                            player1[1]=true;
                            btn2.setIcon(icn2);
                            verifyPlayer1();
                        }
                        else{
                            player2[1]=true;
                            btn2.setIcon(icn3);
                            verifyPlayer2();
                        }
                    }
                    
                    else  if(btn==btn3){
                        if(count%2==1){
                            player1[2]=true;
                            btn3.setIcon(icn2);
                            verifyPlayer1();
                        }
                        else{
                            player2[2]=true;
                            btn3.setIcon(icn3);
                            verifyPlayer2();
                        }
                    }
                    
                    else  if(btn==btn4){
                        if(count%2==1){
                            player1[3]=true;
                            btn4.setIcon(icn2);
                            verifyPlayer1();
                        }
                        else{
                            player2[3]=true;
                            btn4.setIcon(icn3);
                            verifyPlayer2();
                        }
                    }
                    
                    else  if(btn==btn5){
                        if(count%2==1){
                            player1[4]=true;
                            btn5.setIcon(icn2);
                            verifyPlayer1();
                        }
                        else{
                            player2[4]=true;
                            btn5.setIcon(icn3);
                            verifyPlayer2();
                        }
                    }
                    
                    else  if(btn==btn6){
                        if(count%2==1){
                            player1[5]=true;
                            btn6.setIcon(icn2);
                            verifyPlayer1();
                        }
                        else{
                            player2[5]=true;
                            btn6.setIcon(icn3);
                            verifyPlayer2();
                        }
                    }
                    
                    
                    else  if(btn==btn7){
                        if(count%2==1){
                            player1[6]=true;
                            btn7.setIcon(icn2);
                            verifyPlayer1();
                        }
                        else{
                            player2[6]=true;
                            btn7.setIcon(icn3);
                            verifyPlayer2();
                        }
                    }
                    
                    else  if(btn==btn8){
                        if(count%2==1 ){
                            player1[7]=true;
                            btn8.setIcon(icn2);
                            verifyPlayer1();
                        }
                        else{
                            player2[7]=true;
                            btn8.setIcon(icn3);
                            verifyPlayer2();
                        }
                    }
                    
                    else  if(btn==btn9){
                        if(count%2==1){
                            player1[8]=true;
                            btn9.setIcon(icn2);
                            verifyPlayer1();
                        }
                        else{
                            player2[8]=true;
                            btn9.setIcon(icn3);
                            verifyPlayer2();
                        }
                    }
                }    //end of selected button cheking
            } //end of abstract method
            catch (SQLException ex) {
                Logger.getLogger(iifa.class.getName()).log(Level.SEVERE, null, ex);
            }
                   
          }
                   
          
          
       } //end of  inner class
        
        
        
        
 } //end of class
    

