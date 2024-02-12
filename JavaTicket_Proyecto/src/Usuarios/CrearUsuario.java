package Usuarios;
import Principal.Login;
import Principal.MenuInicio;
import Principal.MenuUsuarios;
import javax.swing.JOptionPane;

/**
 *
 * @author USER
 */
public class CrearUsuario extends javax.swing.JFrame {

    /**
     * Creates new form CrearUsuario
     */
    public CrearUsuario() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        usuarioIngresado = new javax.swing.JTextField();
        contraseñaIngresada = new javax.swing.JPasswordField();
        crearUsuario = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        nombreIngresado = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        edadIngresada = new javax.swing.JTextField();
        tipoUsuario = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        botonVolver = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        usuarioIngresado.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        contraseñaIngresada.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        contraseñaIngresada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                contraseñaIngresadaActionPerformed(evt);
            }
        });

        crearUsuario.setText("Crear Usuario");
        crearUsuario.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        crearUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crearUsuarioActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Ravie", 0, 14)); // NOI18N
        jLabel1.setText("Usuario:");

        jLabel2.setFont(new java.awt.Font("Monospaced", 1, 48)); // NOI18N
        jLabel2.setText("Crear Usuario");

        jLabel4.setFont(new java.awt.Font("Ravie", 0, 14)); // NOI18N
        jLabel4.setText("Nombre:");

        nombreIngresado.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Ravie", 0, 14)); // NOI18N
        jLabel5.setText("Contraseña:");

        jLabel3.setFont(new java.awt.Font("Ravie", 0, 14)); // NOI18N
        jLabel3.setText("Edad:");

        edadIngresada.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        tipoUsuario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Administrador", "Contenido", "Limitado" }));
        tipoUsuario.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tipoUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tipoUsuarioActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Ravie", 0, 14)); // NOI18N
        jLabel6.setText("Tipo de usuario:");

        botonVolver.setText("Volver");
        botonVolver.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonVolverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(238, 238, 238)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(crearUsuario))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(119, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(104, 104, 104))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel5)
                                    .addGap(18, 18, 18)
                                    .addComponent(contraseñaIngresada, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel1)
                                    .addGap(53, 53, 53)
                                    .addComponent(usuarioIngresado, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(nombreIngresado, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(34, 34, 34)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tipoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(edadIngresada, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(127, 127, 127))
                    .addComponent(botonVolver, javax.swing.GroupLayout.Alignment.TRAILING)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nombreIngresado, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(usuarioIngresado, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(contraseñaIngresada, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(edadIngresada, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tipoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 94, Short.MAX_VALUE)
                .addComponent(crearUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(botonVolver))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void contraseñaIngresadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_contraseñaIngresadaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_contraseñaIngresadaActionPerformed

    private void crearUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crearUsuarioActionPerformed
        int Edad_numero;
    String tipoUsuarioSeleccionado = (String) tipoUsuario.getSelectedItem();

    if (!usuarioIngresado.getText().isBlank() && !edadIngresada.getText().isBlank() && !nombreIngresado.getText().isBlank() && !contraseñaIngresada.getText().isBlank()) {
        if (!tipoUsuarioSeleccionado.equals("(Seleccione)")) {
            try {
                Edad_numero = Integer.parseInt(edadIngresada.getText());
            } catch (NumberFormatException er) {
                JOptionPane.showMessageDialog(null, "La edad tiene que ser un número entero");
                return; // Sale del método si hay una excepción
            } 
            if(Login.FUNCIONES.verificar(usuarioIngresado.getText())){
            if (Edad_numero > 0 && Edad_numero < 100) {
                int T_user = lista(tipoUsuarioSeleccionado);
                if(T_user==3){
                Login.FUNCIONES.añadir(usuarioIngresado.getText(), new Limitado(usuarioIngresado.getText(), contraseñaIngresada.getText(), T_user, Edad_numero, nombreIngresado.getText()));
                }
                if(T_user==2){
                Login.FUNCIONES.añadir(usuarioIngresado.getText(), new Contenidos(usuarioIngresado.getText(), contraseñaIngresada.getText(), T_user, Edad_numero, nombreIngresado.getText())); 
                }
                if(T_user==1){
                Login.FUNCIONES.añadir(usuarioIngresado.getText(), new Administrador(usuarioIngresado.getText(), contraseñaIngresada.getText(), T_user, Edad_numero, nombreIngresado.getText()));    
                }
                JOptionPane.showMessageDialog(null, "¡Se ha creado el usuario correctamente!");

            } else {
                JOptionPane.showMessageDialog(null, "Ingrese una edad posible");
            }
            }else{
             JOptionPane.showMessageDialog(null, "Ese Username no esta Disponible");   
            }
        } else {
            JOptionPane.showMessageDialog(null, "Tiene que seleccionar un tipo de usuario");
        }
    } else {
        JOptionPane.showMessageDialog(null, "Tiene que llenar todos los espacios");
    }
    }//GEN-LAST:event_crearUsuarioActionPerformed

    private void botonVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonVolverActionPerformed
        MenuUsuarios mu = new MenuUsuarios();
                mu.setVisible(true);
                dispose();
    }//GEN-LAST:event_botonVolverActionPerformed

    private void tipoUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tipoUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tipoUsuarioActionPerformed

    public int lista(String tipoUsuarioSeleccionado) {
        int numero = 0;

        switch (tipoUsuarioSeleccionado) {
            case "Administrador":
                numero = 1;
                break;
            case "Contenido":
                numero = 2;
                break;
            case "Limitado":
                numero = 3;
                break;
        }

        return numero;
    }
    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonVolver;
    private javax.swing.JPasswordField contraseñaIngresada;
    private javax.swing.JButton crearUsuario;
    private javax.swing.JTextField edadIngresada;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField nombreIngresado;
    private javax.swing.JComboBox<String> tipoUsuario;
    private javax.swing.JTextField usuarioIngresado;
    // End of variables declaration//GEN-END:variables
}
