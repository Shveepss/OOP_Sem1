from PyQt5.QtWidgets import QApplication, QMainWindow, QListWidget, QLineEdit, QPushButton, QVBoxLayout, QMessageBox, \
    QWidget


class MainFrame(QMainWindow):
    def __init__(self, products):
        super().__init__()

        self.setWindowTitle("Vending Machine")
        self.setFixedSize(400, 300)

        # Создание списка продуктов
        self.product_list = QListWidget()
        for product in products:
            self.product_list.addItem(f"{product.name} - ${product.price}")

        # Создание поля для ввода наличности
        self.money_field = QLineEdit()

        # Создание кнопки "купить товар"
        self.buy_button = QPushButton("Купить товар")

        # Расположение компонентов на интерфейсе
        main_layout = QVBoxLayout()
        main_layout.addWidget(self.product_list)
        main_layout.addWidget(self.money_field)
        main_layout.addWidget(self.buy_button)

        central_widget = QWidget()
        central_widget.setLayout(main_layout)
        self.setCentralWidget(central_widget)

        # Обработка нажатия на кнопку "купить товар"
        self.buy_button.clicked.connect(self.on_buy_button_clicked)

    def on_buy_button_clicked(self):
        selected_index = self.product_list.currentRow()
        if selected_index != -1:
            selected_item = self.product_list.currentItem().text()
            # Разбиваем строку, чтобы получить имя продукта и его цену
            product_name, product_price = selected_item.split(" - ")
            product_price = float(product_price)

            # Получаем введенную сумму из поля для ввода
            entered_money = float(self.money_field.text())

            # Проверяем, хватает ли денег для покупки товара
            if entered_money >= product_price:
                QMessageBox.information(self, "Покупка", f"Вы купили {product_name}")
                # Обновляем баланс пользователя после покупки
                self.money_field.setText(f"{entered_money - product_price}")
            else:
                QMessageBox.warning(self, "Ошибка", "Недостаточно средств")
        else:
            QMessageBox.warning(self, "Ошибка", "Выберите товар для покупки")
