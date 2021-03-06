/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package demo.sphinx.helloworld;

import edu.cmu.sphinx.frontend.util.Microphone;
import edu.cmu.sphinx.recognizer.Recognizer;
import edu.cmu.sphinx.result.Result;
import edu.cmu.sphinx.util.props.ConfigurationManager;
import edu.cmu.sphinx.util.props.PropertyException;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import javax.swing.JOptionPane;

/**
 *
 * @author TOSHIBA
 */
public class SpeechToText extends javax.swing.JFrame {

    /**
     * Creates new form SpeechToText
     */
    public SpeechToText() {
        initComponents();
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        speechText2 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        speechText = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        speechText2.setFont(new java.awt.Font("Iskoola Pota", 0, 11)); // NOI18N

        speechText.setColumns(20);
        speechText.setFont(new java.awt.Font("Iskoola Pota", 0, 18)); // NOI18N
        speechText.setLineWrap(true);
        speechText.setRows(5);
        jScrollPane1.setViewportView(speechText);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(speechText2, javax.swing.GroupLayout.DEFAULT_SIZE, 491, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(speechText2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(108, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
   static SpeechToText stt;
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SpeechToText.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SpeechToText.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SpeechToText.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SpeechToText.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               stt= new SpeechToText();
               stt.setVisible(true);
            }
        });
        
        try {
            URL url;
            if (args.length > 0) {
                url = new File(args[0]).toURI().toURL();
            } else {
                url = HelloWorld.class.getResource("helloworld.config.xml");
            }

            System.out.println("Loading...");

            ConfigurationManager cm = new ConfigurationManager(url);

	    Recognizer recognizer = (Recognizer) cm.lookup("recognizer");
	    Microphone microphone = (Microphone) cm.lookup("microphone");
            
            
            /* allocate the resource necessary for the recognizer */
            recognizer.allocate();
            
            /* the microphone will keep recording until the program exits */
	    if (microphone.startRecording()) {
                
		System.out.println
		    ("Say: (Good morning | Hello) " +
                     "( Bhiksha | Evandro | Paul | Philip | Rita | Will )");

		while (true) {
		    System.out.println
			("Start speaking. Press Ctrl-C to quit.\n");

                    /*
                     * This method will return when the end of speech
                     * is reached. Note that the endpointer will determine
                     * the end of speech.
                     */ 
		    Result result = recognizer.recognize();
		    
		    if (result != null) {
			String resultText = result.getBestFinalResultNoFiller();
                                                            
			//System.out.println("You said: " + resultText + "\n");
                        System.out.println("Success");
//                        stt.speechText.setText(resultText);
                        if(resultText.equals("පරික්ෂාකරන්න")){
                            JOptionPane.showMessageDialog(stt, "Searching ...");
                        }
                        stt.speechText.append(resultText+" ");
                        //stt.speechText.setText(stt.speechText.getText()+resultText);
                        /////////////////////////////////////////
                        /*if(resultText.equalsIgnoreCase("open command")){
                            try {
                                Process p=Runtime.getRuntime().exec("cmd /c start cmd");
                            } catch (Exception e) {
                            }
                        }
                        if(resultText.equalsIgnoreCase("close command")){
                            try {
                                Process p=Runtime.getRuntime().exec("cmd /c start taskkill /im cmd.exe /f");
                            } catch (Exception e) {
                            }
                        }
                        if(resultText.equalsIgnoreCase("open calculator")){
                            try {
                                Process p=Runtime.getRuntime().exec("cmd /c start calc.exe");
                            } catch (Exception e) {
                            }
                        }
                        if(resultText.equalsIgnoreCase("close calculator")){
                            try {
                                Process p=Runtime.getRuntime().exec("cmd /c start taskkill /im calc.exe /f");
                            } catch (Exception e) {
                            }
                        }*/
                        /////////////////////////////////////////
		    } else {
			System.out.println("I can't hear what you said.\n");
		    }
		}
	    } else {
		System.out.println("Cannot start microphone.");
		recognizer.deallocate();
		System.exit(1);
	    }
        } catch (IOException e) {
            System.err.println("Problem when loading HelloWorld: " + e);
            e.printStackTrace();
        } catch (PropertyException e) {
            System.err.println("Problem configuring HelloWorld: " + e);
            e.printStackTrace();
        } catch (InstantiationException e) {
            System.err.println("Problem creating HelloWorld: " + e);
            e.printStackTrace();
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea speechText;
    private javax.swing.JTextField speechText2;
    // End of variables declaration//GEN-END:variables
}
