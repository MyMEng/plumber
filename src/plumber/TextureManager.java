package plumber;

import java.awt.image.BufferedImage;
import java.net.URL;
import java.util.HashMap;
import javax.imageio.ImageIO;

public class TextureManager
{
    private TextureManager()
    {
        textures = new HashMap<String, BufferedImage>();
    }
    private HashMap<String, BufferedImage> textures;
    
    private static TextureManager instance;
    
    public static BufferedImage get(String textureName)
    {
        if(instance == null)
            instance = new TextureManager();

        if(!instance.textures.containsKey(textureName))
        {
            BufferedImage img = null;
            URL url = instance.getClass().getResource("gfx/" + textureName);
            try
            {
                img = ImageIO.read(url);
            }
            catch(Exception ex)
            {
                System.err.print(url);
                throw new Error("Error while reading from a file: " + ex.getMessage());
            }
            instance.textures.put(textureName, img);
            return img;
        }

        return instance.textures.get(textureName);
    }
}
