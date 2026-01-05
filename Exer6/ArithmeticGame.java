import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import javax.swing.*;

enum GameLevel {
    LEVEL1(1, 100),
    LEVEL2(101, 500),
    LEVEL3(501, 1000);

    private final int min, max;
    GameLevel(int min, int max) { this.min = min; this.max = max; }
    public int getMin() { return min; }
    public int getMax() { return max; }
    public String getDisplay() { return min + "-" + max; }
}

class QuestionGenerator {
    private final Random random = new Random();
    private int num1, num2, correctAnswer;
    private String operator = "+";

    public void generateQuestion(String operator, GameLevel level) {
        this.operator = operator;
        int min = level.getMin();
        int max = level.getMax();
        switch (operator) {
            case "+": num1 = rand(min, max); num2 = rand(min, max); correctAnswer = num1 + num2; break;
            case "-": num1 = rand(min, max); num2 = rand(min, max); if(num2 > num1){int t=num1; num1=num2; num2=t;} correctAnswer = num1 - num2; break;
            case "*": num1 = rand(min, max); num2 = rand(min, max); correctAnswer = num1 * num2; break;
            case "/": num2 = rand(1, max); int q = rand(1, max / num2); num1 = num2 * q; correctAnswer = num1 / num2; break;
            case "%": num2 = rand(1, max); num1 = rand(min, max); correctAnswer = num1 % num2; break;
        }
    }

    private int rand(int min, int max){ return random.nextInt((max - min) + 1) + min; }
    public int getNum1() { return num1; }
    public int getNum2() { return num2; }
    public String getOperator() { return operator; }
    public int getCorrectAnswer() { return correctAnswer; }
}

public class ArithmeticGame extends JFrame implements ActionListener {
    private static final Color BG = new Color(245, 248, 252);
    private static final Color CARD = new Color(255, 255, 255);
    private static final Color ACCENT = new Color(53, 132, 228);
    private static final Font TITLE_FONT = new Font("SansSerif", Font.BOLD, 28);
    private static final Font BODY_FONT = new Font("SansSerif", Font.PLAIN, 16);

    private final QuestionGenerator generator = new QuestionGenerator();
    private String selectedOperation = "+";
    private GameLevel selectedLevel = GameLevel.LEVEL1;

    private final JTextField answerField = new JTextField(10);
    private final JButton submitButton = new JButton("SUBMIT");
    private final JButton nextButton = new JButton("CONTINUE");
    private final JButton exitButton = new JButton("EXIT"); 
    
    private final JLabel correctScoreLabel = new JLabel("0", SwingConstants.CENTER);
    private final JLabel incorrectScoreLabel = new JLabel("0", SwingConstants.CENTER);

    private final JLabel num1Label = new JLabel("0", SwingConstants.CENTER);
    private final JLabel operatorLabel = new JLabel("+", SwingConstants.CENTER);
    private final JLabel num2Label = new JLabel("0", SwingConstants.CENTER);

    private final JLabel feedbackLabel = new JLabel(" ", SwingConstants.LEFT);

    private final ButtonGroup operationGroup = new ButtonGroup();
    private final ButtonGroup levelGroup = new ButtonGroup();
    private int correctCount = 0, incorrectCount = 0;

    public ArithmeticGame() {
        installNimbusLaf();
        setTitle("Arithmetic Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(BG);
        setLayout(new BorderLayout(10, 10));

        add(createMainPanel(), BorderLayout.CENTER);

        submitButton.addActionListener(this);
        nextButton.addActionListener(this);
        exitButton.addActionListener(this);

        styleButton(submitButton, ACCENT);
        styleButton(nextButton, new Color(34, 197, 94));
        styleButton(exitButton, new Color(239, 68, 68));
        
        nextButton.setEnabled(false);
        submitButton.setEnabled(true);

        generateNewQuestion();
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private JPanel createMainPanel() {
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBackground(BG);
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel title = new JLabel("Practice Your Arithmetic!", SwingConstants.CENTER);
        title.setFont(TITLE_FONT);
        title.setForeground(new Color(30, 41, 59));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.add(title);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 20)));

        // === QUESTION ROW ===
        JPanel questionRow = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 0));
        questionRow.setBackground(BG);
        Font bigFont = new Font("Monospaced", Font.BOLD, 48);
        Dimension labelSize = new Dimension(140, 90);

        setupLabel(num1Label, bigFont, labelSize);
        setupLabel(operatorLabel, bigFont, new Dimension(90, 90)); // smaller width for operator
        setupLabel(num2Label, bigFont, labelSize);

        JLabel equalsLabel = new JLabel("=", SwingConstants.CENTER);
        equalsLabel.setFont(bigFont);
        equalsLabel.setPreferredSize(new Dimension(60, 90));

        answerField.setFont(bigFont);
        answerField.setHorizontalAlignment(SwingConstants.CENTER);
        answerField.setPreferredSize(labelSize);

        questionRow.add(num1Label);
        questionRow.add(operatorLabel);
        questionRow.add(num2Label);
        questionRow.add(equalsLabel);
        questionRow.add(answerField);

        mainPanel.add(questionRow);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 10)));

        // === FEEDBACK + BUTTONS ROW ===
        JPanel feedbackSubmitRow = new JPanel(new BorderLayout(20, 0));
        feedbackSubmitRow.setBackground(BG);

        feedbackLabel.setFont(new Font("SansSerif", Font.BOLD, 22));
        feedbackLabel.setForeground(new Color(30, 41, 59));
        feedbackLabel.setPreferredSize(new Dimension(500, 60));
        feedbackSubmitRow.add(feedbackLabel, BorderLayout.WEST);

        // Align buttons vertically but all same width
        int btnWidth = 300, btnHeight = 55, gap = 10;
        submitButton.setPreferredSize(new Dimension(btnWidth, btnHeight));
        nextButton.setPreferredSize(new Dimension((btnWidth - gap) / 2, btnHeight));
        exitButton.setPreferredSize(new Dimension((btnWidth - gap) / 2, btnHeight));

        JPanel buttonStack = new JPanel();
        buttonStack.setLayout(new BoxLayout(buttonStack, BoxLayout.Y_AXIS));
        buttonStack.setOpaque(false);

        JPanel submitRow = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
        submitRow.setOpaque(false);
        submitRow.add(submitButton);

        JPanel nextExitRow = new JPanel(new FlowLayout(FlowLayout.CENTER, gap, 0));
        nextExitRow.setOpaque(false);
        nextExitRow.add(nextButton);
        nextExitRow.add(exitButton);

        buttonStack.add(submitRow);
        buttonStack.add(Box.createRigidArea(new Dimension(0, 5)));
        buttonStack.add(nextExitRow);

        feedbackSubmitRow.add(buttonStack, BorderLayout.EAST);

        mainPanel.add(feedbackSubmitRow);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 25)));

        // === BOTTOM ROW: Left (Operations+Levels) | Right (Scores) ===
        JPanel bottomRow = new JPanel(new BorderLayout(15, 0));
        bottomRow.setBackground(BG);

        JPanel leftPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 15, 0));
        leftPanel.setBackground(BG);

        JPanel opPanel = new JPanel(new GridLayout(5, 1, 5, 5));
        opPanel.setBackground(CARD);
        opPanel.setBorder(BorderFactory.createTitledBorder("OPERATIONS"));
        String[] ops = {"+", "-", "*", "/", "%"};
        String[] names = {"ADDITION (+)", "SUBTRACTION (-)", "MULTIPLICATION (*)", "DIVISION (/)", "MODULO (%)"};
        for (int i = 0; i < ops.length; i++) {
            JRadioButton rb = new JRadioButton(names[i]);
            rb.setActionCommand(ops[i]);
            rb.setFont(BODY_FONT);
            rb.setBackground(CARD);
            rb.addActionListener(this::handleControlSelection);
            operationGroup.add(rb);
            opPanel.add(rb);
            if (ops[i].equals(selectedOperation)) rb.setSelected(true);
        }

        JPanel lvlPanel = new JPanel(new GridLayout(3, 1, 5, 5));
        lvlPanel.setBackground(CARD);
        lvlPanel.setBorder(BorderFactory.createTitledBorder("LEVELS"));
        for (GameLevel level : GameLevel.values()) {
            JRadioButton rb = new JRadioButton("LEVEL " + level.name().substring(5) + " (" + level.getDisplay() + ")");
            rb.setActionCommand(level.name());
            rb.setFont(BODY_FONT);
            rb.setBackground(CARD);
            rb.addActionListener(this::handleControlSelection);
            levelGroup.add(rb);
            lvlPanel.add(rb);
            if (level == selectedLevel) rb.setSelected(true);
        }

        leftPanel.add(opPanel);
        leftPanel.add(lvlPanel);
        bottomRow.add(leftPanel, BorderLayout.WEST);

        // === SCORE SECTION ===
        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));
        rightPanel.setBackground(BG);
        rightPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));

        JPanel scorePanel = new JPanel(new GridLayout(1, 2, 20, 0));
        scorePanel.setBackground(BG);
        Dimension scoreBox = new Dimension(160, 100);

        JPanel correctPanel = makeScoreBox(correctScoreLabel, "CORRECT", new Color(34, 197, 94), scoreBox);
        JPanel incorrectPanel = makeScoreBox(incorrectScoreLabel, "INCORRECT", new Color(239, 68, 68), scoreBox);

        scorePanel.add(correctPanel);
        scorePanel.add(incorrectPanel);

        rightPanel.add(scorePanel);
        bottomRow.add(rightPanel, BorderLayout.EAST);

        mainPanel.add(bottomRow);
        return mainPanel;
    }

    private JPanel makeScoreBox(JLabel label, String text, Color color, Dimension size) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(BG);

        label.setFont(new Font("SansSerif", Font.BOLD, 40));
        label.setForeground(color);
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        label.setPreferredSize(new Dimension(size.width, 60));

        JLabel lbl = new JLabel(text, SwingConstants.CENTER);
        lbl.setFont(new Font("SansSerif", Font.BOLD, 16));
        lbl.setForeground(new Color(30, 41, 59));
        lbl.setAlignmentX(Component.CENTER_ALIGNMENT);

        panel.add(label);
        panel.add(Box.createRigidArea(new Dimension(0, 5)));
        panel.add(lbl);
        return panel;
    }

    private void handleControlSelection(ActionEvent e) {
        String cmd = e.getActionCommand();
        if("+-*/%".contains(cmd)) selectedOperation=cmd;
        else selectedLevel=GameLevel.valueOf(cmd);
        operatorLabel.setText(selectedOperation);
        generateNewQuestion();
    }

    private void generateNewQuestion(){
        generator.generateQuestion(selectedOperation, selectedLevel);
        num1Label.setText(String.valueOf(generator.getNum1()));
        num2Label.setText(String.valueOf(generator.getNum2()));
        operatorLabel.setText(generator.getOperator());
        answerField.setText("");
        answerField.setEnabled(true);
        submitButton.setEnabled(true);
        nextButton.setEnabled(false);
        feedbackLabel.setText(" ");
        answerField.requestFocusInWindow();
    }

    private void updateScore(boolean correct){
        if(correct) correctScoreLabel.setText(String.valueOf(++correctCount));
        else incorrectScoreLabel.setText(String.valueOf(++incorrectCount));
    }

    private void checkAnswer(){
        try{
            int userAnswer = Integer.parseInt(answerField.getText().trim());
            boolean correct = userAnswer==generator.getCorrectAnswer();
            updateScore(correct);

            if(correct){
                feedbackLabel.setText("GOOD JOB, YOU ARE CORRECT!");
                feedbackLabel.setForeground(new Color(34,197,94));
            } else{
                feedbackLabel.setText("YOU ARE WRONG! Answer: " + generator.getCorrectAnswer());
                feedbackLabel.setForeground(new Color(239,68,68));
            }

            answerField.setEnabled(false);
            submitButton.setEnabled(false);
            nextButton.setEnabled(true);

        }catch(NumberFormatException ex){
            JOptionPane.showMessageDialog(this,"Please enter a valid number.","Input Error",JOptionPane.WARNING_MESSAGE);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e){
        Object src = e.getSource();
        if(src==submitButton) checkAnswer();
        else if(src==nextButton) generateNewQuestion();
        else if(src==exitButton){
            num1Label.setText(" ");
            num2Label.setText(" ");
            operatorLabel.setText(" ");
            answerField.setText("");
            feedbackLabel.setText("Game paused. Click CONTINUE to start a new question.");
            feedbackLabel.setForeground(new Color(30, 41, 59));
            answerField.setEnabled(false);
            submitButton.setEnabled(false);
            nextButton.setEnabled(true);
        }
    }

    private void styleButton(JButton btn, Color bg){
        btn.setBackground(bg);
        btn.setForeground(Color.WHITE);
        btn.setFont(new Font("SansSerif", Font.BOLD,16));
        btn.setFocusPainted(false);
        btn.setBorder(BorderFactory.createEmptyBorder(10,20,10,20));
        btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    private void setupLabel(JLabel lbl, Font f, Dimension size){
        lbl.setFont(f);
        lbl.setPreferredSize(size);
        lbl.setOpaque(true);
        lbl.setBackground(CARD);
        lbl.setBorder(BorderFactory.createLineBorder(new Color(203,213,225),2));
    }

    private static void installNimbusLaf(){
        try{
            for(UIManager.LookAndFeelInfo info: UIManager.getInstalledLookAndFeels())
                if("Nimbus".equals(info.getName()))
                    UIManager.setLookAndFeel(info.getClassName());
        }catch(Exception ignore){}
    }

    public static void main(String[] args){
        SwingUtilities.invokeLater(ArithmeticGame::new);
    }
}