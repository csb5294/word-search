import java.awt.*;
import java.awt.font.TextAttribute;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

public enum Theme {

    COUNTRIES {
        @Override
        public Font getTitleFont() {
            try {
                GraphicsEnvironment ge =
                        GraphicsEnvironment.getLocalGraphicsEnvironment();
                ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("C:\\Users\\lisab\\Downloads\\Castoro_Titling\\CastoroTitling-Regular.ttf")));
            } catch (IOException | FontFormatException e) {}

            return new Font("Castoro Titling", Font.PLAIN, 60);
        }

        @Override
        public Font getWordFont() {
            try {
                GraphicsEnvironment ge =
                        GraphicsEnvironment.getLocalGraphicsEnvironment();
                ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("C:\\Users\\lisab\\Downloads\\Castoro_Titling\\CastoroTitling-Regular.ttf")));
            } catch (IOException | FontFormatException e) {
                //Handle exception
            }

            return new Font("Castoro Titling", Font.PLAIN, 30);
        }

        @Override
        public Color getBGColor() {
            return new Color(102,153,255);
        }

        @Override
        public Color getSearchColor() {
            return new Color(0, 153, 51);
        }

        @Override
        public Font getStrikeFont() {
            Font font = new Font("Castoro Titling", Font.PLAIN, 30);
            Map attributes = font.getAttributes();
            attributes.put(TextAttribute.STRIKETHROUGH, TextAttribute.STRIKETHROUGH_ON);
            return new Font(attributes);
        }

        @Override
        public ArrayList<String> getWordList() {
            return new ArrayList<>(Arrays.asList("USA", "CANADA", "MEXICO", "BRAZIL", "ARGENTINA", "RUSSIA", "UNITEDKINGDOM", "IRELAND", "ITALY", "SPAIN", "FRANCE", "GREECE", "AUSTRALIA", "SOUTHAFRICA", "ALGERIA", "NEWZEALAND", "MOROCCO", "MADAGASCAR", "INDIA", "CHINA", "JAPAN", "TURKEY", "SWEDEN", "EGYPT", "PORTUGAL", "INDONESIA"));
        }

        @Override
        public Color getSearchLetterColor() {
            return Color.BLACK;
        }

        @Override
        public Color getWordListColor() {
            return Color.BLACK;
        }

        @Override
        public Color getHighlightColor() {
            return new Color(102,153,255);
        }

        @Override
        public Color getFakeHighlightColor() {
            return new Color(103,153,255);
        }

        @Override
        public String getName() {
            return "COUNTRIES";
        }
    },

    CANDYLAND{
        @Override
        public Font getTitleFont() {
            try {
                GraphicsEnvironment ge =
                        GraphicsEnvironment.getLocalGraphicsEnvironment();
                ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("C:\\Users\\lisab\\Downloads\\candy-stripe-brk\\candystr.ttf")));
            } catch (IOException | FontFormatException e) {
                //Handle exception
            }

            return new Font("Candy Stripe (BRK)", Font.PLAIN, 60);
        }

        @Override
        public Font getWordFont() {
            try {
                GraphicsEnvironment ge =
                        GraphicsEnvironment.getLocalGraphicsEnvironment();
                ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("C:\\Users\\lisab\\Downloads\\candy-stripe-brk\\candystr.ttf")));
            } catch (IOException | FontFormatException e) {
                //Handle exception
            }

            return new Font("Candy Stripe (BRK)", Font.PLAIN, 30);
        }

        @Override
        public Color getBGColor() {
            return new Color(220, 208, 255);
        }

        @Override
        public Color getSearchColor() {
            return new Color(231,84,128);
        }

        @Override
        public Font getStrikeFont() {
            Font font = new Font("Candy Stripe (BRK)", Font.PLAIN, 30);
            Map attributes = font.getAttributes();
            attributes.put(TextAttribute.STRIKETHROUGH, TextAttribute.STRIKETHROUGH_ON);
            return new Font(attributes);
        }

        @Override
        public ArrayList<String> getWordList() {
            return new ArrayList<>(Arrays.asList("CANDY", "KITKAT", "SNICKERS", "TWIX", "CANDYCANE", "GUMDROP", "LICORICE", "PEPPERMINT", "TAFFY", "CHOCOLATE", "SUGAR", "SWEETTOOTH", "SKITTLES", "STARBURST", "JELLYBEAN", "LOLLIPOP", "MARSHMALLOW", "CHERRY", "GUMBALL", "CARAMEL", "FUDGE", "GUMMYBEAR", "SMARTIES", "TREAT", "TOFFEE", "SOUR"));
        }

        @Override
        public Color getSearchLetterColor() {
            return new Color(250, 250, 210);
        }

        @Override
        public Color getWordListColor() {
            return Color.RED;
        }

        @Override
        public Color getHighlightColor() {
            return Color.RED;
        }

        @Override
        public Color getFakeHighlightColor() {
            return new Color(255, 0, 1);
        }

        @Override
        public String getName() {
            return "CANDYLAND";
        }
    },

    OCEAN{
        @Override
        public Font getTitleFont() {
            try {
                GraphicsEnvironment ge =
                        GraphicsEnvironment.getLocalGraphicsEnvironment();
                ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("C:\\Users\\lisab\\Downloads\\bubble-bobble-font\\BubbleBobble-rg3rx.ttf")));
            } catch (IOException | FontFormatException e) {
                //Handle exception
            }

            return new Font("Bubble Bobble", Font.PLAIN, 60);

        }

        @Override
        public Font getWordFont() {
            try {
                GraphicsEnvironment ge =
                        GraphicsEnvironment.getLocalGraphicsEnvironment();
                ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("C:\\Users\\lisab\\Downloads\\bubble-bobble-font\\BubbleBobble-rg3rx.ttf")));
            } catch (IOException | FontFormatException e) {
                //Handle exception
            }

            return new Font("Bubble Bobble", Font.PLAIN, 30);
        }

        @Override
        public Color getBGColor() {
            return new Color(194, 178, 128);
        }

        @Override
        public Color getSearchColor() {
            return new Color(153,187,255);
        }

        @Override
        public Font getStrikeFont() {
            Font font = new Font("Bubble Bobble", Font.PLAIN, 30);
            Map attributes = font.getAttributes();
            attributes.put(TextAttribute.STRIKETHROUGH, TextAttribute.STRIKETHROUGH_ON);
            return new Font(attributes);
        }

        @Override
        public ArrayList<String> getWordList() {
            return new ArrayList<>(Arrays.asList("SEA", "OCEAN", "SHORE", "FISH", "SHARK", "SQUID", "SHELL", "SAND", "TURTLE", "OCTOPUS", "STARFISH", "SEAHORSE", "CURRENT", "SHIP", "KELP", "JELLYFISH", "SAILOR", "MERMAID", "PIRATE", "CRAB", "LOBSTER", "WHALE", "RAY", "DOLPHIN", "BUOY", "TIDEPOOL"));
        }

        @Override
        public Color getSearchLetterColor() {
            return new Color(0, 17, 102);
        }

        @Override
        public Color getWordListColor() {
            return new Color(0, 17, 102);
        }

        @Override
        public Color getHighlightColor() {
            return new Color(194, 178, 128);
        }

        @Override
        public Color getFakeHighlightColor() {
            return new Color(195, 178, 128);
        }

        @Override
        public String getName() {
            return "OCEAN";
        }
    },

    SPACE{
        @Override
        public Font getTitleFont() {
            try {
                GraphicsEnvironment ge =
                        GraphicsEnvironment.getLocalGraphicsEnvironment();
                ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("C:\\Users\\lisab\\Downloads\\alone-in-space-font\\AloneInSpaceReguler-qZ2xr.ttf")));
            } catch (IOException | FontFormatException e) {
                //Handle exception
            }

            return new Font("Alone In Space", Font.BOLD, 50);
        }

        @Override
        public Font getWordFont() {
            try {
                GraphicsEnvironment ge =
                        GraphicsEnvironment.getLocalGraphicsEnvironment();
                ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("C:\\Users\\lisab\\Downloads\\alone-in-space-font\\AloneInSpaceReguler-qZ2xr.ttf")));
            } catch (IOException | FontFormatException e) {
                //Handle exception
            }

            return new Font("Alone In Space", Font.PLAIN, 20);
        }

        @Override
        public Color getBGColor() {
            return new Color(46,26,71);
        }

        @Override
        public Color getSearchColor() {
            return Color.BLACK;
        }

        @Override
        public Font getStrikeFont() {
            Font font = new Font("Alone In Space", Font.PLAIN, 20);
            Map attributes = font.getAttributes();
            attributes.put(TextAttribute.STRIKETHROUGH, TextAttribute.STRIKETHROUGH_ON);
            return new Font(attributes);
        }

        @Override
        public ArrayList<String> getWordList() {
            return new ArrayList<>(Arrays.asList("SPACE", "STAR", "PLANET", "ASTRONAUT", "COMET", "ASTEROID", "MERCURY", "VENUS", "EARTH", "MARS", "JUPITER", "SATURN", "URANUS", "NEPTUNE", "SUN", "ALIEN", "GALAXY", "BLACKHOLE", "TELESCOPE", "CRATER", "ORBIT", "LIGHTYEAR", "MILKYWAY", "NEBULA", "UNIVERSE", "MOON"));
        }

        @Override
        public Color getSearchLetterColor() {
            return Color.WHITE;
        }

        @Override
        public Color getWordListColor() {
            return Color.WHITE;
        }

        @Override
        public Color getHighlightColor() {
            return new Color(46,26,71);
        }

        @Override
        public Color getFakeHighlightColor() {
            return new Color(47,26,71);
        }

        @Override
        public String getName() {
            return "SPACE";
        }
    },
    FOREST{
        @Override
        public Font getTitleFont() {

            try {
                GraphicsEnvironment ge =
                        GraphicsEnvironment.getLocalGraphicsEnvironment();
                ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("C:\\Users\\lisab\\Downloads\\Indie_Flower\\IndieFlower-Regular.ttf")));
            } catch (IOException | FontFormatException e) {
                //Handle exception
            }

            return new Font("Indie Flower", Font.BOLD, 60);
        }

        @Override
        public Font getWordFont() {
            try {
                GraphicsEnvironment ge =
                        GraphicsEnvironment.getLocalGraphicsEnvironment();
                ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("C:\\Users\\lisab\\Downloads\\Indie_Flower\\IndieFlower-Regular.ttf")));
            } catch (IOException | FontFormatException e) {
                //Handle exception
            }

            return new Font("Indie Flower", Font.PLAIN, 30);
        }

        @Override
        public Color getBGColor() {
            return new Color(34, 139, 34);
        }

        @Override
        public Color getSearchColor() {
            return new Color(150, 75, 0);
        }

        @Override
        public Font getStrikeFont() {
            Font font = new Font("Indie Flower", Font.PLAIN, 30);
            Map attributes = font.getAttributes();
            attributes.put(TextAttribute.STRIKETHROUGH, TextAttribute.STRIKETHROUGH_ON);
            return new Font(attributes);
        }

        @Override
        public ArrayList<String> getWordList() {
            return new ArrayList<>(Arrays.asList("SQUIRREL", "TREE", "LEAF", "GRASS", "BUSH", "PINE", "OAK", "POND", "BIRD", "FLOWER", "NEST", "ANT", "STONE", "WOOD", "LOG", "CANOPY", "RIVER", "ANIMAL", "DIRT", "PLANT", "FOX", "BUG", "FROG", "BARK", "DEER", "BERRY"));
        }

        @Override
        public Color getSearchLetterColor() {
            return Color.BLACK;
        }

        @Override
        public Color getWordListColor() {
            return Color.BLACK;
        }

        @Override
        public Color getHighlightColor() {
            return new Color(255, 255, 0);
        }

        @Override
        public Color getFakeHighlightColor() {
            return new Color(254, 255, 0);
        }

        @Override
        public String getName() {
            return "FOREST";
        }
    };


    public abstract Font getTitleFont();
    public abstract Font getWordFont();
    public abstract Color getBGColor();
    public abstract Color getSearchColor();
    public abstract Font getStrikeFont();
    public abstract ArrayList<String> getWordList();
    public abstract Color getSearchLetterColor();
    public abstract Color getWordListColor();
    public abstract Color getHighlightColor();
    public abstract Color getFakeHighlightColor();
    public abstract String getName();

}
