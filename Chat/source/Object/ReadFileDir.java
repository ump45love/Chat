package Object;

import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class ReadFileDir {
	String fileDir;
	File file;
	String name;
	boolean isOK;
	 public ReadFileDir() {
		 JFileChooser chooser = new JFileChooser();
		 FileNameExtensionFilter fliter = new FileNameExtensionFilter("jpg&png", "jpg","png");
		 chooser.setFileFilter(fliter);
	     int returnVal = chooser.showOpenDialog(null);
	     if(returnVal != JFileChooser.APPROVE_OPTION) {
	    	 JOptionPane.showMessageDialog(null, "파일을 선택하지 않으셨습니다.", "파일", JOptionPane.WARNING_MESSAGE);
	    	 fileDir = new String();
	    	 file = new File("");
	    	 isOK = false;
	    	 name = new String();
	     }
	     else {
	    	 file = chooser.getSelectedFile();
	    	 fileDir = chooser.getSelectedFile().getPath();
	    	 isOK = true;
	    	 name = chooser.getName(file);
	     }
	 }
	 
	 public String GetFileDir() {
		 System.out.println(fileDir);
		 return fileDir;
	 }
	 
	 public File GetFile() {
		 return file;
	 }
	 
	 public boolean IsOk() {
		 return isOK;
	 }
	 public String GetName() {
		 System.out.println(name);
		 return name;
	 }
}
