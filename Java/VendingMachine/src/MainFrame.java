import domain.Product;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class MainFrame extends JFrame {
    private JPanel productPanel;
    private JTextField moneyField;
    private JButton buyButton;
    private JLabel selectedProductLabel;
    private Product selectedProduct;

    public MainFrame(List<Product> products) {
        setTitle("Vending Machine");
        setSize(600, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Создаем панель для отображения продуктов
        productPanel = new JPanel();
        productPanel.setLayout(new GridLayout(products.size(), 2));

        // Для каждого продукта создаем кнопку и добавляем ее на панель
        for (Product product : products) {
            JButton productButton = new JButton(product.getName());
            productButton.setPreferredSize(new Dimension(50, 50)); // Не разобрался почему не срабатывает
            JLabel priceLabel = new JLabel(product.getPrice() + "₽");
            priceLabel.setHorizontalAlignment(SwingConstants.CENTER);

            productButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Обрабатываем нажатие кнопки продукта
                    selectedProduct = product;
                    updateSelectedProductLabel();
                }
            });

            // Добавляем кнопку и подпись на панель
            productPanel.add(productButton);
            productPanel.add(priceLabel);
        }

        moneyField = new JTextField(10);

        buyButton = new JButton("Купить товар");
        buyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (selectedProduct != null) {
                    double productPrice = selectedProduct.getPrice();
                    double enteredMoney = 0.00;

                    String moneyText = moneyField.getText();
                    if (!moneyText.isEmpty()) {
                        enteredMoney = Double.parseDouble(moneyText);
                    } else {
                        JOptionPane.showMessageDialog(MainFrame.this, "Введите сумму");
                        return;
                    }

                    if (enteredMoney >= productPrice) {
                        JOptionPane.showMessageDialog(MainFrame.this, "Вы купили " + selectedProduct.getName());
                        moneyField.setText(String.valueOf(enteredMoney - productPrice));
                    } else {
                        JOptionPane.showMessageDialog(MainFrame.this, "Недостаточно средств");
                    }
                } else {
                    JOptionPane.showMessageDialog(MainFrame.this, "Выберите товар для покупки");
                }
            }
        });

        // Метка для отображения выбранного продукта
        selectedProductLabel = new JLabel("Выбран: ");

        // Располагаем компоненты на интерфейсе
        setLayout(new BorderLayout());
        add(productPanel, BorderLayout.CENTER);
        JPanel bottomPanel = new JPanel();
        bottomPanel.add(selectedProductLabel);
        bottomPanel.add(new JLabel("Введите сумму:"));
        bottomPanel.add(moneyField);
        bottomPanel.add(buyButton);
        add(bottomPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    private void updateSelectedProductLabel() {
        if (selectedProduct != null) {
            selectedProductLabel.setText(
                    "Выбран: " +
                    selectedProduct.getName() +
                    " стоимостью: " +
                    selectedProduct.getPrice()
            );
        } else {
            selectedProductLabel.setText("Выбран: ");
        }
    }
}
