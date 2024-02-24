from Domain.product import Product


class HotDrink(Product):
    def __init__(self, id, name, price, place):
        super().__init__(id, name, price, place)
        self.temperature = 0.0

    def __init__(self, id, name, price, place, temperature):
        super().__init__(id, name, price, place)
        self.temperature = temperature

    def getTemperature(self):
        return self.temperature

    def setTemperature(self, temperature):
        self.temperature = temperature

    def __str__(self):
        return super().__str__() + "temperature=" + str(self.temperature)
