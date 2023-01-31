package sk.stuba.fei.uim.oop.logic;

import lombok.Getter;
import sk.stuba.fei.uim.oop.components.Board;
import sk.stuba.fei.uim.oop.components.CheckMoves;
import sk.stuba.fei.uim.oop.components.Move;
import sk.stuba.fei.uim.oop.components.Square;
import sk.stuba.fei.uim.oop.graphics.Cage;
import sk.stuba.fei.uim.oop.graphics.ScoreLabel;
import sk.stuba.fei.uim.oop.player.Essence;
import sk.stuba.fei.uim.oop.player.Player;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class UniversalLogic extends ActivityAdapter {
        private Player[] players;
        @Getter
        private JPanel panel;
        @Getter
        private int sizeBoard;
        @Getter
        private JPanel scoreBoardPanel;
        private Board board;
        private CheckMoves checkMoves;
        private String textScore;
        private Move move;
        private Player actualPlayer;
        private boolean noMoves;

        public UniversalLogic(){
                this.players=new Player[2];
                this.panel=new JPanel();
                this.move=new Move();
                this.noMoves=false;
                this.sizeBoard=6;

                this.players[0]=new Player(Essence.PEOPLE);
                this.players[1]=new Player(Essence.COMPUTER);

                this.scoreBoardPanel=new JPanel();
                this.scoreBoardPanel.setLayout((new GridLayout(2,2)));
                this.scoreBoardPanel.add(new ScoreLabel(players[0]));
                this.scoreBoardPanel.add(new JLabel());
                this.scoreBoardPanel.add(new ScoreLabel(players[1]));
                this.scoreBoardPanel.add(new JLabel());
                startGame();
        }
        private void startGame(){
                this.board=new Board();
                this.board.setBoard(sizeBoard,players);
                this.panel.setLayout(new GridLayout(sizeBoard,sizeBoard));
                for (Square[] squares : this.board.getSquares()){
                        for (Square square:squares){
                                this.panel.add(new Cage(this,square));
                        }
                }
                actualPlayer=players[0];
                this.board.setNeigbours();
                checkMoves=new CheckMoves(this.board);
                this.checkMoves.checkBoard(actualPlayer);
                this.panel.addMouseMotionListener(this);
                this.panel.addMouseListener(this);
                this.panel.revalidate();
                this.textScore=actualPlayer.getEssence().getName()+" your turn";
                this.repaint();
        }
        private void repaint(){
                this.panel.repaint();
                ((JLabel)this.scoreBoardPanel.getComponent(1)).setText(("Board size = "+this.sizeBoard+"x"+this.sizeBoard));
                ((JLabel)this.scoreBoardPanel.getComponent(3)).setText(this.textScore);
                this.scoreBoardPanel.repaint();
        }

        private void clearMoved(){
                checkMoves.clear();
        }
        private void changePlayers(){
                if(actualPlayer==players[0]){
                        actualPlayer=players[1];
                }
                else actualPlayer=players[0];
        }
        private void makeMove(){
                clearMoved();
                changePlayers();
                this.checkMoves.checkBoard(actualPlayer);
                this.textScore=actualPlayer.getEssence().getName()+" your turn";
                this.repaint();
                try {
                        nextMove();
                }
                catch (WinnerException w){
                        if(players[0].getCountRock()>players[1].getCountRock()){
                                this.textScore="YOU WIN!!!";
                        }
                        else if (players[0].getCountRock()==players[1].getCountRock())
                        {
                                this.textScore="DRAW!";
                        }
                        else {
                                this.textScore="You lose";
                        }
                        this.repaint();
                }
        }
        private void nextMove() throws WinnerException {
                if((checkMoves.getMoveRecords().getMoveMap().isEmpty())||(players[0].getCountRock()+players[1].getCountRock()==sizeBoard*sizeBoard)){
                       if (this.noMoves ||(players[0].getCountRock()+players[1].getCountRock()==sizeBoard*sizeBoard)){
                               throw new WinnerException();
                       }
                       else{
                               this.noMoves=true;
                       }
                       if (actualPlayer.getEssence()==Essence.PEOPLE){
                               this.makeMove();
                       }
                }
                else if(actualPlayer.getEssence()==Essence.COMPUTER){
                        move.moveOnComputer(checkMoves.getMoveRecords(),actualPlayer);
                        this.noMoves=false;
                }
                if(actualPlayer.getEssence()==Essence.COMPUTER){
                        this.makeMove();
                }
        }

        private void restart(){
                clearMoved();
                players[0].setCountRock(2);
                players[1].setCountRock(2);
                this.panel.removeAll();
                startGame();
        }

        @Override
        public void mouseExited(MouseEvent e) {
                if((e.getComponent()) instanceof Cage ) {
                        ((Cage) e.getComponent()).getSquare().setMouseAktive(false);
                        this.panel.repaint();
                }
        }

        @Override
        public void mouseEntered(MouseEvent e) {
                if((e.getComponent()) instanceof Cage ) {
                        ((Cage) e.getComponent()).getSquare().setMouseAktive(true);
                        this.panel.repaint();
                }
        }

        @Override
        public void actionPerformed(ActionEvent e) {
                this.restart();
        }

        @Override
        public void keyTyped(KeyEvent e) {
                if(e.getKeyChar()==KeyEvent.VK_ESCAPE){
                        ((JFrame)e.getComponent()).dispose();
                        System.exit(1);
                }
                else if(e.getKeyChar()=='R' || e.getKeyChar()=='r'){
                        this.restart();
                }
        }
        

        @Override
        public void mousePressed(MouseEvent e) {
                if(e.getComponent() instanceof Cage) {
                        if (move.moveOn(checkMoves.getMoveRecords(),((Cage) e.getComponent()).getSquare(),actualPlayer)) {
                                this.noMoves=false;
                                makeMove();
                        }
                }
        }

        @Override
        public void stateChanged(ChangeEvent e) {
                if (sizeBoard!=((JSlider)e.getSource()).getValue()){
                        this.sizeBoard=((JSlider)e.getSource()).getValue();
                        restart();
                }

        }
}

