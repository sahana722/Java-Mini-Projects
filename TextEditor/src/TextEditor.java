import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;


public class TextEditor implements ActionListener {
    // declaring properties of TextEditor
    JFrame frame;
    JMenuBar menuBar;

    JMenu file, edit;
    JMenuItem newFile, openFile, saveFile; //File Menu items

    JMenuItem cut, copy, paste, selectAll, close; //Edit Menu items

    JTextArea textArea;

    TextEditor(){
       //Initialize a frame
       frame = new JFrame();

       //Initialize menuBar
        menuBar = new JMenuBar();

        //Initialize textArea
        textArea = new JTextArea();

        //initialize menus
        file = new JMenu("File");
        edit = new JMenu("Edit");

        //Initialize file menu items
        newFile = new JMenuItem("New Window");
        openFile = new JMenuItem("Open File");
        saveFile = new JMenuItem("Save File");

        //adding action listener to file items
        newFile.addActionListener(this);
        openFile.addActionListener(this);
        saveFile.addActionListener(this);


        //Add menu items to file menu
        file.add(newFile);
        file.add(openFile);
        file.add(saveFile);

        //Initialize edit menu items
        cut = new JMenuItem("Cut");
        copy = new JMenuItem("Copy");
        paste = new JMenuItem("Paste");
        selectAll = new JMenuItem("Select All");
        close = new JMenuItem("Close");

        //adding action Listener to edit items
        cut.addActionListener(this);
        copy.addActionListener(this);
        paste.addActionListener(this);
        selectAll.addActionListener(this);
        close.addActionListener(this);

        //Add edit menu items to edit menu
        edit.add(cut);
        edit.add(copy);
        edit.add(paste);
        edit.add(selectAll);
        edit.add(close);

        //add menus to menuBar
        menuBar.add(file);
        menuBar.add(edit);

        //set menuBar to frame
        frame.setJMenuBar(menuBar);
        //create content pane
        JPanel panel = new JPanel();
        panel.setBorder(new EmptyBorder(5,5,5,5));
        panel.setLayout(new BorderLayout(0,0));
        //add text area to panel
        panel.add(textArea, BorderLayout.CENTER);
        //create scroll pane
        JScrollPane scrollPane= new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        //Add scroll pane to panel
        panel.add(scrollPane);
        //add panel to frame
        frame.add(panel);

       // set dimensions of frame
        frame.setBounds(100,100,400,400);
        frame.setTitle("Text Editor");
        frame.setVisible(true);
        frame.setLayout(null);
    }
    @Override
    public void actionPerformed(ActionEvent actionEvent){
       if(actionEvent.getSource()==cut){
           //performing cut operation
           textArea.cut();
       }
       if(actionEvent.getSource()==copy){
           textArea.copy(); // performing copy operation
       }
       if(actionEvent.getSource()==paste){
           textArea.paste(); //performing paste operation
       }
       if(actionEvent.getSource()==selectAll){
           textArea.selectAll(); //performing selectAll operation
       }
       if(actionEvent.getSource()==close){
           System.exit(0); //performing close editor operation
       }
       if(actionEvent.getSource()==openFile){
           //open a file chooser
           JFileChooser fileChooser = new JFileChooser("C:");
           int chooseOption = fileChooser.showOpenDialog(null);
           //If we have clicked on open button
           if(chooseOption==JFileChooser.APPROVE_OPTION){
               //Getting selected file
               File file = fileChooser.getSelectedFile();
               //Get the path of selected file
               String filePath = file.getPath();
               try{
                   //Initialize file reader
                   FileReader fileReader= new FileReader(filePath);
                   //Initialize buffer reader
                   BufferedReader bufferedReader = new BufferedReader(fileReader);
                   String intermediate = "", output="";
                   //Read content from file line by line
                   while((intermediate = bufferedReader.readLine())!=null){
                       output+=intermediate+"\n";
                   }
                   textArea.setText(output);

               }
               catch(IOException ioException){
                   ioException.printStackTrace();
               }
           }

       }
       if(actionEvent.getSource()==saveFile){
           //Initialize file picker
           JFileChooser fileChooser = new JFileChooser("C:");
           //get choose option from file chooser
           int chooseOption = fileChooser.showSaveDialog(null);
           //check if we clicked on save button
           if(chooseOption==JFileChooser.APPROVE_OPTION){
               //Create a new file with chosen directory path and file name
               File file = new File(fileChooser.getSelectedFile().getAbsolutePath()+".txt");
               try{
                  //Initialize file writer
                   FileWriter fileWriter = new FileWriter(file);
                   //Initialize buffer writer
                   BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                   //write contents of text area to file
                   textArea.write(bufferedWriter);
                   bufferedWriter.close();
               }
               catch (IOException ioException){
                   ioException.printStackTrace();
               }
           }
       }
        if(actionEvent.getSource()==newFile){
            TextEditor newTextEditor = new TextEditor();
        }
    }

    public static void main(String[] args) {
        TextEditor textEditor = new TextEditor();
    }
}