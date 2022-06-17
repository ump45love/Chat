package ImageFile;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class ReadImage {
	FileInputStream read;
	byte data[];
	BufferedImage image;
	
	
	public ReadImage(String dir){
		try {
			read = new FileInputStream(dir);
			image = resize(read,50,50);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(image, "jpg", baos);
            data= baos.toByteArray();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ReadImage (byte data[]){
		this.data = data;
	}
	
	public byte[] Getbyte() {
		return data;
	}
	
	public BufferedImage resize(InputStream stream, int width, int height) {
		BufferedImage i = null;
		try {
			i = ImageIO.read(stream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BufferedImage newImage = new BufferedImage(width, height, i.getType());
        Graphics2D g = newImage.createGraphics();
        g.drawImage(i, 0, 0, width,height,null);
        g.dispose();
        return newImage;
	}
	
	public Image GetImage() {
	      ByteArrayInputStream bis = new ByteArrayInputStream(data);
	      BufferedImage image = null;
		try {
			image = ImageIO.read(bis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return image;
	}
	
	
}
