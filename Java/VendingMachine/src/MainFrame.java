import domain.Product;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class MainFrame extends JFrame {
    private JList<String> productList;
    private JTextField moneyField;
    private JButton buyButton;
    private DefaultListModel<String> listModel;

    public MainFrame(List<Product> products) {
        setTitle("Vending Machine");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Создание списка продуктов
        listModel = new DefaultListModel<>();
        for (Product product : products) {
            listModel.addElement(product.getName() + " - $" + product.getPrice());
        }
        productList = new JList<>(listModel);

        // Создание поля для ввода наличности
        moneyField = new JTextField(10);

        // Создание кнопки "купить товар"
        buyButton = new JButton("Купить товар");

        // Расположение компонентов на интерфейсе
        setLayout(new BorderLayout());
        add(new JScrollPane(productList), BorderLayout.CENTER);
        JPanel bottomPanel = new JPanel();
        bottomPanel.add(new JLabel("Введите сумму:"));
        bottomPanel.add(moneyField);
        bottomPanel.add(buyButton);
        add(bottomPanel, BorderLayout.SOUTH);

        // Обработка нажатия на кнопку "купить товар"
        buyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = productList.getSelectedIndex();
                if (selectedIndex != -1) {
                    String selectedItem = listModel.getElementAt(selectedIndex);
                    // Разбиваем строку, чтобы получить имя продукта и его цену
                    String[] parts = selectedItem.split(" - \\$");
                    String productName = parts[0];
                    double productPrice = Double.parseDouble(parts[1]);

                    // Получаем введенную сумму из поля для ввода
                    double enteredMoney = Double.parseDouble(moneyField.getText());

                    // Проверяем, хватает ли денег для покупки товара
                    if (enteredMoney >= productPrice) {
                        JOptionPane.showMessageDialog(MainFrame.this, "Вы купили " + productName);
                        // Обновляем баланс пользователя после покупки
                        moneyField.setText(String.valueOf(enteredMoney - productPrice));
                    } else {
                        JOptionPane.showMessageDialog(MainFrame.this, "Недостаточно средств");
                    }
                } else {
                    JOptionPane.showMessageDialog(MainFrame.this, "Выберите товар для покупки");
                }
            }
        });

        setVisible(true);
    }
}
