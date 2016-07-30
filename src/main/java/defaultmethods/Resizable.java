package defaultmethods;

/**
 * Created by ahmad on 07/10/15.
 */
public interface Resizable extends Drawable {

    public int getWidth();
    public int getHeight();
    public void setWidth(int width);
    public void setHeight(int height);
    public void setAbsoluteSize(int width, int height);

    // public void setRelativeSize(int widthFactor, int heightFactor);

    public default void setRelativeSize(int widthFactor, int heightFactor) {
        setAbsoluteSize(getWidth() / widthFactor, getHeight() / heightFactor);
    }

}