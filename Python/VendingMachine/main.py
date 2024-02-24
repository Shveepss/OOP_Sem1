import sys
from PyQt5.QtWidgets import QApplication

from typing import List
from Domain.bottle import Bottle
from Domain.product import Product
from Domain.hotDrink import HotDrink
from Services.coin_dispenser import CoinDispenser
from Services.display import Display
from Services.holder import Holder
from Services.vending_machine import VendingMachine
from main_frame import MainFrame


if __name__ == "__main__":
    assort: List[Product] = []
    # item1 = Product(100, 1, "Lays")
    # item2 = Product(50, 2, "Cola")
    # item3 = Bottle(150, 3, "Mineral Water", 101, 1.5)

    product1 = Product(1, "Lays", 132.55, 13)
    product2 = Product(2, "Snikers", 52.10, 14)
    product3 = Product(3, "Nuts", 49.55, 15)
    bottle1 = Bottle(4, "CocaCola", 99.00, 5, 0.5)
    capuchino = HotDrink(5, "Capuchino", 150.00, 1, 80)
    latte = HotDrink(6, "Latte", 160.00, 1, 70)
    americano = HotDrink(7, "Americano", 140.00, 1, 85)

    assort.append(product1)
    assort.append(product2)
    assort.append(product3)
    assort.append(bottle1)
    assort.append(capuchino)
    assort.append(latte)
    assort.append(americano)


    hold1 = Holder(4, 4)
    coinDesp = CoinDispenser(0)
    disp = Display()

    venMachine = VendingMachine(hold1, coinDesp, assort, disp)

    for prod in venMachine.getProducts():
        print(prod)


    app = QApplication(sys.argv)
    myFrame = MainFrame()
    myFrame.show()
    sys.exit(app.exec_())

    #print("Hello, World!")