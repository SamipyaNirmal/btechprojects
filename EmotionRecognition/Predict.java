import java.util.ArrayList;
import java.util.List;
import java.io.*;
import weka.classifiers.Classifier;
import weka.core.Attribute;
import weka.core.DenseInstance;
import weka.core.Instances;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;  
public class Predict
{

    public static void main(String[] args) {
        double[] varr=new double[30];
		 int j=0;
	     String res="";
		try {

	   
			FileReader fr = new FileReader("C:/Users/samipyalahari/Desktop/matlab/try/mfcc.txt");
			BufferedReader br = new BufferedReader(fr);
			FileReader fr1 = new FileReader("C:/Users/samipyalahari/Desktop/matlab/try/fbes.txt");
			BufferedReader br1 = new BufferedReader(fr1);

			String str;
			

			while ((str = br.readLine()) != null) {
				varr[j++]=Double.parseDouble(str);
				 
					}
			while ((str = br1.readLine()) != null) {
				
             varr[j++]=Double.parseDouble(str);
			}

		} catch (IOException e) {

			e.printStackTrace();

		}
         
 
        // we need those for creating new instances later
        final Attribute attributemf1 = new Attribute("mfcc1");
        final Attribute attributemf2 = new Attribute("mfcc2");
        final Attribute attributemf3 = new Attribute("mfcc3");
        final Attribute attributemf4 = new Attribute("mfcc4");
		final Attribute attributemf5 = new Attribute("mfcc5");
		final Attribute attributemf6 = new Attribute("fbe1");
		final Attribute attributemf7 = new Attribute("fbe2");
		final Attribute attributemf8 = new Attribute("fbe3");
		final Attribute attributemf9 = new Attribute("fbe4");
		final Attribute attributemf10 = new Attribute("fbe5");
		
        final List<String> classes = new ArrayList<String>() {
            {
                add("angry");
                add("happy");
                add("sad");
				add("neutral");
				add("fear");
				
            }
        };
 
        // Instances(...) requires ArrayList<> instead of List<>...
        ArrayList<Attribute> attributeList = new ArrayList<Attribute>(2) {
            {
                add(attributemf1);
                add(attributemf2);
                add(attributemf3);
                add(attributemf4);
				add(attributemf5);
				add(attributemf6);
				add(attributemf7);
				add(attributemf8);
                add(attributemf9);
                add(attributemf10);
				
                Attribute attributeClass = new Attribute("@@class@@", classes);
                add(attributeClass);
            }
        };
        // unpredicted data sets (reference to sample structure for new instances)
        Instances dataUnpredicted = new Instances("TestInstances",attributeList, 1);
        // last feature is target variable
        dataUnpredicted.setClassIndex(dataUnpredicted.numAttributes() - 1); 
 
        // create new instance: this one should fall into the setosa domain
        DenseInstance newInstanceAngry = new DenseInstance(dataUnpredicted.numAttributes()) {
            {
                setValue(attributemf1,varr[0]);
				setValue(attributemf2,varr[1]);
				setValue(attributemf3,varr[2]);
				setValue(attributemf4,varr[3]);
				setValue(attributemf5,varr[4]);
				setValue(attributemf6,varr[5]);
				setValue(attributemf7,varr[6]);
				setValue(attributemf8,varr[7]);
				setValue(attributemf9,varr[8]);
				setValue(attributemf10,varr[9]);
				
                
            }
        };
        
         
        // instance to use in prediction
        DenseInstance newInstance = newInstanceAngry;
        // reference to dataset
        newInstance.setDataset(dataUnpredicted);
 
        // import ready trained model
        Classifier cls = null;
        try {
   cls = (Classifier) weka.core.SerializationHelper.read("emotiontry_model.model");
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (cls == null)
            return;
 
        // predict new sample
        try {
            double result = cls.classifyInstance(newInstance);
  System.out.println("Index of predicted class label: " + result + ", which corresponds to class: " + classes.get(new Double(result).intValue()));
       res=classes.get(new Double(result).intValue());
		} 
		catch (Exception e) {
            e.printStackTrace();
        }
        JFrame f=new JFrame();
		f.setSize(1000, 750);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setLayout(new GridLayout());
		  if (res.equals("sad"))
		  {
       ImageIcon image = new ImageIcon("C:/Users/samipyalahari/Desktop/major/sad.png");
        JLabel imageLabel = new JLabel(image); 
        f.add(imageLabel);
		imageLabel.setBounds(10, 10, 300, 300);
         imageLabel.setVisible(true);
		 JTextArea area=new JTextArea("You are sad\n1.Stop Overthinking\n2.Surround Yourself With Loved ones\n3.Watch your favourite movies!\n4.Recall your happy memories");
		 Font fo = new java.awt.Font("TimesRoman",Font.BOLD,36);
		 area.setFont(fo);
        area.setBounds(10,30, 200,200);  
        f.add(area);
		  }
 if (res.equals("happy"))
		  {
       ImageIcon image = new ImageIcon("C:/Users/samipyalahari/Desktop/major/happy.png");
        JLabel imageLabel = new JLabel(image); 
        f.add(imageLabel);
		imageLabel.setBounds(10, 10, 200, 200);
         imageLabel.setVisible(true);
		  JTextArea area=new JTextArea("Great!! You are happy\nKeep Smiling and Make others HAPPY");
		 Font fo = new java.awt.Font("TimesRoman",Font.BOLD,36);
		 area.setFont(fo);
        area.setBounds(10,30, 200,200);  
        f.add(area);
		  }
 if (res.equals("angry"))
		  {
       ImageIcon image = new ImageIcon("C:/Users/samipyalahari/Desktop/major/angry.jpg");
        JLabel imageLabel = new JLabel(image); 
        f.add(imageLabel);
		imageLabel.setBounds(10, 10, 400, 400);
         imageLabel.setVisible(true);
		  Font fo = new java.awt.Font("TimesRoman",Font.BOLD,36);
		 JTextArea area=new JTextArea("Ohh!! You are angry...\nHere are some tips for you!!\n 1. Think before you speak \n2. Once you're calm, express your anger\n3. Get some exercise\n4. Take a timeout\n5. Identify possible solutions"); 
		 area.setFont(fo);
		 
        area.setBounds(10,30, 200,200);  
        f.add(area);
		
		  }
 if (res.equals("fear"))
		  {
       ImageIcon image = new ImageIcon("C:/Users/samipyalahari/Desktop/major/fear.jpg");
        JLabel imageLabel = new JLabel(image); 
        f.add(imageLabel);
		imageLabel.setBounds(10, 10, 200, 200);
         imageLabel.setVisible(true);
		 JTextArea area=new JTextArea("You are scared of something!\n1.Assess the situation\n2.Breathe\n3.Write down what you are scared of\n4.Tell Someone");  
        Font fo = new java.awt.Font("TimesRoman",Font.BOLD,36);
		 area.setFont(fo);
		area.setBounds(10,30, 200,200);  
        f.add(area);
		  }
 if (res.equals("neutral"))
		  {
       ImageIcon image = new ImageIcon("C:/Users/samipyalahari/Desktop/major/neutral.png");
        JLabel imageLabel = new JLabel(image); 
        f.add(imageLabel);
		imageLabel.setBounds(10, 10, 400, 400);
         imageLabel.setVisible(true);
		 JTextArea area=new JTextArea("Neutral\n0 emotions=0 Enemies\nSay CHEESE!!");  
		 Font fo = new java.awt.Font("TimesRoman",Font.BOLD,36);
		 area.setFont(fo);
        area.setBounds(10,30, 200,200);  
        f.add(area);
		  }


    }//main
}