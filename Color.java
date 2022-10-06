/**
 * This class can be used to represent colors.
 * Using the RGB color model.
 * @author Majed Girover
 */
public class Color {

    /**
     * An integer represents intensity of the Red color in RGB
     */
    private int r;

    /**
     * An integer represents intensity of the Green color in RGB
     */
    private int g;

    /**
     * An integer represents intensity of the Blue color in RGB
     */
    private int b;

    /**
     * Default constructor
     */
    public Color(){
        this(0, 0, 0);
    }

    /**
     * Set-Constructor
     * @param r int
     * @param g int
     * @param b int
     */
    public Color(int r, int g, int b){
        set(r, g, b);
    }

    /**
     * Copy-Constructor
     * @param color Color
     */
    public Color(Color color){
        this(color.getR(), color.getG(), color.getB());
    }

    /**
     * This method sets new color by providing intensity of each color in RGB
     * @param r int
     * @param g int
     * @param b int
     */
    public void set(int r, int g, int b){
        
        if (!validIntensity(r) || !validIntensity(g) || !validIntensity(b)) {
            System.out.println("The intensity must be between 0 and 500");
            System.out.println("in the method set()");

            System.exit(0);
        }
        
        setR(r);
        setG(g);
        setB(b);
    }

    /**
     * This method sets the intensity of red color
     * @param r int
     */
    public void setR(int r) {
        this.r = r;
    }

    /**
     * This method sets the intensity of green color
     * @param g int
     */
    public void setG(int g) {
        this.g = g;
    }

    /**
     * This method sets the intensity of blue color
     * @param b int
     */
    public void setB(int b) {
        this.b = b;
    }

    /**
     * This method returns the intensity of Red color in the color object.
     * @return int
     */
    public int getR(){
        return r;
    }
    /**
     * This method returns the intensity of Green color in the color object.
     * @return int
     */
    public int getG(){
        return g;
    }
    /**
     * This method returns the intensity of Blue color in the color object.
     * @return int
     */
    public int getB(){
        return b;
    }

    /**
     * This method determines of the color is equal to the color that is provided as argument.
     * @param color Color
     * @return boolean
     */
    public boolean equals(Color color) {
        return r  == color.getR() && 
               g  == color.getG() && 
               b  == color.getB() 
                ? true 
                : false;
    }

    /**
     * This method checks if the color is red or not.
     * @return boolean
     */
    public boolean isRed() {
        return r == 255 && g == 0 && b == 0 ? true : false;
    }
    
    /**
     * This method checks if the color is green or not.
     * @return boolean
     */
    public boolean isGreen() {
        return r==0 && g == 255 && b == 0 ? true : false;
    }
    
    /**
     * This method checks if the color is blue or not.
     * @return boolean
     */
    public boolean isBlue() {
        return r == 0 && g == 0 && b == 255 ? true : false;
    }
    
    /**
     * This method checks if the color is black or not.
     * @return boolean
     */
    public boolean isBlack() {
        return r == 0 && g == 0 && b == 0 ? true : false;
    }

    /**
     * This method validate the intensity of the color that is provided by the user.
     * @param intensity int
     * @return boolean
     */
    private boolean validIntensity(int intensity){
        return 0 > intensity || intensity > 255 ? false : true;
    }

    /**
     * This method prints the color as string
     * @return String
     */
    public String toString() {
        if (isRed()) {
            return "[Red]";
        }
        if (isGreen()) {
            return "[Green]";
        }
        if (isBlue()) {
            return "[Blue]";
        }
        if (isBlack()) {
            return "[Black]";
        }
        return "[" + r + "," + g + "," + b + "]";
    }
}
