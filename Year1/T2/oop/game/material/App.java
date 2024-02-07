package material;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.Timer;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class App {
    procress script = new procress();
    patten ui = new patten();
    private JFrame Frame;
    private JButton btnNew, btnStart, btnEnd, btnLevel;
    private JLabel lbBlank1,lbBlank2,lbBlank3;
    private JLabel lbtitle,lbScore,lbLevel;

    private int count;
    private int score;
    private int level = 1;
    private int i;
    public int tmploop = 5;
    private int tmploopindex = 0;

    public App() {
        Frame = new JFrame("MEMORY-GAME");
        Frame.getContentPane().setBackground(Color.black);
        Frame.setIconImage(Toolkit.getDefaultToolkit().getImage("zbrain2.jpg"));
        Frame.setSize(600, 680);
        Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        detailComponents();
        Frame.setVisible(true);
        Frame.setResizable(false);
    }

    private void detailComponents() {
        btnNew = new JButton("New Game");
        btnStart = new JButton("Start");
        btnLevel = new JButton("Next Level");
        btnEnd = new JButton("End Game");
        lbBlank1 = new JLabel("      ");
        lbBlank2 = new JLabel("      ");
        lbBlank3 = new JLabel("      ");
        lbScore = new JLabel("Your Score  :  " + score, SwingConstants.CENTER);
        lbLevel = new JLabel("Level  :  " + level);
        lbtitle = new JLabel("MemoryGame", SwingConstants.CENTER);
        

        btnNew.setPreferredSize(new Dimension(100, 30));
        btnStart.setPreferredSize(new Dimension(100, 30));
        btnEnd.setPreferredSize(new Dimension(100, 30));
        btnLevel.setPreferredSize(new Dimension(100, 30));
        lbBlank1.setPreferredSize(new Dimension(600, 10));
        lbBlank2.setPreferredSize(new Dimension(600, 20));
        lbBlank3.setPreferredSize(new Dimension(50, 30));
        lbtitle.setForeground(Color.white);
        lbtitle.setPreferredSize(new Dimension(500, 20));
        lbScore.setForeground(Color.CYAN);
        lbScore.setPreferredSize(new Dimension(200, 30));
        lbLevel.setForeground(Color.ORANGE);
        lbLevel.setPreferredSize(new Dimension(200, 30));
        lbLevel.setFont(new Font("", Font.PLAIN, 20));
        lbScore.setFont(new Font("", Font.PLAIN, 20));

        Frame.setLayout(new FlowLayout());
        Frame.add(lbtitle);
        Frame.add(lbBlank2);
        Frame.add(btnStart);
        Frame.add(btnNew);
        Frame.add(btnEnd);
        Frame.add(btnLevel);
        Frame.add(lbBlank2);
        Frame.add(lbLevel);
        // Frame.add(lbBlank3);
        Frame.add(lbScore);
        Frame.add(lbBlank1);
        Frame.add(ui.btn1);
        Frame.add(ui.btn2);
        Frame.add(ui.btn3);
        Frame.add(ui.btn4);
        Frame.add(ui.btn5);
        Frame.add(ui.btn6);
        Frame.add(ui.btn7);
        Frame.add(ui.btn8);
        Frame.add(ui.btn9);

        // Event
        btnStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent event) {
                startGame();
            }
        });

        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent event) {
                newGame();
                score = 0;
                lbScore.setText("Your Score : " + score);
            }
        });

        btnEnd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent event) {
                Frame.dispose();
                new Thankyou();
            }
        });

        btnLevel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent event) {
                level++;
                lbLevel.setText("Level : " + level);
                tmploop++;
                count++;
                System.out.println(tmploop);
                if(tmploop == 9) {
                    btnLevel.setEnabled(false);
                }else{
                    btnLevel.setEnabled(true);
                }
            }
        });


        // Event Button

        ui.btn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent event) {
                boolean check = checklist(0);
                if (check){
                    ui.btn1.setIcon(ui.img3);
                    count++;
                    System.out.println(count);
                    success();
                }
                else{
                    ui.btn1.setIcon(ui.img4);
                }
            }
        });

        ui.btn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent event) {
                boolean check = checklist(1);
                if (check){
                    ui.btn2.setIcon(ui.img3);
                    count++;
                    System.out.println(count); 
                    success();
                }
                else{
                    ui.btn2.setIcon(ui.img4);
                }
            }
        });

        ui.btn3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent event) {
                boolean check = checklist(2);
                if (check){
                    ui.btn3.setIcon(ui.img3);
                    count++;
                    System.out.println(count);
                    success();
                }
                else
                    ui.btn3.setIcon(ui.img4);

            }
        });

        ui.btn4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent event) {
                boolean check = checklist(3);
                if (check){
                    ui.btn4.setIcon(ui.img3);
                    count++;
                    System.out.println(count);
                    success();
                }
                else
                    ui.btn4.setIcon(ui.img4);
            }
        });

        ui.btn5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent event) {
                boolean check = checklist(4);
                if (check){
                    ui.btn5.setIcon(ui.img3);
                    count++;
                    System.out.println(count);
                    success();
                }
                else
                    ui.btn5.setIcon(ui.img4);
            }
        });

        ui.btn6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent event) {
                boolean check = checklist(5);
                if (check){
                    ui.btn6.setIcon(ui.img3);
                    count++;
                    System.out.println(count);
                    success();
                }
                else
                    ui.btn6.setIcon(ui.img4);
            }
        });

        ui.btn7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent event) {
                boolean check = checklist(6);
                if (check){
                    ui.btn7.setIcon(ui.img3);
                    count++;
                    System.out.println(count);
                    success();
                }
                else
                    ui.btn7.setIcon(ui.img4);
            }
        });

        ui.btn8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent event) {
                boolean check = checklist(7);
                if (check){
                    ui.btn8.setIcon(ui.img3);
                    count++;
                    System.out.println(count);
                    success();
                }

                else
                    ui.btn8.setIcon(ui.img4);
            }
        });

        ui.btn9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent event) {
                boolean check = checklist(8);
                if (check){
                    ui.btn9.setIcon(ui.img3);
                    count++;
                    System.out.println(count);
                    success();
                }
                else
                    ui.btn9.setIcon(ui.img4);
            }
        });

    }

    private void startGame() {
        int[] pattern = script.shuffleNumber();
        i = 0;

        for (int tmp = 0; tmp < tmploop; tmp++) {
            Timer timer = new Timer(1000 * tmp, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (pattern[i] == 0) {
                        ui.btn1.setIcon(ui.img13);
                    } else if (pattern[i] == 1) {
                        ui.btn2.setIcon(ui.img5);
                    } else if (pattern[i] == 2) {
                        ui.btn3.setIcon(ui.img6);
                    } else if (pattern[i] == 3) {
                        ui.btn4.setIcon(ui.img7);
                    } else if (pattern[i] == 4) {
                        ui.btn5.setIcon(ui.img8);
                    } else if (pattern[i] == 5) {
                        ui.btn6.setIcon(ui.img9);
                    } else if (pattern[i] == 6) {
                        ui.btn7.setIcon(ui.img10);
                    } else if (pattern[i] == 7) {
                        ui.btn8.setIcon(ui.img11);
                    } else if (pattern[i] == 8) {
                        ui.btn9.setIcon(ui.img12);
                    }
                    i++;
                }
            });
            timer.setRepeats(false);
            timer.start();
        }
        ActionListener listener = new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                ui.btn1.setIcon(ui.img1);
                ui.btn2.setIcon(ui.img1);
                ui.btn3.setIcon(ui.img1);
                ui.btn4.setIcon(ui.img1);
                ui.btn5.setIcon(ui.img1);
                ui.btn6.setIcon(ui.img1);
                ui.btn7.setIcon(ui.img1);
                ui.btn8.setIcon(ui.img1);
                ui.btn9.setIcon(ui.img1);
            }
        };
        Timer timer = new Timer(tmploop * 1000, listener);
        timer.setRepeats(false);
        timer.start();
    }

    private boolean checklist(int x) {
        int[] pattern = script.patternNumber;
        if (pattern[tmploopindex] == x) {
            tmploopindex++;
            return true;
        }else {
            return false;
        }

    }
    private void newGame(){      
        tmploopindex = 0;
        count = 0;
        ui.btn1.setIcon(ui.img1);
        ui.btn2.setIcon(ui.img1);
        ui.btn3.setIcon(ui.img1);
        ui.btn4.setIcon(ui.img1);
        ui.btn5.setIcon(ui.img1);
        ui.btn6.setIcon(ui.img1);
        ui.btn7.setIcon(ui.img1);
        ui.btn8.setIcon(ui.img1);
        ui.btn9.setIcon(ui.img1);  
    }

    private void success(){
        if(count == 5){ // ติดตรงที่ next level แล้วก็ยังกดถูกแค่ 5 เหมือนเดิม count ไม่เพิ่ม
            System.out.println("success " + count);
            count = 0;
            score++;
            lbScore.setText("Your Score : " + score);
            System.out.println("Your Score : " + score);
            if(score == 1){
                level++;
                tmploop++;
                count++;
                lbLevel.setText("Level : " + level);
                System.out.println("Level " + level); 
                if(tmploop == 9){
                    tmploop = tmploop;
                } 
            }
            newGame();
            startGame();  
        }
    }
}
