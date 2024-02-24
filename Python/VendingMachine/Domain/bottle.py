from Domain.product import Product

class Bottle(Product):
    def __init__(self, id, name, price, place):
        super().__init__(id, name, price, place)
        self.bottleVolume = 0.0

    def __init__(self, id, name, price, place, bottleVolume):
        super().__init__(id, name, price, place)
        self.bottleVolume = bottleVolume

    def getBottleVolume(self):
        return self.bottleVolume

    def setBottleVolume(self, bottleVolume):
        self.bottleVolume = bottleVolume

    def __str__(self):
        return super().__str__() + "volume=" + str(self.bottleVolume)
