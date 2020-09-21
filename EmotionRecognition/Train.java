import weka.core.*;
import weka.core.converters.*;
import weka.classifiers.functions.*;
import java.io.*;
class Train 
{
	public static void main(String[] args) 
	{
		  try {
            File myFile = new File("emotiontry_model.model");
        if (!myFile.exists()) {
           // Toast.makeText(this, "We had to make a new file", Toast.LENGTH_SHORT).show();
            myFile.createNewFile();
        }
            ConverterUtils.DataSource source = new ConverterUtils.DataSource("emotiontry.arff");
            Instances trainDataSet = source.getDataSet();
   trainDataSet.setClassIndex(trainDataSet.numAttributes() - 1);
            MultilayerPerceptron smo = new MultilayerPerceptron();
            smo.buildClassifier(trainDataSet);

            SerializationHelper.write("emotiontry_model.model", smo);


        } catch (Exception e) {
            e.printStackTrace();
        }
	}
}

