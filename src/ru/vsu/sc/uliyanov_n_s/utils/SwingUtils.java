package ru.vsu.sc.uliyanov_n_s.utils;


import ru.vsu.sc.uliyanov_n_s.error.FrameError;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;


public class SwingUtils {
    /**
     * Показать диалоговое окно с информационным сообщением
     * @param message Сообщение
     * @param title Заголовок окна
     */
    public static void showInfoMessageBox(String message, String title) {
        JOptionPane.showMessageDialog(null, message, title, JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Показать диалоговое окно с информационным сообщением
     * @param message Сообщение
     */
    public static void showInfoMessageBox(String message) {
        showInfoMessageBox(message, "Сообщение");
    }


    public static void showErrorMessageBox(String errorMessage) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new FrameError(errorMessage).setVisible(true);
            }
        });
    }

    /**
     * Задание фиксированного размера для компонента Swing
     * @param <T> Тип компонента
     * @param comp Компонент
     * @param width Ширина компонента
     * @param height Высота компонента
     * @return
     */
    public static <T extends Component> T setFixedSize(T comp, int width, int height) {
        Dimension d = new Dimension(width, height);
        comp.setMaximumSize(d);
        comp.setMinimumSize(d);
        comp.setPreferredSize(d);
        comp.setSize(d);
        return comp;
    }

    /**
     * Установка темы отображения (LookAndFeel) для элементов управления
     * @param name Название темы
     */
    public static void setLookAndFeelByName(String name) {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if (name.equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    for (Window window : Window.getWindows()) {
                        Dimension size = window.getSize();
                        SwingUtilities.updateComponentTreeUI(window);
                        window.pack();
                        window.setSize(size);
                    }
                    break;
                }
            }
        } catch (Exception ex) {
            Class inner = new Object() {}.getClass();
            Logger.getGlobal().logp(Level.SEVERE, inner.getEnclosingClass().getName(), inner.getEnclosingMethod().getName(), null, ex);
        }
    }

    /**
     * Заполнение меню JMenu элементами для выбора тем отображения (LookAndFeel)
     * @param menu Меню для добавления пунктов меню
     */
    public static void initLookAndFeelMenu(JMenu menu) {
        ActionListener actionListener = (ActionEvent e) -> {
            JMenuItem menuItem = (JMenuItem) e.getSource();
            SwingUtils.setLookAndFeelByName(menuItem.getText());
        };
        ButtonGroup group = new ButtonGroup();
        LookAndFeel currentLookAndFeel = UIManager.getLookAndFeel();
        for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
            if ("Nimbus".equals(info.getName())) {
                continue;
            }
            JRadioButtonMenuItem menuItem = new JRadioButtonMenuItem();
            menuItem.setText(info.getName());
            menuItem.setSelected(info.getName().equals(currentLookAndFeel.getName()));
            menuItem.addActionListener(actionListener);
            group.add(menuItem);
            menu.add(menuItem);
        }
    }
}
