import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Board {

    private final int BOARD_SIZE = 15;
    private boolean hasClicked = false;
    private int wordsFound;
    private Theme theme;
    private JFrame frame;
    private JPanel mainPanel;
    private MenuPanel menuPanel;
    private SearchField searchField;
    private WordField wordField;
    private String[] wordList;
    CardLayout cardLayout;
    Container contentPane;

    public Board(){
        this.frame = new JFrame("Word Search");
        this.frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.menuPanel = new MenuPanel();
        this.frame.add(menuPanel);
        this.frame.setSize(new Dimension(1000, 500));

        this.contentPane = frame.getContentPane();
        this.cardLayout = new CardLayout();

        contentPane.setLayout(cardLayout);
        contentPane.add(menuPanel, "MainMenu");

        this.frame.setVisible(true);
    }

    public void setTheme(Theme theme){
        this.theme = theme;
    }

    public void switchScenes(){
        this.cardLayout.next(contentPane);
    }

    public void unhighlight(){
        searchField.unhighlightWord();
    }

    public void check(){
        searchField.checkWord();
    }

    public static String[] shuffleWords(ArrayList<String> wordList){
        String[] list = new String[10];
        Collections.shuffle(wordList);
        for(int i = 0; i < 10; i++)
            list[i] = wordList.get(i);
        return list;
    }

    class MenuPanel extends JPanel{

        ThemeButton forestButton;
        ThemeButton spaceButton;
        ThemeButton oceanButton;
        ThemeButton candyButton;

        public MenuPanel(){
            setLayout(new FlowLayout());
            forestButton = new ThemeButton(Theme.FOREST);
            spaceButton = new ThemeButton(Theme.SPACE);
            oceanButton = new ThemeButton(Theme.OCEAN);
            candyButton = new ThemeButton(Theme.CANDYLAND);
            add(forestButton);
            add(spaceButton);
            add(oceanButton);
            add(candyButton);
        }

        class ThemeButton extends JButton{

            ThemeButton(Theme theme){
                setBackground(theme.getBGColor());
                setForeground(theme.getWordListColor());
                setFont(theme.getWordFont());
                setText(theme.getName());

                addMouseListener(new MouseListener() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        setTheme(theme);
                        wordList = shuffleWords(theme.getWordList());
                        mainPanel = new JPanel();
                        searchField = new SearchField();
                        searchField.addWords(wordList);
                        mainPanel.add(searchField);
                        wordField = new WordField(wordList);
                        mainPanel.add(wordField);
                        mainPanel.setBackground(theme.getBGColor());
                        contentPane.add(mainPanel, "SearchField");
                        frame.add(mainPanel);
                        frame.pack();
                        switchScenes();
                    }

                    @Override
                    public void mousePressed(MouseEvent e) {

                    }

                    @Override
                    public void mouseReleased(MouseEvent e) {

                    }

                    @Override
                    public void mouseEntered(MouseEvent e) {

                    }

                    @Override
                    public void mouseExited(MouseEvent e) {

                    }
                });
            }


        }

    }

    class SearchField extends JPanel{

        private LetterBox[][] letterBoxes = new LetterBox[BOARD_SIZE][BOARD_SIZE];
        public SearchField(){
            setLayout(new GridLayout(BOARD_SIZE, BOARD_SIZE));
            for (int i = 0; i < BOARD_SIZE; i++) {
                for (int j = 0; j < BOARD_SIZE; j++) {
                    LetterBox box = new LetterBox();
                    box.setXValue(j);
                    box.setYValue(i);
                    this.letterBoxes[i][j] = box;
                    add(box);
                }
            }
        }

        public LetterBox getBox(int x, int  y){
            for(int i = 0; i < BOARD_SIZE; i ++){
                for(int j = 0; j < BOARD_SIZE; j++){
                    LetterBox box = letterBoxes[i][j];
                    if(box.getXValue() == x && box.getYValue() == y)
                        return box;
                }
            }
            return null;
        }

        void checkWord(){
            int yelx = -1;
            int yely = -1;
            int grex = -1;
            int grey = -1;
            for(int i = 0; i < BOARD_SIZE; i++){
                for(int j = 0; j < BOARD_SIZE; j++){
                    if(letterBoxes[i][j].getBackground().equals(theme.getFakeHighlightColor())) {
                        yelx = letterBoxes[i][j].XValue;
                        yely = letterBoxes[i][j].YValue;
                    }
                    if(letterBoxes[i][j].getBackground().equals(Color.WHITE)) {
                        grex = letterBoxes[i][j].XValue;
                        grey = letterBoxes[i][j].YValue;
                    }
                }
            }
            if(!getBox(yelx, yely).isWordEnd() || !getBox(grex, grey).isWordEnd())
                unhighlightWord();
            else if(getBox(yelx, yely).getWord().equals(getBox(grex, grey).getWord()))
                highlightWord(getBox(yelx, yely).getWord());
            else{
                unhighlightWord();}
        }

        public void highlightWord(String word) {
            for(int i = 0; i < BOARD_SIZE; i++){
                for(int j = 0; j < BOARD_SIZE; j++){
                    if(letterBoxes[i][j].getWord().equals(word)) {
                        letterBoxes[i][j].setBackground(theme.getHighlightColor());
                        letterBoxes[i][j].found = true;
                    }
                }
            }
            wordField.strikeWord(word);
            wordsFound++;
            if(wordsFound >= 10) {
                wordField.title.setText("Congratulations");
                wordField.wordListPanel.setVisible(false);
            }
        }

        public void unhighlightWord() {
            for(int i = 0; i < BOARD_SIZE; i++)
                for(int j = 0; j < BOARD_SIZE; j++)
                    if(!letterBoxes[i][j].found)
                        letterBoxes[i][j].setBackground(theme.getSearchColor());
        }

        void addWords(String[] list){
            for(int i = 0; i < 10; i++){
                int length = list[i].length();
                String word = list[i];
                Random rand = new Random();
                int direction = rand.nextInt(8);
                switch(direction){
                    case 0:{ //right
                        int startx;
                        int starty;
                        outer:
                        while(true) {
                            startx = rand.nextInt(BOARD_SIZE - length);
                            starty = rand.nextInt(BOARD_SIZE);

                            for (int j = 0; j < length; j++)
                                if (getBox(startx + j, starty).isWordLetter())
                                    continue outer;
                            break;
                        }

                        for(int k = 0; k < length; k++){
                            getBox(startx + k, starty).setLetter(word.charAt(k));
                            getBox(startx + k, starty).setWordLetter(true);
                            getBox(startx + k, starty).setWord(word);
                        }
                        getBox(startx, starty).setWordEnd(true);
                        getBox(startx + length - 1, starty).setWordEnd(true);
                        break;}
                    case 1:{ //down right

                        int startx;
                        int starty;
                        outer:
                        while(true) {
                            startx = rand.nextInt(BOARD_SIZE - length);
                            starty = rand.nextInt(BOARD_SIZE - length);

                            for (int j = 0; j < length; j++)
                                if (getBox(startx + j, starty + j).isWordLetter())
                                    continue outer;
                            break;
                        }

                        for(int k = 0; k < length; k++){
                            getBox(startx + k, starty + k).setLetter(word.charAt(k));
                            getBox(startx + k, starty + k).setWordLetter(true);
                            getBox(startx + k, starty + k).setWord(word);
                        }

                        getBox(startx, starty).setWordEnd(true);
                        getBox(startx + length - 1, starty + length - 1).setWordEnd(true);
                        break;}
                    case 2:{ //down

                        int startx;
                        int starty;
                        outer:
                        while(true) {
                            startx = rand.nextInt(BOARD_SIZE);
                            starty = rand.nextInt(BOARD_SIZE - length);

                            for (int j = 0; j < length; j++)
                                if (getBox(startx, starty + j).isWordLetter())
                                    continue outer;
                            break;
                        }

                        for(int k = 0; k < length; k++){
                            getBox(startx, starty + k).setLetter(word.charAt(k));
                            getBox(startx, starty + k).setWordLetter(true);
                            getBox(startx, starty + k).setWord(word);
                        }

                        getBox(startx, starty).setWordEnd(true);
                        getBox(startx, starty + length - 1).setWordEnd(true);
                        break;}
                    case 3:{ //down left
                        int startx;
                        int starty;
                        outer:
                        while(true) {
                            startx = rand.nextInt(length - 1, BOARD_SIZE);
                            starty = rand.nextInt(BOARD_SIZE - length);

                            for (int j = 0; j < length; j++)
                                if (getBox(startx - j, starty + j).isWordLetter())
                                    continue outer;
                            break;
                        }


                        for(int k = 0; k < length; k++){
                            getBox(startx - k, starty + k).setLetter(word.charAt(k));
                            getBox(startx - k, starty + k).setWordLetter(true);
                            getBox(startx - k, starty + k).setWord(word);
                        }

                        getBox(startx, starty).setWordEnd(true);
                        getBox(startx - length + 1, starty + length - 1).setWordEnd(true);
                        break;}
                    case 4:{ //left

                        int startx;
                        int starty;
                        outer:
                        while(true) {
                            startx = rand.nextInt(length - 1, BOARD_SIZE);
                            starty = rand.nextInt(BOARD_SIZE);

                            for (int j = 0; j < length; j++)
                                if (getBox(startx - j, starty).isWordLetter())
                                    continue outer;
                            break;
                        }

                        for(int k = 0; k < length; k++){
                            getBox(startx - k, starty).setLetter(word.charAt(k));
                            getBox(startx - k, starty).setWordLetter(true);
                            getBox(startx - k, starty).setWord(word);
                        }

                        getBox(startx, starty).setWordEnd(true);
                        getBox(startx - length + 1, starty).setWordEnd(true);
                        break;}
                    case 5:{ //up left

                        int startx;
                        int starty;
                        outer:
                        while(true) {
                            startx = rand.nextInt(length - 1, BOARD_SIZE);
                            starty = rand.nextInt(length - 1, BOARD_SIZE);

                            for (int j = 0; j < length; j++)
                                if (getBox(startx - j, starty - j).isWordLetter())
                                    continue outer;
                            break;
                        }

                        for(int k = 0; k < length; k++){
                            getBox(startx - k, starty - k).setLetter(word.charAt(k));
                            getBox(startx - k, starty - k).setWordLetter(true);
                            getBox(startx - k, starty - k).setWord(word);
                        }

                        getBox(startx, starty).setWordEnd(true);
                        getBox(startx - length + 1, starty - length + 1).setWordEnd(true);
                        break;}
                    case 6:{ //up

                        int startx;
                        int starty;
                        outer:
                        while(true) {
                            startx = rand.nextInt(BOARD_SIZE);
                            starty = rand.nextInt(length - 1, BOARD_SIZE);

                            for (int j = 0; j < length; j++)
                                if (getBox(startx, starty - j).isWordLetter())
                                    continue outer;
                            break;
                        }

                        for(int k = 0; k < length; k++){
                            getBox(startx, starty - k).setLetter(word.charAt(k));
                            getBox(startx, starty - k).setWordLetter(true);
                            getBox(startx, starty - k).setWord(word);
                        }

                        getBox(startx, starty).setWordEnd(true);
                        getBox(startx, starty - length + 1).setWordEnd(true);
                        break;}
                    case 7:{ //up right

                        int startx;
                        int starty;
                        outer:
                        while(true) {
                            startx = rand.nextInt(BOARD_SIZE - length);
                            starty = rand.nextInt(length - 1, BOARD_SIZE);

                            for (int j = 0; j < length; j++)
                                if (getBox(startx + j, starty - j).isWordLetter())
                                    continue outer;
                            break;
                        }

                        for(int k = 0; k < length; k++){
                            getBox(startx + k, starty - k).setLetter(word.charAt(k));
                            getBox(startx + k, starty - k).setWordLetter(true);
                            getBox(startx + k, starty - k).setWord(word);
                        }

                        getBox(startx, starty).setWordEnd(true);
                        getBox(startx + length - 1, starty - length + 1).setWordEnd(true);
                        break;}
                }
            }
        }

    }

    class LetterBox extends JLabel{
        char letter;
        boolean wordLetter;
        boolean wordEnd;
        int XValue;
        int YValue;
        String word;
        boolean found;

        public LetterBox(){

            letter = (char) ('A' + new Random().nextInt(26));
            wordLetter = false;
            wordEnd = false;
            XValue = -1;
            YValue = -1;
            word = "";
            found = false;

            setHorizontalAlignment(CENTER);
            setPreferredSize(new Dimension(40, 40));
            setOpaque(true);
            setBackground(theme.getSearchColor());
            setForeground(theme.getSearchLetterColor());
            setText(Character.toString(letter));

            addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if(!found){
                        if (!hasClicked) {
                            setBackground(theme.getFakeHighlightColor());
                            hasClicked = true;
                        } else {
                            if(!isWordEnd()) {
                                unhighlight();
                                hasClicked = false;
                            } else {
                                setBackground(Color.WHITE);
                                hasClicked = false;
                                check();
                            }
                        }
                    }
                }

                @Override
                public void mousePressed(MouseEvent e) {

                }

                @Override
                public void mouseReleased(MouseEvent e) {

                }

                @Override
                public void mouseEntered(MouseEvent e) {

                }

                @Override
                public void mouseExited(MouseEvent e) {

                }
            });
        }


        public String getWord() {
            return word;
        }

        public void setWord(String word) {
            this.word = word;
        }

        public int getXValue() {
            return XValue;
        }

        public void setXValue(int XValue) {
            this.XValue = XValue;
        }

        public int getYValue() {
            return YValue;
        }

        public void setYValue(int YValue) {
            this.YValue = YValue;
        }

        public boolean isWordLetter() {
            return wordLetter;
        }

        public void setWordLetter(boolean wordLetter) {
            this.wordLetter = wordLetter;
        }

        public boolean isWordEnd() {
            return wordEnd;
        }

        public void setWordEnd(boolean wordEnd) {
            this.wordEnd = wordEnd;
        }

        public char getLetter() {
            return letter;
        }

        public void setLetter(char letter) {
            this.letter = letter;
            setText(Character.toString(letter));
        }
    }

    class WordField extends JPanel{

        JPanel titlePanel;
        JLabel title;
        GridBagConstraints gb;
        WordList wordListPanel;
        JButton menuButton;

        public WordField(String[] wordList){
            setBackground(theme.getBGColor());
            setLayout(new GridBagLayout());
            gb = new GridBagConstraints();
            this.titlePanel = new JPanel();
            this.titlePanel.setBackground(theme.getBGColor());
            this.title = new JLabel("Words");
            this.title.setFont(theme.getTitleFont());
            this.title.setForeground(theme.getWordListColor());
            this.title.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
            this.titlePanel.add(title);

            gb.gridx = 0;
            gb.gridy = 0;
            add(titlePanel, gb);

            gb.gridx = 0;
            gb.gridy = 1;
            wordListPanel = new WordList(wordList);
            add(wordListPanel, gb);

            menuButton = new JButton("Main Menu");
            menuButton.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    switchScenes();
                }

                @Override
                public void mousePressed(MouseEvent e) {

                }

                @Override
                public void mouseReleased(MouseEvent e) {

                }

                @Override
                public void mouseEntered(MouseEvent e) {

                }

                @Override
                public void mouseExited(MouseEvent e) {

                }
            });
            //add(menuButton, gb);
        }

        public void strikeWord(String word){
            wordListPanel.getWord(word).setFont(theme.getStrikeFont());
        }

        class WordList extends JPanel{
            private Font font;
            private GridLayout layout;
            JLabel[] words = new JLabel[10];

            public WordList(String[] list){
                setBackground(theme.getBGColor());
                font = theme.getWordFont();
                layout = new GridLayout(5, 2);
                layout.setHgap(100);
                layout.setVgap(50);
                setLayout(layout);
                setBorder(new EmptyBorder(0, 100, 50, 100));

                for(int i = 0; i< 10; i++){
                    JLabel label = new JLabel(list[i]);
                    label.setFont(font);
                    label.setForeground(theme.getWordListColor());
                    label.setBorder(BorderFactory.createEmptyBorder(5, 0, 0, 0));
                    words[i] = label;
                    add(label);
                }
            }

            public JLabel getWord(String word){
                for(JLabel label : words)
                    if(label.getText().equals(word))
                        return label;
                return null;
            }

        }

    }
}
