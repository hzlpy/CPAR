import java.io.*;

/* Classification application the CPAR (Classification based on Predictive 
Association Rules) algorithm proposed by Xiaoxin Yin and Jiawei Han.

Compile using:

javac ClassCPAR_App.java

Run using javaARM.exe, Example:

java ClassCPAR_App -FpimaIndians.D42.N768.C2.num -N2

(-F filename, -N number of classifiers).              */

public class ClassCPAR_App {

    // ------------------- FIELDS ------------------------

    // None

    // ---------------- CONSTRUCTORS ---------------------

    // None

    // ------------------ METHODS ------------------------

    public static void main(String[] args) throws IOException {

        // Create instance of class ClassificationCPAR
//        String s[] = null;
        CPAR_CARgen newClassification = new CPAR_CARgen(args);

        // Read data to be mined from file (method in AssocRuleMining class)
        newClassification.inputDataSet();
        newClassification.outputDataArraySize();

        // Create training and test data sets (method in ClassificationAprioriT class)
        // assuming a 50:50 split
        newClassification.createTrainingAndTestDataSets();

        // Mine data and generate CARs
        double time1 = (double) System.currentTimeMillis();
        double accuracy = newClassification.startClassification();
        newClassification.outputDuration(time1,(double) System.currentTimeMillis());

        // Output
        System.out.println("Accuracy = " + accuracy);
        newClassification.getCurrentRuleListObject().outputNumRules();
        newClassification.getCurrentRuleListObject().outputRules();

        // End
        System.exit(0);
    }
}
