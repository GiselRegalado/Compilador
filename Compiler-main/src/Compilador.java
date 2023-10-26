
import com.formdev.flatlaf.FlatIntelliJLaf;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import compilerTools.Directory;
import compilerTools.ErrorLSSL;
import compilerTools.Functions;
import compilerTools.Production;
import compilerTools.TextColor;
import compilerTools.Token;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.JTextComponent;

public class Compilador extends javax.swing.JFrame {

    private DefaultTableModel modeloTabla;
    private String title;
    private Directory directorio;
    private ArrayList<Token> tokens;
    private ArrayList<ErrorLSSL> errors;
    private ArrayList<TextColor> textsColor;
    private Timer timerKeyReleased;
    private ArrayList<Production> identProd;
    private HashMap<String, String> identificadores;
    private boolean codeHasBeenCompiled = false;

    //constructor
    public Compilador() {
        initComponents();
        init();

    }

    private void init() {
        title = "Compiler";
        setLocationRelativeTo(null);
        setTitle(title);
        directorio = new Directory(this, escritura, title, ".comp");
        addWindowListener(new WindowAdapter() {// Cuando presiona la "X" de la esquina superior derecha
            @Override
            public void windowClosing(WindowEvent e) {
                directorio.Exit();
                System.exit(0);
            }
        });
        Functions.setLineNumberOnJTextComponent(escritura);
        timerKeyReleased = new Timer((int) (1000 * 0.3), (ActionEvent e) -> {
            timerKeyReleased.stop();
            colorAnalysis();
        });
        Functions.insertAsteriskInName(this, escritura, () -> {
            timerKeyReleased.restart();
        });
        tokens = new ArrayList<>();
        errors = new ArrayList<>();
        textsColor = new ArrayList<>();
        identProd = new ArrayList<>();
        identificadores = new HashMap<>();
        Functions.setAutocompleterJTextComponent(new String[]{}, escritura, () -> {
            timerKeyReleased.restart();
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu2 = new javax.swing.JPopupMenu();
        jMenuItem12 = new javax.swing.JMenuItem();
        jMenuItem14 = new javax.swing.JMenuItem();
        jMenuItem15 = new javax.swing.JMenuItem();
        jMenuItem16 = new javax.swing.JMenuItem();
        jMenuItem17 = new javax.swing.JMenuItem();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu4 = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();
        rootPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        escritura = new javax.swing.JTextPane();
        panelButtonCompilerExecute = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        btnCompilar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        mensajes = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        tablaPila = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();

        jMenuItem12.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem12.setText("Cortar");
        jMenuItem12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem12jmiCortar(evt);
            }
        });
        jPopupMenu2.add(jMenuItem12);

        jMenuItem14.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem14.setText("Copiar");
        jMenuItem14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem14jmiCopiar(evt);
            }
        });
        jPopupMenu2.add(jMenuItem14);

        jMenuItem15.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem15.setText("Pegar");
        jMenuItem15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem15jmiPegar(evt);
            }
        });
        jPopupMenu2.add(jMenuItem15);

        jMenuItem16.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_DELETE, 0));
        jMenuItem16.setText("Borrar");
        jMenuItem16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem16jmiBorrar(evt);
            }
        });
        jPopupMenu2.add(jMenuItem16);

        jMenuItem17.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem17.setText("Seleccionar Todo");
        jMenuItem17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem17jmiSeleccionarTodo(evt);
            }
        });
        jPopupMenu2.add(jMenuItem17);

        jMenu4.setText("File");
        jMenuBar2.add(jMenu4);

        jMenu5.setText("Edit");
        jMenuBar2.add(jMenu5);

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.LINE_AXIS));

        escritura.setComponentPopupMenu(jPopupMenu2);
        jScrollPane1.setViewportView(escritura);

        jButton1.setText("📄");
        jButton1.setToolTipText("Nuevo archivo..");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("📂");
        jButton2.setToolTipText("Abrir archivo...");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("📝");
        jButton3.setToolTipText("Guardar el archivo...");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        btnCompilar.setText("▶");
        btnCompilar.setToolTipText("Analizar el programa...");
        btnCompilar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCompilarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelButtonCompilerExecuteLayout = new javax.swing.GroupLayout(panelButtonCompilerExecute);
        panelButtonCompilerExecute.setLayout(panelButtonCompilerExecuteLayout);
        panelButtonCompilerExecuteLayout.setHorizontalGroup(
            panelButtonCompilerExecuteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelButtonCompilerExecuteLayout.createSequentialGroup()
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCompilar, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        panelButtonCompilerExecuteLayout.setVerticalGroup(
            panelButtonCompilerExecuteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panelButtonCompilerExecuteLayout.createSequentialGroup()
                .addComponent(btnCompilar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        btnCompilar.getAccessibleContext().setAccessibleName(" ▶️");

        mensajes.setEditable(false);
        mensajes.setBackground(new java.awt.Color(255, 255, 255));
        mensajes.setColumns(20);
        mensajes.setRows(5);
        jScrollPane2.setViewportView(mensajes);

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Componente léxico"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabla.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(tabla);

        tablaPila.setName("tablaPila"); // NOI18N
        jScrollPane4.setViewportView(tablaPila);

        javax.swing.GroupLayout rootPanelLayout = new javax.swing.GroupLayout(rootPanel);
        rootPanel.setLayout(rootPanelLayout);
        rootPanelLayout.setHorizontalGroup(
            rootPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rootPanelLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(rootPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane4)
                    .addGroup(rootPanelLayout.createSequentialGroup()
                        .addGroup(rootPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1)
                            .addComponent(panelButtonCompilerExecute, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 336, Short.MAX_VALUE)))
                .addGap(17, 17, 17))
        );
        rootPanelLayout.setVerticalGroup(
            rootPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rootPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelButtonCompilerExecute, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(rootPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(rootPanelLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE))
        );

        getContentPane().add(rootPanel);

        jMenu1.setText("Archivo");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem1.setText("Nuevo");
        jMenuItem1.setToolTipText("");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiNuevo(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem2.setText("Abrir");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiAbrir(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem3.setText("Guardar");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiGuardar(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Editar");

        jMenuItem7.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem7.setText("Cortar");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiCortar(evt);
            }
        });
        jMenu2.add(jMenuItem7);

        jMenuItem8.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem8.setText("Copiar");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiCopiar(evt);
            }
        });
        jMenu2.add(jMenuItem8);

        jMenuItem9.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem9.setText("Pegar");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiPegar(evt);
            }
        });
        jMenu2.add(jMenuItem9);

        jMenuItem10.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_DELETE, 0));
        jMenuItem10.setText("Borrar");
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiBorrar(evt);
            }
        });
        jMenu2.add(jMenuItem10);

        jMenuItem11.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem11.setText("Seleccionar Todo");
        jMenuItem11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiSeleccionarTodo(evt);
            }
        });
        jMenu2.add(jMenuItem11);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Correr");

        jMenuItem5.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem5.setText("Analizar");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiCompilar(evt);
            }
        });
        jMenu3.add(jMenuItem5);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jmiNuevo(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiNuevo
        // TODO add your handling code here:
        directorio.New();
        clearFields();
    }//GEN-LAST:event_jmiNuevo

    private void jmiAbrir(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiAbrir
        // TODO add your handling code here:
        if (directorio.Open()) {
            colorAnalysis();
            clearFields();
        }
    }//GEN-LAST:event_jmiAbrir

    private void jmiGuardar(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiGuardar
        // TODO add your handling code here:
        if (directorio.Save()) {
            clearFields();
        }
    }//GEN-LAST:event_jmiGuardar

    private void jmiCompilar(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiCompilar
        // TODO add your handling code here:
/*        if (getTitle().contains("*") || getTitle().equals(title)) {
            if (directorio.Save()) {
                compile();
            }
        } else {
            compile();
        }*/
        compile();
    }//GEN-LAST:event_jmiCompilar

    private void jmiCortar(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiCortar
        // TODO add your handling code here:
        JTextComponent textComponent = escritura;
        textComponent.cut();
    }//GEN-LAST:event_jmiCortar

    private void jmiCopiar(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiCopiar
        // TODO add your handling code here:
        JTextComponent textComponent = escritura;
        textComponent.copy();
    }//GEN-LAST:event_jmiCopiar

    private void jmiPegar(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiPegar
        // TODO add your handling code here:
        JTextComponent textComponent = escritura;
        textComponent.paste();
    }//GEN-LAST:event_jmiPegar

    private void jmiBorrar(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiBorrar
        // TODO add your handling code here:
        JTextComponent textComponent = escritura;
        textComponent.replaceSelection("");
    }//GEN-LAST:event_jmiBorrar

    private void jmiSeleccionarTodo(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiSeleccionarTodo
        // TODO add your handling code here:
        JTextComponent textComponent = escritura;
        textComponent.selectAll();
        textComponent.requestFocusInWindow();
    }//GEN-LAST:event_jmiSeleccionarTodo

    private void jMenuItem12jmiCortar(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem12jmiCortar
        // TODO add your handling code here:
        JTextComponent textComponent = escritura;
        textComponent.cut();
    }//GEN-LAST:event_jMenuItem12jmiCortar

    private void jMenuItem14jmiCopiar(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem14jmiCopiar
        // TODO add your handling code here:
        JTextComponent textComponent = escritura;
        textComponent.copy();
    }//GEN-LAST:event_jMenuItem14jmiCopiar

    private void jMenuItem15jmiPegar(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem15jmiPegar
        // TODO add your handling code here:
        JTextComponent textComponent = escritura;
        textComponent.paste();
    }//GEN-LAST:event_jMenuItem15jmiPegar

    private void jMenuItem16jmiBorrar(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem16jmiBorrar
        // TODO add your handling code here:
        JTextComponent textComponent = escritura;
        textComponent.replaceSelection("");
    }//GEN-LAST:event_jMenuItem16jmiBorrar

    private void jMenuItem17jmiSeleccionarTodo(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem17jmiSeleccionarTodo
        // TODO add your handling code here:
        JTextComponent textComponent = escritura;
        textComponent.selectAll();
        textComponent.requestFocusInWindow();
    }//GEN-LAST:event_jMenuItem17jmiSeleccionarTodo

    private void btnCompilarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCompilarActionPerformed
        /*    if (getTitle().contains("*") || getTitle().equals(title)) {
            if (directorio.Save()) {
                compile();
            }
        } else {
            compile();
        }*/

        compile();

    }//GEN-LAST:event_btnCompilarActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        if (directorio.Save()) {
            clearFields();
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        if (directorio.Open()) {
            colorAnalysis();
            clearFields();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        directorio.New();
        clearFields();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void compile() {
        clearFields();
        lexicalAnalysis();
        fillTableTokens();
        syntacticAnalysis();
        printConsole();
        codeHasBeenCompiled = true;
    }
    
    private void lexicalAnalysis() {
        // Extraer tokens
        Lexer lexer;
        try {
            File codigo = new File("code.encrypter");
            FileOutputStream output = new FileOutputStream(codigo);
            byte[] bytesText = escritura.getText().getBytes();
            output.write(bytesText);
            BufferedReader entrada = new BufferedReader(new InputStreamReader(new FileInputStream(codigo), "UTF8"));
            lexer = new Lexer(entrada);
            while (true) {
                Token token = lexer.yylex();
                if (token == null) {
                    break;
                }
                tokens.add(token);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("El archivo no pudo ser encontrado... " + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("Error al escribir en el archivo... " + ex.getMessage());
        }
    }

    /*========================================================*/
 /*========================================================*/
 /*========================================================*/
 /*========================================================*/
 /*========================================================*/
 /*========================================================*/
 /*========================================================*/
 /*========================================================*/

    Stack<String> pila = new Stack<>();

    private void errorLexico() {
        try {
            int banL = 0;
            while ("ERROR".equals(tokens.get(indice).getLexicalComp())) {
                if (tokens.get(indice).getLexeme().matches("[\']")) {
                    mensajes.setText(mensajes.getText() + "Error Lexico: token [ " + tokens.get(indice).getLexeme() + " ] se esperaba comilla simple de cierre [" + tokens.get(indice).getLine() + ", " + tokens.get(indice).getColumn() + "]");
                    ban = 1;
                } else if (tokens.get(indice).getLexeme().matches("'[^']*'")) {
                    mensajes.setText(mensajes.getText() + "Error Lexico: token [ " + tokens.get(indice).getLexeme() + " ] se esperaba solo un caracter entre las comillas simples [" + tokens.get(indice).getLine() + ", " + tokens.get(indice).getColumn() + "]");
                    ban = 1;
                } else {
                    mensajes.setText(mensajes.getText() + "Error Lexico: token [ " + tokens.get(indice).getLexeme() + " ] no es valido [" + tokens.get(indice).getLine() + ", " + tokens.get(indice).getColumn() + "]");
                    ban = 1 ;
                }
                indice++;
                banL = 1;
            }
            if (banL == 1) {
                indice--;
            }
        } catch (Exception e) {
        }
    }

    private void syntacticAnalysis() {
        modeloTabla = new DefaultTableModel();
        modeloTabla.addColumn("Pila");
        tablaPila.setModel(modeloTabla);

        pila.clear();
        
        if(!tokens.isEmpty()){
            tokens.add( new Token("$","$", tokens.get(tokens.size()-1).getLine()+1 , tokens.get(tokens.size()-1).getColumn()+1 ) );
            ban = 0 ;
        }else{
            mensajes.setText(mensajes.getText() + "Error Linea: 0 Columna: 0");
            ban = 1;
        }
        programa();
        if (ban == 0) {
            mensajes.setText("Analisis terminado correctamente. La cadena si es aceptada...");
        } else {
            String mmm = "";
            for(int i=1; i<=15; i++){
                String estado=pila.peek().substring(1,pila.peek().length()-1);
                int numEnt=Integer.parseInt(estado);
                if(!"-1".equals(mTabla[numEnt+1][i])){
                    mmm=mmm+mTabla[0][i] + "   ";
                }
            }
            mensajes.setText(mensajes.getText()+ "\nSe esperaba:\n" + mmm);
            
        }
    }
    
    
    private void fillPilaT() {
        modeloTabla.addRow(new Object[]{pila.toString()});
    }

    String mTabla[][] = {
{	"-1",	"id",	"num",	"int",	"float","char",	",",	";",	"+",	"-",	"*",	"/",	"(",	")",	"=",	"$",	"P",	"TIPO",	"V",	"A",	"EXP",	"E",	"TERM",	"T",	"F",	"S",	},
{	"I0",	"I7",	"-1",	"I4",	"I5",	"I6",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"I1",	"I2",	"-1",	"I3",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	},
{	"I1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"P0",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	},
{	"I2",	"I8",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	},
{	"I3",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"P2",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	},
{	"I4",	"P3",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	},
{	"I5",	"P4",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	},
{	"I6",	"P5",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	},
{	"I7",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"I9",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	},
{	"I8",	"-1",	"-1",	"-1",	"-1",	"-1",	"I11",	"I12",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"I10",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	},
{	"I9",	"I24",	"I25",	"-1",	"-1",	"-1",	"-1",	"-1",	"I14",	"I15",	"-1",	"-1",	"I23",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"I16",	"-1",	"I21",	"I22",	"I13",	},
{	"I10",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"P1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	},
{	"I11",	"I17",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	},
{	"I12",	"I7",	"-1",	"I4",	"I5",	"I6",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"I18",	"I2",	"-1",	"I3",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	},
{	"I13",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"I19",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	},
{	"I14",	"I24",	"I25",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"I23",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"I20",	"-1",	"I21",	"I22",	"-1",	},
{	"I15",	"I24",	"I25",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"I26",	"-1",	"I21",	"I22",	"-1",	},
{	"I16",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"P11",	"I28",	"I29",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	},
{	"I17",	"-1",	"-1",	"-1",	"-1",	"-1",	"I11",	"I12",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"I27",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	},
{	"I18",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"P7",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	},
{	"I19",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"P8",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	},
{	"I20",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"P9",	"I28",	"I29",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	},
{	"I21",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"P14",	"P14",	"P14",	"I30",	"I31",	"-1",	"P14",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	},
{	"I22",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"P17",	"P17",	"P17",	"P17",	"P17",	"-1",	"P17",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	},
{	"I23",	"I24",	"I25",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"I23",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"I32",	"",	"I21",	"I22",	"-1",	},
{	"I24",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"P19",	"P19",	"P19",	"P19",	"P19",	"-1",	"P19",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	},
{	"I25",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"P20",	"P20",	"P20",	"P20",	"P20",	"-1",	"P20",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	},
{	"I26",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"P10",	"I28",	"I29",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	},
{	"I27",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"P6",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	},
{	"I28",	"I24",	"I25",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"I23",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"I33",	"I22",	"-1",	},
{	"I29",	"I24",	"I25",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"I23",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"I34",	"I22",	"-1",	},
{	"I30",	"I24",	"I25",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"I23",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"I35",	"-1",	},
{	"I31",	"I24",	"I25",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"I23",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"I36",	"-1",	},
{	"I32",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"I28",	"I29",	"-1",	"-1",	"-1",	"I37",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	},
{	"I33",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"P12",	"P12",	"P12",	"I30",	"I31",	"-1",	"P12",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	},
{	"I34",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"P13",	"P13",	"P13",	"I30",	"I31",	"-1",	"P13",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	},
{	"I35",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"P15",	"P15",	"P15",	"P15",	"P15",	"-1",	"P15",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	},
{	"I36",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"P16",	"P16",	"P16",	"P16",	"P16",	"-1",	"P16",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	},
{	"I37",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"P18",	"P18",	"P18",	"P18",	"P18",	"-1",	"P18",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	"-1",	}

    };
  
    
    int indice;
    int ban;
    private void programa() {
        pila.push(" $");
        pila.push("I0 ");
        indice=0;
        mMientras();
        if(ban == 0){
            fillPilaT();
        }
    }
    
    
    private void mMientras(){
        errorLexico();
        while(indice<tokens.size() && ban==0 && !(tokens.get(indice).getLexicalComp().equals("$") && pila.peek().equals("I0 ") )){
            mRecorrer();
            errorLexico();
        }
    }
    
    private void mRecorrer(){
        int num;
        for(int i=1; i<=15; i++){
            if(tokens.get(indice).getLexicalComp().equals(mTabla[0][i]) ){
                num=mEstado();
                if(mTabla[num+1][i].equals("-1")){
                    mensajes.setText(mensajes.getText()+ "Error en ´´ " + tokens.get(indice).getLexicalComp() + " ´´ Linea: " + tokens.get(indice).getLine() + " Columna: " + tokens.get(indice).getColumn());
                    ban=1;
                }else{
                    pila.push(" "+tokens.get(indice).getLexicalComp());
                    pila.push(mTabla[num+1][i]+" ");
                }
                if(pila.peek().charAt(0)=='P'){
                    mProduccion();
                }else{
                    indice++;
                }
                break;
            }
        } 
    }
    
    private int mEstado(){
        int numEnt;
        String estado=pila.peek().substring(1,pila.peek().length()-1);
        numEnt=Integer.parseInt(estado);
        fillPilaT();
        return numEnt;
    }
    
    
    int arrProd[] ={ 1,   3,  1,  1,     1,     1,     3,  2,  4,  2,  2,  1,  3,  3,  1,  3,  3,  1,  3,  1,  1  };
    String arrPC[]={"P'","P","P","TIPO","TIPO","TIPO","V","V","A","S","S","S","E","E","E","T","T","T","F","F","F",};
    
    private void mProduccion(){
        int numEnt;
        String produccion=pila.peek().substring(1,pila.peek().length()-1);
            numEnt=Integer.parseInt(produccion);
            pila.pop();
            pila.pop();
            for(int i=0; i<arrProd[numEnt]; i++){
                pila.pop();
                pila.pop();
            }
            int num;
            for(int i=15; i<=25; i++){
                if(arrPC[numEnt].equals(mTabla[0][i]) ){
                    num=mEstado();
                    pila.push(" "+arrPC[numEnt]);
                    pila.push(mTabla[num+1][i]+" ");
                    break;
                }
            }
    }
    
    
    
    
/*@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@*/
    /*@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@*/
/*@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@*/
    
    /*=====================================================*/
 /*=====================================================*/
 /*=====================================================*/
 /*=====================================================*/
 /*=====================================================*/
 /*=====================================================*/
 /*=====================================================*/
 /*=====================================================*/
 /*=====================================================*/
 /*=====================================================*/
    private void colorAnalysis() {
        /* Limpiar el arreglo de colores */
        textsColor.clear();
        /* Extraer rangos de colores */
        LexerColor lexerColor;
        try {
            File codigo = new File("color.encrypter");
            FileOutputStream output = new FileOutputStream(codigo);
            byte[] bytesText = escritura.getText().getBytes();
            output.write(bytesText);
            BufferedReader entrada = new BufferedReader(new InputStreamReader(new FileInputStream(codigo), "UTF8"));
            lexerColor = new LexerColor(entrada);
            while (true) {
                TextColor textColor = lexerColor.yylex();
                if (textColor == null) {
                    break;
                }
                textsColor.add(textColor);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("El archivo no pudo ser encontrado... " + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("Error al escribir en el archivo... " + ex.getMessage());
        }
        Functions.colorTextPane(textsColor, escritura, new Color(40, 40, 40));
    }

    private void fillTableTokens() {
        tokens.forEach(token -> {
            Object[] data = new Object[]{token.getLexicalComp(), token.getLexeme(), "[" + token.getLine() + ", " + token.getColumn() + "]"};
            Functions.addRowDataInTable(tabla, data);
        });
    }

    private void printConsole() {
        int sizeErrors = errors.size();
        if (sizeErrors > 0) {
            Functions.sortErrorsByLineAndColumn(errors);
            String strErrors = "\n";
            for (ErrorLSSL error : errors) {
                String strError = String.valueOf(error);
                strErrors += strError + "\n";
            }
            mensajes.setText("Analisis terminado...\n" + strErrors + "\nEl analisis terminó con errores...");
        } else {
            mensajes.setText("Analisis terminado...\n");
            this.syntacticAnalysis();
        }
        mensajes.setCaretPosition(0);
    }

    private void clearFields() {
        Functions.clearDataInTable(tabla);
        mensajes.setText("");
        tokens.clear();
        errors.clear();
        identProd.clear();
        identificadores.clear();
        codeHasBeenCompiled = false;
    }

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(Compilador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Compilador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Compilador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Compilador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(new FlatIntelliJLaf());
            } catch (UnsupportedLookAndFeelException ex) {
                System.out.println("LookAndFeel no soportado: " + ex);
            }
            new Compilador().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCompilar;
    private javax.swing.JTextPane escritura;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem14;
    private javax.swing.JMenuItem jMenuItem15;
    private javax.swing.JMenuItem jMenuItem16;
    private javax.swing.JMenuItem jMenuItem17;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JPopupMenu jPopupMenu2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextArea mensajes;
    private javax.swing.JPanel panelButtonCompilerExecute;
    private javax.swing.JPanel rootPanel;
    private javax.swing.JTable tabla;
    private javax.swing.JTable tablaPila;
    // End of variables declaration//GEN-END:variables
}
